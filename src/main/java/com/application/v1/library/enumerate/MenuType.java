package com.application.v1.library.enumerate;

public enum MenuType {

    /**
     * 目录
     */
    DIRECTORY(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private Integer type;

    private MenuType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

}
