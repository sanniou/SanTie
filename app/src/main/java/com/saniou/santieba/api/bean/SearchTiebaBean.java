package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SearchTiebaBean extends BaseBean {

    private int ctime;
    private String error_code;
    private List<String> fname;
    private int logid;
    private int time;

    public static SearchTiebaBean objectFromData(String str) {
        return (SearchTiebaBean) new Gson().fromJson(str, SearchTiebaBean.class);
    }

    public static List<SearchTiebaBean> arraySearchTiebaBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SearchTiebaBean>>() {
        }.getType());
    }

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
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

    public int getLogid() {
        return this.logid;
    }

    public void setLogid(int i) {
        this.logid = i;
    }

    public List<String> getFname() {
        return this.fname;
    }

    public void setFname(List<String> list) {
        this.fname = list;
    }
}
