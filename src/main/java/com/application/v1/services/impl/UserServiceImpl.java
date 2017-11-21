package com.application.v1.services.impl;

import com.application.v1.daos.UserDao;
import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User userOne(String name, String password) {
        return userDao.findUserByNameAndPassword(name, password);
    }

    @Override
    public boolean userSave(User user) {
        User saveUser = userDao.save(user);
        return saveUser.getId() > 0 ? true : false;
    }

    @Override
    public User userFind(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public boolean userUpdate(User user) {
        return userDao.userUpdate(user);
    }
}
