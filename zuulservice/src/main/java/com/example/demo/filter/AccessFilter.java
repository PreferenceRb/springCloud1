package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kobe on 2018/10/26.
 */
public class AccessFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object obj = request.getParameter("accessToken");
        if (obj == null){
            log.warn("access token is empty");
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
