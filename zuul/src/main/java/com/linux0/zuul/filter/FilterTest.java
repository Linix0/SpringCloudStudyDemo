package com.linux0.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenhang
 * @Title: FilterTest
 * @ProjectName SpringCloudStudyDemo
 * @Description: TODO
 * @date 2019/11/7 000716:00
 */
public class FilterTest extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(FilterTest.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *         pre：可以在请求被路由之前调用
     *         routing：在路由请求时候被调用
     *         post：在routing和error过滤器之后被调用
     *         error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行
     * 通过此函数可实现过滤器的开关
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            //通过设置setSendZuulResponse(false)过滤该请求
            ctx.setSendZuulResponse(false);
            //设置状态码
            ctx.setResponseStatusCode(401);
            return null;
        }else{
            //设置返回内容
            //ctx.setResponseBody("it's zuul");

            log.info("access token ok");
        }
        return null;
    }
}
