package com.application.v1.services.impl;

import com.application.v1.daos.RoleDao;
import com.application.v1.orms.Role;
import com.application.v1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther ttm
 * @date 2017/11/21
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean roleSave(Role role) {
        Role saveRole = roleDao.save(role);
        return saveRole.getId() > 0 ? true : false;
    }

}
