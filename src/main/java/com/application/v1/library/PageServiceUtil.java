package com.application.v1.library;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 查询数据层的分页对象
 */
public class PageServiceUtil extends AbstractPageRequest {

    /**
     * 排序
     */
    private Sort sort;

    /**
     * 排序对应的列
     */
    private String sortColumn;

    private PageServiceUtil(int page, int size, Sort sort) {
        super(page, size);
        this.sort = sort;
    }

    private PageServiceUtil(int page, int size) {
        super(page, size);

    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previous() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

}
