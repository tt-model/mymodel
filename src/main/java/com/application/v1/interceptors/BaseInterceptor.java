package com.application.v1.interceptors;

import com.application.v1.BaseParseXml;
import com.application.v1.orms.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义拦截器
 * @auther ttm
 * @date 2017/11/4
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = Logger.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {super.preHandle(request, response, handler);
        logger.info("pre handle");
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("/v1/admin/login");
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("post handle");
        Map<String, Object> modelMap = modelAndView.getModel();
        //如果对应的请求设置了 这几个值 说明页面需要做解析处理
        if (modelMap.containsKey("main")) {
            BaseParseXml baseParseXml = new BaseParseXml();
            String requestUrl = request.getRequestURI();
            System.out.println("ttm | " + requestUrl);
            String[] actionNames = StringUtils.split(requestUrl, "/");
            baseParseXml.parseMainXml(actionNames[(actionNames.length - 1)]);
            modelAndView.addAllObjects(baseParseXml.getXmlMap());
        } else if (modelMap.containsKey("add")) {

        } else if (modelMap.containsKey("edit")) {

        }
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("after completion");
        super.afterCompletion(request, response, handler, ex);
    }
}
