package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SignBean extends BaseBean {

    private int ctime;
    private String error_code;
    private long logid;
    private String server_time;
    private int time;
    private UserInfoBean user_info;

    public static class UserInfoBean {

        private String cont_sign_num;
        private String cout_total_sing_num;
        private String hun_sign_num;
        private String is_org_name;
        private String is_sign_in;
        private String level_name;
        private String levelup_score;
        private String miss_sign_num;
        private String sign_bonus_point;
        private String sign_time;
        private String total_resign_num;
        private String total_sign_num;
        private String user_id;
        private String user_sign_rank;

        public static UserInfoBean objectFromData(String str) {
            return (UserInfoBean) new Gson().fromJson(str, UserInfoBean.class);
        }

        public static List<UserInfoBean> arrayUserInfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserInfoBean>>() {
            }.getType());
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String str) {
            this.user_id = str;
        }

        public String getIs_sign_in() {
            return this.is_sign_in;
        }

        public void setIs_sign_in(String str) {
            this.is_sign_in = str;
        }

        public String getUser_sign_rank() {
            return this.user_sign_rank;
        }

        public void setUser_sign_rank(String str) {
            this.user_sign_rank = str;
        }

        public String getSign_time() {
            return this.sign_time;
        }

        public void setSign_time(String str) {
            this.sign_time = str;
        }

        public String getCont_sign_num() {
            return this.cont_sign_num;
        }

        public void setCont_sign_num(String str) {
            this.cont_sign_num = str;
        }

        public String getTotal_sign_num() {
            return this.total_sign_num;
        }

        public void setTotal_sign_num(String str) {
            this.total_sign_num = str;
        }

        public String getCout_total_sing_num() {
            return this.cout_total_sing_num;
        }

        public void setCout_total_sing_num(String str) {
            this.cout_total_sing_num = str;
        }

        public String getHun_sign_num() {
            return this.hun_sign_num;
        }

        public void setHun_sign_num(String str) {
            this.hun_sign_num = str;
        }

        public String getTotal_resign_num() {
            return this.total_resign_num;
        }

        public void setTotal_resign_num(String str) {
            this.total_resign_num = str;
        }

        public String getIs_org_name() {
            return this.is_org_name;
        }

        public void setIs_org_name(String str) {
            this.is_org_name = str;
        }

        public String getSign_bonus_point() {
            return this.sign_bonus_point;
        }

        public void setSign_bonus_point(String str) {
            this.sign_bonus_point = str;
        }

        public String getMiss_sign_num() {
            return this.miss_sign_num;
        }

        public void setMiss_sign_num(String str) {
            this.miss_sign_num = str;
        }

        public String getLevel_name() {
            return this.level_name;
        }

        public void setLevel_name(String str) {
            this.level_name = str;
        }

        public String getLevelup_score() {
            return this.levelup_score;
        }

        public void setLevelup_score(String str) {
            this.levelup_score = str;
        }
    }

    public static SignBean objectFromData(String str) {
        return (SignBean) new Gson().fromJson(str, SignBean.class);
    }

    public static List<SignBean> arraySignBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SignBean>>() {
        }.getType());
    }

    public UserInfoBean getUser_info() {
        return this.user_info;
    }

    public void setUser_info(UserInfoBean userInfoBean) {
        this.user_info = userInfoBean;
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
}
