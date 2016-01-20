package com.dongyuan.figting.impl.dao;

import com.dongyuan.figting.impl.entity.TOrderItem;
import com.dongyuan.figting.impl.entity.TOrderItemExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderItemMapper {
    int countByExample(TOrderItemExample example);

    int deleteByExample(TOrderItemExample example);

    int deleteByPrimaryKey(String orderItemId);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    List<TOrderItem> selectByExample(TOrderItemExample example);

    TOrderItem selectByPrimaryKey(String orderItemId);

    int updateByExampleSelective(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByExample(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}