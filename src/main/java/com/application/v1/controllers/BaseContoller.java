package com.application.v1.controllers;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BaseContoller {

    private int pageNumber = 1;

    private int pageSize = 20;

    public ModelAndView manager(int pageNumber, int pageSize, List<?> list, int count) {
        ModelAndView view = new ModelAndView();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
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
