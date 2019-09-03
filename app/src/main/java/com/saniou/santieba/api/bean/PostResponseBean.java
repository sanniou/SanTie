package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class PostResponseBean extends BaseBean {

    private AntiStatBean anti_stat;
    private int ctime;
    private String error_code;
    private ExpBean exp;
    private InfoBean info;
    private long logid;
    private String msg;
    private String opgroup;
    private String pid;
    private String pre_msg;
    private String server_time;
    private String tid;
    private long time;

    public static class AntiStatBean {

        private String block_stat;
        private String days_tofree;
        private String has_chance;
        private String hide_stat;
        private String vcode_stat;

        public static AntiStatBean objectFromData(String str) {
            return (AntiStatBean) new Gson().fromJson(str, AntiStatBean.class);
        }

        public static List<AntiStatBean> arrayAntiStatBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AntiStatBean>>() {
            }.getType());
        }

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

        private int color_msg;
        private int current_level;
        private int current_level_max_exp;
        private String inc;
        private int old;
        private String pre_msg;

        public static ExpBean objectFromData(String str) {
            return (ExpBean) new Gson().fromJson(str, ExpBean.class);
        }

        public static List<ExpBean> arrayExpBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ExpBean>>() {
            }.getType());
        }

        public int getCurrent_level_max_exp() {
            return this.current_level_max_exp;
        }

        public void setCurrent_level_max_exp(int i) {
            this.current_level_max_exp = i;
        }

        public int getCurrent_level() {
            return this.current_level;
        }

        public void setCurrent_level(int i) {
            this.current_level = i;
        }

        public int getOld() {
            return this.old;
        }

        public void setOld(int i) {
            this.old = i;
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

        public int getColor_msg() {
            return this.color_msg;
        }

        public void setColor_msg(int i) {
            this.color_msg = i;
        }
    }

    public static class InfoBean {

        private List<?> access_state;
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
    }

    public static PostResponseBean objectFromData(String str) {
        return (PostResponseBean) new Gson().fromJson(str, PostResponseBean.class);
    }

    public static List<PostResponseBean> arrayPostResponseBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostResponseBean>>() {
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

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
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
}
