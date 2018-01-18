package com.application.v1.orms;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 部门管理
 */
@Entity
@Table(name = "tt_dept")
public class Dept implements Serializable {

    /**
     * 部门ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 上级部门ID，一级部门为0
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 上级部门名称
     */
    @Transient
    private String parentName;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * ztree属性
     */
    @Transient
    private Boolean open;

    @Transient
    private List<?> list;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
