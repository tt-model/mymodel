package com.application.v1.controllers;

import com.application.v1.library.DumperUtil;
import com.application.v1.library.JsonUtil;
import com.application.v1.library.ServiceResponseUtil;
import com.application.v1.library.select.DeptNameSelect;
import com.application.v1.orms.User;
import com.application.v1.services.BaseService;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ModelAndView userManager(HttpServletRequest request) {
        userService.execute(request);
        Long userCount = userService.getCollectionCount(request);
        List<User> userList = userService.getCollection(request);
        return manager(userService, userList, userCount);
    }

    /**
     * 创建用户信息
     * @return
     */
    @RequestMapping(value = "/userCreator", method = RequestMethod.GET)
    public ModelAndView userCreator() {
        DeptNameSelect deptNameSelect = new DeptNameSelect();
        Map<String, Object> deptOptions = deptNameSelect.getOption();
        ModelAndView view = new ModelAndView();
        view.addObject("deptOption", deptOptions);
        view.setViewName("/v1/base/v1-create-edit-content");
        return view;
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping(value = "/userEdit/{id}", method = RequestMethod.GET)
    public ModelAndView userEdit(@PathVariable(value = "id") Long id) {
        DeptNameSelect deptNameSelect = new DeptNameSelect();
        Map<String, Object> deptOptions = deptNameSelect.getOption();
        User userFind = userService.userFind(id);

        ModelAndView view = new ModelAndView();
        view.addObject("deptOption", deptOptions);
        view.addObject("user", userFind);
        view.setViewName("/v1/base/v1-create-edit-content");
        return view;
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/userSave", method = RequestMethod.POST)
    public ModelAndView userSave(User user) {
        ModelAndView view = new ModelAndView();
        try {
            if (userService.userSave(user)) {
                view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.success()));
            } else {
                view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.fail("User save fail")));
            }
        } catch (Exception e){
            e.printStackTrace();
            view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.error()));
        }
        view.setViewName("/v1/base/response");
        return view;
    }

    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.POST)
    public ModelAndView userDelete(@PathVariable(value = "id") Long id) {
        ModelAndView view = new ModelAndView();
        userService.userDelete(id);
        view.addObject("response", JsonUtil.toJson(ServiceResponseUtil.success()));
        view.setViewName("/v1/base/response");
        return view;
    }

}
