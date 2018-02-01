package com.application.v1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 访问数据库基类
 * @auther ttm
 * @date 2018/2/1
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    public T getCollection(Class classes);

    public Long getCollectionCount(Class classes);

}
