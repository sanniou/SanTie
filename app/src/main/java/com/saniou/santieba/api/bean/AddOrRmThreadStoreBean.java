package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddOrRmThreadStoreBean extends BaseBean {

    private int ctime;
    private ErrorBean error;
    private String error_code;
    private String error_msg;
    private long logid;
    private String server_time;
    private int time;

    public static class ErrorBean {

        private String errmsg;
        private String errno;
        private String usermsg;

        public static ErrorBean objectFromData(String str) {
            return (ErrorBean) new Gson().fromJson(str, ErrorBean.class);
        }

        public static List<ErrorBean> arrayErrorBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ErrorBean>>() {
            }.getType());
        }

        public String getErrno() {
            return this.errno;
        }

        public void setErrno(String str) {
            this.errno = str;
        }

        public String getErrmsg() {
            return this.errmsg;
        }

        public void setErrmsg(String str) {
            this.errmsg = str;
        }

        public String getUsermsg() {
            return this.usermsg;
        }

        public void setUsermsg(String str) {
            this.usermsg = str;
        }
    }

    public static AddOrRmThreadStoreBean objectFromData(String str) {
        return (AddOrRmThreadStoreBean) new Gson().fromJson(str, AddOrRmThreadStoreBean.class);
    }

    public static List<AddOrRmThreadStoreBean> arrayAddOrRmThreadStoreBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AddOrRmThreadStoreBean>>() {
        }.getType());
    }

    public ErrorBean getError() {
        return this.error;
    }

    public void setError(ErrorBean errorBean) {
        this.error = errorBean;
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
}
