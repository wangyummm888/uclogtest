package com.uclog.constant;

/**
 * Created by wangyu on 2017/8/10.
 */
public enum BaseEnum {
        NAVA_SPREAD_IS("左侧导航栏菜单展开",1),
        NAVA_SPREAD_NO("左侧导航栏菜单展折叠",0);








    BaseEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    private String name;
    private Integer index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
