package com.midea.cmo2o.wx.impl.entity;

import java.util.Date;

public class TOrderAddr {
    private String orderId;

    private Long activityId;

    private String receiverName;

    private Integer receiverProvince;

    private String receiverProvinceName;

    private Integer receiverCity;

    private String receiverCityName;

    private Integer receiverCounty;

    private String receiverCountyName;

    private String receiverAddress;

    private String receiverAddrDetail;

    private Integer receiverZip;

    private String receiverMobile;

    private String receiverPhone;

    private Date createTime;

    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public Integer getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(Integer receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverProvinceName() {
        return receiverProvinceName;
    }

    public void setReceiverProvinceName(String receiverProvinceName) {
        this.receiverProvinceName = receiverProvinceName == null ? null : receiverProvinceName.trim();
    }

    public Integer getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(Integer receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCityName() {
        return receiverCityName;
    }

    public void setReceiverCityName(String receiverCityName) {
        this.receiverCityName = receiverCityName == null ? null : receiverCityName.trim();
    }

    public Integer getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(Integer receiverCounty) {
        this.receiverCounty = receiverCounty;
    }

    public String getReceiverCountyName() {
        return receiverCountyName;
    }

    public void setReceiverCountyName(String receiverCountyName) {
        this.receiverCountyName = receiverCountyName == null ? null : receiverCountyName.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverAddrDetail() {
        return receiverAddrDetail;
    }

    public void setReceiverAddrDetail(String receiverAddrDetail) {
        this.receiverAddrDetail = receiverAddrDetail == null ? null : receiverAddrDetail.trim();
    }

    public Integer getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(Integer receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}