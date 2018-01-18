package com.application.v1.daos.impl;

import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ttm
 * @data 2017/11/22
 */
public class UserDaoImpl implements UserRepository {

    @Autowired
    private EntityManager entityManagerFactory;

    private CriteriaBuilder builder;

    private CriteriaQuery<User> criteriaQuery;

    private Root<User> root;

    @Transactional
    @Override
    public boolean userUpdate(User user) {
        try {
            User updateUser = entityManagerFactory.merge(user);
            System.out.println("ttm |" + updateUser.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<User> userList(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> paging) {
        builder = entityManagerFactory.getCriteriaBuilder();
        criteriaQuery = builder.createQuery(User.class);
        root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if (MapUtils.isNotEmpty(query)) {

        }
        return null;
    }

    @Override
    public List<User> userList(Map<String, Object> query, Map<String, Object> sort) {
        return null;
    }

    @Override
    public List<User> userList(Map<String, Object> query) {
        return null;
    }

    @Override
    public User userOne(Map<String, Object> query) {
        return null;
    }
}
