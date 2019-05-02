package com.cloud.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流过滤方案
 * @author 皇甫
 */
@Component
public class RateLimiterFilter extends ZuulFilter {
    /**
     * 创建令牌桶  每一秒放入100个令牌 超过100则抛弃
     * 拿到令牌执行方法 没有拿到执行降级方法
     */
    private final RateLimiter RATELIMITER = RateLimiter.create(100);
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //如果没有没拿到令牌
        if(!RATELIMITER.tryAcquire()){
            try {
                throw new Exception("人家不值得");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
