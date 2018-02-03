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
public class RoleController extends BaseContoller {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "roleManager", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roleManager(HttpServletRequest request) {
        List<Role> roleList = roleService.getCollection(request);
        Long roleCount = roleService.getCollectionCount(request);
        return manager(getPageNumber(), getPageSize(), roleList, Integer.valueOf(roleCount.toString()));
    }

}
