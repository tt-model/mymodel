package com.application.v1.controllers;

import com.application.v1.library.JsonUtil;
import com.application.v1.library.ServiceResponse;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/7
 */
@Controller
@RequestMapping(value = "/v1/admin")
@SessionAttributes(value = {"loginUser"})
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户进入登录界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> view) {
        User user = ( User ) view.get("loginUser");
        if (user == null) {
            return "/v1/admin/user/login";
        }
        return "/v1/admin/index";
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user) {
        ModelAndView view = new ModelAndView();
        ServiceResponse response = userService.userOne(user);
        if (response.getCode() == 200) {
            view.addObject("loginUser", response.getResult());
        }
        view.addObject("response", JsonUtil.toJson(response));
        view.setViewName("/v1/base/response");
        return view;
    }

    /**
     * 用户注销
     * @param view
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(Map<String, Object> view) {
        view.remove("loginUser");
        return "/v1/admin/user/index";
    }

}
