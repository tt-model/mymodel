package com.application.v1.core.session;

import com.application.v1.library.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.context.ServletConfigAware;

/**
 * 分页 session
 * @auther ttm
 * @date 2017/11/27
 */
public class PageSession {

    public static final String PAGE = "page";

    /**
     * dao 层分页对象
     */
    private PageRequest pageRequest;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

}
