package com.application.v1.orms.test;

import javax.persistence.*;

/**
 * 测试用户
 * @auther ttm
 * @date 2017/12/15
 */
@Entity
@Table(name = "mm_testuser")
public class TestUser {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
