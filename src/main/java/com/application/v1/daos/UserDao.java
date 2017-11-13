package com.application.v1.daos;

import com.application.v1.orms.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
