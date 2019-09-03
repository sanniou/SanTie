package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadStoreBean extends BaseBean {

    private int ctime;
    private ErrorBean error;
    private String error_code;
    private String error_msg;
    private int logid;
    private String server_time;
    private List<StoreThreadBean> store_thread;
    private int time;

    public static class ErrorBean {

        private String errmsg;
        private String errno;

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
    }

    public static class StoreThreadBean {

        private AuthorBean author;
        private String count;
        private String floor_num;
        private String forum_name;
        private String last_time;
        private String mark_pid;
        private String mark_status;
        private String max_pid;
        private String min_pid;
        private String reply_num;
        private String status;
        private String thread_id;
        private String thread_type;
        private String title;
        private String type;

        public static class AuthorBean {

            private String lz_uid;
            private String name;
            private String name_show;

            public static AuthorBean objectFromData(String str) {
                return (AuthorBean) new Gson().fromJson(str, AuthorBean.class);
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AuthorBean>>() {
                }.getType());
            }

            public String getLz_uid() {
                return this.lz_uid;
            }

            public void setLz_uid(String str) {
                this.lz_uid = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getName_show() {
                return this.name_show;
            }

            public void setName_show(String str) {
                this.name_show = str;
            }
        }

        public static StoreThreadBean objectFromData(String str) {
            return (StoreThreadBean) new Gson().fromJson(str, StoreThreadBean.class);
        }

        public static List<StoreThreadBean> arrayStoreThreadBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<StoreThreadBean>>() {
            }.getType());
        }

        public String getThread_id() {
            return this.thread_id;
        }

        public void setThread_id(String str) {
            this.thread_id = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getForum_name() {
            return this.forum_name;
        }

        public void setForum_name(String str) {
            this.forum_name = str;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public String getLast_time() {
            return this.last_time;
        }

        public void setLast_time(String str) {
            this.last_time = str;
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

        public String getMax_pid() {
            return this.max_pid;
        }

        public void setMax_pid(String str) {
            this.max_pid = str;
        }

        public String getMin_pid() {
            return this.min_pid;
        }

        public void setMin_pid(String str) {
            this.min_pid = str;
        }

        public String getCount() {
            return this.count;
        }

        public void setCount(String str) {
            this.count = str;
        }

        public String getMark_pid() {
            return this.mark_pid;
        }

        public void setMark_pid(String str) {
            this.mark_pid = str;
        }

        public String getMark_status() {
            return this.mark_status;
        }

        public void setMark_status(String str) {
            this.mark_status = str;
        }

        public String getReply_num() {
            return this.reply_num;
        }

        public void setReply_num(String str) {
            this.reply_num = str;
        }

        public String getFloor_num() {
            return this.floor_num;
        }

        public void setFloor_num(String str) {
            this.floor_num = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }
    }

    public static ThreadStoreBean objectFromData(String str) {
        return (ThreadStoreBean) new Gson().fromJson(str, ThreadStoreBean.class);
    }

    public static List<ThreadStoreBean> arrayThreadStoreBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThreadStoreBean>>() {
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

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public List<StoreThreadBean> getStore_thread() {
        return this.store_thread;
    }

    public void setStore_thread(List<StoreThreadBean> list) {
        this.store_thread = list;
    }
}
