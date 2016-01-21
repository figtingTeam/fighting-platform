package com.dongyuan.figting.dao;

import com.dongyuan.figting.entity.FUser;
import com.dongyuan.figting.entity.FUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FUserMapper {
    int countByExample(FUserExample example);

    int deleteByExample(FUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FUser record);

    int insertSelective(FUser record);

    List<FUser> selectByExample(FUserExample example);

    FUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FUser record, @Param("example") FUserExample example);

    int updateByExample(@Param("record") FUser record, @Param("example") FUserExample example);

    int updateByPrimaryKeySelective(FUser record);

    int updateByPrimaryKey(FUser record);
}