package com.dongyuan.figting.impl.dao;

import com.dongyuan.figting.impl.entity.MAreaExample;
import com.dongyuan.figting.impl.dao.annotations.IRepository;
import com.dongyuan.figting.impl.entity.MArea;

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