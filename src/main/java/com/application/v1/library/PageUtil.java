package com.application.v1.library;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @auther ttm
 * @date 2018/2/5
 */
public class PageUtil extends AbstractPageRequest {

    private Sort sort;

//    public PageUtil(int page, int size, int totalCount, String sortColumn) {
//
//    }

    public PageUtil(int page, int size, String sortColumn) {
        this(page, size, new Sort(Sort.Direction.DESC, sortColumn));
    }

    public PageUtil(int page, int size, Sort sort) {
        super(page, size);
        this.sort = sort;
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    /**
     * 下一页
     * @return
     */
    @Override
    public Pageable next() {
        return null;
    }

    /**
     * 上一页
     * @return
     */
    @Override
    public Pageable previous() {
        return null;
    }

    /**
     * 第一页
     * @return
     */
    @Override
    public Pageable first() {
        return null;
    }

}
