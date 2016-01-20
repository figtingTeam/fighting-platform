package com.dongyuan.figting.impl.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dongyuan.figting.impl.Constants;
import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.code.TicketApiCode;
import com.dongyuan.figting.impl.dto.response.ActivityInfoRes;
import com.dongyuan.figting.impl.dto.response.TicketAddrInfoRes;
import com.dongyuan.figting.impl.dto.response.TicketBasicInfoRes;
import com.dongyuan.figting.impl.enums.TicketStatusType;
import com.dongyuan.figting.impl.enums.WxChannel;
import com.dongyuan.figting.impl.service.ITicketService;
import com.dongyuan.figting.impl.utils.DateUtil;
import com.dongyuan.figting.impl.utils.JedisUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midea.cmo2o.shopping.api.domain.ShoppingCart;
import com.midea.cmo2o.shopping.api.dto.request.cart.ShoppingCartQueryRequest;
import com.midea.cmo2o.shopping.api.dto.response.cart.ShoppingCartQueryResponse;
import com.midea.cmo2o.shopping.api.service.ShoppingCartFacade;
import com.midea.cmo2o.ticket.api.ActivityServiceFacade;
import com.midea.cmo2o.ticket.api.TicketServiceFacade;
import com.midea.cmo2o.ticket.api.dto.ActivityData;
import com.midea.cmo2o.ticket.api.dto.AddressData;
import com.midea.cmo2o.ticket.api.dto.Result;
import com.midea.cmo2o.ticket.api.dto.ResultCode;
import com.midea.cmo2o.ticket.api.dto.TicketData;
import com.dongyuan.figting.impl.dto.request.TicketActivateRequest;
import com.dongyuan.figting.impl.dto.request.TicketBindRequest;
import com.dongyuan.figting.impl.utils.CacheKeyRegistry;
import com.dongyuan.figting.impl.utils.DateStyle;
import com.dongyuan.figting.impl.utils.StringUtil;
import com.midea.trade.common.util.FastJSONHelper;

/**
 * 类TicketServiceImpl.java的实现描述：认筹券接口实现类
 * 
 * @author huanghf 2015年12月27日 下午5:09:08
 * @email haifeng1.huang@midea.com
 */
