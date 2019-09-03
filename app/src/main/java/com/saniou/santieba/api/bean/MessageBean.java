package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MessageBean {

    private int ctime;
    private String error_code;
    private String error_msg;
    private List<?> info;
    private long logid;
    private String server_time;
    private int time;

    public static MessageBean objectFromData(String str) {
        return (MessageBean) new Gson().fromJson(str, MessageBean.class);
    }

    public static List<MessageBean> arrayMessageBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MessageBean>>() {
        }.getType());
    }

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public String getServer_time() {
        return this.server_time;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public long getLogid() {
        return this.logid;
    }

    public void setLogid(long j) {
        this.logid = j;
    }

    public List<?> getInfo() {
        return this.info;
    }

    public void setInfo(List<?> list) {
        this.info = list;
    }
}
