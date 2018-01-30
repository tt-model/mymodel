package com.application.v1.core.session;

import com.application.v1.library.Page;
import org.springframework.web.context.ServletConfigAware;

/**
 * 分页 session
 * @auther ttm
 * @date 2017/11/27
 */
public class PageSession {

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
