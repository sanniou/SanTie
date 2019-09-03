package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SearchPostBean extends BaseBean {

    private int ctime;
    private String error_code;
    private String error_msg;
    private int logid;
    private PageBean page;
    private List<PostListBean> post_list;
    private String server_time;
    private int time;

    public static class PageBean {

        private int current_page;
        private String has_more;
        private String has_prev;
        private String offset;
        private String page_size;
        private String total_count;
        private String total_page;

        public static PageBean objectFromData(String str) {
            return (PageBean) new Gson().fromJson(str, PageBean.class);
        }

        public static List<PageBean> arrayPageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PageBean>>() {
            }.getType());
        }

        public String getPage_size() {
            return this.page_size;
        }

        public void setPage_size(String str) {
            this.page_size = str;
        }

        public String getOffset() {
            return this.offset;
        }

        public void setOffset(String str) {
            this.offset = str;
        }

        public int getCurrent_page() {
            return this.current_page;
        }

        public void setCurrent_page(int i) {
            this.current_page = i;
        }

        public String getTotal_count() {
            return this.total_count;
        }

        public void setTotal_count(String str) {
            this.total_count = str;
        }

        public String getTotal_page() {
            return this.total_page;
        }

        public void setTotal_page(String str) {
            this.total_page = str;
        }

        public String getHas_more() {
            return this.has_more;
        }

        public void setHas_more(String str) {
            this.has_more = str;
        }

        public String getHas_prev() {
            return this.has_prev;
        }

        public void setHas_prev(String str) {
            this.has_prev = str;
        }
    }

    public static class PostListBean {

        private AuthorBean author;
        private String cid;
        private String content;
        private String fname;
        private String is_floor;
        private String is_replay;
        private String pid;
        private String thread_type;
        private String tid;
        private long time;
        private String title;

        public static class AuthorBean {

            private String name;
            private String name_show;

            public static AuthorBean objectFromData(String str) {
                return (AuthorBean) new Gson().fromJson(str, AuthorBean.class);
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AuthorBean>>() {
                }.getType());
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

        public static PostListBean objectFromData(String str) {
            return (PostListBean) new Gson().fromJson(str, PostListBean.class);
        }

        public static List<PostListBean> arrayPostListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostListBean>>() {
            }.getType());
        }

        public String getPid() {
            return this.pid;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getFname() {
            return this.fname;
        }

        public void setFname(String str) {
            this.fname = str;
        }

        public String getTid() {
            return this.tid;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public String getIs_floor() {
            return this.is_floor;
        }

        public void setIs_floor(String str) {
            this.is_floor = str;
        }

        public String getCid() {
            return this.cid;
        }

        public void setCid(String str) {
            this.cid = str;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public String getIs_replay() {
            return this.is_replay;
        }

        public void setIs_replay(String str) {
            this.is_replay = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }
    }

    public static SearchPostBean objectFromData(String str) {
        return (SearchPostBean) new Gson().fromJson(str, SearchPostBean.class);
    }

    public static List<SearchPostBean> arraySearchPostBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SearchPostBean>>() {
        }.getType());
    }

    public PageBean getPage() {
        return this.page;
    }

    public void setPage(PageBean pageBean) {
        this.page = pageBean;
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

    public List<PostListBean> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<PostListBean> list) {
        this.post_list = list;
    }
}
