package com.forezp.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 不同生命周期的过滤器类型
     * pre:路由之前
     * routing:路由之时
     * post:路由之后
     * error:发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否过滤
    @Override
    public boolean shouldFilter() {
        //需要过滤时改为true
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("accessToken is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("OK");
        return null;
    }
}
