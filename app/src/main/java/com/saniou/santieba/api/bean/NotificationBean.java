package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class NotificationBean extends BaseBean {

    private long ctime;
    private String error_code;
    private long logid;
    private MessageBean message;
    private String server_time;
    private long time;

    public static class MessageBean {

        private int atme;
        private int bookmark;
        private int count;
        private String fans;
        private int pletter;
        private int replyme;

        public static MessageBean objectFromData(String str) {
            return (MessageBean) new Gson().fromJson(str, MessageBean.class);
        }

        public static List<MessageBean> arrayMessageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MessageBean>>() {
            }.getType());
        }

        public String getFans() {
            return this.fans;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public int getReplyme() {
            return this.replyme;
        }

        public void setReplyme(int i) {
            this.replyme = i;
        }

        public int getAtme() {
            return this.atme;
        }

        public void setAtme(int i) {
            this.atme = i;
        }

        public int getPletter() {
            return this.pletter;
        }

        public void setPletter(int i) {
            this.pletter = i;
        }

        public int getBookmark() {
            return this.bookmark;
        }

        public void setBookmark(int i) {
            this.bookmark = i;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }
    }

    public static MessageBean objectFromData(String str) {
        return (MessageBean) new Gson().fromJson(str, MessageBean.class);
    }

    public static List<MessageBean> arrayMessageBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MessageBean>>() {
        }.getType());
    }

    public MessageBean getMessage() {
        return this.message;
    }

    public void setMessage(MessageBean messageBean) {
        this.message = messageBean;
    }

    public String getServer_time() {
        return this.server_time;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public long getCtime() {
        return this.ctime;
    }

    public void setCtime(long j) {
        this.ctime = j;
    }

    public long getLogid() {
        return this.logid;
    }

    public void setLogid(long j) {
        this.logid = j;
    }

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }
}
