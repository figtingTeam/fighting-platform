package com.midea.cmo2o.wx.impl.core.excute;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * 服务处理方法代码
 */
public interface ServiceMethod<T> {

    /**
     * 执行服务调用操作
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    T invoke();
}
