package com.application.v1.services;

import com.application.v1.repositorys.BaseRepository;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * @auther ttm
 * @date 2017/11/29
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * 处理一些数据的方法
     */
    public void execute(HttpServletRequest request);

    /**
     * 获取数据集合
     * @param repository
     * @param request
     * @return
     */
    public List<T> getCollection(BaseRepository repository, HttpServletRequest request);

    /**
     * 获取数据集合数量
     * @param repository
     * @param request
     * @return
     */
    public Long getCollectionCount(BaseRepository repository, HttpServletRequest request);

    /**
     * 获取数据集合
     * @param request
     * @return
     */
    public List<T> getCollection(HttpServletRequest request);

    /**
     * 获取数据集合数量
     * @param request
     * @return
     */
    public Long getCollectionCount(HttpServletRequest request);

    public PageRequest fetchPage();

}
