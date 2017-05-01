package com.cdut.shici.javabean;
import cn.bmob.v3.BmobUser;

/**
 * Created by 城 on 2017/2/28.
 */

public class User extends BmobUser{

    /*
    * 用户当前的关数
    * */
    private Integer current;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
