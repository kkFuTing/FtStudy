package com.futing.javalib.javabase;

import java.io.Serializable;

/**
 * Created by futing on 2024/6/22.
 * 如果去掉Serializable然后执行SerializableData 的main方法将抛出下面的错误
 * java.io.NotSerializableException: com.futing.javalib.javabase.TestBean
 */
public class TestBean implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String pwd;

    public TestBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
