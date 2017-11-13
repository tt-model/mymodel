package com.application.v1.controllers;

import com.application.v1.daos.UserDao;
import com.application.v1.orms.User;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Controller
@RequestMapping(value = "/v1/admin")
@SessionAttributes(value = {"loginUser"})
public class HelloContoller {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> view) {
        view.put("main", "true");
        List<User> userList = userDao.findAll();
        view.put("colletion", userList);
        return "/v1/admin/user/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/v1/admin/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Map<String, Object> view) {
        view.put("loginUser", user);
        return "redirect:/v1/admin/index";
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(Map<String, Object> view) {
        view.remove("loginUser");
        return "/v1/admin/user/index";
    }

}
