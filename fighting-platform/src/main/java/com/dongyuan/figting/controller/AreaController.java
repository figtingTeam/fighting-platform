package com.dongyuan.figting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongyuan.figting.Constants;
import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.core.excute.ControllerWrapper;
import com.dongyuan.figting.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.dto.BaseRequest;
import com.dongyuan.figting.dto.BodyData;

/**
 * 类AreaController.java的实现描述：地区控制器
 * 
 * @author huanghf 2015年12月28日 下午6:36:40
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("/area")
public class AreaController {
	private static Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

	/*@Autowired
	private IAreaService areaService;*/

	/**
	 * 根据父编码获取地区信息
	 * 
	 * @param parentCode 若不传，则默认为1，查询中国下的省信息
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	BodyData getAreas(
			@RequestParam(value = "parentCode", required = false, defaultValue = Constants.CONSTANT_ONE_STR)
	final Integer parentCode) {
		final BaseRequest request = new BaseRequest();
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				/*List<AreaRes> areas = areaService.getAreas(request.getParentCode());
				response.setContent(areas);            
				LOGGER.info("根据parentCode：{}获取到的地区信息如下：{}", request.getParentCode(),
						FastJSONHelper.serialize(areas));  */
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}

}