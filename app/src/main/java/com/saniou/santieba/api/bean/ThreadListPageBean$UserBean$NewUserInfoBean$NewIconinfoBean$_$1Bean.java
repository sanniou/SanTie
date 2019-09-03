package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean {

    private String category_id;
    private String end_time;
    private String level;
    private String name;
    private String slot_no;
    private String slot_type;
    private String type;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean) new Gson()
                .fromJson(str, ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean> array_$1BeanFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean>>() {
                }.getType());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String str) {
        this.end_time = str;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String str) {
        this.category_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getSlot_no() {
        return this.slot_no;
    }

    public void setSlot_no(String str) {
        this.slot_no = str;
    }

    public String getSlot_type() {
        return this.slot_type;
    }

    public void setSlot_type(String str) {
        this.slot_type = str;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String str) {
        this.level = str;
    }
}
