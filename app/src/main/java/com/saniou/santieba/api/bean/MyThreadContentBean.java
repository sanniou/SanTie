package com.saniou.santieba.api.bean;

public class MyThreadContentBean {

    public String bsize;
    public String info;
    public String link_or_uid;
    private SubPostList subPostList;
    public String type;

    class SubPostList {

        SubPostList() {
        }
    }

    public MyThreadContentBean(String str, String str2, String str3, SubPostList subPostList2) {
        this.info = str;
        this.type = str2;
        this.link_or_uid = str3;
        this.subPostList = subPostList2;
    }

    public MyThreadContentBean(String str, String str2, String str3, String str4) {
        this.info = str;
        this.type = str2;
        this.link_or_uid = str3;
        this.bsize = str4;
    }
}
