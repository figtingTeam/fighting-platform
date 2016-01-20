package com.dongyuan.figting.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dongyuan.figting.dto.response.ActivityDataRes;
import com.dongyuan.figting.utils.FastJSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midea.cmo2o.ticket.api.WorkerServiceFacade;
import com.midea.cmo2o.ticket.api.dto.ActivityData;
import com.midea.cmo2o.ticket.api.dto.Result;
import com.midea.cmo2o.ticket.api.dto.WorkerData;
import com.dongyuan.figting.service.WWorkerService;

/**
 * 类WWorkerServiceImpl.java的实现描述：工作文员信息获取服务类
 * 
 * @author huanghf 2016年1月2日 上午11:24:06
 * @email haifeng1.huang@midea.com
 */
@Service(value = "wWorkerService")
public class WWorkerServiceImpl implements WWorkerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WWorkerServiceImpl.class);

	@Autowired
	private WorkerServiceFacade workerServiceFacade;

	/**
	 * 获取指定微信号当前正在进行的活动列表
	 * 
	 * @param wxcode 微信号。如果微信号和手机号均不为 null，则优先使用微信号
	 * @param mobile 微信号。如果微信号和手机号均不为 null，则优先使用微信号
	 * @return
	 */
	@Override
	public List<ActivityDataRes> getActivityListByWxCode(String wxCode, String mobile) {
		LOGGER.info("根据导购微信号{}、手机号{}获取当前参加的活动列表.", wxCode, mobile);
		List<ActivityDataRes> resultDatas = new ArrayList<ActivityDataRes>();
		Result<List<ActivityData>> result = workerServiceFacade.getOngoingActivity(wxCode, mobile);
		if (result.isOk()) {
			List<ActivityData> resultDatas_ = result.getData();
			ActivityDataRes activityDataRes = null;
			for (ActivityData item : resultDatas_) {
				activityDataRes = new ActivityDataRes();
				BeanUtils.copyProperties(item, activityDataRes);
				Result<WorkerData> resultWorkData =
						workerServiceFacade.getWorkerByWx(item.getId(), wxCode, mobile);
				if (resultWorkData.isOk() && resultWorkData.getData() != null) {
					activityDataRes.setWorkId(resultWorkData.getData().getWorkerId());
				}
				resultDatas.add(activityDataRes);
			}
		}
		LOGGER.info("根据导购微信号{}、手机号{}获取当前参加的活动列表信息如下：{}.", wxCode, mobile,
				FastJSONHelper.serialize(resultDatas));
		return resultDatas;
	}

}
