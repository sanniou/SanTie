package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class UserProfileBean extends BaseBean {

    private AntiBean anti;
    private AntiStatBean anti_stat;
    private int ctime;
    private String error_code;
    private List<?> highs;
    private int logid;
    private List<PostListBean> post_list;
    private String server_time;
    private TainfoBean tainfo;
    private List<?> tbbookrack;
    private int time;
    private List<?> uc_card;
    private UserBean user;
    private List<?> user_god_info;
    private VideoChannelInfoBean video_channel_info;
    private WindowBean window;

    public static class AntiBean {

        private String tbs;

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
    }

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

    public static class PostListBean {

        @SerializedName("abstract")
        private List<?> abstractX;
        private String content;
        private String create_time;
        private String forum_id;
        private String forum_name;
        private String is_post_deleted;
        private String is_thread;
        private List<?> media;
        private String post_id;
        private String ptype;
        private String reply_num;
        private String thread_id;
        private String thread_type;
        private String title;
        private String user_id;
        private String user_name;
        private String user_portrait;

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

        public List<?> getAbstractX() {
            return this.abstractX;
        }

        public void setAbstractX(List<?> list) {
            this.abstractX = list;
        }

        public List<?> getMedia() {
            return this.media;
        }

        public void setMedia(List<?> list) {
            this.media = list;
        }
    }

    public static class TainfoBean {

        private String friend_add_type;
        private String friendnum;
        private String groupnum;
        private String hide_user_feed;
        private String is_friend;
        private List<?> reply_list;
        private String userClientVersionIsLower;
        private String userIosHightestVerSion;

        public static TainfoBean objectFromData(String str) {
            return (TainfoBean) new Gson().fromJson(str, TainfoBean.class);
        }

        public static List<TainfoBean> arrayTainfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TainfoBean>>() {
            }.getType());
        }

        public String getGroupnum() {
            return this.groupnum;
        }

        public void setGroupnum(String str) {
            this.groupnum = str;
        }

        public String getFriendnum() {
            return this.friendnum;
        }

        public void setFriendnum(String str) {
            this.friendnum = str;
        }

        public String getIs_friend() {
            return this.is_friend;
        }

        public void setIs_friend(String str) {
            this.is_friend = str;
        }

        public String getFriend_add_type() {
            return this.friend_add_type;
        }

        public void setFriend_add_type(String str) {
            this.friend_add_type = str;
        }

        public String getUserIosHightestVerSion() {
            return this.userIosHightestVerSion;
        }

        public void setUserIosHightestVerSion(String str) {
            this.userIosHightestVerSion = str;
        }

        public String getUserClientVersionIsLower() {
            return this.userClientVersionIsLower;
        }

        public void setUserClientVersionIsLower(String str) {
            this.userClientVersionIsLower = str;
        }

        public String getHide_user_feed() {
            return this.hide_user_feed;
        }

        public void setHide_user_feed(String str) {
            this.hide_user_feed = str;
        }

        public List<?> getReply_list() {
            return this.reply_list;
        }

        public void setReply_list(List<?> list) {
            this.reply_list = list;
        }
    }

    public static class UserBean {

        private String bg_pic;
        private String bookmark_count;
        private String bookmark_new_count;
        private String concern_num;
        private List<?> consume_info;
        private EcomBean ecom;
        private String fans_num;
        private String friend_num;
        private String has_bottle_enter;
        private String has_concerned;
        private List<IconinfoBean> iconinfo;
        private String id;
        private String intro;
        private String is_mask;
        private String is_mem;
        private String like_forum_num;
        private String my_like_num;
        private String name;
        private String name_show;
        private String outer_id;
        private List<?> parr_scores;
        private PayMemberInfoBean pay_member_info;
        private List<?> pendant;
        private String portrait;
        private String portraith;
        private String post_num;
        private PrivSetsBean priv_sets;
        private List<?> profit_list;
        private String repost_num;
        private String seal_prefix;
        private String sex;
        private String tb_age;
        private List<?> tb_vip;
        private String thread_num;
        private String total_visitor_num;
        private List<TshowIconBean> tshow_icon;
        private List<?> tw_anchor_info;
        private List<?> user_pics;
        private VipInfoBean vipInfo;
        private VipCloseAdBean vip_close_ad;
        private String visitor_num;

        public static class EcomBean {

            private String is_seller;

            public static EcomBean objectFromData(String str) {
                return (EcomBean) new Gson().fromJson(str, EcomBean.class);
            }

            public static List<EcomBean> arrayEcomBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<EcomBean>>() {
                }.getType());
            }

            public String getIs_seller() {
                return this.is_seller;
            }

            public void setIs_seller(String str) {
                this.is_seller = str;
            }
        }

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

        public static class PayMemberInfoBean {

            private String end_time;
            private String expire_remind;
            private String props_id;
            private String url;

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

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public String getExpire_remind() {
                return this.expire_remind;
            }

            public void setExpire_remind(String str) {
                this.expire_remind = str;
            }
        }

        public static class PrivSetsBean {

            private String friend;
            private String group;
            private String like;
            private String live;
            private String location;
            private String post;

            public static PrivSetsBean objectFromData(String str) {
                return (PrivSetsBean) new Gson().fromJson(str, PrivSetsBean.class);
            }

            public static List<PrivSetsBean> arrayPrivSetsBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PrivSetsBean>>() {
                }.getType());
            }

            public String getPost() {
                return this.post;
            }

            public void setPost(String str) {
                this.post = str;
            }

            public String getFriend() {
                return this.friend;
            }

            public void setFriend(String str) {
                this.friend = str;
            }

            public String getGroup() {
                return this.group;
            }

            public void setGroup(String str) {
                this.group = str;
            }

            public String getLike() {
                return this.like;
            }

            public void setLike(String str) {
                this.like = str;
            }

            public String getLocation() {
                return this.location;
            }

            public void setLocation(String str) {
                this.location = str;
            }

            public String getLive() {
                return this.live;
            }

            public void setLive(String str) {
                this.live = str;
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

        public static class VipCloseAdBean {

            private List<?> forum_close;
            private String is_open;
            private String vip_close;

            public static VipCloseAdBean objectFromData(String str) {
                return (VipCloseAdBean) new Gson().fromJson(str, VipCloseAdBean.class);
            }

            public static List<VipCloseAdBean> arrayVipCloseAdBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<VipCloseAdBean>>() {
                }.getType());
            }

            public String getIs_open() {
                return this.is_open;
            }

            public void setIs_open(String str) {
                this.is_open = str;
            }

            public String getVip_close() {
                return this.vip_close;
            }

            public void setVip_close(String str) {
                this.vip_close = str;
            }

            public List<?> getForum_close() {
                return this.forum_close;
            }

            public void setForum_close(List<?> list) {
                this.forum_close = list;
            }
        }

        public static class VipInfoBean {

            private String a_score;
            private String e_time;
            private String ext_score;
            private String icon_url;
            private String n_score;
            private String s_time;
            private String v_level;
            private String v_status;

            public static VipInfoBean objectFromData(String str) {
                return (VipInfoBean) new Gson().fromJson(str, VipInfoBean.class);
            }

            public static List<VipInfoBean> arrayVipInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<VipInfoBean>>() {
                }.getType());
            }

            public String getV_status() {
                return this.v_status;
            }

            public void setV_status(String str) {
                this.v_status = str;
            }

            public String getS_time() {
                return this.s_time;
            }

            public void setS_time(String str) {
                this.s_time = str;
            }

            public String getE_time() {
                return this.e_time;
            }

            public void setE_time(String str) {
                this.e_time = str;
            }

            public String getExt_score() {
                return this.ext_score;
            }

            public void setExt_score(String str) {
                this.ext_score = str;
            }

            public String getV_level() {
                return this.v_level;
            }

            public void setV_level(String str) {
                this.v_level = str;
            }

            public String getA_score() {
                return this.a_score;
            }

            public void setA_score(String str) {
                this.a_score = str;
            }

            public String getN_score() {
                return this.n_score;
            }

            public void setN_score(String str) {
                this.n_score = str;
            }

            public String getIcon_url() {
                return this.icon_url;
            }

            public void setIcon_url(String str) {
                this.icon_url = str;
            }
        }

        public static UserBean objectFromData(String str) {
            return (UserBean) new Gson().fromJson(str, UserBean.class);
        }

        public static List<UserBean> arrayUserBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserBean>>() {
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

        public String getPortrait() {
            return this.portrait;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public String getPortraith() {
            return this.portraith;
        }

        public void setPortraith(String str) {
            this.portraith = str;
        }

        public PrivSetsBean getPriv_sets() {
            return this.priv_sets;
        }

        public void setPriv_sets(PrivSetsBean privSetsBean) {
            this.priv_sets = privSetsBean;
        }

        public String getIntro() {
            return this.intro;
        }

        public void setIntro(String str) {
            this.intro = str;
        }

        public String getSex() {
            return this.sex;
        }

        public void setSex(String str) {
            this.sex = str;
        }

        public String getOuter_id() {
            return this.outer_id;
        }

        public void setOuter_id(String str) {
            this.outer_id = str;
        }

        public String getPost_num() {
            return this.post_num;
        }

        public void setPost_num(String str) {
            this.post_num = str;
        }

        public String getRepost_num() {
            return this.repost_num;
        }

        public void setRepost_num(String str) {
            this.repost_num = str;
        }

        public String getThread_num() {
            return this.thread_num;
        }

        public void setThread_num(String str) {
            this.thread_num = str;
        }

        public String getTb_age() {
            return this.tb_age;
        }

        public void setTb_age(String str) {
            this.tb_age = str;
        }

        public String getIs_mask() {
            return this.is_mask;
        }

        public void setIs_mask(String str) {
            this.is_mask = str;
        }

        public String getIs_mem() {
            return this.is_mem;
        }

        public void setIs_mem(String str) {
            this.is_mem = str;
        }

        public String getBookmark_count() {
            return this.bookmark_count;
        }

        public void setBookmark_count(String str) {
            this.bookmark_count = str;
        }

        public String getBookmark_new_count() {
            return this.bookmark_new_count;
        }

        public void setBookmark_new_count(String str) {
            this.bookmark_new_count = str;
        }

        public String getBg_pic() {
            return this.bg_pic;
        }

        public void setBg_pic(String str) {
            this.bg_pic = str;
        }

        public VipCloseAdBean getVip_close_ad() {
            return this.vip_close_ad;
        }

        public void setVip_close_ad(VipCloseAdBean vipCloseAdBean) {
            this.vip_close_ad = vipCloseAdBean;
        }

        public String getHas_bottle_enter() {
            return this.has_bottle_enter;
        }

        public void setHas_bottle_enter(String str) {
            this.has_bottle_enter = str;
        }

        public String getSeal_prefix() {
            return this.seal_prefix;
        }

        public void setSeal_prefix(String str) {
            this.seal_prefix = str;
        }

        public String getVisitor_num() {
            return this.visitor_num;
        }

        public void setVisitor_num(String str) {
            this.visitor_num = str;
        }

        public String getTotal_visitor_num() {
            return this.total_visitor_num;
        }

        public void setTotal_visitor_num(String str) {
            this.total_visitor_num = str;
        }

        public PayMemberInfoBean getPay_member_info() {
            return this.pay_member_info;
        }

        public void setPay_member_info(PayMemberInfoBean payMemberInfoBean) {
            this.pay_member_info = payMemberInfoBean;
        }

        public VipInfoBean getVipInfo() {
            return this.vipInfo;
        }

        public void setVipInfo(VipInfoBean vipInfoBean) {
            this.vipInfo = vipInfoBean;
        }

        public String getMy_like_num() {
            return this.my_like_num;
        }

        public void setMy_like_num(String str) {
            this.my_like_num = str;
        }

        public String getLike_forum_num() {
            return this.like_forum_num;
        }

        public void setLike_forum_num(String str) {
            this.like_forum_num = str;
        }

        public String getConcern_num() {
            return this.concern_num;
        }

        public void setConcern_num(String str) {
            this.concern_num = str;
        }

        public String getFans_num() {
            return this.fans_num;
        }

        public void setFans_num(String str) {
            this.fans_num = str;
        }

        public String getHas_concerned() {
            return this.has_concerned;
        }

        public void setHas_concerned(String str) {
            this.has_concerned = str;
        }

        public String getFriend_num() {
            return this.friend_num;
        }

        public void setFriend_num(String str) {
            this.friend_num = str;
        }

        public EcomBean getEcom() {
            return this.ecom;
        }

        public void setEcom(EcomBean ecomBean) {
            this.ecom = ecomBean;
        }

        public List<?> getUser_pics() {
            return this.user_pics;
        }

        public void setUser_pics(List<?> list) {
            this.user_pics = list;
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

        public List<?> getConsume_info() {
            return this.consume_info;
        }

        public void setConsume_info(List<?> list) {
            this.consume_info = list;
        }

        public List<?> getTw_anchor_info() {
            return this.tw_anchor_info;
        }

        public void setTw_anchor_info(List<?> list) {
            this.tw_anchor_info = list;
        }

        public List<?> getProfit_list() {
            return this.profit_list;
        }

        public void setProfit_list(List<?> list) {
            this.profit_list = list;
        }

        public List<?> getParr_scores() {
            return this.parr_scores;
        }

        public void setParr_scores(List<?> list) {
            this.parr_scores = list;
        }
    }

    public static class VideoChannelInfoBean {

        private String follow_channel;
        private String man_channel;

        public static VideoChannelInfoBean objectFromData(String str) {
            return (VideoChannelInfoBean) new Gson().fromJson(str, VideoChannelInfoBean.class);
        }

        public static List<VideoChannelInfoBean> arrayVideoChannelInfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<VideoChannelInfoBean>>() {
            }.getType());
        }

        public String getMan_channel() {
            return this.man_channel;
        }

        public void setMan_channel(String str) {
            this.man_channel = str;
        }

        public String getFollow_channel() {
            return this.follow_channel;
        }

        public void setFollow_channel(String str) {
            this.follow_channel = str;
        }
    }

    public static class WindowBean {

        private List<?> list;
        private String total;

        public static WindowBean objectFromData(String str) {
            return (WindowBean) new Gson().fromJson(str, WindowBean.class);
        }

        public static List<WindowBean> arrayWindowBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<WindowBean>>() {
            }.getType());
        }

        public String getTotal() {
            return this.total;
        }

        public void setTotal(String str) {
            this.total = str;
        }

        public List<?> getList() {
            return this.list;
        }

        public void setList(List<?> list2) {
            this.list = list2;
        }
    }

    public static UserProfileBean objectFromData(String str) {
        return (UserProfileBean) new Gson().fromJson(str, UserProfileBean.class);
    }

    public static List<UserProfileBean> arrayUserProfileBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserProfileBean>>() {
        }.getType());
    }

    public AntiStatBean getAnti_stat() {
        return this.anti_stat;
    }

    public void setAnti_stat(AntiStatBean antiStatBean) {
        this.anti_stat = antiStatBean;
    }

    public AntiBean getAnti() {
        return this.anti;
    }

    public void setAnti(AntiBean antiBean) {
        this.anti = antiBean;
    }

    public UserBean getUser() {
        return this.user;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }

    public WindowBean getWindow() {
        return this.window;
    }

    public void setWindow(WindowBean windowBean) {
        this.window = windowBean;
    }

    public TainfoBean getTainfo() {
        return this.tainfo;
    }

    public void setTainfo(TainfoBean tainfoBean) {
        this.tainfo = tainfoBean;
    }

    public VideoChannelInfoBean getVideo_channel_info() {
        return this.video_channel_info;
    }

    public void setVideo_channel_info(VideoChannelInfoBean videoChannelInfoBean) {
        this.video_channel_info = videoChannelInfoBean;
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

    public List<?> getHighs() {
        return this.highs;
    }

    public void setHighs(List<?> list) {
        this.highs = list;
    }

    public List<PostListBean> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<PostListBean> list) {
        this.post_list = list;
    }

    public List<?> getUser_god_info() {
        return this.user_god_info;
    }

    public void setUser_god_info(List<?> list) {
        this.user_god_info = list;
    }

    public List<?> getTbbookrack() {
        return this.tbbookrack;
    }

    public void setTbbookrack(List<?> list) {
        this.tbbookrack = list;
    }

    public List<?> getUc_card() {
        return this.uc_card;
    }

    public void setUc_card(List<?> list) {
        this.uc_card = list;
    }
}
