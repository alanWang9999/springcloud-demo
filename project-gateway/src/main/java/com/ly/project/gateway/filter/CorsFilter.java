package com.ly.project.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CorsFilter
 * @Author alan.wang   QQ:3103484396
 * @Description 解决跨域问题的过滤器
 */
@Component
public class CorsFilter extends ZuulFilter
{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletResponse response = ctx.getResponse();
        //解决跨域问题，只需要在响应的头信息中加入一些字段即可
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,token");
        if ("options".equals(ctx.getRequest().getMethod().toLowerCase())) {
            ctx.setSendZuulResponse(false);//这行代码执行后，zuul就不会把请求转发给其他服务了
            ctx.setResponseStatusCode(HttpStatus.OK.value());
            return null;
        }
        return null;
    }
}
