package com.wutong.order.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zzg on 2018/6/6.
 */
@Component
public class UserLoginFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(UserLoginFilter.class);

    @Override

    /**
     * 过滤器类型
     * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
     */
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 同filterType类型中，order值越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uid = request.getParameter("userid");
        if (StringUtils.isNotEmpty(uid)) {
            request.getSession().setAttribute("login", uid);
        }

        if (request.getRequestURL().toString().contains("buy")) {
            uid = request.getSession().getAttribute("login").toString();
            if (uid == null) {
                logger.warn("access token is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                return null;
            }
        }
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        logger.info("access token ok");
        return null;
    }
}
