package com.midea.cmo2o.wx.impl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.midea.cmo2o.wx.impl.Constants;
import com.midea.cmo2o.wx.impl.dao.MAreaMapper;
import com.midea.cmo2o.wx.impl.dto.response.AreaRes;
import com.midea.cmo2o.wx.impl.entity.MArea;
import com.midea.cmo2o.wx.impl.entity.MAreaExample;
import com.midea.cmo2o.wx.impl.service.IAreaService;
import com.midea.cmo2o.wx.impl.utils.CacheKeyRegistry;
import com.midea.cmo2o.wx.impl.utils.FastJSONHelper;
import com.midea.cmo2o.wx.impl.utils.JedisUtil;
import com.midea.cmo2o.wx.impl.utils.StringUtils;

/**
 * 类AreaServiceImpl.java的实现描述：地区服务类
 * 
 * @author huanghf 2015年12月30日 上午9:19:19
 * @email haifeng1.huang@midea.com
 */
@Service(value = "areaService")
public class AreaServiceImpl implements IAreaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AreaServiceImpl.class);

	@Autowired
	private MAreaMapper areaMapper;

	// 该方法就为了加一个hasSubArea属性
	@Override
	public List<AreaRes> getAreas(Integer parentCode) {
		Assert.notNull(parentCode);
		String areaDetailCacheKey = CacheKeyRegistry.getAreaDetailCacheKey(parentCode + "");
		String areaJson = JedisUtil.getJedisInstance().execGetFromCache(areaDetailCacheKey);
		if (StringUtils.isBlank(areaJson)) {
			LOGGER.info("数据库中获取地区详细信息...");
			List<MArea> mAreas = getBasicAreas(parentCode);
			List<AreaRes> areaList = new ArrayList<AreaRes>();
			AreaRes areaRes = null;
			for (MArea item : mAreas) {
				areaRes = new AreaRes();
				BeanUtils.copyProperties(item, areaRes);
				List<MArea> areas = getBasicAreas(item.getAreaCode());
				if (CollectionUtils.isNotEmpty(areas)) {
					areaRes.setHasSubArea(true);
				}
				areaList.add(areaRes);
			}
			JedisUtil.getJedisInstance().execSetexToCache(areaDetailCacheKey,
					Constants.REDIS_ONEDAY, FastJSONHelper.serialize(areaList));
			return areaList;
		} else {
			LOGGER.info("缓存中获取地区详细信息...");
			return FastJSONHelper.deserializeList(areaJson, AreaRes.class);
		}
	}

	public List<MArea> getBasicAreas(Integer parentCode) {
		Assert.notNull(parentCode);
		String areaCacheKey = CacheKeyRegistry.getAreaCacheKey(parentCode + "");
		String areaJson = JedisUtil.getJedisInstance().execGetFromCache(areaCacheKey);
		if (StringUtils.isBlank(areaJson)) {
			LOGGER.info("数据库中获取地区信息...");
			MAreaExample example = new MAreaExample();
			if (parentCode != null) {
				example.createCriteria().andParentCodeEqualTo(parentCode);
			}
			List<MArea> areas = areaMapper.selectByExample(example);
			JedisUtil.getJedisInstance().execSetexToCache(areaCacheKey, Constants.REDIS_ONEDAY,
					FastJSONHelper.serialize(areas));
			return areas;
		} else {
			LOGGER.info("缓存中获取地区信息...");
			return FastJSONHelper.deserializeList(areaJson, MArea.class);
		}
	}

}
