package com.saniou.santieba.api.bean;

import java.util.List;

public class DataBean {

    private List<DataBeanX> dataBeanXes;

    public static class DataBeanX {

        private String pid;
        private String status;
        private String tid;
        private String type;

        public DataBeanX() {
        }

        public String getTid() {
            return this.tid;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getPid() {
            return this.pid;
        }

        public void setPid(String str) {
            this.pid = str;
        }
    }

    public List<DataBeanX> getDataBeanXes() {
        return this.dataBeanXes;
    }

    public void setDataBeanXes(List<DataBeanX> list) {
        this.dataBeanXes = list;
    }
}
