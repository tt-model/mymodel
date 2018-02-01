package com.application.v1.interceptors;

import com.application.v1.BaseParseXml;
import com.application.v1.core.session.FilterSession;
import com.application.v1.core.session.MapSession;
import com.application.v1.library.JsonUtil;
import com.application.v1.library.Page;
import com.application.v1.orms.User;
import com.application.v1.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
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
        User loginUser = ShiroUtils.getUser();
        if (loginUser == null) {
            response.sendRedirect("/v1/admin/login");
            return false;
        }
        //获取session 对session进行处理
        String sessionId = request.getRequestedSessionId();
        HttpSession session = request.getSession();
        MapSession mapSession = (MapSession) session.getAttribute(FilterSession.FILTER);
        FilterSession filterSession = new FilterSession();
        String method = request.getMethod();
        String postMethod = RequestMethod.POST.name().toUpperCase();
        //如果是post请求 目前当成管理页面请求
        if (postMethod.equals(method)) {

        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("post handle");
        //如果对应的请求设置了 这几个值 说明页面需要做解析处理
        if (modelAndView.getModelMap().containsAttribute("main")) {
            BaseParseXml baseParseXml = new BaseParseXml();
            String requestUrl = request.getRequestURI();
            System.out.println("ttm | " + requestUrl);
            String[] actionNames = StringUtils.split(requestUrl, "/");
            baseParseXml.parseMainXml(actionNames[(actionNames.length - 1)]);
            modelAndView.addAllObjects(baseParseXml.getXmlMap());
            modelAndView.addObject("method", request.getMethod());
//            modelMap.putAll(baseParseXml.getXmlMap());
//            modelMap.put("method", request.getMethod());
            //paging
            String pageNumber = request.getParameter("pageNumber");
            String pageSize = request.getParameter("pageSize");
            if (StringUtils.isEmpty(pageNumber)) {
                pageNumber = "1";
            }
            if (StringUtils.isEmpty(pageSize)) {
                pageSize = "10";
            }
            Integer collectionCount = ( Integer ) modelAndView.getModelMap().get("collectionCount");
            if (collectionCount == null) {
                collectionCount = 0;
            }
            Page page = new Page(collectionCount, Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
            modelAndView.addObject("paging", page);
//            modelMap.put("paging", page);
            System.out.println("show modelAndView : " + JsonUtil.toJson(modelAndView));
        } else if (modelAndView.getModelMap().containsKey("add")) {

        } else if (modelAndView.getModelMap().containsKey("edit")) {

        }
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("after completion");
        super.afterCompletion(request, response, handler, ex);
    }
}
