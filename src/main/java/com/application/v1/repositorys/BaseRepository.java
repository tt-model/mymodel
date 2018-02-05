package com.application.v1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    public List<T> getCollection(SpecificationOperator query);

    public Long getCollectionCount(SpecificationOperator query);

}
