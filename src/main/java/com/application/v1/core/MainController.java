package com.application.v1.core;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther ttm
 * @date 2017/11/27
 */
@org.springframework.stereotype.Controller
public class MainController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return handleRequest(httpServletRequest, httpServletResponse);
    }
}
