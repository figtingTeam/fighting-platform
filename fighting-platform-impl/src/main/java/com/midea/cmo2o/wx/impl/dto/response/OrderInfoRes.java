package com.midea.cmo2o.wx.impl.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.midea.cmo2o.wx.impl.core.fieldpack.annotions.PackEntity;



public class OrderInfoRes {

	// 订单编号
	private String orderId;

	// 订单状态
	private int orderStatus;

	// 订单状态名称
	@PackEntity(cacheKey = "cmo2o:orderStatusName", dbColumn = "dd_label", idFieldName = "orderStatus", querySql = "select dd_label from m_dd_value where dd_key='orderStatus' and dd_value=?")
	private String orderStatusName;

	// 成交时间
	private Date payTime;

	// 收货人姓名
	private String receiverName;

	// 收货人电话
	private String receiverMobile;

	// 收货人详细地址
	private String receiverAddress;

	// 商品总金额
	private BigDecimal itemAmount;

	// 优惠金额
	private BigDecimal discountAmount;

	// 调整金额
	private BigDecimal adjustAmount;

	// 应付金额
	private BigDecimal paymentAmount;

	// 备注
	private String memo;

	// 订单商品列表
	List<OrderItemInfoRes> orderItems;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getAdjustAmount() {
		return adjustAmount;
	}

	public void setAdjustAmount(BigDecimal adjustAmount) {
		this.adjustAmount = adjustAmount;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<OrderItemInfoRes> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemInfoRes> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

}
