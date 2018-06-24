package com.application.v1.controllers;

import com.application.v1.library.JsonUtil;
import com.application.v1.library.ServiceResponseUtil;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import com.application.v1.shiro.ShiroUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/7
 */
@Controller
@RequestMapping(value = "/v1/admin")
public class LoginController {

    private final static Logger LOG = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户进入登录界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> view) {
        User user = ShiroUtils.getUser();
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

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            ShiroUtils.getSubject().login(token);
            view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.success()));
        } catch (UnknownAccountException e) {
            LOG.error("验证错误");
        } catch (Exception e) {
            LOG.error("未知错误");
            view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.error()));
        }
        view.setViewName("/v1/base/response");
        return view;
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        if (ShiroUtils.isLogin()) {
            ShiroUtils.logout();
        }
        return "/v1/admin/user/login";
    }

}
