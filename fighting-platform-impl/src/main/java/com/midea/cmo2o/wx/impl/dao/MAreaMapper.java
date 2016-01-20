package com.midea.cmo2o.wx.impl.dao;

import com.midea.cmo2o.wx.impl.dao.annotations.IRepository;
import com.midea.cmo2o.wx.impl.entity.MArea;
import com.midea.cmo2o.wx.impl.entity.MAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@IRepository
public interface MAreaMapper {
	int countByExample(MAreaExample example);

	int deleteByExample(MAreaExample example);

	int deleteByPrimaryKey(Integer areaCode);

	int insert(MArea record);

	int insertSelective(MArea record);

	List<MArea> selectByExample(MAreaExample example);

	MArea selectByPrimaryKey(Integer areaCode);

	int updateByExampleSelective(@Param("record") MArea record,
			@Param("example") MAreaExample example);

	int updateByExample(@Param("record") MArea record, @Param("example") MAreaExample example);

	int updateByPrimaryKeySelective(MArea record);

	int updateByPrimaryKey(MArea record);
}