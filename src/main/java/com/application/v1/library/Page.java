package com.application.v1.library;

import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页工具
 * @auther ttm
 * @date 2017/11/20
 */
public class Page implements Serializable {

    /**
     * 当前页
     */
    private int pageNumber = 1;

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
    private int rollPages = 11;

    /**
     * 是否下一页
     */
    private boolean downRow;

    /**
     * 是否上一页
     */
    private boolean upRow;

    /**
     * 是否第一页
     */
    private boolean firstRow;

    /**
     * 是否最后一页
     */
    private boolean endRow;

    private int upNumber;

    private int downNumber;

    private int firstNumber;

    private int endNumber;

    /**
     * 数字分页连接
     */
    private List<Integer> linkPages;

    private PageRequest pageRequest;

    public Page(int totalRows, Map<String, Object> paging) {
        this(totalRows,
                Integer.valueOf(paging.get("pageNumber").toString()),
                Integer.valueOf(paging.get("pageSize").toString()));
    }

    /**
     * 初始化构建分页
     * @param totalRows
     * @param pageNumber
     * @param pageSize
     */
    public Page(int totalRows, int pageNumber, int pageSize) {
        //总数量
        this.totalRows = totalRows;
        //当前页
        this.pageNumber = initPageNumber(pageNumber);
        //每页显示数量
        this.pageSize = pageSize;
        //初始化总页数
        totalPages = initTotalPages(totalRows, pageSize);
        //第一页
        initFirstRow(this.pageNumber, totalPages, rollPages);
        //最后一页
        initEndRow(this.pageNumber, totalPages, rollPages);
        //上一页
        initUpRow(this.pageNumber);
        //下一页
        initDownRow(this.pageNumber, totalPages);
        //数字分页
        linkPages = linkPages(pageNumber, totalPages, rollPages);
    }

    /**
     * 初始化 当前页
     * @param pageNumber
     * @return
     */
    private int initPageNumber(int pageNumber) {
        return pageNumber > 0 ? pageNumber : 1;
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
    private void initUpRow(int pageNumber) {
        upNumber = pageNumber - 1;
        if (upNumber > 0) {
            upRow = true;
        } else {
            upRow = false;
        }
    }

    /**
     * 下一页
     * @param pageNumber
     * @return
     */
    private void initDownRow(int pageNumber, int totalPages) {
        downNumber = pageNumber + 1;
        if (downNumber < totalPages) {
            downRow = true;
        } else {
            downRow = false;
        }
    }

    /**
     * 第一页
     * @return
     */
    private void initFirstRow(int pageNumber, int totalPages, int rollPages) {
        int tmpRollPage = rollPages / 2;
        if (totalPages > rollPages && (pageNumber - tmpRollPage) >= 1) {
            firstNumber = 1;
            firstRow = true;
        } else {
            firstNumber = 0;
            firstRow = false;
        }
    }

    /**
     * 最后一页
     * @return
     */
    private void initEndRow(int pageNumber, int totalPages, int rollPages) {
        int tmpRollPage = rollPages / 2;
        if ((totalPages > rollPages && (pageNumber + tmpRollPage) < totalPages)) {
            endNumber = totalPages;
            endRow = true;
        } else {
            endNumber = 0;
            endRow = false;
        }
    }

    /**
     * 初始化 数字连接集合
     * @param pageNumber
     * @param totalPages
     * @param rollPages
     * @return
     */
    private List<Integer> linkPages(int pageNumber, int totalPages, int rollPages) {
        List<Integer> linkPages = new ArrayList<>();
        if (totalPages <= 0) {
            return linkPages;
        }
        int tmpRollPage = rollPages / 2;
        int tmpPageNumber = pageNumber;
        if (totalPages > 0 && tmpPageNumber > totalPages) {
            tmpPageNumber = totalPages;
        }
        for (int page = 1; page <= rollPages; page++) {
            int currentPage = 0;
            if ((tmpPageNumber - tmpRollPage) <= 0) {
                currentPage = page;
            } else if ((tmpPageNumber + tmpRollPage - 1) >= totalPages) {
                currentPage = (totalPages - rollPages + page);
            } else {
                currentPage = (tmpPageNumber - tmpRollPage + page);
            }
            if (currentPage > 0 && currentPage <= totalPages) {
                linkPages.add(currentPage);
            }
        }
        return linkPages;
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

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRollPages() {
        return rollPages;
    }

    public void setRollPages(int rollPages) {
        this.rollPages = rollPages;
    }

    public boolean isDownRow() {
        return downRow;
    }

    public void setDownRow(boolean downRow) {
        this.downRow = downRow;
    }

    public boolean isUpRow() {
        return upRow;
    }

    public void setUpRow(boolean upRow) {
        this.upRow = upRow;
    }

    public boolean isFirstRow() {
        return firstRow;
    }

    public void setFirstRow(boolean firstRow) {
        this.firstRow = firstRow;
    }

    public boolean isEndRow() {
        return endRow;
    }

    public void setEndRow(boolean endRow) {
        this.endRow = endRow;
    }

    public List<Integer> getLinkPages() {
        return linkPages;
    }

    public void setLinkPages(List<Integer> linkPages) {
        this.linkPages = linkPages;
    }

    public int getUpNumber() {
        return upNumber;
    }

    public void setUpNumber(int upNumber) {
        this.upNumber = upNumber;
    }

    public int getDownNumber() {
        return downNumber;
    }

    public void setDownNumber(int downNumber) {
        this.downNumber = downNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", rollPages=" + rollPages +
                ", downRow=" + downRow +
                ", upRow=" + upRow +
                ", firstRow=" + firstRow +
                ", endRow=" + endRow +
                ", upNumber=" + upNumber +
                ", downNumber=" + downNumber +
                ", firstNumber=" + firstNumber +
                ", endNumber=" + endNumber +
                ", linkPages=" + linkPages +
                '}';
    }
}
