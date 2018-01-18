package com.application.v1.controllers;

import com.application.v1.daos.UserDao;
import com.application.v1.orms.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Controller
@RequestMapping(value = "/v1/text")
public class HelloContoller {

    private static final Logger logger = Logger.getLogger(HelloContoller.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> view) {
//        view.put("main", "true");
//        List<User> userList = userDao.findAll();
//        view.put("colletion", userList);
//        view.put("total", userList.size());
        return "/v1/test/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index(HttpServletRequest request) {
        System.out.println("ttm : " + request.getParameterMap());
        //search
        Enumeration requestParams = request.getParameterNames();
        for (;requestParams.hasMoreElements();) {
            String params = ( String ) requestParams.nextElement();
            String value = request.getParameter(params);
            logger.info("show request data: "+ params + " " + value);
        }
        return "success";
    }

}
