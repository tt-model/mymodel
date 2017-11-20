package com.application.v1.orms;

import javax.persistence.*;

/**
 * @author ttm
 * @data 2017/11/21
 */
@Entity
@Table(name = "mm_role_function")
public class RoleFunction {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "function_id")
    private int functionId;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
