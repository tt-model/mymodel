package com.application.v1.daos;

import com.application.v1.orms.User;
import com.application.v1.repositorys.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public interface UserDao extends JpaRepository<User, Long>, BaseRepository<User, Long> {

    /**
     * 账号密码查询用户
     * @param name
     * @param password
     * @return
     */
    public User findUserByUserNameAndPassword(String name, String password);

    /**
     * 用户名查询数据
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName);

}
