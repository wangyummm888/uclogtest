package com.uclog.model;/**
 * Created by wangyu on 2017/8/10.
 */

import com.uclog.constant.BaseEnum;

import java.util.List;
/** 左侧导航页
 * @author yu.wang15
 * @create 2017-08-10 16:20
 **/
public class Navs {
    private transient  Long id;
    private String title;
    private String icon;
    private String href;
    private transient Integer spreadFlag;//是否展开的关键字
    private boolean spread;
    private String target;
    private List<Navs> children;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSpreadFlag() {
        return spreadFlag;
    }

    public void setSpreadFlag(Integer spreadFlag) {
        if(spreadFlag!=null&&spreadFlag.intValue()== BaseEnum.NAVA_SPREAD_IS.getIndex())
            this.spread=true;
        else if(spreadFlag!=null&&spreadFlag.intValue()== BaseEnum.NAVA_SPREAD_NO.getIndex())
            this.spread=false;
        this.spreadFlag = spreadFlag;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Navs> getChildren() {
        return children;
    }

    public void setChildren(List<Navs> children) {
        this.children = children;
    }
}
