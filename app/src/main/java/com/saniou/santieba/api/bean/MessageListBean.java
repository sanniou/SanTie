package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MessageListBean extends BaseBean {

    private List<AtListBean> at_list;
    private int ctime;
    private String error_code;
    private String logid;
    private MessageBean message;
    private PageBean page;
    private List<ReplyListBean> reply_list;
    private String server_time;
    private String time;

    public static class AtListBean {

        private String content;
        private String fname;
        private String is_floor;
        private String post_id;
        private String quote_content;
        private String quote_pid;
        private QuoteUserBean quote_user;
        private ReplyerBean replyer;
        private String thread_id;
        private String thread_type;
        private long time;
        private String title;

        public static class QuoteUserBean {

            private String id;
            private String name;
            private String name_show;

            public static QuoteUserBean objectFromData(String str) {
                return (QuoteUserBean) new Gson().fromJson(str, QuoteUserBean.class);
            }

            public static List<QuoteUserBean> arrayQuoteUserBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<QuoteUserBean>>() {
                }.getType());
            }

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
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

        public static class ReplyerBean {

            private String id;
            private String is_friend;
            private String name;
            private String name_show;
            private String portrait;

            public static ReplyerBean objectFromData(String str) {
                return (ReplyerBean) new Gson().fromJson(str, ReplyerBean.class);
            }

            public static List<ReplyerBean> arrayReplyerBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ReplyerBean>>() {
                }.getType());
            }

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getPortrait() {
                return this.portrait;
            }

            public void setPortrait(String str) {
                this.portrait = str;
            }

            public String getIs_friend() {
                return this.is_friend;
            }

            public void setIs_friend(String str) {
                this.is_friend = str;
            }

            public String getName_show() {
                return this.name_show;
            }

            public void setName_show(String str) {
                this.name_show = str;
            }
        }

        public static AtListBean objectFromData(String str) {
            return (AtListBean) new Gson().fromJson(str, AtListBean.class);
        }

        public static List<AtListBean> arrayAtListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AtListBean>>() {
            }.getType());
        }

        public ReplyerBean getReplyer() {
            return this.replyer;
        }

        public void setReplyer(ReplyerBean replyerBean) {
            this.replyer = replyerBean;
        }

        public QuoteUserBean getQuote_user() {
            return this.quote_user;
        }

        public void setQuote_user(QuoteUserBean quoteUserBean) {
            this.quote_user = quoteUserBean;
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

        public String getThread_id() {
            return this.thread_id;
        }

        public void setThread_id(String str) {
            this.thread_id = str;
        }

        public String getQuote_pid() {
            return this.quote_pid;
        }

        public void setQuote_pid(String str) {
            this.quote_pid = str;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String str) {
            this.post_id = str;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public String getQuote_content() {
            return this.quote_content;
        }

        public void setQuote_content(String str) {
            this.quote_content = str;
        }

        public String getFname() {
            return this.fname;
        }

        public void setFname(String str) {
            this.fname = str;
        }

        public String getIs_floor() {
            return this.is_floor;
        }

        public void setIs_floor(String str) {
            this.is_floor = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }
    }

    public static class MessageBean {

        private String anti;
        private String atme;
        private String evaluate;
        private String fans;
        private String feature;
        private String guess;
        private String money;
        private String recycle;
        private String replyme;
        private String storethread;
        private String zan;

        public static MessageBean objectFromData(String str) {
            return (MessageBean) new Gson().fromJson(str, MessageBean.class);
        }

        public static List<MessageBean> arrayMessageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MessageBean>>() {
            }.getType());
        }

        public String getFans() {
            return this.fans;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public String getEvaluate() {
            return this.evaluate;
        }

        public void setEvaluate(String str) {
            this.evaluate = str;
        }

        public String getMoney() {
            return this.money;
        }

        public void setMoney(String str) {
            this.money = str;
        }

        public String getReplyme() {
            return this.replyme;
        }

        public void setReplyme(String str) {
            this.replyme = str;
        }

        public String getFeature() {
            return this.feature;
        }

        public void setFeature(String str) {
            this.feature = str;
        }

        public String getGuess() {
            return this.guess;
        }

        public void setGuess(String str) {
            this.guess = str;
        }

        public String getAnti() {
            return this.anti;
        }

        public void setAnti(String str) {
            this.anti = str;
        }

        public String getAtme() {
            return this.atme;
        }

        public void setAtme(String str) {
            this.atme = str;
        }

        public String getRecycle() {
            return this.recycle;
        }

        public void setRecycle(String str) {
            this.recycle = str;
        }

        public String getZan() {
            return this.zan;
        }

        public void setZan(String str) {
            this.zan = str;
        }

        public String getStorethread() {
            return this.storethread;
        }

        public void setStorethread(String str) {
            this.storethread = str;
        }
    }

    public static class PageBean {

        private int current_page;
        private int has_more;
        private int has_prev;

        public static PageBean objectFromData(String str) {
            return (PageBean) new Gson().fromJson(str, PageBean.class);
        }

        public static List<PageBean> arrayPageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PageBean>>() {
            }.getType());
        }

        public int getCurrent_page() {
            return this.current_page;
        }

        public void setCurrent_page(int i) {
            this.current_page = i;
        }

        public int getHas_more() {
            return this.has_more;
        }

        public void setHas_more(int i) {
            this.has_more = i;
        }

        public int getHas_prev() {
            return this.has_prev;
        }

        public void setHas_prev(int i) {
            this.has_prev = i;
        }
    }

    public static class ReplyListBean {

        private String content;
        private String fname;
        private String is_floor;
        private String post_id;
        private String quote_content;
        private String quote_pid;
        private QuoteUserBean quote_user;
        private ReplyerBean replyer;
        private String thread_id;
        private String thread_type;
        private long time;
        private String title;
        private String type;
        private String unread;

        public static class QuoteUserBean {

            private String id;
            private String name;
            private String name_show;
            private String portrait;

            public static QuoteUserBean objectFromData(String str) {
                return (QuoteUserBean) new Gson().fromJson(str, QuoteUserBean.class);
            }

            public static List<QuoteUserBean> arrayQuoteUserBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<QuoteUserBean>>() {
                }.getType());
            }

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getPortrait() {
                return this.portrait;
            }

            public void setPortrait(String str) {
                this.portrait = str;
            }

            public String getName_show() {
                return this.name_show;
            }

            public void setName_show(String str) {
                this.name_show = str;
            }
        }

        public static class ReplyerBean {

            private String id;
            private String is_friend;
            private String name;
            private String name_show;
            private String portrait;

            public static ReplyerBean objectFromData(String str) {
                return (ReplyerBean) new Gson().fromJson(str, ReplyerBean.class);
            }

            public static List<ReplyerBean> arrayReplyerBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ReplyerBean>>() {
                }.getType());
            }

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getPortrait() {
                return this.portrait;
            }

            public void setPortrait(String str) {
                this.portrait = str;
            }

            public String getIs_friend() {
                return this.is_friend;
            }

            public void setIs_friend(String str) {
                this.is_friend = str;
            }

            public String getName_show() {
                return this.name_show;
            }

            public void setName_show(String str) {
                this.name_show = str;
            }
        }

        public static ReplyListBean objectFromData(String str) {
            return (ReplyListBean) new Gson().fromJson(str, ReplyListBean.class);
        }

        public static List<ReplyListBean> arrayReplyListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ReplyListBean>>() {
            }.getType());
        }

        public String getIs_floor() {
            return this.is_floor;
        }

        public void setIs_floor(String str) {
            this.is_floor = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getUnread() {
            return this.unread;
        }

        public void setUnread(String str) {
            this.unread = str;
        }

        public ReplyerBean getReplyer() {
            return this.replyer;
        }

        public void setReplyer(ReplyerBean replyerBean) {
            this.replyer = replyerBean;
        }

        public QuoteUserBean getQuote_user() {
            return this.quote_user;
        }

        public void setQuote_user(QuoteUserBean quoteUserBean) {
            this.quote_user = quoteUserBean;
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

        public String getQuote_content() {
            return this.quote_content;
        }

        public void setQuote_content(String str) {
            this.quote_content = str;
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

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public String getFname() {
            return this.fname;
        }

        public void setFname(String str) {
            this.fname = str;
        }

        public String getQuote_pid() {
            return this.quote_pid;
        }

        public void setQuote_pid(String str) {
            this.quote_pid = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }
    }

    public static MessageListBean objectFromData(String str) {
        return (MessageListBean) new Gson().fromJson(str, MessageListBean.class);
    }

    public static List<MessageListBean> arrayReplyMeBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MessageListBean>>() {
        }.getType());
    }

    public PageBean getPage() {
        return this.page;
    }

    public void setPage(PageBean pageBean) {
        this.page = pageBean;
    }

    public MessageBean getMessage() {
        return this.message;
    }

    public void setMessage(MessageBean messageBean) {
        this.message = messageBean;
    }

    public String getServer_time() {
        return this.server_time;
    }

    public void setServer_time(String str) {
        this.server_time = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
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

    public List<ReplyListBean> getReply_list() {
        return this.reply_list;
    }

    public void setReply_list(List<ReplyListBean> list) {
        this.reply_list = list;
    }

    public List<AtListBean> getAt_list() {
        return this.at_list;
    }

    public void setAt_list(List<AtListBean> list) {
        this.at_list = list;
    }
}
