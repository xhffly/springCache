package com.cyh;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/1/11.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    private Integer id;
    private String name;

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

    public Account() {}

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getCacheKey() {
        String key = AccountService.class.getSimpleName() + "-" + this.getName();
        return key;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
