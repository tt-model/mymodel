package com.application.v1.daos;

import com.application.v1.orms.Function;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/11/21
 */
public interface FunctionDao extends JpaRepository<Function, Integer> {
}
