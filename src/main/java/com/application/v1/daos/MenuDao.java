package com.application.v1.daos;

import com.application.v1.orms.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 菜单
 */
public interface MenuDao extends JpaRepository<Menu, Long> {
}
