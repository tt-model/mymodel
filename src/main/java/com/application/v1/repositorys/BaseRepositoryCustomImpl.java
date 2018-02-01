package com.application.v1.repositorys;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

public class BaseRepositoryCustomImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    public BaseRepositoryCustomImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepositoryCustomImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<T> getCollection(SpecificationOperator query) {
        if (MapUtils.isNotEmpty(query)) {
            BaseRepositoryCustomImpl.ByQuerySpecification operatorQuery = new BaseRepositoryCustomImpl.ByQuerySpecification(query);
           return findAll(operatorQuery, (Sort) null);
        }
        return findAll();
    }

    private static final class ByQuerySpecification<T> implements Specification {

        private SpecificationOperator query;

        public ByQuerySpecification(SpecificationOperator query) {
            this.query = query;
        }

        @Override
        public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (MapUtils.isNotEmpty(query)) {
                List<Predicate> predicates = new ArrayList<>();
                for (Object keyRow : query.keySet()) {
                    Object valueRow = query.get(keyRow);
                    if (valueRow instanceof Map) {

                    } else {
                        //相等于情况
                        Predicate predicate = criteriaBuilder.equal(root.get(keyRow.toString()), valueRow);
                        predicates.add(predicate);
                    }
                }
                if (CollectionUtils.isNotEmpty(predicates)) {
                    criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                }
            }

            return null;
        }
    }

}