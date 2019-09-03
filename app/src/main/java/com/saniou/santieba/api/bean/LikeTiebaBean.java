package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class LikeTiebaBean extends BaseBean {

    private int ctime;
    private ErrorBean error;
    private String error_code;
    private List<?> feed_forum;
    private InfoBean info;
    private int logid;
    private String server_time;
    private int time;
    private UserPermBean user_perm;

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

    public static class InfoBean {

        private String cur_score;
        private String is_black;
        private String is_like;
        private String level_id;
        private String level_name;
        private String levelup_score;
        private String like_num;
        private String member_sum;

        public static InfoBean objectFromData(String str) {
            return (InfoBean) new Gson().fromJson(str, InfoBean.class);
        }

        public static List<InfoBean> arrayInfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<InfoBean>>() {
            }.getType());
        }

        public String getCur_score() {
            return this.cur_score;
        }

        public void setCur_score(String str) {
            this.cur_score = str;
        }

        public String getLevelup_score() {
            return this.levelup_score;
        }

        public void setLevelup_score(String str) {
            this.levelup_score = str;
        }

        public String getIs_like() {
            return this.is_like;
        }

        public void setIs_like(String str) {
            this.is_like = str;
        }

        public String getIs_black() {
            return this.is_black;
        }

        public void setIs_black(String str) {
            this.is_black = str;
        }

        public String getLike_num() {
            return this.like_num;
        }

        public void setLike_num(String str) {
            this.like_num = str;
        }

        public String getLevel_id() {
            return this.level_id;
        }

        public void setLevel_id(String str) {
            this.level_id = str;
        }

        public String getLevel_name() {
            return this.level_name;
        }

        public void setLevel_name(String str) {
            this.level_name = str;
        }

        public String getMember_sum() {
            return this.member_sum;
        }

        public void setMember_sum(String str) {
            this.member_sum = str;
        }
    }

    public static class UserPermBean {

        private String level_id;
        private String level_name;

        public static UserPermBean objectFromData(String str) {
            return (UserPermBean) new Gson().fromJson(str, UserPermBean.class);
        }

        public static List<UserPermBean> arrayUserPermBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserPermBean>>() {
            }.getType());
        }

        public String getLevel_id() {
            return this.level_id;
        }

        public void setLevel_id(String str) {
            this.level_id = str;
        }

        public String getLevel_name() {
            return this.level_name;
        }

        public void setLevel_name(String str) {
            this.level_name = str;
        }
    }

    public static LikeTiebaBean objectFromData(String str) {
        return (LikeTiebaBean) new Gson().fromJson(str, LikeTiebaBean.class);
    }

    public static List<LikeTiebaBean> arrayFocusTiebaBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LikeTiebaBean>>() {
        }.getType());
    }

    public InfoBean getInfo() {
        return this.info;
    }

    public void setInfo(InfoBean infoBean) {
        this.info = infoBean;
    }

    public UserPermBean getUser_perm() {
        return this.user_perm;
    }

    public void setUser_perm(UserPermBean userPermBean) {
        this.user_perm = userPermBean;
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

    public List<?> getFeed_forum() {
        return this.feed_forum;
    }

    public void setFeed_forum(List<?> list) {
        this.feed_forum = list;
    }
}
