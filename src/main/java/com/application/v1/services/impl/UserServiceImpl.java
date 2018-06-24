package com.application.v1.services.impl;

import com.application.v1.daos.UserDao;
import com.application.v1.library.*;
import com.application.v1.orms.User;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.UserService;
import com.application.v1.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

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
        String userName = user.getUserName();
        String password = user.getPassword();
        if (StringUtils.isEmpty(userName)) {
            return ServiceResponseUtil.fail("用户名不能为空!");
        }
        if (StringUtils.isEmpty(password)) {
            return ServiceResponseUtil.fail("密码不能为空!");
        }

//        String encodePassword = "";
//        try {
//            encodePassword = AesEncodeUtil.encryption(password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        User fetchUser = userDao.findUserByUserNameAndPassword(userName, password);
        if (fetchUser == null) {
            return ServiceResponseUtil.fail("用户名或者密码不正确!");
        } else {
            return ServiceResponseUtil.success(fetchUser);
        }
    }

    @Override
    public User userOne(String name, String password) {
        return userDao.findUserByUserNameAndPassword(name, password);
    }

    @Override
    public boolean userSave(User user) {
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String password = ShiroUtils.sha256(user.getPassword(), salt);
        String createDate = DateUtil.fetchCurrentTime();
        user.setSalt(salt);
        user.setPassword(password);
        user.setCreateTime(createDate);
        user.setStatus(1);
        DumperUtil.dump(user);
        User saveUser = userDao.save(user);
        return saveUser.getUserId() > 0 ? true : false;
//        return true;
    }

    @Override
    public User userFind(Long id) {
        if (null != id) {
            return userDao.findOne(id);
        }

        return null;
    }

    @Override
    public boolean userUpdate(User user) {
        return false;
    }

    @Override
    public void userShow() {

    }

    @Override
    public boolean userDelete(Long id) {
        User findOne = userDao.findOne(id);
        if (null != findOne) {
            userDao.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List getCollection(HttpServletRequest request) {
        return getCollection(userDao, request);
    }

    @Override
    public Long getCollectionCount(HttpServletRequest request) {
        return getCollectionCount(userDao, request);
    }
}
