package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddThreadBean {

    private int ctime;
    private String error_code;
    private InfoBean info;
    private int logid;
    private String msg;
    private String opgroup;
    private String pid;
    private String pre_msg;
    private String server_time;
    private String tid;
    private int time;

    public static class InfoBean {

        private List<?> access_state;
        private List<?> confilter_hitwords;
        private String need_vcode;
        private String vcode_md5;
        private String vcode_prev_type;
        private String vcode_type;

        public static InfoBean objectFromData(String str) {
            return (InfoBean) new Gson().fromJson(str, InfoBean.class);
        }

        public static List<InfoBean> arrayInfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<InfoBean>>() {
            }.getType());
        }

        public String getNeed_vcode() {
            return this.need_vcode;
        }

        public void setNeed_vcode(String str) {
            this.need_vcode = str;
        }

        public String getVcode_md5() {
            return this.vcode_md5;
        }

        public void setVcode_md5(String str) {
            this.vcode_md5 = str;
        }

        public String getVcode_prev_type() {
            return this.vcode_prev_type;
        }

        public void setVcode_prev_type(String str) {
            this.vcode_prev_type = str;
        }

        public String getVcode_type() {
            return this.vcode_type;
        }

        public void setVcode_type(String str) {
            this.vcode_type = str;
        }

        public List<?> getAccess_state() {
            return this.access_state;
        }

        public void setAccess_state(List<?> list) {
            this.access_state = list;
        }

        public List<?> getConfilter_hitwords() {
            return this.confilter_hitwords;
        }

        public void setConfilter_hitwords(List<?> list) {
            this.confilter_hitwords = list;
        }
    }

    public static AddThreadBean objectFromData(String str) {
        return (AddThreadBean) new Gson().fromJson(str, AddThreadBean.class);
    }

    public static List<AddThreadBean> arrayAddThreadBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AddThreadBean>>() {
        }.getType());
    }

    public String getOpgroup() {
        return this.opgroup;
    }

    public void setOpgroup(String str) {
        this.opgroup = str;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getPre_msg() {
        return this.pre_msg;
    }

    public void setPre_msg(String str) {
        this.pre_msg = str;
    }

    public InfoBean getInfo() {
        return this.info;
    }

    public void setInfo(InfoBean infoBean) {
        this.info = infoBean;
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

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public String getServer_time() {
        return this.server_time;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

}
