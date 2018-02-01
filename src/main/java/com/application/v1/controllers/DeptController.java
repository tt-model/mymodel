package com.application.v1.controllers;

import com.application.v1.orms.Dept;
import com.application.v1.services.DeptService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/v1/dept")
public class DeptController extends BaseContoller {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/deptManager", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView deptManagerGet(HttpServletRequest request) {
        Map<String, Object> parameterMap = request.getParameterMap();
        List<Dept> deptList = deptService.getCollection(parameterMap);
        int deptCount = deptService.deptCount();
        return manager(getPageNumber(), getPageSize(), deptList, deptCount);
    }

}
