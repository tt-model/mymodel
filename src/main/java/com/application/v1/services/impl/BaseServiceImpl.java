package com.application.v1.services.impl;

import com.application.v1.services.BaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther ttm
 * @date 2017/11/29
 */
public class BaseServiceImpl implements BaseService {

    /**
     * 获取用户数据集合
     *
     * @param request 前台请求参数
     * @return
     */
    @Override
    public List userList(HttpServletRequest request) {
        return null;
    }
}
