package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class UserPostBean extends BaseBean {

    private int ctime;
    private String error_code;
    private String error_msg;
    private String hide_post;
    private long logid;
    private List<PostListBean> post_list;
    private String server_time;
    private int time;

    public static class PostListBean {

        @SerializedName("abstract")
        private List<AbstractBean> abstractX;
        private List<?> anchor_info;
        private String content;
        private String create_time;
        private String forum_id;
        private String forum_name;
        private String ip;
        private String is_post_deleted;
        private String is_thread;
        private List<MediaBean> media;
        private List<?> poll_info;
        private String post_id;
        private String ptype;
        private String reply_num;
        private String thread_id;
        private String thread_type;
        private String title;
        private String user_id;
        private String user_name;
        private String user_portrait;

        public static class AbstractBean {

            private String text;
            private String type;

            public static AbstractBean objectFromData(String str) {
                return (AbstractBean) new Gson().fromJson(str, AbstractBean.class);
            }

            public static List<AbstractBean> arrayAbstractBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AbstractBean>>() {
                }.getType());
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getText() {
                return this.text;
            }

            public void setText(String str) {
                this.text = str;
            }
        }

        public static class MediaBean {

            private String big_pic;
            private String small_pic;
            private String type;
            private String water_pic;

            public static MediaBean objectFromData(String str) {
                return (MediaBean) new Gson().fromJson(str, MediaBean.class);
            }

            public static List<MediaBean> arrayMediaBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MediaBean>>() {
                }.getType());
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getSmall_pic() {
                return this.small_pic;
            }

            public void setSmall_pic(String str) {
                this.small_pic = str;
            }

            public String getBig_pic() {
                return this.big_pic;
            }

            public void setBig_pic(String str) {
                this.big_pic = str;
            }

            public String getWater_pic() {
                return this.water_pic;
            }

            public void setWater_pic(String str) {
                this.water_pic = str;
            }
        }

        public static PostListBean objectFromData(String str) {
            return (PostListBean) new Gson().fromJson(str, PostListBean.class);
        }

        public static List<PostListBean> arrayPostListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostListBean>>() {
            }.getType());
        }

        public String getForum_id() {
            return this.forum_id;
        }

        public void setForum_id(String str) {
            this.forum_id = str;
        }

        public String getThread_id() {
            return this.thread_id;
        }

        public void setThread_id(String str) {
            this.thread_id = str;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String str) {
            this.post_id = str;
        }

        public String getIs_thread() {
            return this.is_thread;
        }

        public void setIs_thread(String str) {
            this.is_thread = str;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public void setCreate_time(String str) {
            this.create_time = str;
        }

        public String getForum_name() {
            return this.forum_name;
        }

        public void setForum_name(String str) {
            this.forum_name = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getUser_name() {
            return this.user_name;
        }

        public void setUser_name(String str) {
            this.user_name = str;
        }

        public String getIp() {
            return this.ip;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public String getIs_post_deleted() {
            return this.is_post_deleted;
        }

        public void setIs_post_deleted(String str) {
            this.is_post_deleted = str;
        }

        public String getPtype() {
            return this.ptype;
        }

        public void setPtype(String str) {
            this.ptype = str;
        }

        public String getReply_num() {
            return this.reply_num;
        }

        public void setReply_num(String str) {
            this.reply_num = str;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String str) {
            this.user_id = str;
        }

        public String getUser_portrait() {
            return this.user_portrait;
        }

        public void setUser_portrait(String str) {
            this.user_portrait = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }

        public List<AbstractBean> getAbstractX() {
            return this.abstractX;
        }

        public void setAbstractX(List<AbstractBean> list) {
            this.abstractX = list;
        }

        public List<MediaBean> getMedia() {
            return this.media;
        }

        public void setMedia(List<MediaBean> list) {
            this.media = list;
        }

        public List<?> getAnchor_info() {
            return this.anchor_info;
        }

        public void setAnchor_info(List<?> list) {
            this.anchor_info = list;
        }

        public List<?> getPoll_info() {
            return this.poll_info;
        }

        public void setPoll_info(List<?> list) {
            this.poll_info = list;
        }
    }

    public static UserPostBean objectFromData(String str) {
        return (UserPostBean) new Gson().fromJson(str, UserPostBean.class);
    }

    public static List<UserPostBean> arrayUserPostBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserPostBean>>() {
        }.getType());
    }

    public String getHide_post() {
        return this.hide_post;
    }

    public void setHide_post(String str) {
        this.hide_post = str;
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

    public List<PostListBean> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<PostListBean> list) {
        this.post_list = list;
    }
}
