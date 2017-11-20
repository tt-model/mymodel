package com.application.v1.library;

/**
 * 分页工具
 * @auther ttm
 * @date 2017/11/20
 */
public class Page {

    /**
     * 起始页
     */
    private int pageNumber;

    /**
     * 每页显示行数
     */
    private int pageSize;

    /**
     * 总数量
     */
    private int totalRows;

    /**
     * 分页数
     */
    private int totalPages;

    /**
     * 分页栏每页显示数量
     */
    private int rollPages = 10;

    private int nowPage = 1;

    /**
     * 下一页
     */
    private int downRow;

    /**
     * 上一页
     */
    private int upRow;

    /**
     * 第一页
     */
    private int firstRow;

    /**
     * 最后一页
     */
    private int endRow;

    /**
     * 初始化构建分页
     * @param totalRows
     * @param pageNumber
     * @param pageSize
     */
    public Page(int totalRows, int pageNumber, int pageSize) {
        this.totalRows = totalRows;
        this.nowPage = initPageNumber(pageNumber);
        this.pageNumber = pageSize * (nowPage - 1);
        this.pageSize = pageSize;
    }

    /**
     * 初始化 起始页
     * @param pageNumber
     * @return
     */
    private int initPageNumber(int pageNumber) {
        return pageNumber <= 0 ? nowPage : pageNumber;
    }

    /**
     * 初始化 总页数
     * @param totalRows
     * @param pageSize
     * @return
     */
    private int initTotalPages(int totalRows, int pageSize) {
        return (totalRows + pageSize - 1) / pageSize;
    }

    /**
     * 上一页
     * @param pageNumber
     * @return
     */
    private int initUpRow(int pageNumber) {
        return pageNumber - 1;
    }

    /**
     * 下一页
     * @param pageNumber
     * @return
     */
    private int initDownRow(int pageNumber) {
        return pageNumber + 1;
    }

    /**
     * 第一页
     * @return
     */
    private int initFirstRow() {
        return 1;
    }

    /**
     * 最后一页
     * @return
     */
    private int initEndRow() {
        return totalPages;
    }


}