@Service(value = "ticketService")
public class TicketServiceImpl implements ITicketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	private TicketServiceFacade ticketServiceFacade;

	@Autowired
	private ActivityServiceFacade activityServiceFacade;

	@Autowired
	private ShoppingCartFacade shoppingCartFacade;

	@Override
	public List<TicketBasicInfoRes> getTicketsByOpenid(String openid) {
		LOGGER.info("根据openid：{}获取认筹券列表.", openid);
		List<TicketBasicInfoRes> ticketBasicInfoRess = new ArrayList<TicketBasicInfoRes>();
		Result<List<TicketData>> result =
				ticketServiceFacade.getTicketsByWx(WxChannel.MIDEA_AIR_CONDITIONER.getChannel(),
						openid);
		List<TicketData> ticketDatas = result.getData();
		if (result.isOk() && CollectionUtils.isNotEmpty(ticketDatas)) {
			TicketBasicInfoRes ticketBasicInfoRes = null;
			for (TicketData item : ticketDatas) {
				ticketBasicInfoRes = new TicketBasicInfoRes();
				BeanUtils.copyProperties(item, ticketBasicInfoRes);
				Result<ActivityData> result_ =
						activityServiceFacade.getActivity(item.getActivityId());
				ActivityData activityData = result_.getData();
				if (result_.isOk() && activityData != null) {
					ticketBasicInfoRes.setActivityName(activityData.getName());
					ticketBasicInfoRes.setStartTime(activityData.getStartTime());
					ticketBasicInfoRes.setEndTime(activityData.getEndTime());
				}
				ticketBasicInfoRess.add(ticketBasicInfoRes);
			}
		}
		LOGGER.info("获取到的认筹券信息如下：{}", FastJSONHelper.serialize(ticketBasicInfoRess));
		return ticketBasicInfoRess;
	}

	@Override
	public String checkTicket(String openid, String ticketId) {
		LOGGER.info("校验认筹券，openid为：{}，认筹券号为：{}", openid, ticketId);
		Result<TicketData> result = ticketServiceFacade.getTicket(null, ticketId);
		if (result.isOk()) {
			TicketData ticketData = result.getData();
			if (ticketData != null) {
				// 认筹券状态小于0都是无效状态
				if (ticketData.getTicketStatus() < Constants.CONSTANT_ZERO_INT) {
					// 判断是否过期
					if (TicketStatusType.OUTDATED.getType() == ticketData.getTicketStatus()) {
						Result<ActivityData> result_ =
								activityServiceFacade.getActivity(ticketData.getActivityId());
						if (result_.isOk() && result_.getData() != null) {
							// 若券过期，则返回活动截止时间
							String activityEndTime =
									DateUtil.DateToString(result_.getData().getEndTime(),
											DateStyle.YYYY_MM_DD_HH_MM_SS);
							LOGGER.info("认筹券号{}对应活动已过期，过期时间为：{}", ticketId, activityEndTime);
							return activityEndTime;
						}
					} else {
						LOGGER.info("认筹券号{}不可用.", ticketId);
						return TicketApiCode.TICKET_NOT_AVAILABLE;
					}
				} else {
					Result<List<TicketData>> resultList =
							ticketServiceFacade.getTicketsByWx(
									WxChannel.MIDEA_AIR_CONDITIONER.getChannel(), openid);
					if (resultList.isOk()) {
						List<TicketData> ticketDatas = resultList.getData();
						if (CollectionUtils.isNotEmpty(ticketDatas)) {
							for (TicketData item : ticketDatas) {
								if (item.getActivityId().equals(ticketData.getActivityId())
										&& !item.getId().equals(ticketData.getId())) {
									LOGGER.info("本openid{}已经绑定过本次活动的另一张认筹券.", openid);
									return TicketApiCode.OPENID_LINK_OTHER_TICKET;
								}
							}
						}
					}
					if (ticketData.getActivateTime() != null) {
						if (StringUtil.isBlank(ticketData.getOpenid())) {
							// 券号有效且已经被激活，但未关联任何openid
							LOGGER.info("认筹券号{}有效且已被激活，但未关联任何openid.", ticketId);
							return ticketData.getMobile();
						} else if (!ticketData.getOpenid().equals(openid)) {
							// 券号已经被激活，但关联的openid非本微信号
							LOGGER.info("认筹券号{}已经被激活，但关联的openid非本微信号.", ticketId);
							return TicketApiCode.TICKET_ACTIVATED_OTHER;
						} else if (ticketData.getOpenid().equals(openid)) {
							// 券号已经被激活，但已关联本微信号
							LOGGER.info("认筹券号{}已经被激活，但已关联本微信号,不可重复激活.", ticketId);
							return TicketApiCode.TICKET_ACTIVATED_SELF;
						}
					} else {
						if (StringUtil.isBlank(ticketData.getOpenid())) {
							// 券号尚未被激活且可用
							LOGGER.info("认筹券号{}尚未被激活且可用.", ticketId);
							return ticketData.getActivityId() + "_ACTIVITYID";
						}
					}
				}
			}
		} else {
			// 错误码7002 认筹券不存在
			if (ResultCode.DATA_NOT_EXISTS == result.getErrcode()) {
				LOGGER.info("认筹券号{}不存在.", ticketId);
				return TicketApiCode.TICKET_NOT_EXIST;
			}
		}
		return BaseApiCode.OPERATE_FAIL;
	}

	@Override
	public TicketBasicInfoRes getTicketById(String ticketId) {
		TicketBasicInfoRes ticketBasicInfoRes = new TicketBasicInfoRes();
		Result<TicketData> result = ticketServiceFacade.getTicket(null, ticketId);
		if (result.isOk() && result.getData() != null) {
			BeanUtils.copyProperties(result.getData(), ticketBasicInfoRes);
		}
		return ticketBasicInfoRes;
	}

	@Override
	public String bindOpenid(TicketBindRequest request) {
		// 缓存中获取对应手机的验证码
		String captcha_ =
				JedisUtil.getJedisInstance().execGetFromCache(
						CacheKeyRegistry.getMobileCaptchaCacheKey(request.getMobile()));
		// 验证码过期
		if (StringUtil.isBlank(captcha_)) {
			LOGGER.info("验证码{}过期.", request.getCaptcha());
			return TicketApiCode.CAPTCHA_EXPIRE;
		} else {
			if (captcha_.equals(request.getCaptcha())) {
				@SuppressWarnings("rawtypes")
				Result result =
						ticketServiceFacade.bindWx(request.getTicketId(),
								WxChannel.MIDEA_AIR_CONDITIONER.getChannel(), request.getOpenid());
				if (result.isOk()) {
					LOGGER.info("openid：{}绑定认筹券：{}成功.", request.getOpenid(), request.getTicketId());
					return BaseApiCode.OPERATE_SUCCESS;
				} else {
					// 返回7014-认筹券无效 7011-openid已绑定
					LOGGER.info("openid：{}绑定认筹券：{}失败,接口返回错误码：{}", request.getOpenid(),
							request.getTicketId(), ResultCode.getMessage(result.getErrcode()));
					return TicketApiCode.BIND_FAIL;
				}
			} else {
				LOGGER.info("验证码：{}错误.", request.getCaptcha());
				return TicketApiCode.CAPTCHA_ERROR;
			}
		}
	}

	@Override
	public ActivityInfoRes getActivityByTicketId(String ticketId, Long activityId) {
		LOGGER.info("根据认筹券号：{}获取活动信息", ticketId);
		ActivityInfoRes activityInfoRes = new ActivityInfoRes();
		activityInfoRes.setTicketId(ticketId);
		Result<TicketData> result = ticketServiceFacade.getTicket(null, ticketId);
		if (result.isOk()) {
			TicketData ticketData = result.getData();
			if (ticketData != null) {
				BeanUtils.copyProperties(ticketData, activityInfoRes);
				// 判断是否已签到
				if (ticketData.getCheckinTime() != null) {
					activityInfoRes.setCheckin(true);
				}
				// 判断是否已领赠
				if (ticketData.getGiftTime() != null) {
					activityInfoRes.setGift(true);
				}
			}
			// 获取活动信息
			Result<ActivityData> activityResult =
					activityServiceFacade.getActivity(result.getData().getActivityId());
			if (activityResult.isOk() && activityResult.getData() != null) {
				activityInfoRes.setActivityName(activityResult.getData().getName());
				activityInfoRes.setAddress(activityResult.getData().getAddress());
				activityInfoRes.setStartTime(activityResult.getData().getStartTime());
				activityInfoRes.setEndTime(activityResult.getData().getEndTime());
			}
			// 获取购物车sku数量
			ShoppingCartQueryRequest queryReq = new ShoppingCartQueryRequest();
			queryReq.setTicketId(ticketId);
			queryReq.setActivityId(activityId);
			ShoppingCartQueryResponse shoppingCartQueryResponse =
					shoppingCartFacade.queryShoppingCarts(queryReq);
			if (shoppingCartQueryResponse.getCartInfo() != null) {
				List<ShoppingCart> list = shoppingCartQueryResponse.getCartInfo().getCartItems();
				if (CollectionUtils.isNotEmpty(list)) {
					activityInfoRes.setCartAmount(list.size());
				}
			}
			LOGGER.info("根据认筹券号：{}获取到的活动信息如下：", ticketId, FastJSONHelper.serialize(activityInfoRes));
			return activityInfoRes;
		}
		return null;
	}

	@Transactional
	@Override
	public String activate(TicketActivateRequest request) {
		// 判断手机号是否已绑定本次活动其它认筹券
		Result<TicketData> resultDate =
				ticketServiceFacade.getTicket(request.getActivityId(), request.getMobile());
		if (resultDate.isOk() && resultDate.getData() != null) {
			LOGGER.info("手机号{}已绑定本次活动其它认筹券", request.getMobile());
			return TicketApiCode.MOBILE_LINK_OTHER_TICKET;
		}
		String captcha_ =
				JedisUtil.getJedisInstance().execGetFromCache(
						CacheKeyRegistry.getMobileCaptchaCacheKey(request.getMobile()));
		// 验证码过期
		if (StringUtil.isBlank(captcha_)) {
			LOGGER.info("验证码{}已过期", request.getCaptcha());
			return TicketApiCode.CAPTCHA_EXPIRE;
		} else {
			if (captcha_.equals(request.getCaptcha())) {
				@SuppressWarnings("rawtypes")
				Result result =
						ticketServiceFacade.activate(request.getTicketId(), request.getName(),
								request.getMobile(), WxChannel.MIDEA_AIR_CONDITIONER.getChannel(),
								request.getOpenid(), request.getActivateType());
				if (result.isOk()) {
					AddressData address = new AddressData();
					BeanUtils.copyProperties(request, address);
					address.setPhone(request.getMobile());
					Result<Long> result_ = ticketServiceFacade.addAddress(address);
					if (result_.isOk() && result_.getData() != null) {
						LOGGER.info("认筹券:{}激活成功，绑定openid:{}", request.getTicketId(),
								request.getOpenid());
						return BaseApiCode.OPERATE_SUCCESS;
					} else {
						// TODO 回滚
						throw new RuntimeException();
					}
				}
			} else {
				LOGGER.info("验证码{}错误", request.getCaptcha());
				return TicketApiCode.CAPTCHA_ERROR;
			}
		}
		LOGGER.info("认筹券：{}激活失败", request.getTicketId());
		return TicketApiCode.TICKET_ACTIVATED_FAIL;
	}

	/**
	 * 企业号，输入认筹券号码\电话号码查询用户信息
	 */
	@Override
	public TicketAddrInfoRes getTicket(String ticketId, String mobile, Long activityId) {
		TicketAddrInfoRes ticketAddrInfoRes = null;
		Result<TicketData> resultData = null;
		if (!StringUtil.isBlank(ticketId)) {
			LOGGER.info("企业号：根据认筹券号：{}查找信息.", ticketId);
			resultData = ticketServiceFacade.getTicket(activityId, ticketId);
		}
		if (!StringUtil.isBlank(mobile)) {
			LOGGER.info("企业号：根据手机号：{}查找信息.", mobile);
			resultData = ticketServiceFacade.getTicket(activityId, mobile);
		}
		if (resultData.isOk()) {
			TicketData ticketData = resultData.getData();
			ticketAddrInfoRes = new TicketAddrInfoRes();
			ticketAddrInfoRes.setTicketId(ticketData.getId());
			ticketAddrInfoRes.setActivityId(ticketData.getActivityId());
			ticketAddrInfoRes.setName(ticketData.getName());
			ticketAddrInfoRes.setTicketStatus(ticketData.getTicketStatus());
			ticketAddrInfoRes.setMobile(ticketData.getMobile());
			ticketAddrInfoRes.setActivateTime(ticketData.getActivateTime());
			Result<List<AddressData>> resultData_ =
					ticketServiceFacade.getAddresses(ticketData.getId());
			if (resultData_.isOk()) {
				List<AddressData> addressDatas = resultData_.getData();
				if (CollectionUtils.isNotEmpty(addressDatas)) {
					AddressData address = addressDatas.get(0);
					ticketAddrInfoRes.setCity(address.getCity());
					ticketAddrInfoRes.setCityName(address.getCityName());
					ticketAddrInfoRes.setDistrict(address.getDistrict());
					ticketAddrInfoRes.setDistrictName(address.getDistrictName());
					ticketAddrInfoRes.setProvince(address.getProvince());
					ticketAddrInfoRes.setProvinceName(address.getProvinceName());
					ticketAddrInfoRes.setAddress(address.getAddress());
				}
			}
		}
		return ticketAddrInfoRes;
	}

}
