package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX {

    private String end_time;
    private String level;
    private String pic_url;
    private String score_limit;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX) new Gson()
                .fromJson(str,
                        ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX> array_$2BeanXFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX>>() {
                }.getType());
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String str) {
        this.end_time = str;
    }

    public String getScore_limit() {
        return this.score_limit;
    }

    public void setScore_limit(String str) {
        this.score_limit = str;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public void setPic_url(String str) {
        this.pic_url = str;
    }
}
