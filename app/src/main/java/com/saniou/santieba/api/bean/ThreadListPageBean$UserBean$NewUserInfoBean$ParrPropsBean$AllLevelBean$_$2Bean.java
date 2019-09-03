package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean {

    private String end_time;
    private String level;
    private String score_limit;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean) new Gson()
                .fromJson(str,
                        ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean> array_$2BeanFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean>>() {
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
}
