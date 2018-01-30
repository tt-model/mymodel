package com.application.v1.controllers;

import com.application.v1.core.MainController;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ttm
 * @data 2017/11/21
 */
@Controller
@RequestMapping(value = "/v1/user")
public class UserController extends BaseContoller {

    @Autowired
    public UserService userService;

    /**
     * 用户管理页面
     * @return
     */
    @RequestMapping(value = "/userManager", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView userManagerGet() {
        List<User> userList = userService.userList(getPageNumber(), getPageSize());
        int userCount = userService.userCount();
        return manager(getPageNumber(), getPageSize(), userList, userCount);
    }

}
