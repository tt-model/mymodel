package com.application.v1.controllers;

import com.application.v1.library.Page;
import com.application.v1.services.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BaseContoller {

    private int pageNumber = 1;

    private int pageSize = 20;

    public ModelAndView manager(BaseService service, List<?> list, Long count) {
        ModelAndView view = new ModelAndView();
        PageRequest pageRequest = service.fetchPage();
        view.addObject("main", "true");
        view.addObject("collection", list);
        view.addObject("collectionCount", count.intValue());
        Page page = new Page(count.intValue(), (pageRequest.getPageNumber() + 1), pageRequest.getPageSize());
        view.addObject("paging", page);
        view.setViewName("/v1/base/v1-main-content");
        return view;
    }

    public ModelAndView manager(int pageNumber, int pageSize, List<?> list, int count) {
        ModelAndView view = new ModelAndView();
        view.addObject("main", "true");
        view.addObject("collection", list);
        view.addObject("collectionCount", count);
        view.setViewName("/v1/base/v1-main-content");
        return view;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
