package com.application.v1.controllers;

import com.application.v1.daos.UserDao;
import com.application.v1.orms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Controller
@RequestMapping(value = "/v1/text")
public class HelloContoller {

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
    public String index(HttpServletRequest request) {
        return "success";
    }

}
