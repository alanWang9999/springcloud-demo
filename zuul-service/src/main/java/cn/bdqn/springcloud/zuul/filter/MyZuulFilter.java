package cn.bdqn.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyZuulFilter
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@Slf4j
@Component
public class MyZuulFilter extends ZuulFilter
{
    //此方法的返回值，是用来说明此过滤器在什么阶段可以拦截
    @Override
    public String filterType() {
        //    pre：可以在请求被路由之前调用,拿到请求，在转发给对应的微服务之前的阶段
        //    route：在路由请求时候被调用，把请求转发给微服务之后的阶段
        //    post：在被代理的微服务返回结果后的阶段。
        //    error：被代理的微服务发生异常时的阶段
        return "pre";
    }
    //网关里可以存在n个过滤器，此返回值表示本过滤器在n个过滤器中第几个执行
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。我们直接返回true，所以该过滤器总是生效
        return true;
    }
    //过滤器的具体执行逻辑
    @Override
    public Object run()
    {
        RequestContext ctx = RequestContext.getCurrentContext();
        //请求
        HttpServletRequest request = ctx.getRequest();
        //响应对象
        HttpServletResponse response = ctx.getResponse();
        log.info("testFilter接到请求  uri:" + request.getRequestURI());
        return null;
    }
}
