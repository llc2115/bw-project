package com.mz.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * 拦截器
 */
@Slf4j
public class TranslateInterceptor implements HandlerInterceptor {


    long start = System.currentTimeMillis();

    private Set<String> ips;

    private Boolean ipAuthSwitch;

    public TranslateInterceptor( Set<String> ips, Boolean ipAuthSwitch) {
        this.ips = ips;
        this.ipAuthSwitch = ipAuthSwitch;
    }

    /**
     * preHandle是在请求执行前执行的
     *
     * 1.IP拦截
     *
     * 2.根据不同的认证类型，增加不同的逻辑处理
     *
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        start = System.currentTimeMillis();

        String ip = request.getRemoteAddr();
        log.info("request ip: " + ip);

        /**
         * 返回true,postHandler和afterCompletion方法才能执行
         * 否则false为拒绝执行，起到拦截器控制作用
         */
        //1.ip拦截
        if (ipAuthSwitch) {
            if( null == ip || "".equals(ip) || !ips.contains(ip)){
                log.info("ip:{} No authority", ip);
                return false;
            }
        }

        return true;
    }



    /**
     * postHandler是在请求结束之后,视图渲染之前执行的,但只有preHandle方法返回true的时候才会执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("Interception cost=" + (System.currentTimeMillis() - start));
    }

    /**
     * afterCompletion是视图渲染完成之后才执行,同样需要preHandle返回true
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //该方法通常用于清理资源等工作
    }


}
