package com.neo.spring.spel;

/**
 * create by xiaocai on 2020/10/23 16:55
 **/
public class SpelBean {
    private String name;
    private String desc;

    public SpelBean(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
