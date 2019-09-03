package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean {

    private String end_time;
    private String expired_notify;
    private String expiring_notify;
    private String left_num;
    private String open_status;
    private String props_category;
    private String props_id;
    private String props_type;
    private String update_time;
    private String used_status;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean) new Gson()
                .fromJson(str,
                        ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean> array_$1260048BeanFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean>>() {
                }.getType());
    }

    public String getProps_id() {
        return this.props_id;
    }

    public void setProps_id(String str) {
        this.props_id = str;
    }

    public String getProps_type() {
        return this.props_type;
    }

    public void setProps_type(String str) {
        this.props_type = str;
    }

    public String getProps_category() {
        return this.props_category;
    }

    public void setProps_category(String str) {
        this.props_category = str;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String str) {
        this.end_time = str;
    }

    public String getLeft_num() {
        return this.left_num;
    }

    public void setLeft_num(String str) {
        this.left_num = str;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(String str) {
        this.update_time = str;
    }

    public String getUsed_status() {
        return this.used_status;
    }

    public void setUsed_status(String str) {
        this.used_status = str;
    }

    public String getOpen_status() {
        return this.open_status;
    }

    public void setOpen_status(String str) {
        this.open_status = str;
    }

    public String getExpiring_notify() {
        return this.expiring_notify;
    }

    public void setExpiring_notify(String str) {
        this.expiring_notify = str;
    }

    public String getExpired_notify() {
        return this.expired_notify;
    }

    public void setExpired_notify(String str) {
        this.expired_notify = str;
    }
}
