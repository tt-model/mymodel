package com.application.v1.orms;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * @author ttm
 * @data 2017/11/21
 */
@Entity
@Table(name = "tt_role")
public class Role implements Serializable {

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 角色ID
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 部门名称
     */
    @Transient
    private String deptName;

    @Transient
    private List<Long> menuIdList;

    @Transient
    private List<Long> deptIdList;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getDeptIdList() {
        return deptIdList;
    }

    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
