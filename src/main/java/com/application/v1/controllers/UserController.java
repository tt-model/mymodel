package com.application.v1.controllers;

import com.application.v1.library.Page;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/userManager", method = {RequestMethod.GET})
    public ModelAndView userManagerGet() {
        List<User> userList = userService.userList(getPageNumber(), getPageSize());
        int userCount = userService.userCount();
        return manager(getPageNumber(), getPageSize(), userList, userCount);
    }

    @RequestMapping(value = "/userManager", method = {RequestMethod.POST})
    public ModelAndView userManagerPost(HttpServletRequest request) {
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        try {
            Assert.isNull(pageNumber, "page number is null!");
            Assert.isNull(pageSize, "page siage is null");
            List<User> userList = userService.userList(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
            int userCount = userService.userCount();
            return manager(Integer.valueOf(pageNumber), Integer.valueOf(pageSize), userList, userCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }

}
