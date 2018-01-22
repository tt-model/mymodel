package com.application.v1.daos;

import com.application.v1.orms.User;
import com.application.v1.repositorys.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public interface UserDao extends JpaRepository<User, Long>, UserRepository {

    /**
     * 账号密码查询用户
     * @param name
     * @param password
     * @return
     */
    public User findUserByUserNameAndPassword(String name, String password);

}
