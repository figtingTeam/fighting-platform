package com.dongyuan.figting.dto.log;

import com.midea.trade.common.util.DateUtils;

public class UserLogWithBLOBs extends UserLog {
    private String reqParams;

    private String repData;

    private String exceptionMsg;

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getRepData() {
        return repData;
    }

    public void setRepData(String repData) {
        this.repData = repData;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserLog[reqParams=");
        builder.append(reqParams);
        builder.append(", repData=");
        builder.append(repData);
        builder.append(", exceptionMsg=");
        builder.append(exceptionMsg);
        builder.append(", userId=");
        builder.append(getUserId());
        builder.append(", cn=");
        builder.append(getCn());
        builder.append(", clientIp=");
        builder.append(getClientIp());
        builder.append(", reqUrl=");
        builder.append(getReqUrl());
        builder.append(", reqTime=");
        if (null != getReqTime()) {
        	builder.append(DateUtils.formatDate(getReqTime()));
        }
        builder.append(", repStatus=");
        builder.append(getRepStatus());
        builder.append(", processTime=");
        builder.append(getProcessTime());
        builder.append(", reqEntrytype=");
        builder.append(getReqEntrytype());
        builder.append("]");
        return builder.toString();
    }
    
    public UserLogWithBLOBs clone()
    {
       UserLogWithBLOBs copy = null;    
       try {  
           copy = (UserLogWithBLOBs) super.clone();
       } catch (CloneNotSupportedException e) {
       }
       return copy;    
    }
}
