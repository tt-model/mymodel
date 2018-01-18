package com.application.v1.daos;

import com.application.v1.orms.test.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/12/15
 */
public interface TestOrderDao extends JpaRepository<TestOrder, Integer> {
}
