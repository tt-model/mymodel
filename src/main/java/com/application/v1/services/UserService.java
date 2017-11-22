package com.application.v1.services;

import com.application.v1.library.ServiceResponse;
import com.application.v1.orms.User;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public interface UserService {

    /**
     * 用户名 密码查询一个用户
     * @param user
     * @return
     */
    public ServiceResponse userOne(User user);

    /**
     * 用户名 密码查询一个用户
     * @param name
     * @param password
     * @return
     */
    public User userOne(String name, String password);

    /**
     * 保存用户
     * @param user
     * @return
     */
    public boolean userSave(User user);

    /**
     * 用戶查詢 id
     * @param id
     * @return
     */
    public User userFind(Integer id);

    /**
     * 用戶修改
     * @param user
     * @return
     */
    public boolean userUpdate(User user);

}
