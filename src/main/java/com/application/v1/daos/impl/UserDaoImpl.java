package com.application.v1.daos.impl;

import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author ttm
 * @data 2017/11/22
 */
public class UserDaoImpl implements UserRepository {

    @Autowired
    private EntityManager entityManagerFactory;

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
    public void userShow() {
        System.out.println("user show!");
    }
}
