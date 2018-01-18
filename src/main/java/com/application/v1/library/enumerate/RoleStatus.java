package com.application.v1.library.enumerate;

/**
 * 角色状态枚举
 * @author ttm
 * @data 2017/11/28
 */
public enum RoleStatus {

    /**
     * 开启
     */
    OPEN(1),

    /**
     * 关闭
     */
    CLOSE(2);

    private int status;

    private RoleStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
