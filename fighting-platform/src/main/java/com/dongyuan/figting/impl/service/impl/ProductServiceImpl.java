package com.dongyuan.figting.impl.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.service.IProductService;
import com.dongyuan.figting.impl.utils.FastJSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midea.cmo2o.shopping.api.domain.ProductDetail;
import com.midea.cmo2o.shopping.api.dto.request.item.ProductQueryRequest;
import com.midea.cmo2o.shopping.api.dto.response.item.ProductQueryResponse;
import com.midea.cmo2o.shopping.api.service.ProductFacade;
import com.dongyuan.figting.impl.Constants;
import com.dongyuan.figting.impl.utils.StringUtil;

/**
 * 类ProductServiceImpl.java的实现描述：商品服务实现类
 * 
 * @author huanghf 2015年12月28日 下午7:05:01
 * @email haifeng1.huang@midea.com
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductFacade productFacade;

	private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Map<String, Object> getProductInfo(Long activityId, String shortCode) {
		LOGGER.info("根据活动ID:{}、商品短码{}获取商品信息.", activityId, shortCode);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ProductQueryRequest productQueryReq = new ProductQueryRequest();
		productQueryReq.setActivityId(activityId);
		productQueryReq.setShortCode(shortCode);
		ProductQueryResponse result = productFacade.getProductByShortCode(productQueryReq);
		if (StringUtil.isBlank(result.getErrorCode())) {
			ProductDetail productDetail = result.getProduct();
			if (productDetail != null) {
				LOGGER.info("商品信息如下：{}", FastJSONHelper.serialize(productDetail));
				resultMap.put(Constants.RESPONSE_CONTENT, productDetail);
			}
		}
		if (BaseApiCode.OPERATE_SYSTEM_FAIL.equals(result.getErrorCode())) {
			resultMap.put(Constants.RESPONSE_NAME, BaseApiCode.OPERATE_SYSTEM_FAIL);
		}
		return resultMap;
	}

}
