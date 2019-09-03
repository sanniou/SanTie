package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean {

    private String count;
    private List<String> forum_list;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean) new Gson()
                .fromJson(str,
                        ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean> array_$13BeanFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean>>() {
                }.getType());
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public List<String> getForum_list() {
        return this.forum_list;
    }

    public void setForum_list(List<String> list) {
        this.forum_list = list;
    }
}
