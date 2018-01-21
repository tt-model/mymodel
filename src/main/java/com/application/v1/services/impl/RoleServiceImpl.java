package com.application.v1.services.impl;

import com.application.v1.daos.RoleDao;
import com.application.v1.orms.Role;
import com.application.v1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return saveRole.getRoleId() > 0 ? true : false;
    }

    @Override
    public List<Role> roleList(int pageNumber, int pageSize) {
        Page<Role> page = roleDao.findAll(new PageRequest((pageNumber - 1), pageSize));
        return page.getContent();
    }

    @Override
    public Integer roleCount() {
        return Long.valueOf(roleDao.count()).intValue();
    }

}
