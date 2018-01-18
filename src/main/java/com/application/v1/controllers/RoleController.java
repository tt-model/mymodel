package com.application.v1.controllers;

import com.application.v1.orms.Role;
import com.application.v1.orms.User;
import com.application.v1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ttm
 * @data 2017/11/28
 */
@Controller
@RequestMapping(value = "/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "roleManager", method = {RequestMethod.GET})
    public ModelAndView roleManagerGet() {
        return roleManager(0, 0);
    }

    @RequestMapping(value = "roleManager", method = {RequestMethod.POST})
    public ModelAndView roleManagerPost(HttpServletRequest request) {
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        return roleManager(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
    }

    private ModelAndView roleManager(int pageNumber, int pageSize) {
        ModelAndView view = new ModelAndView();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        List<Role> roleList = roleService.roleList(pageNumber, pageSize);
        int roleCount = roleService.roleCount();
        view.addObject("main", "true");
        view.addObject("collection", roleList);
        view.addObject("collectionCount", roleCount);
        view.setViewName("/v1/base/v1-main-content");
        return view;
    }

}
