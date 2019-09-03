package com.saniou.santieba.api.bean;

import java.util.List;

public class AddReplyBean {

    private AntiStatBean anti_stat;
    private String ctime;
    private String error_code;
    private String error_msg;
    private ExpBean exp;
    private InfoBean info;
    private String logid;
    private String msg;
    private String opgroup;
    private String pid;
    private String pre_msg;
    private String server_time;
    private String tid;
    private int time;

    public static class AntiStatBean {

        private String block_stat;
        private String days_tofree;
        private String has_chance;
        private String hide_stat;
        private String vcode_stat;

        public String getBlock_stat() {
            return this.block_stat;
        }

        public void setBlock_stat(String str) {
            this.block_stat = str;
        }

        public String getVcode_stat() {
            return this.vcode_stat;
        }

        public void setVcode_stat(String str) {
            this.vcode_stat = str;
        }

        public String getHide_stat() {
            return this.hide_stat;
        }

        public void setHide_stat(String str) {
            this.hide_stat = str;
        }

        public String getDays_tofree() {
            return this.days_tofree;
        }

        public void setDays_tofree(String str) {
            this.days_tofree = str;
        }

        public String getHas_chance() {
            return this.has_chance;
        }

        public void setHas_chance(String str) {
            this.has_chance = str;
        }
    }

    public static class ExpBean {

        private String color_msg;
        private String current_level;
        private String current_level_max_exp;
        private String inc;
        private String old;
        private String pre_msg;

        public String getCurrent_level_max_exp() {
            return this.current_level_max_exp;
        }

        public void setCurrent_level_max_exp(String str) {
            this.current_level_max_exp = str;
        }

        public String getCurrent_level() {
            return this.current_level;
        }

        public void setCurrent_level(String str) {
            this.current_level = str;
        }

        public String getOld() {
            return this.old;
        }

        public void setOld(String str) {
            this.old = str;
        }

        public String getInc() {
            return this.inc;
        }

        public void setInc(String str) {
            this.inc = str;
        }

        public String getPre_msg() {
            return this.pre_msg;
        }

        public void setPre_msg(String str) {
            this.pre_msg = str;
        }

        public String getColor_msg() {
            return this.color_msg;
        }

        public void setColor_msg(String str) {
            this.color_msg = str;
        }
    }

    public static class InfoBean {

        private List<?> access_state;
        private String need_vcode;
        private String vcode_md5;
        private String vcode_pic_url;
        private String vcode_prev_type;
        private String vcode_type;

        public String getVcode_pic_url() {
            return this.vcode_pic_url;
        }

        public void setVcode_pic_url(String str) {
            this.vcode_pic_url = str;
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

    public InfoBean getInfo() {
        return this.info;
    }

    public void setInfo(InfoBean infoBean) {
        this.info = infoBean;
    }

    public AntiStatBean getAnti_stat() {
        return this.anti_stat;
    }

    public void setAnti_stat(AntiStatBean antiStatBean) {
        this.anti_stat = antiStatBean;
    }

    public ExpBean getExp() {
        return this.exp;
    }

    public void setExp(ExpBean expBean) {
        this.exp = expBean;
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

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }
}
