package com.midea.cmo2o.wx.impl.dao;

import com.midea.cmo2o.wx.impl.dao.annotations.IRepository;
import com.midea.cmo2o.wx.impl.entity.TOrderAddr;
import com.midea.cmo2o.wx.impl.entity.TOrderAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@IRepository
public interface TOrderAddrMapper {
    int countByExample(TOrderAddrExample example);

    int deleteByExample(TOrderAddrExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TOrderAddr record);

    int insertSelective(TOrderAddr record);

    List<TOrderAddr> selectByExample(TOrderAddrExample example);

    TOrderAddr selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TOrderAddr record, @Param("example") TOrderAddrExample example);

    int updateByExample(@Param("record") TOrderAddr record, @Param("example") TOrderAddrExample example);

    int updateByPrimaryKeySelective(TOrderAddr record);

    int updateByPrimaryKey(TOrderAddr record);
}