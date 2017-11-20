package com.application.v1.orms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 功能
 * @auther ttm
 * @date 2017/11/20
 */
@Entity
public class Function implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    private int parentId;

    @Column(name = "url")
    private String url;

    @Column(name = "serial_number")
    private int serialNumber;

    @Column(name = "accordion")
    private int accordion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getAccordion() {
        return accordion;
    }

    public void setAccordion(int accordion) {
        this.accordion = accordion;
    }
}
