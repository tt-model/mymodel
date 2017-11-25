package com.application.v1.controllers;

import com.application.v1.library.Page;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author ttm
 * @data 2017/11/21
 */
@Controller
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * 用户管理页面
     * @return
     */
    @RequestMapping(value = "/userManager", method = RequestMethod.GET)
    public ModelAndView userManager(@RequestParam Map<String, Object> paging) {
        ModelAndView view = new ModelAndView();
        List<User> userList = userService.userList();
        view.addObject("main", "true");
        view.addObject("colletion", userList);
        view.setViewName("/v1/base/v1-main-content");
        return view;
    }

}
