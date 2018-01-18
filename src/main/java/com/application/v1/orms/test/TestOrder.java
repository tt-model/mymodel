package com.application.v1.orms.test;

import javax.persistence.*;

/**
 * 测试订单
 * @auther ttm
 * @date 2017/12/15
 */
@Entity
@Table(name = "mm_testorder")
public class TestOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="order_name")
    private String orderName;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TestUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public TestUser getUser() {
        return user;
    }

    public void setUser(TestUser user) {
        this.user = user;
    }

}
