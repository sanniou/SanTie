package com.saniou.santieba.api.bean;

import java.util.List;

public class NewThreadBean {

    private String ctime;
    private String error_code;
    private String error_msg;
    private InfoBean info;
    private String logid;
    private String msg;
    private String opgroup;
    private String pid;
    private String pre_msg;
    private String server_time;
    private String tid;
    private String time;

    public static class InfoBean {

        private List<?> access_state;
        private String need_vcode;
        private String vcode_md5;
        private String vcode_pic_url;
        private String vcode_prev_type;
        private String vcode_type;

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

        public String getVcode_pic_url() {
            return this.vcode_pic_url;
        }

        public void setVcode_pic_url(String str) {
            this.vcode_pic_url = str;
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

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getCtime() {
        return this.ctime;
    }

    public void setCtime(String str) {
        this.ctime = str;
    }

    public String getLogid() {
        return this.logid;
    }

    public void setLogid(String str) {
        this.logid = str;
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

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }
}
