package com.application.v1.controllers;

import com.application.v1.core.MainController;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ttm
 * @data 2017/11/21
 */
@Controller
@RequestMapping(value = "/v1/user")
public class UserController extends MainController {

    @Autowired
    public UserService userService;

    /**
     * 用户管理页面
     * @return
     */
    @RequestMapping(value = "/userManager", method = {RequestMethod.GET})
    public ModelAndView userManagerGet() {
        return userManager(0, 20);
    }

    @RequestMapping(value = "/userManager", method = {RequestMethod.POST})
    public ModelAndView userManagerPost(HttpServletRequest request) {
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        return userManager(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
    }

    private ModelAndView userManager(int pageNumber, int pageSize) {
        ModelAndView view = new ModelAndView();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        List<User> userList = userService.userList(pageNumber, pageSize);
        int userCount = userService.userCount();
        view.addObject("main", "true");
        view.addObject("collection", userList);
        view.addObject("collectionCount", userCount);
        view.setViewName("/v1/base/v1-main-content");
        return view;
    }

}
