package com.cdut.shici.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 城 on 2017/2/28.
 */

public class Poetry extends BmobObject {

    private Integer number;
    private String poetryWord;
    private String key;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPoetryWord() {
        return poetryWord;
    }

    public void setPoetryWord(String poetryWord) {
        this.poetryWord = poetryWord;
    }

    public String getKey() {
        return key;
    }
}
