package com.application.v1.daos;

import com.application.v1.orms.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色
 * @auther ttm
 * @date 2017/11/21
 */
public interface RoleDao extends JpaRepository<Role, Long> {

}
