package com.dongyuan.figting.dto.log;

import java.util.Date;

public class UserLog implements Cloneable{
    public static final byte REQ_ENTRYTYPE_HTTP = 1;
    public static final byte REQ_ENTRYTYPE_HESSIAN = 2;
    
    private Long userLogId;

    private Long userId;

    private String cn;

    private String clientIp;

    private String reqUrl;

    private Date reqTime;

    private String repStatus;

    private Integer processTime;

    private Byte reqEntrytype;

    public Long getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(Long userLogId) {
        this.userLogId = userLogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public String getRepStatus() {
        return repStatus;
    }

    public void setRepStatus(String repStatus) {
        this.repStatus = repStatus;
    }

    public Integer getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Integer processTime) {
        this.processTime = processTime;
    }

    public Byte getReqEntrytype() {
        return reqEntrytype;
    }

    public void setReqEntrytype(Byte reqEntrytype) {
        this.reqEntrytype = reqEntrytype;
    }
}