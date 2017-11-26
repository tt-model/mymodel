package com.application.v1.services.impl;

import com.application.v1.daos.UserDao;
import com.application.v1.library.AesEncodeUtil;
import com.application.v1.library.ServiceResponse;
import com.application.v1.library.ServiceResponseUtil;
import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import com.application.v1.services.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int userCount() {
        return Long.valueOf(userDao.count()).intValue();
    }

    /**
     * 分页查询数据
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<User> userList(int pageNumber, int pageSize) {
        Page page = userDao.findAll(new PageRequest((pageNumber - 1), pageSize));
        return page.getContent();
    }

    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Override
    public ServiceResponse userOne(User user) {
        String userName = user.getName();
        String password = user.getPassword();
        if (StringUtils.isEmpty(userName)) {
            return ServiceResponseUtil.fail("用户名不能为空!");
        }
        if (StringUtils.isEmpty(password)) {
            return ServiceResponseUtil.fail("密码不能为空!");
        }

        String encodePassword = "";
        try {
            encodePassword = AesEncodeUtil.encryption(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User fetchUser = userDao.findUserByNameAndPassword(userName, encodePassword);
        if (fetchUser == null) {
            return ServiceResponseUtil.fail("用户名或者密码不正确!");
        } else {
            return ServiceResponseUtil.success(fetchUser);
        }
    }

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
