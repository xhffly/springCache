package com.cyh;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/11.
 */
public class Account implements Serializable {

    private int id;
    private String name;

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

    public Account() {}

    public Account(int id, String name) {
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
