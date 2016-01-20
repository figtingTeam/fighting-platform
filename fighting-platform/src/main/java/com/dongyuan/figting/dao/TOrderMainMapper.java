package com.dongyuan.figting.dao;

import java.util.List;

import com.dongyuan.figting.dao.annotations.IRepository;
import com.dongyuan.figting.entity.TOrderMain;
import com.dongyuan.figting.entity.TOrderMainExample;
import com.dongyuan.figting.dto.response.OrderInfoRes;
import org.apache.ibatis.annotations.Param;

@IRepository
public interface TOrderMainMapper {
	int countByExample(TOrderMainExample example);

	int deleteByExample(TOrderMainExample example);

	int deleteByPrimaryKey(String orderId);

	int insert(TOrderMain record);

	int insertSelective(TOrderMain record);

	List<TOrderMain> selectByExample(TOrderMainExample example);

	TOrderMain selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") TOrderMain record,
			@Param("example") TOrderMainExample example);

	int updateByExample(@Param("record") TOrderMain record,
			@Param("example") TOrderMainExample example);

	int updateByPrimaryKeySelective(TOrderMain record);

	int updateByPrimaryKey(TOrderMain record);
	
	List<OrderInfoRes> getOrdersByTicketId(String ticketId);
}