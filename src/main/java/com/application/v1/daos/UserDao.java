package com.application.v1.daos;

import com.application.v1.orms.User;
import com.application.v1.repositorys.CustomizedUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public interface UserDao extends JpaRepository<User, Integer>, com.application.v1.repositorys.CustomizedUserRepository {

    /**
     * 账号密码查询用户
     * @param name
     * @param password
     * @return
     */
    public User findUserByNameAndPassword(String name, String password);

}
