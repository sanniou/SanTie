package com.saniou.santieba.api.bean;

public class UploadPicBean {

    private String ctime;
    private String error_code;
    private String error_msg;
    private int index;
    private InfoBean info;
    private String logid;
    private String time;

    public static class InfoBean {

        private int height;
        private String pic_id;
        private String pic_url;
        private int width;

        public String getPic_id() {
            return this.pic_id;
        }

        public void setPic_id(String str) {
            this.pic_id = str;
        }

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public void setPic_url(String str) {
            this.pic_url = str;
        }
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

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }
}
