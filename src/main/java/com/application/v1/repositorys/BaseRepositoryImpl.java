package com.application.v1.repositorys;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 基类实现类
 * @auther ttm
 * @date 2018/2/1
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Override
    public T getCollection(Class classes) {
        return null;
    }

    @Override
    public Long getCollectionCount(Class classes) {
        return null;
    }

    private final static class ByQuerysSpecification<T> implements Specification<T> {

        private Map<String, Object> query;

        public ByQuerysSpecification(Map<String, Object> query) {
            super();
            this.query = query;
        }

        @Override
        public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicateQuery = new ArrayList<>();
            if (MapUtils.isNotEmpty(query)) {
                for (String keyRow : query.keySet()) {
                    Object keyRowValue = query.get(keyRow);
                    if (keyRowValue instanceof Map) {

                    } else {
                        //不为map就进行数据eq操作
                        Predicate predicate = criteriaBuilder.equal(root.get(keyRow), keyRowValue);
                        predicateQuery.add(predicate);
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(predicateQuery)) {
                criteriaQuery.where(predicateQuery.toArray(new Predicate[predicateQuery.size()]));
            }
            return criteriaQuery.getRestriction();
        }

    }

}
