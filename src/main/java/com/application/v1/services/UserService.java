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
     * 查询数量
     * @return
     */
    public int userCount();

    /**
     * 分页查询数据
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<User> userList(int pageNumber, int pageSize);

    /**
     * 用户信息
     * @return
     */
    public List<User> userList();

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
    public User userFind(Long id);

    /**
     * 用戶修改
     * @param user
     * @return
     */
    public boolean userUpdate(User user);

    public void userShow();

}
