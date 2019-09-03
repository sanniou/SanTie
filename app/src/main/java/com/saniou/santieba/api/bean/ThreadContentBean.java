package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreadContentBean extends BaseBean {

    private AddPostBean add_post;
    private AntiBean anti;
    private BannerListBean banner_list;
    private int ctime;
    private String error_code;
    private String error_msg;
    private ForumBean forum;
    private String has_floor;
    private String is_new_url;
    private List<?> location;
    private int logid;
    private PageBean page;
    private List<PostListBean> post_list;
    private String server_time;
    private String switch_read_open;
    private ThreadBean thread;
    private int time;
    private UserBean user;
    private List<UserListBean> user_list;
    private Map<String, UserListBean> users;

    public static class AddPostBean {

        private String already_count;
        private String create_time;
        private String last_addition_content;
        private String last_addition_time;
        private String post_id;
        private String total_count;
        private String warn_msg;

        public static AddPostBean objectFromData(String str) {
            return (AddPostBean) new Gson().fromJson(str, AddPostBean.class);
        }

        public static List<AddPostBean> arrayAddPostBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AddPostBean>>() {
            }.getType());
        }

        public String getLast_addition_content() {
            return this.last_addition_content;
        }

        public void setLast_addition_content(String str) {
            this.last_addition_content = str;
        }

        public String getLast_addition_time() {
            return this.last_addition_time;
        }

        public void setLast_addition_time(String str) {
            this.last_addition_time = str;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String str) {
            this.post_id = str;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public void setCreate_time(String str) {
            this.create_time = str;
        }

        public String getAlready_count() {
            return this.already_count;
        }

        public void setAlready_count(String str) {
            this.already_count = str;
        }

        public String getTotal_count() {
            return this.total_count;
        }

        public void setTotal_count(String str) {
            this.total_count = str;
        }

        public String getWarn_msg() {
            return this.warn_msg;
        }

        public void setWarn_msg(String str) {
            this.warn_msg = str;
        }
    }

    public static class AntiBean {

        private String forbid_flag;
        private String forbid_info;
        private String ifaddition;
        private String ifpost;
        private String ifposta;
        private String ifvoice;
        private String ifxiaoying;
        private String tbs;
        private String video_message;
        private String voice_message;

        public static AntiBean objectFromData(String str) {
            return (AntiBean) new Gson().fromJson(str, AntiBean.class);
        }

        public static List<AntiBean> arrayAntiBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AntiBean>>() {
            }.getType());
        }

        public String getTbs() {
            return this.tbs;
        }

        public void setTbs(String str) {
            this.tbs = str;
        }

        public String getIfvoice() {
            return this.ifvoice;
        }

        public void setIfvoice(String str) {
            this.ifvoice = str;
        }

        public String getVoice_message() {
            return this.voice_message;
        }

        public void setVoice_message(String str) {
            this.voice_message = str;
        }

        public String getVideo_message() {
            return this.video_message;
        }

        public void setVideo_message(String str) {
            this.video_message = str;
        }

        public String getIfaddition() {
            return this.ifaddition;
        }

        public void setIfaddition(String str) {
            this.ifaddition = str;
        }

        public String getForbid_flag() {
            return this.forbid_flag;
        }

        public void setForbid_flag(String str) {
            this.forbid_flag = str;
        }

        public String getForbid_info() {
            return this.forbid_info;
        }

        public void setForbid_info(String str) {
            this.forbid_info = str;
        }

        public String getIfpost() {
            return this.ifpost;
        }

        public void setIfpost(String str) {
            this.ifpost = str;
        }

        public String getIfposta() {
            return this.ifposta;
        }

        public void setIfposta(String str) {
            this.ifposta = str;
        }

        public String getIfxiaoying() {
            return this.ifxiaoying;
        }

        public void setIfxiaoying(String str) {
            this.ifxiaoying = str;
        }
    }

    public static class BannerListBean {

        private List<?> app;

        public static BannerListBean objectFromData(String str) {
            return (BannerListBean) new Gson().fromJson(str, BannerListBean.class);
        }

        public static List<BannerListBean> arrayBannerListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BannerListBean>>() {
            }.getType());
        }

        public List<?> getApp() {
            return this.app;
        }

        public void setApp(List<?> list) {
            this.app = list;
        }
    }

    public static class ForumBean {

        private String avatar;
        private String first_class;
        private String id;
        private String is_exists;
        private String name;
        private String second_class;

        public static ForumBean objectFromData(String str) {
            return (ForumBean) new Gson().fromJson(str, ForumBean.class);
        }

        public static List<ForumBean> arrayForumBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumBean>>() {
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

        public String getIs_exists() {
            return this.is_exists;
        }

        public void setIs_exists(String str) {
            this.is_exists = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public String getFirst_class() {
            return this.first_class;
        }

        public void setFirst_class(String str) {
            this.first_class = str;
        }

        public String getSecond_class() {
            return this.second_class;
        }

        public void setSecond_class(String str) {
            this.second_class = str;
        }
    }

    public static class PageBean {

        private int current_page;
        private int has_more;
        private int has_prev;
        private int offset;
        private int page_size;
        private int pnum;
        private int req_num;
        private int tnum;
        private int total_num;
        private int total_page;

        public static PageBean objectFromData(String str) {
            return (PageBean) new Gson().fromJson(str, PageBean.class);
        }

        public static List<PageBean> arrayPageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PageBean>>() {
            }.getType());
        }

        public int getReq_num() {
            return this.req_num;
        }

        public void setReq_num(int i) {
            this.req_num = i;
        }

        public int getPage_size() {
            return this.page_size;
        }

        public void setPage_size(int i) {
            this.page_size = i;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public int getCurrent_page() {
            return this.current_page;
        }

        public void setCurrent_page(int i) {
            this.current_page = i;
        }

        public int getTotal_page() {
            return this.total_page;
        }

        public void setTotal_page(int i) {
            this.total_page = i;
        }

        public int getTotal_num() {
            return this.total_num;
        }

        public void setTotal_num(int i) {
            this.total_num = i;
        }

        public int getPnum() {
            return this.pnum;
        }

        public void setPnum(int i) {
            this.pnum = i;
        }

        public int getTnum() {
            return this.tnum;
        }

        public void setTnum(int i) {
            this.tnum = i;
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

    public static class PostListBean {

        private List<?> add_post_list;
        private String add_post_number;
        private List<?> arr_video;
        private String author_id;
        private String bimg_url;
        private List<ContentBeanX> content;
        private String floor;
        private String from_thread_id;
        private String has_signature;
        private String id;
        private String ios_bimg_format;
        private String is_vote;
        private List<?> lbs_info;
        private String noMoreView;
        private String pb_live;
        private List<?> signature;
        private SubPostListBeanX sub_post_list;
        private String sub_post_number;
        private List<?> tail_info;
        private long time;
        private String title;

        public static class ContentBeanX {

            private String big_cdn_src;
            private String bsize;
            private String c;
            private String cdn_src;
            private String cdn_src_active;
            private String is_native_app;
            private String link;
            private List<?> native_app;
            private String origin_size;
            private String origin_src;
            private String size;
            private String text;
            private String type;
            private String uid;
            private String voice_md5;

            public static ContentBeanX objectFromData(String str) {
                return (ContentBeanX) new Gson().fromJson(str, ContentBeanX.class);
            }

            public static List<ContentBeanX> arrayContentBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ContentBeanX>>() {
                }.getType());
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getLink() {
                return this.link;
            }

            public void setLink(String str) {
                this.link = str;
            }

            public String getUid() {
                return this.uid;
            }

            public void setUid(String str) {
                this.uid = str;
            }

            public String getText() {
                return this.text;
            }

            public void setText(String str) {
                this.text = str;
            }

            public String getC() {
                return this.c;
            }

            public void setC(String str) {
                this.c = str;
            }

            public String getBig_cdn_src() {
                return this.big_cdn_src;
            }

            public void setBig_cdn_src(String str) {
                this.big_cdn_src = str;
            }

            public String getBsize() {
                return this.bsize;
            }

            public void setBsize(String str) {
                this.bsize = str;
            }

            public String getCdn_src() {
                return this.cdn_src;
            }

            public void setCdn_src(String str) {
                this.cdn_src = str;
            }

            public String getCdn_src_active() {
                return this.cdn_src_active;
            }

            public void setCdn_src_active(String str) {
                this.cdn_src_active = str;
            }

            public String getOrigin_src() {
                return this.origin_src;
            }

            public void setOrigin_src(String str) {
                this.origin_src = str;
            }

            public String getOrigin_size() {
                return this.origin_size;
            }

            public void setOrigin_size(String str) {
                this.origin_size = str;
            }

            public String getSize() {
                return this.size;
            }

            public void setSize(String str) {
                this.size = str;
            }

            public String getVoice_md5() {
                return this.voice_md5;
            }

            public void setVoice_md5(String str) {
                this.voice_md5 = str;
            }

            public String getIs_native_app() {
                return this.is_native_app;
            }

            public void setIs_native_app(String str) {
                this.is_native_app = str;
            }

            public List<?> getNative_app() {
                return this.native_app;
            }

            public void setNative_app(List<?> list) {
                this.native_app = list;
            }
        }

        public static class SubPostListBeanX {

            private String pid;
            private List<SubPostListBean> sub_post_list;

            public static class SubPostListBean {

                private String author_id;
                private List<ContentBean> content;
                private String floor;
                private String id;
                private String time;
                private String title;

                public static class ContentBean {

                    private String c;
                    private int during_time;
                    private String is_sub;
                    private String link;
                    private String text;
                    private String type;
                    private String uid;
                    private String voice_md5;

                    public static ContentBean objectFromData(String str) {
                        return (ContentBean) new Gson().fromJson(str, ContentBean.class);
                    }

                    public static List<ContentBean> arrayContentBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ContentBean>>() {
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

                    public String getC() {
                        return this.c;
                    }

                    public void setC(String str) {
                        this.c = str;
                    }

                    public String getLink() {
                        return this.link;
                    }

                    public void setLink(String str) {
                        this.link = str;
                    }

                    public String getUid() {
                        return this.uid;
                    }

                    public void setUid(String str) {
                        this.uid = str;
                    }

                    public int getDuring_time() {
                        return this.during_time;
                    }

                    public void setDuring_time(int i) {
                        this.during_time = i;
                    }

                    public String getIs_sub() {
                        return this.is_sub;
                    }

                    public void setIs_sub(String str) {
                        this.is_sub = str;
                    }

                    public String getVoice_md5() {
                        return this.voice_md5;
                    }

                    public void setVoice_md5(String str) {
                        this.voice_md5 = str;
                    }
                }

                public static SubPostListBean objectFromData(String str) {
                    return (SubPostListBean) new Gson().fromJson(str, SubPostListBean.class);
                }

                public static List<SubPostListBean> arraySubPostListBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SubPostListBean>>() {
                    }.getType());
                }

                public String getId() {
                    return this.id;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public String getTime() {
                    return this.time;
                }

                public void setTime(String str) {
                    this.time = str;
                }

                public String getFloor() {
                    return this.floor;
                }

                public void setFloor(String str) {
                    this.floor = str;
                }

                public String getTitle() {
                    return this.title;
                }

                public void setTitle(String str) {
                    this.title = str;
                }

                public String getAuthor_id() {
                    return this.author_id;
                }

                public void setAuthor_id(String str) {
                    this.author_id = str;
                }

                public List<ContentBean> getContent() {
                    return this.content;
                }

                public void setContent(List<ContentBean> list) {
                    this.content = list;
                }
            }

            public static SubPostListBeanX objectFromData(String str) {
                return (SubPostListBeanX) new Gson().fromJson(str, SubPostListBeanX.class);
            }

            public static List<SubPostListBeanX> arraySubPostListBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SubPostListBeanX>>() {
                }.getType());
            }

            public String getPid() {
                return this.pid;
            }

            public void setPid(String str) {
                this.pid = str;
            }

            public List<SubPostListBean> getSub_post_list() {
                return this.sub_post_list;
            }

            public void setSub_post_list(List<SubPostListBean> list) {
                this.sub_post_list = list;
            }
        }

        public static PostListBean objectFromData(String str) {
            return (PostListBean) new Gson().fromJson(str, PostListBean.class);
        }

        public static List<PostListBean> arrayPostListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostListBean>>() {
            }.getType());
        }

        public String getNoMoreView() {
            return this.noMoreView;
        }

        public void setNoMoreView(String str) {
            this.noMoreView = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getFloor() {
            return this.floor;
        }

        public void setFloor(String str) {
            this.floor = str;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public String getBimg_url() {
            return this.bimg_url;
        }

        public void setBimg_url(String str) {
            this.bimg_url = str;
        }

        public String getIos_bimg_format() {
            return this.ios_bimg_format;
        }

        public void setIos_bimg_format(String str) {
            this.ios_bimg_format = str;
        }

        public String getHas_signature() {
            return this.has_signature;
        }

        public void setHas_signature(String str) {
            this.has_signature = str;
        }

        public String getPb_live() {
            return this.pb_live;
        }

        public void setPb_live(String str) {
            this.pb_live = str;
        }

        public String getFrom_thread_id() {
            return this.from_thread_id;
        }

        public void setFrom_thread_id(String str) {
            this.from_thread_id = str;
        }

        public String getSub_post_number() {
            return this.sub_post_number;
        }

        public void setSub_post_number(String str) {
            this.sub_post_number = str;
        }

        public String getAdd_post_number() {
            return this.add_post_number;
        }

        public void setAdd_post_number(String str) {
            this.add_post_number = str;
        }

        public SubPostListBeanX getSub_post_list() {
            return this.sub_post_list;
        }

        public void setSub_post_list(SubPostListBeanX subPostListBeanX) {
            this.sub_post_list = subPostListBeanX;
        }

        public String getAuthor_id() {
            return this.author_id;
        }

        public void setAuthor_id(String str) {
            this.author_id = str;
        }

        public String getIs_vote() {
            return this.is_vote;
        }

        public void setIs_vote(String str) {
            this.is_vote = str;
        }

        public List<ContentBeanX> getContent() {
            return this.content;
        }

        public void setContent(List<ContentBeanX> list) {
            this.content = list;
        }

        public List<?> getLbs_info() {
            return this.lbs_info;
        }

        public void setLbs_info(List<?> list) {
            this.lbs_info = list;
        }

        public List<?> getArr_video() {
            return this.arr_video;
        }

        public void setArr_video(List<?> list) {
            this.arr_video = list;
        }

        public List<?> getSignature() {
            return this.signature;
        }

        public void setSignature(List<?> list) {
            this.signature = list;
        }

        public List<?> getTail_info() {
            return this.tail_info;
        }

        public void setTail_info(List<?> list) {
            this.tail_info = list;
        }

        public List<?> getAdd_post_list() {
            return this.add_post_list;
        }

        public void setAdd_post_list(List<?> list) {
            this.add_post_list = list;
        }
    }

    public static class ThreadBean {

        private AuthorBean author;
        private String collect_mark_pid;
        private String collect_status;
        private String create_time;
        private String id;
        private String is_activity;
        private String is_bub;
        private String is_ntitle;
        private List<?> location;
        private String pids;
        private String post_id;
        private String reply_num;
        private String repost_num;
        private String thread_type;
        private String title;
        private TopicBean topic;
        private TwzhiboInfoBean twzhibo_info;
        private ZanBean zan;

        public static class AuthorBean {

            private String ala_info;
            private String bawu_type;
            private String fans_nickname;
            private String fans_num;
            private String gender;
            private String gift_num;
            private String god_data;
            private String has_concerned;
            private List<IconinfoBean> iconinfo;
            private String id;
            private String is_bawu;
            private String is_like;
            private String level_id;
            private String name;
            private String name_show;
            private List<NewTshowIconBean> new_tshow_icon;
            private List<?> pendant;
            private String portrait;
            private String seal_prefix;
            private List<?> spring_virtual_user;
            private List<?> tb_vip;
            private List<TshowIconBean> tshow_icon;
            private String type;

            public static class IconinfoBean {

                private String icon;
                private String name;
                private PositionBean position;
                private SpriteBean sprite;
                private TerminalBean terminal;
                private String value;
                private String weight;

                public static class PositionBean {

                    private String card;
                    private String frs;
                    private String home;
                    private String pb;

                    public static PositionBean objectFromData(String str) {
                        return (PositionBean) new Gson().fromJson(str, PositionBean.class);
                    }

                    public static List<PositionBean> arrayPositionBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PositionBean>>() {
                        }.getType());
                    }

                    public String getFrs() {
                        return this.frs;
                    }

                    public void setFrs(String str) {
                        this.frs = str;
                    }

                    public String getPb() {
                        return this.pb;
                    }

                    public void setPb(String str) {
                        this.pb = str;
                    }

                    public String getHome() {
                        return this.home;
                    }

                    public void setHome(String str) {
                        this.home = str;
                    }

                    public String getCard() {
                        return this.card;
                    }

                    public void setCard(String str) {
                        this.card = str;
                    }
                }

                public static class SpriteBean {

                    @SerializedName("1")
                    private String _$1;

                    public static SpriteBean objectFromData(String str) {
                        return (SpriteBean) new Gson().fromJson(str, SpriteBean.class);
                    }

                    public static List<SpriteBean> arraySpriteBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SpriteBean>>() {
                        }.getType());
                    }

                    public String get_$1() {
                        return this._$1;
                    }

                    public void set_$1(String str) {
                        this._$1 = str;
                    }
                }

                public static class TerminalBean {

                    private String client;
                    private String pc;
                    private String wap;

                    public static TerminalBean objectFromData(String str) {
                        return (TerminalBean) new Gson().fromJson(str, TerminalBean.class);
                    }

                    public static List<TerminalBean> arrayTerminalBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TerminalBean>>() {
                        }.getType());
                    }

                    public String getPc() {
                        return this.pc;
                    }

                    public void setPc(String str) {
                        this.pc = str;
                    }

                    public String getWap() {
                        return this.wap;
                    }

                    public void setWap(String str) {
                        this.wap = str;
                    }

                    public String getClient() {
                        return this.client;
                    }

                    public void setClient(String str) {
                        this.client = str;
                    }
                }

                public static IconinfoBean objectFromData(String str) {
                    return (IconinfoBean) new Gson().fromJson(str, IconinfoBean.class);
                }

                public static List<IconinfoBean> arrayIconinfoBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<IconinfoBean>>() {
                    }.getType());
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public String getValue() {
                    return this.value;
                }

                public void setValue(String str) {
                    this.value = str;
                }

                public String getWeight() {
                    return this.weight;
                }

                public void setWeight(String str) {
                    this.weight = str;
                }

                public TerminalBean getTerminal() {
                    return this.terminal;
                }

                public void setTerminal(TerminalBean terminalBean) {
                    this.terminal = terminalBean;
                }

                public PositionBean getPosition() {
                    return this.position;
                }

                public void setPosition(PositionBean positionBean) {
                    this.position = positionBean;
                }

                public SpriteBean getSprite() {
                    return this.sprite;
                }

                public void setSprite(SpriteBean spriteBean) {
                    this.sprite = spriteBean;
                }

                public String getIcon() {
                    return this.icon;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }
            }

            public static class NewTshowIconBean {

                private String icon;
                private String name;
                private String url;

                public static NewTshowIconBean objectFromData(String str) {
                    return (NewTshowIconBean) new Gson().fromJson(str, NewTshowIconBean.class);
                }

                public static List<NewTshowIconBean> arrayNewTshowIconBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<NewTshowIconBean>>() {
                    }.getType());
                }

                public String getIcon() {
                    return this.icon;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setUrl(String str) {
                    this.url = str;
                }
            }

            public static class TshowIconBean {

                private String icon;
                private String name;
                private String url;

                public static TshowIconBean objectFromData(String str) {
                    return (TshowIconBean) new Gson().fromJson(str, TshowIconBean.class);
                }

                public static List<TshowIconBean> arrayTshowIconBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TshowIconBean>>() {
                    }.getType());
                }

                public String getIcon() {
                    return this.icon;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setUrl(String str) {
                    this.url = str;
                }
            }

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

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getPortrait() {
                return this.portrait;
            }

            public void setPortrait(String str) {
                this.portrait = str;
            }

            public String getLevel_id() {
                return this.level_id;
            }

            public void setLevel_id(String str) {
                this.level_id = str;
            }

            public String getIs_like() {
                return this.is_like;
            }

            public void setIs_like(String str) {
                this.is_like = str;
            }

            public String getIs_bawu() {
                return this.is_bawu;
            }

            public void setIs_bawu(String str) {
                this.is_bawu = str;
            }

            public String getBawu_type() {
                return this.bawu_type;
            }

            public void setBawu_type(String str) {
                this.bawu_type = str;
            }

            public String getGender() {
                return this.gender;
            }

            public void setGender(String str) {
                this.gender = str;
            }

            public String getHas_concerned() {
                return this.has_concerned;
            }

            public void setHas_concerned(String str) {
                this.has_concerned = str;
            }

            public String getFans_nickname() {
                return this.fans_nickname;
            }

            public void setFans_nickname(String str) {
                this.fans_nickname = str;
            }

            public String getFans_num() {
                return this.fans_num;
            }

            public void setFans_num(String str) {
                this.fans_num = str;
            }

            public String getGod_data() {
                return this.god_data;
            }

            public void setGod_data(String str) {
                this.god_data = str;
            }

            public String getGift_num() {
                return this.gift_num;
            }

            public void setGift_num(String str) {
                this.gift_num = str;
            }

            public String getAla_info() {
                return this.ala_info;
            }

            public void setAla_info(String str) {
                this.ala_info = str;
            }

            public String getSeal_prefix() {
                return this.seal_prefix;
            }

            public void setSeal_prefix(String str) {
                this.seal_prefix = str;
            }

            public List<IconinfoBean> getIconinfo() {
                return this.iconinfo;
            }

            public void setIconinfo(List<IconinfoBean> list) {
                this.iconinfo = list;
            }

            public List<TshowIconBean> getTshow_icon() {
                return this.tshow_icon;
            }

            public void setTshow_icon(List<TshowIconBean> list) {
                this.tshow_icon = list;
            }

            public List<NewTshowIconBean> getNew_tshow_icon() {
                return this.new_tshow_icon;
            }

            public void setNew_tshow_icon(List<NewTshowIconBean> list) {
                this.new_tshow_icon = list;
            }

            public List<?> getTb_vip() {
                return this.tb_vip;
            }

            public void setTb_vip(List<?> list) {
                this.tb_vip = list;
            }

            public List<?> getPendant() {
                return this.pendant;
            }

            public void setPendant(List<?> list) {
                this.pendant = list;
            }

            public List<?> getSpring_virtual_user() {
                return this.spring_virtual_user;
            }

            public void setSpring_virtual_user(List<?> list) {
                this.spring_virtual_user = list;
            }
        }

        public static class TopicBean {

            private String is_lpost;
            private String link;

            public static TopicBean objectFromData(String str) {
                return (TopicBean) new Gson().fromJson(str, TopicBean.class);
            }

            public static List<TopicBean> arrayTopicBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TopicBean>>() {
                }.getType());
            }

            public String getIs_lpost() {
                return this.is_lpost;
            }

            public void setIs_lpost(String str) {
                this.is_lpost = str;
            }

            public String getLink() {
                return this.link;
            }

            public void setLink(String str) {
                this.link = str;
            }
        }

        public static class TwzhiboInfoBean {

            private String is_copytwzhibo;
            private UserBeanX user;

            public static class UserBeanX {

                private TwAnchorInfoBean tw_anchor_info;

                public static class TwAnchorInfoBean {

                    private String anchor_level;
                    private String caller_msg;
                    private String fans_num;
                    private String follow;
                    private String gifts_num;
                    private String guide;
                    private String in_black_list;
                    private String month_update_days;
                    private String newfloor;
                    private String set_cover;

                    public static TwAnchorInfoBean objectFromData(String str) {
                        return (TwAnchorInfoBean) new Gson().fromJson(str, TwAnchorInfoBean.class);
                    }

                    public static List<TwAnchorInfoBean> arrayTwAnchorInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TwAnchorInfoBean>>() {
                        }.getType());
                    }

                    public String getAnchor_level() {
                        return this.anchor_level;
                    }

                    public void setAnchor_level(String str) {
                        this.anchor_level = str;
                    }

                    public String getIn_black_list() {
                        return this.in_black_list;
                    }

                    public void setIn_black_list(String str) {
                        this.in_black_list = str;
                    }

                    public String getSet_cover() {
                        return this.set_cover;
                    }

                    public void setSet_cover(String str) {
                        this.set_cover = str;
                    }

                    public String getCaller_msg() {
                        return this.caller_msg;
                    }

                    public void setCaller_msg(String str) {
                        this.caller_msg = str;
                    }

                    public String getFollow() {
                        return this.follow;
                    }

                    public void setFollow(String str) {
                        this.follow = str;
                    }

                    public String getGuide() {
                        return this.guide;
                    }

                    public void setGuide(String str) {
                        this.guide = str;
                    }

                    public String getNewfloor() {
                        return this.newfloor;
                    }

                    public void setNewfloor(String str) {
                        this.newfloor = str;
                    }

                    public String getFans_num() {
                        return this.fans_num;
                    }

                    public void setFans_num(String str) {
                        this.fans_num = str;
                    }

                    public String getMonth_update_days() {
                        return this.month_update_days;
                    }

                    public void setMonth_update_days(String str) {
                        this.month_update_days = str;
                    }

                    public String getGifts_num() {
                        return this.gifts_num;
                    }

                    public void setGifts_num(String str) {
                        this.gifts_num = str;
                    }
                }

                public static UserBeanX objectFromData(String str) {
                    return (UserBeanX) new Gson().fromJson(str, UserBeanX.class);
                }

                public static List<UserBeanX> arrayUserBeanXFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserBeanX>>() {
                    }.getType());
                }

                public TwAnchorInfoBean getTw_anchor_info() {
                    return this.tw_anchor_info;
                }

                public void setTw_anchor_info(TwAnchorInfoBean twAnchorInfoBean) {
                    this.tw_anchor_info = twAnchorInfoBean;
                }
            }

            public static TwzhiboInfoBean objectFromData(String str) {
                return (TwzhiboInfoBean) new Gson().fromJson(str, TwzhiboInfoBean.class);
            }

            public static List<TwzhiboInfoBean> arrayTwzhiboInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TwzhiboInfoBean>>() {
                }.getType());
            }

            public String getIs_copytwzhibo() {
                return this.is_copytwzhibo;
            }

            public void setIs_copytwzhibo(String str) {
                this.is_copytwzhibo = str;
            }

            public UserBeanX getUser() {
                return this.user;
            }

            public void setUser(UserBeanX userBeanX) {
                this.user = userBeanX;
            }
        }

        public static class ZanBean {

            private String is_liked;
            private String last_time;
            private List<String> liker_id;
            private String num;

            public static ZanBean objectFromData(String str) {
                return (ZanBean) new Gson().fromJson(str, ZanBean.class);
            }

            public static List<ZanBean> arrayZanBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ZanBean>>() {
                }.getType());
            }

            public String getNum() {
                return this.num;
            }

            public void setNum(String str) {
                this.num = str;
            }

            public String getLast_time() {
                return this.last_time;
            }

            public void setLast_time(String str) {
                this.last_time = str;
            }

            public String getIs_liked() {
                return this.is_liked;
            }

            public void setIs_liked(String str) {
                this.is_liked = str;
            }

            public List<String> getLiker_id() {
                return this.liker_id;
            }

            public void setLiker_id(List<String> list) {
                this.liker_id = list;
            }
        }

        public static ThreadBean objectFromData(String str) {
            return (ThreadBean) new Gson().fromJson(str, ThreadBean.class);
        }

        public static List<ThreadBean> arrayThreadBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThreadBean>>() {
            }.getType());
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getReply_num() {
            return this.reply_num;
        }

        public void setReply_num(String str) {
            this.reply_num = str;
        }

        public String getRepost_num() {
            return this.repost_num;
        }

        public void setRepost_num(String str) {
            this.repost_num = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }

        public String getIs_ntitle() {
            return this.is_ntitle;
        }

        public void setIs_ntitle(String str) {
            this.is_ntitle = str;
        }

        public String getIs_bub() {
            return this.is_bub;
        }

        public void setIs_bub(String str) {
            this.is_bub = str;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public void setCreate_time(String str) {
            this.create_time = str;
        }

        public String getCollect_status() {
            return this.collect_status;
        }

        public void setCollect_status(String str) {
            this.collect_status = str;
        }

        public String getCollect_mark_pid() {
            return this.collect_mark_pid;
        }

        public void setCollect_mark_pid(String str) {
            this.collect_mark_pid = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public ZanBean getZan() {
            return this.zan;
        }

        public void setZan(ZanBean zanBean) {
            this.zan = zanBean;
        }

        public TwzhiboInfoBean getTwzhibo_info() {
            return this.twzhibo_info;
        }

        public void setTwzhibo_info(TwzhiboInfoBean twzhiboInfoBean) {
            this.twzhibo_info = twzhiboInfoBean;
        }

        public String getPids() {
            return this.pids;
        }

        public void setPids(String str) {
            this.pids = str;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String str) {
            this.post_id = str;
        }

        public TopicBean getTopic() {
            return this.topic;
        }

        public void setTopic(TopicBean topicBean) {
            this.topic = topicBean;
        }

        public String getIs_activity() {
            return this.is_activity;
        }

        public void setIs_activity(String str) {
            this.is_activity = str;
        }

        public List<?> getLocation() {
            return this.location;
        }

        public void setLocation(List<?> list) {
            this.location = list;
        }
    }

    public static class UserBean {

        private String bimg_end_time;
        private String bimg_url;
        private String id;
        private String ios_bimg_format;
        private String is_like;
        private String is_login;
        private String is_manager;
        private String is_mem;
        private String is_select_tail;
        private String level_id;
        private String name;
        private String name_show;
        private PayMemberInfoBean pay_member_info;
        private List<?> pendant;
        private String portrait;
        private String seal_prefix;
        private List<?> spring_virtual_user;
        private String type;

        public static class PayMemberInfoBean {

            private String end_time;
            private String pic_url;
            private String props_id;

            public static PayMemberInfoBean objectFromData(String str) {
                return (PayMemberInfoBean) new Gson().fromJson(str, PayMemberInfoBean.class);
            }

            public static List<PayMemberInfoBean> arrayPayMemberInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PayMemberInfoBean>>() {
                }.getType());
            }

            public String getProps_id() {
                return this.props_id;
            }

            public void setProps_id(String str) {
                this.props_id = str;
            }

            public String getEnd_time() {
                return this.end_time;
            }

            public void setEnd_time(String str) {
                this.end_time = str;
            }

            public String getPic_url() {
                return this.pic_url;
            }

            public void setPic_url(String str) {
                this.pic_url = str;
            }
        }

        public static UserBean objectFromData(String str) {
            return (UserBean) new Gson().fromJson(str, UserBean.class);
        }

        public static List<UserBean> arrayUserBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserBean>>() {
            }.getType());
        }

        public String getIs_login() {
            return this.is_login;
        }

        public void setIs_login(String str) {
            this.is_login = str;
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

        public String getPortrait() {
            return this.portrait;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getLevel_id() {
            return this.level_id;
        }

        public void setLevel_id(String str) {
            this.level_id = str;
        }

        public String getIs_like() {
            return this.is_like;
        }

        public void setIs_like(String str) {
            this.is_like = str;
        }

        public String getIs_manager() {
            return this.is_manager;
        }

        public void setIs_manager(String str) {
            this.is_manager = str;
        }

        public String getBimg_url() {
            return this.bimg_url;
        }

        public void setBimg_url(String str) {
            this.bimg_url = str;
        }

        public PayMemberInfoBean getPay_member_info() {
            return this.pay_member_info;
        }

        public void setPay_member_info(PayMemberInfoBean payMemberInfoBean) {
            this.pay_member_info = payMemberInfoBean;
        }

        public String getIos_bimg_format() {
            return this.ios_bimg_format;
        }

        public void setIos_bimg_format(String str) {
            this.ios_bimg_format = str;
        }

        public String getBimg_end_time() {
            return this.bimg_end_time;
        }

        public void setBimg_end_time(String str) {
            this.bimg_end_time = str;
        }

        public String getIs_mem() {
            return this.is_mem;
        }

        public void setIs_mem(String str) {
            this.is_mem = str;
        }

        public String getIs_select_tail() {
            return this.is_select_tail;
        }

        public void setIs_select_tail(String str) {
            this.is_select_tail = str;
        }

        public String getSeal_prefix() {
            return this.seal_prefix;
        }

        public void setSeal_prefix(String str) {
            this.seal_prefix = str;
        }

        public List<?> getPendant() {
            return this.pendant;
        }

        public void setPendant(List<?> list) {
            this.pendant = list;
        }

        public List<?> getSpring_virtual_user() {
            return this.spring_virtual_user;
        }

        public void setSpring_virtual_user(List<?> list) {
            this.spring_virtual_user = list;
        }
    }

    public static class UserListBean {

        private String ala_info;
        private String bawu_type;
        private String fans_nickname;
        private String fans_num;
        private String gender;
        private String gift_num;
        private String god_data;
        private String has_concerned;
        private List<IconinfoBeanX> iconinfo;
        private String id;
        private String is_bawu;
        private String is_mem;
        private String level_id;
        private String name;
        private String name_show;
        private List<NewTshowIconBeanX> new_tshow_icon;
        private List<?> pendant;
        private String portrait;
        private String seal_prefix;
        private List<?> spring_virtual_user;
        private List<?> tb_vip;
        private List<TshowIconBeanX> tshow_icon;

        public static class IconinfoBeanX {

            private String icon;
            private String name;
            private PositionBeanX position;
            private SpriteBeanX sprite;
            private TerminalBeanX terminal;
            private String value;
            private String weight;

            public static class PositionBeanX {

                private String card;
                private String frs;
                private String home;
                private String pb;

                public static PositionBeanX objectFromData(String str) {
                    return (PositionBeanX) new Gson().fromJson(str, PositionBeanX.class);
                }

                public static List<PositionBeanX> arrayPositionBeanXFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PositionBeanX>>() {
                    }.getType());
                }

                public String getFrs() {
                    return this.frs;
                }

                public void setFrs(String str) {
                    this.frs = str;
                }

                public String getPb() {
                    return this.pb;
                }

                public void setPb(String str) {
                    this.pb = str;
                }

                public String getHome() {
                    return this.home;
                }

                public void setHome(String str) {
                    this.home = str;
                }

                public String getCard() {
                    return this.card;
                }

                public void setCard(String str) {
                    this.card = str;
                }
            }

            public static class SpriteBeanX {

                @SerializedName("1")
                private String _$1;

                public static SpriteBeanX objectFromData(String str) {
                    return (SpriteBeanX) new Gson().fromJson(str, SpriteBeanX.class);
                }

                public static List<SpriteBeanX> arraySpriteBeanXFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SpriteBeanX>>() {
                    }.getType());
                }

                public String get_$1() {
                    return this._$1;
                }

                public void set_$1(String str) {
                    this._$1 = str;
                }
            }

            public static class TerminalBeanX {

                private String client;
                private String pc;
                private String wap;

                public static TerminalBeanX objectFromData(String str) {
                    return (TerminalBeanX) new Gson().fromJson(str, TerminalBeanX.class);
                }

                public static List<TerminalBeanX> arrayTerminalBeanXFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TerminalBeanX>>() {
                    }.getType());
                }

                public String getPc() {
                    return this.pc;
                }

                public void setPc(String str) {
                    this.pc = str;
                }

                public String getWap() {
                    return this.wap;
                }

                public void setWap(String str) {
                    this.wap = str;
                }

                public String getClient() {
                    return this.client;
                }

                public void setClient(String str) {
                    this.client = str;
                }
            }

            public static IconinfoBeanX objectFromData(String str) {
                return (IconinfoBeanX) new Gson().fromJson(str, IconinfoBeanX.class);
            }

            public static List<IconinfoBeanX> arrayIconinfoBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<IconinfoBeanX>>() {
                }.getType());
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getValue() {
                return this.value;
            }

            public void setValue(String str) {
                this.value = str;
            }

            public String getWeight() {
                return this.weight;
            }

            public void setWeight(String str) {
                this.weight = str;
            }

            public TerminalBeanX getTerminal() {
                return this.terminal;
            }

            public void setTerminal(TerminalBeanX terminalBeanX) {
                this.terminal = terminalBeanX;
            }

            public PositionBeanX getPosition() {
                return this.position;
            }

            public void setPosition(PositionBeanX positionBeanX) {
                this.position = positionBeanX;
            }

            public SpriteBeanX getSprite() {
                return this.sprite;
            }

            public void setSprite(SpriteBeanX spriteBeanX) {
                this.sprite = spriteBeanX;
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String str) {
                this.icon = str;
            }
        }

        public static class NewTshowIconBeanX {

            private String icon;
            private String name;
            private String url;

            public static NewTshowIconBeanX objectFromData(String str) {
                return (NewTshowIconBeanX) new Gson().fromJson(str, NewTshowIconBeanX.class);
            }

            public static List<NewTshowIconBeanX> arrayNewTshowIconBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<NewTshowIconBeanX>>() {
                }.getType());
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public static class TshowIconBeanX {

            private String icon;
            private String name;
            private String url;

            public static TshowIconBeanX objectFromData(String str) {
                return (TshowIconBeanX) new Gson().fromJson(str, TshowIconBeanX.class);
            }

            public static List<TshowIconBeanX> arrayTshowIconBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TshowIconBeanX>>() {
                }.getType());
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public static UserListBean objectFromData(String str) {
            return (UserListBean) new Gson().fromJson(str, UserListBean.class);
        }

        public static List<UserListBean> arrayUserListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserListBean>>() {
            }.getType());
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getPortrait() {
            return this.portrait;
        }

        public void setPortrait(String str) {
            this.portrait = str;
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

        public String getLevel_id() {
            return this.level_id;
        }

        public void setLevel_id(String str) {
            this.level_id = str;
        }

        public String getIs_bawu() {
            return this.is_bawu;
        }

        public void setIs_bawu(String str) {
            this.is_bawu = str;
        }

        public String getBawu_type() {
            return this.bawu_type;
        }

        public void setBawu_type(String str) {
            this.bawu_type = str;
        }

        public String getGender() {
            return this.gender;
        }

        public void setGender(String str) {
            this.gender = str;
        }

        public String getHas_concerned() {
            return this.has_concerned;
        }

        public void setHas_concerned(String str) {
            this.has_concerned = str;
        }

        public String getFans_nickname() {
            return this.fans_nickname;
        }

        public void setFans_nickname(String str) {
            this.fans_nickname = str;
        }

        public String getFans_num() {
            return this.fans_num;
        }

        public void setFans_num(String str) {
            this.fans_num = str;
        }

        public String getGod_data() {
            return this.god_data;
        }

        public void setGod_data(String str) {
            this.god_data = str;
        }

        public String getIs_mem() {
            return this.is_mem;
        }

        public void setIs_mem(String str) {
            this.is_mem = str;
        }

        public String getGift_num() {
            return this.gift_num;
        }

        public void setGift_num(String str) {
            this.gift_num = str;
        }

        public String getAla_info() {
            return this.ala_info;
        }

        public void setAla_info(String str) {
            this.ala_info = str;
        }

        public String getSeal_prefix() {
            return this.seal_prefix;
        }

        public void setSeal_prefix(String str) {
            this.seal_prefix = str;
        }

        public List<IconinfoBeanX> getIconinfo() {
            return this.iconinfo;
        }

        public void setIconinfo(List<IconinfoBeanX> list) {
            this.iconinfo = list;
        }

        public List<TshowIconBeanX> getTshow_icon() {
            return this.tshow_icon;
        }

        public void setTshow_icon(List<TshowIconBeanX> list) {
            this.tshow_icon = list;
        }

        public List<NewTshowIconBeanX> getNew_tshow_icon() {
            return this.new_tshow_icon;
        }

        public void setNew_tshow_icon(List<NewTshowIconBeanX> list) {
            this.new_tshow_icon = list;
        }

        public List<?> getTb_vip() {
            return this.tb_vip;
        }

        public void setTb_vip(List<?> list) {
            this.tb_vip = list;
        }

        public List<?> getPendant() {
            return this.pendant;
        }

        public void setPendant(List<?> list) {
            this.pendant = list;
        }

        public List<?> getSpring_virtual_user() {
            return this.spring_virtual_user;
        }

        public void setSpring_virtual_user(List<?> list) {
            this.spring_virtual_user = list;
        }
    }

    public static ThreadContentBean objectFromData(String str) {
        return (ThreadContentBean) new Gson().fromJson(str, ThreadContentBean.class);
    }

    public static List<ThreadContentBean> arrayThreadContentBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThreadContentBean>>() {
        }.getType());
    }

    public String getHas_floor() {
        return this.has_floor;
    }

    public void setHas_floor(String str) {
        this.has_floor = str;
    }

    public String getIs_new_url() {
        return this.is_new_url;
    }

    public void setIs_new_url(String str) {
        this.is_new_url = str;
    }

    public ForumBean getForum() {
        return this.forum;
    }

    public void setForum(ForumBean forumBean) {
        this.forum = forumBean;
    }

    public AddPostBean getAdd_post() {
        return this.add_post;
    }

    public void setAdd_post(AddPostBean addPostBean) {
        this.add_post = addPostBean;
    }

    public UserBean getUser() {
        return this.user;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }

    public AntiBean getAnti() {
        return this.anti;
    }

    public void setAnti(AntiBean antiBean) {
        this.anti = antiBean;
    }

    public PageBean getPage() {
        return this.page;
    }

    public void setPage(PageBean pageBean) {
        this.page = pageBean;
    }

    public ThreadBean getThread() {
        return this.thread;
    }

    public void setThread(ThreadBean threadBean) {
        this.thread = threadBean;
    }

    public String getSwitch_read_open() {
        return this.switch_read_open;
    }

    public void setSwitch_read_open(String str) {
        this.switch_read_open = str;
    }

    public BannerListBean getBanner_list() {
        return this.banner_list;
    }

    public void setBanner_list(BannerListBean bannerListBean) {
        this.banner_list = bannerListBean;
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

    public List<?> getLocation() {
        return this.location;
    }

    public void setLocation(List<?> list) {
        this.location = list;
    }

    public List<PostListBean> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<PostListBean> list) {
        this.post_list = list;
    }

    public List<UserListBean> getUser_list() {
        return this.user_list;
    }

    public void setUser_list(List<UserListBean> list) {
        this.user_list = list;
    }

    public Map<String, UserListBean> getUsers() {
        return this.users;
    }

    public void setUsers(Map<String, UserListBean> map) {
        this.users = map;
    }
}
