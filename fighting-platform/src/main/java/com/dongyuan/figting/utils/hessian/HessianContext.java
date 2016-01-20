package com.dongyuan.figting.utils.hessian;

import javax.servlet.http.HttpServletRequest;

public class HessianContext {
    private static final ThreadLocal<HttpServletRequest> localContext = 
            new ThreadLocal<HttpServletRequest>();

    public static void setRequest(HttpServletRequest request) {
       localContext.set(request);
    }

    public static HttpServletRequest getRequest() {
        return localContext.get();
    }
}