package com.application.v1.services.impl;

import com.application.v1.daos.UserDao;
import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import com.application.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

}
