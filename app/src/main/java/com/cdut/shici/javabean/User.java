package com.cdut.shici.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 城 on 2017/2/28.
 */

public class User extends BmobObject{
    private int id;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
