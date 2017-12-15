package com.application.v1.daos;

import com.application.v1.orms.test.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/12/15
 */
public interface TestUserDao extends JpaRepository<TestUser, Integer> {
}
