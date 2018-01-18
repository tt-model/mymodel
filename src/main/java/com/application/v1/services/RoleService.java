package com.application.v1.services;

import com.application.v1.orms.Role;

import java.util.List;

/**
 * 角色业务处理
 * @auther ttm
 * @date 2017/11/21
 */
public interface RoleService {

    public boolean roleSave(Role role);

    public List<Role> roleList(int pageNumber, int pageSize);

    public Integer roleCount();

}
