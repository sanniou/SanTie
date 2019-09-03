package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean extends BaseBean {

    private AntiBean anti;
    private String asp_shown_info;
    private List<?> banner_thread_list;
    private BottleBean bottle;
    private String ctime;
    private String error_code;
    private String error_msg;
    private String fortune_bag;
    private String fortune_desc;
    private ForumBean forum;
    private FrsStarBean frs_star;
    private String frs_tab_default;
    private List<FrsTabInfoBean> frs_tab_info;
    private GconAccountBean gcon_account;
    private String is_new_url;
    private String logid;
    private String need_log;
    private PageBean page;
    private String server_time;
    private String sort_type;
    private List<StarEnterBean> star_enter;
    private List<?> thread_id_list;
    private List<ThreadListBean> thread_list;
    private int time;
    private String twzhibo_pos;
    private UserBean user;

    public static class AntiBean {

        private BlockPopInfoBean block_pop_info;
        private String block_stat;
        private String days_tofree;
        private String forbid_flag;
        private String forbid_info;
        private String has_chance;
        private String hide_stat;
        private String ifpost;
        private String ifposta;
        private String ifvoice;
        private String ifxiaoying;
        private String poll_message;
        private String tbs;
        private String vcode_stat;
        private String video_local_message;
        private String video_message;
        private String voice_message;

        public static class BlockPopInfoBean {

            private String ahead_info;
            private String ahead_url;
            private String block_info;
            private String can_post;
            private String ok_info;

            public static BlockPopInfoBean objectFromData(String str) {
                return (BlockPopInfoBean) new Gson().fromJson(str, BlockPopInfoBean.class);
            }

            public static List<BlockPopInfoBean> arrayBlockPopInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BlockPopInfoBean>>() {
                }.getType());
            }

            public String getCan_post() {
                return this.can_post;
            }

            public void setCan_post(String str) {
                this.can_post = str;
            }

            public String getBlock_info() {
                return this.block_info;
            }

            public void setBlock_info(String str) {
                this.block_info = str;
            }

            public String getAhead_info() {
                return this.ahead_info;
            }

            public void setAhead_info(String str) {
                this.ahead_info = str;
            }

            public String getAhead_url() {
                return this.ahead_url;
            }

            public void setAhead_url(String str) {
                this.ahead_url = str;
            }

            public String getOk_info() {
                return this.ok_info;
            }

            public void setOk_info(String str) {
                this.ok_info = str;
            }
        }

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

        public String getHide_stat() {
            return this.hide_stat;
        }

        public void setHide_stat(String str) {
            this.hide_stat = str;
        }

        public String getVcode_stat() {
            return this.vcode_stat;
        }

        public void setVcode_stat(String str) {
            this.vcode_stat = str;
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

        public String getIfxiaoying() {
            return this.ifxiaoying;
        }

        public void setIfxiaoying(String str) {
            this.ifxiaoying = str;
        }

        public String getPoll_message() {
            return this.poll_message;
        }

        public void setPoll_message(String str) {
            this.poll_message = str;
        }

        public String getVideo_message() {
            return this.video_message;
        }

        public void setVideo_message(String str) {
            this.video_message = str;
        }

        public String getVideo_local_message() {
            return this.video_local_message;
        }

        public void setVideo_local_message(String str) {
            this.video_local_message = str;
        }

        public String getBlock_stat() {
            return this.block_stat;
        }

        public void setBlock_stat(String str) {
            this.block_stat = str;
        }

        public BlockPopInfoBean getBlock_pop_info() {
            return this.block_pop_info;
        }

        public void setBlock_pop_info(BlockPopInfoBean blockPopInfoBean) {
            this.block_pop_info = blockPopInfoBean;
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
    }

    public static class BottleBean {

        private String has_enter_display;
        private String tid;

        public static BottleBean objectFromData(String str) {
            return (BottleBean) new Gson().fromJson(str, BottleBean.class);
        }

        public static List<BottleBean> arrayBottleBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BottleBean>>() {
            }.getType());
        }

        public String getHas_enter_display() {
            return this.has_enter_display;
        }

        public void setHas_enter_display(String str) {
            this.has_enter_display = str;
        }

        public String getTid() {
            return this.tid;
        }

        public void setTid(String str) {
            this.tid = str;
        }
    }

    public static class ForumBean {

        private String accelerate_cotent;
        private String album_open_photo_frs;
        private AnchorPowerBean anchor_power;
        private String avatar;
        private List<?> badges;
        private BannerBean banner;
        private BannerListBean banner_list;
        private String can_use_accelerate;
        private String cur_score;
        private String first_class;
        private ForumButtonBean forum_button;
        private List<?> forum_sign_calendar;
        private ForumvipShowIconBean forumvip_show_icon;
        private List<GoodClassifyBean> good_classify;
        private String has_game;
        private String has_postpre;
        private String id;
        private String is_exists;
        private String is_like;
        private String is_readonly;
        private String is_search_people;
        private String is_stage_forum;
        private String level_id;
        private String level_name;
        private String levelup_score;
        private List<ManagersBean> managers;
        private int member_num;
        private String name;
        private int post_num;
        private PostPrefixBean post_prefix;
        private String second_class;
        private SignInInfoBean sign_in_info;
        private String slogan;
        private TagInfoBean tag_info;
        private String thread_num;
        private String tids;
        private List<?> top_notice;
        private String user_level;
        private ZhiboBean zhibo;

        public static class AnchorPowerBean {

            private String anchor_message;
            private String have_power;

            public static AnchorPowerBean objectFromData(String str) {
                return (AnchorPowerBean) new Gson().fromJson(str, AnchorPowerBean.class);
            }

            public static List<AnchorPowerBean> arrayAnchorPowerBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AnchorPowerBean>>() {
                }.getType());
            }

            public String getHave_power() {
                return this.have_power;
            }

            public void setHave_power(String str) {
                this.have_power = str;
            }

            public String getAnchor_message() {
                return this.anchor_message;
            }

            public void setAnchor_message(String str) {
                this.anchor_message = str;
            }
        }

        public static class BannerBean {

            private String desc;
            private String type;

            public static BannerBean objectFromData(String str) {
                return (BannerBean) new Gson().fromJson(str, BannerBean.class);
            }

            public static List<BannerBean> arrayBannerBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BannerBean>>() {
                }.getType());
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getDesc() {
                return this.desc;
            }

            public void setDesc(String str) {
                this.desc = str;
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

        public static class ForumButtonBean {

            private String is_blueV;

            public static ForumButtonBean objectFromData(String str) {
                return (ForumButtonBean) new Gson().fromJson(str, ForumButtonBean.class);
            }

            public static List<ForumButtonBean> arrayForumButtonBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumButtonBean>>() {
                }.getType());
            }

            public String getIs_blueV() {
                return this.is_blueV;
            }

            public void setIs_blueV(String str) {
                this.is_blueV = str;
            }
        }

        public static class ForumvipShowIconBean {

            private String icon;
            private String name;
            private String url;

            public static ForumvipShowIconBean objectFromData(String str) {
                return (ForumvipShowIconBean) new Gson().fromJson(str, ForumvipShowIconBean.class);
            }

            public static List<ForumvipShowIconBean> arrayForumvipShowIconBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumvipShowIconBean>>() {
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

        public static class GoodClassifyBean {

            private String class_id;
            private String class_name;
            private String id;
            private String name;

            public static GoodClassifyBean objectFromData(String str) {
                return (GoodClassifyBean) new Gson().fromJson(str, GoodClassifyBean.class);
            }

            public static List<GoodClassifyBean> arrayGoodClassifyBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<GoodClassifyBean>>() {
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

            public String getClass_id() {
                return this.class_id;
            }

            public void setClass_id(String str) {
                this.class_id = str;
            }

            public String getClass_name() {
                return this.class_name;
            }

            public void setClass_name(String str) {
                this.class_name = str;
            }
        }

        public static class ManagersBean {

            private String id;
            private String name;

            public static ManagersBean objectFromData(String str) {
                return (ManagersBean) new Gson().fromJson(str, ManagersBean.class);
            }

            public static List<ManagersBean> arrayManagersBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ManagersBean>>() {
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
        }

        public static class PostPrefixBean {

            private String mode;
            private String text;
            private String time;
            private String type;

            public static PostPrefixBean objectFromData(String str) {
                return (PostPrefixBean) new Gson().fromJson(str, PostPrefixBean.class);
            }

            public static List<PostPrefixBean> arrayPostPrefixBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostPrefixBean>>() {
                }.getType());
            }

            public String getMode() {
                return this.mode;
            }

            public void setMode(String str) {
                this.mode = str;
            }

            public String getText() {
                return this.text;
            }

            public void setText(String str) {
                this.text = str;
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getTime() {
                return this.time;
            }

            public void setTime(String str) {
                this.time = str;
            }
        }

        public static class SignInInfoBean {

            private ForumInfoBeanX forum_info;
            private UserInfoBean user_info;

            public static class ForumInfoBeanX {

                private CurrentRankInfoBean current_rank_info;
                private ForumInfoBean forum_info;
                private String is_filter;
                private String is_on;
                private String level_1_dir_name;
                private String level_2_dir_name;
                private MonthlyRankInfoBean monthly_rank_info;
                private WeeklyRankInfoBean weekly_rank_info;
                private YesterdayRankInfoBean yesterday_rank_info;

                public static class CurrentRankInfoBean {

                    private String dir_rate;
                    private String member_count;
                    private String sign_count;
                    private String sign_rank;

                    public static CurrentRankInfoBean objectFromData(String str) {
                        return (CurrentRankInfoBean) new Gson().fromJson(str, CurrentRankInfoBean.class);
                    }

                    public static List<CurrentRankInfoBean> arrayCurrentRankInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<CurrentRankInfoBean>>() {
                        }.getType());
                    }

                    public String getSign_count() {
                        return this.sign_count;
                    }

                    public void setSign_count(String str) {
                        this.sign_count = str;
                    }

                    public String getMember_count() {
                        return this.member_count;
                    }

                    public void setMember_count(String str) {
                        this.member_count = str;
                    }

                    public String getSign_rank() {
                        return this.sign_rank;
                    }

                    public void setSign_rank(String str) {
                        this.sign_rank = str;
                    }

                    public String getDir_rate() {
                        return this.dir_rate;
                    }

                    public void setDir_rate(String str) {
                        this.dir_rate = str;
                    }
                }

                public static class ForumInfoBean {

                    private String forum_id;
                    private String level_1_dir_name;

                    public static ForumInfoBean objectFromData(String str) {
                        return (ForumInfoBean) new Gson().fromJson(str, ForumInfoBean.class);
                    }

                    public static List<ForumInfoBean> arrayForumInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumInfoBean>>() {
                        }.getType());
                    }

                    public String getForum_id() {
                        return this.forum_id;
                    }

                    public void setForum_id(String str) {
                        this.forum_id = str;
                    }

                    public String getLevel_1_dir_name() {
                        return this.level_1_dir_name;
                    }

                    public void setLevel_1_dir_name(String str) {
                        this.level_1_dir_name = str;
                    }
                }

                public static class MonthlyRankInfoBean {

                    private String member_count;
                    private String sign_count;
                    private String sign_rank;

                    public static MonthlyRankInfoBean objectFromData(String str) {
                        return (MonthlyRankInfoBean) new Gson().fromJson(str, MonthlyRankInfoBean.class);
                    }

                    public static List<MonthlyRankInfoBean> arrayMonthlyRankInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MonthlyRankInfoBean>>() {
                        }.getType());
                    }

                    public String getSign_count() {
                        return this.sign_count;
                    }

                    public void setSign_count(String str) {
                        this.sign_count = str;
                    }

                    public String getMember_count() {
                        return this.member_count;
                    }

                    public void setMember_count(String str) {
                        this.member_count = str;
                    }

                    public String getSign_rank() {
                        return this.sign_rank;
                    }

                    public void setSign_rank(String str) {
                        this.sign_rank = str;
                    }
                }

                public static class WeeklyRankInfoBean {

                    private String member_count;
                    private String sign_count;
                    private String sign_rank;

                    public static WeeklyRankInfoBean objectFromData(String str) {
                        return (WeeklyRankInfoBean) new Gson().fromJson(str, WeeklyRankInfoBean.class);
                    }

                    public static List<WeeklyRankInfoBean> arrayWeeklyRankInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<WeeklyRankInfoBean>>() {
                        }.getType());
                    }

                    public String getSign_count() {
                        return this.sign_count;
                    }

                    public void setSign_count(String str) {
                        this.sign_count = str;
                    }

                    public String getMember_count() {
                        return this.member_count;
                    }

                    public void setMember_count(String str) {
                        this.member_count = str;
                    }

                    public String getSign_rank() {
                        return this.sign_rank;
                    }

                    public void setSign_rank(String str) {
                        this.sign_rank = str;
                    }
                }

                public static class YesterdayRankInfoBean {

                    private String dir_rate;
                    private String member_count;
                    private String sign_count;
                    private String sign_rank;

                    public static YesterdayRankInfoBean objectFromData(String str) {
                        return (YesterdayRankInfoBean) new Gson().fromJson(str, YesterdayRankInfoBean.class);
                    }

                    public static List<YesterdayRankInfoBean> arrayYesterdayRankInfoBeanFromData(String str) {
                        return (List) new Gson()
                                .fromJson(str, new TypeToken<ArrayList<YesterdayRankInfoBean>>() {
                                }.getType());
                    }

                    public String getSign_count() {
                        return this.sign_count;
                    }

                    public void setSign_count(String str) {
                        this.sign_count = str;
                    }

                    public String getMember_count() {
                        return this.member_count;
                    }

                    public void setMember_count(String str) {
                        this.member_count = str;
                    }

                    public String getSign_rank() {
                        return this.sign_rank;
                    }

                    public void setSign_rank(String str) {
                        this.sign_rank = str;
                    }

                    public String getDir_rate() {
                        return this.dir_rate;
                    }

                    public void setDir_rate(String str) {
                        this.dir_rate = str;
                    }
                }

                public static ForumInfoBeanX objectFromData(String str) {
                    return (ForumInfoBeanX) new Gson().fromJson(str, ForumInfoBeanX.class);
                }

                public static List<ForumInfoBeanX> arrayForumInfoBeanXFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumInfoBeanX>>() {
                    }.getType());
                }

                public String getIs_on() {
                    return this.is_on;
                }

                public void setIs_on(String str) {
                    this.is_on = str;
                }

                public String getIs_filter() {
                    return this.is_filter;
                }

                public void setIs_filter(String str) {
                    this.is_filter = str;
                }

                public ForumInfoBean getForum_info() {
                    return this.forum_info;
                }

                public void setForum_info(ForumInfoBean forumInfoBean) {
                    this.forum_info = forumInfoBean;
                }

                public CurrentRankInfoBean getCurrent_rank_info() {
                    return this.current_rank_info;
                }

                public void setCurrent_rank_info(CurrentRankInfoBean currentRankInfoBean) {
                    this.current_rank_info = currentRankInfoBean;
                }

                public String getLevel_1_dir_name() {
                    return this.level_1_dir_name;
                }

                public void setLevel_1_dir_name(String str) {
                    this.level_1_dir_name = str;
                }

                public String getLevel_2_dir_name() {
                    return this.level_2_dir_name;
                }

                public void setLevel_2_dir_name(String str) {
                    this.level_2_dir_name = str;
                }

                public YesterdayRankInfoBean getYesterday_rank_info() {
                    return this.yesterday_rank_info;
                }

                public void setYesterday_rank_info(YesterdayRankInfoBean yesterdayRankInfoBean) {
                    this.yesterday_rank_info = yesterdayRankInfoBean;
                }

                public WeeklyRankInfoBean getWeekly_rank_info() {
                    return this.weekly_rank_info;
                }

                public void setWeekly_rank_info(WeeklyRankInfoBean weeklyRankInfoBean) {
                    this.weekly_rank_info = weeklyRankInfoBean;
                }

                public MonthlyRankInfoBean getMonthly_rank_info() {
                    return this.monthly_rank_info;
                }

                public void setMonthly_rank_info(MonthlyRankInfoBean monthlyRankInfoBean) {
                    this.monthly_rank_info = monthlyRankInfoBean;
                }
            }

            public static class UserInfoBean {

                private String c_sign_num;
                private String cont_sign_num;
                private String cout_total_sing_num;
                private String hun_sign_num;
                private String is_org_disabled;
                private String is_sign_in;
                private String miss_sign_num;
                private String sign_time;
                private String total_resign_num;
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

                public String getIs_org_disabled() {
                    return this.is_org_disabled;
                }

                public void setIs_org_disabled(String str) {
                    this.is_org_disabled = str;
                }

                public String getC_sign_num() {
                    return this.c_sign_num;
                }

                public void setC_sign_num(String str) {
                    this.c_sign_num = str;
                }

                public String getMiss_sign_num() {
                    return this.miss_sign_num;
                }

                public void setMiss_sign_num(String str) {
                    this.miss_sign_num = str;
                }
            }

            public static SignInInfoBean objectFromData(String str) {
                return (SignInInfoBean) new Gson().fromJson(str, SignInInfoBean.class);
            }

            public static List<SignInInfoBean> arraySignInInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SignInInfoBean>>() {
                }.getType());
            }

            public UserInfoBean getUser_info() {
                return this.user_info;
            }

            public void setUser_info(UserInfoBean userInfoBean) {
                this.user_info = userInfoBean;
            }

            public ForumInfoBeanX getForum_info() {
                return this.forum_info;
            }

            public void setForum_info(ForumInfoBeanX forumInfoBeanX) {
                this.forum_info = forumInfoBeanX;
            }
        }

        public static class TagInfoBean {

            private String color;
            private String forum_id;
            private String hot_value;
            private String influence;
            private String op_time;
            private String relation_weight;
            private String tag_id;
            private String tag_level;
            private String tag_name;
            private String tag_type;

            public static TagInfoBean objectFromData(String str) {
                return (TagInfoBean) new Gson().fromJson(str, TagInfoBean.class);
            }

            public static List<TagInfoBean> arrayTagInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TagInfoBean>>() {
                }.getType());
            }

            public String getForum_id() {
                return this.forum_id;
            }

            public void setForum_id(String str) {
                this.forum_id = str;
            }

            public String getTag_id() {
                return this.tag_id;
            }

            public void setTag_id(String str) {
                this.tag_id = str;
            }

            public String getRelation_weight() {
                return this.relation_weight;
            }

            public void setRelation_weight(String str) {
                this.relation_weight = str;
            }

            public String getOp_time() {
                return this.op_time;
            }

            public void setOp_time(String str) {
                this.op_time = str;
            }

            public String getTag_name() {
                return this.tag_name;
            }

            public void setTag_name(String str) {
                this.tag_name = str;
            }

            public String getHot_value() {
                return this.hot_value;
            }

            public void setHot_value(String str) {
                this.hot_value = str;
            }

            public String getInfluence() {
                return this.influence;
            }

            public void setInfluence(String str) {
                this.influence = str;
            }

            public String getColor() {
                return this.color;
            }

            public void setColor(String str) {
                this.color = str;
            }

            public String getTag_type() {
                return this.tag_type;
            }

            public void setTag_type(String str) {
                this.tag_type = str;
            }

            public String getTag_level() {
                return this.tag_level;
            }

            public void setTag_level(String str) {
                this.tag_level = str;
            }
        }

        public static class ZhiboBean {

            private String forum;
            private String has_lpost;
            private String int1;
            private String lpost_type;
            private String status;
            private String tid;
            private String type;

            public static ZhiboBean objectFromData(String str) {
                return (ZhiboBean) new Gson().fromJson(str, ZhiboBean.class);
            }

            public static List<ZhiboBean> arrayZhiboBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ZhiboBean>>() {
                }.getType());
            }

            public String getForum() {
                return this.forum;
            }

            public void setForum(String str) {
                this.forum = str;
            }

            public String getTid() {
                return this.tid;
            }

            public void setTid(String str) {
                this.tid = str;
            }

            public String getStatus() {
                return this.status;
            }

            public void setStatus(String str) {
                this.status = str;
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getInt1() {
                return this.int1;
            }

            public void setInt1(String str) {
                this.int1 = str;
            }

            public String getHas_lpost() {
                return this.has_lpost;
            }

            public void setHas_lpost(String str) {
                this.has_lpost = str;
            }

            public String getLpost_type() {
                return this.lpost_type;
            }

            public void setLpost_type(String str) {
                this.lpost_type = str;
            }
        }

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

        public String getIs_like() {
            return this.is_like;
        }

        public void setIs_like(String str) {
            this.is_like = str;
        }

        public String getUser_level() {
            return this.user_level;
        }

        public void setUser_level(String str) {
            this.user_level = str;
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

        public int getMember_num() {
            return this.member_num;
        }

        public void setMember_num(int i) {
            this.member_num = i;
        }

        public String getIs_exists() {
            return this.is_exists;
        }

        public void setIs_exists(String str) {
            this.is_exists = str;
        }

        public String getThread_num() {
            return this.thread_num;
        }

        public void setThread_num(String str) {
            this.thread_num = str;
        }

        public int getPost_num() {
            return this.post_num;
        }

        public void setPost_num(int i) {
            this.post_num = i;
        }

        public SignInInfoBean getSign_in_info() {
            return this.sign_in_info;
        }

        public void setSign_in_info(SignInInfoBean signInInfoBean) {
            this.sign_in_info = signInInfoBean;
        }

        public String getAlbum_open_photo_frs() {
            return this.album_open_photo_frs;
        }

        public void setAlbum_open_photo_frs(String str) {
            this.album_open_photo_frs = str;
        }

        public String getIs_readonly() {
            return this.is_readonly;
        }

        public void setIs_readonly(String str) {
            this.is_readonly = str;
        }

        public String getIs_search_people() {
            return this.is_search_people;
        }

        public void setIs_search_people(String str) {
            this.is_search_people = str;
        }

        public String getIs_stage_forum() {
            return this.is_stage_forum;
        }

        public void setIs_stage_forum(String str) {
            this.is_stage_forum = str;
        }

        public ForumvipShowIconBean getForumvip_show_icon() {
            return this.forumvip_show_icon;
        }

        public void setForumvip_show_icon(ForumvipShowIconBean forumvipShowIconBean) {
            this.forumvip_show_icon = forumvipShowIconBean;
        }

        public String getAccelerate_cotent() {
            return this.accelerate_cotent;
        }

        public void setAccelerate_cotent(String str) {
            this.accelerate_cotent = str;
        }

        public String getCan_use_accelerate() {
            return this.can_use_accelerate;
        }

        public void setCan_use_accelerate(String str) {
            this.can_use_accelerate = str;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public void setSlogan(String str) {
            this.slogan = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public ZhiboBean getZhibo() {
            return this.zhibo;
        }

        public void setZhibo(ZhiboBean zhiboBean) {
            this.zhibo = zhiboBean;
        }

        public String getHas_postpre() {
            return this.has_postpre;
        }

        public void setHas_postpre(String str) {
            this.has_postpre = str;
        }

        public PostPrefixBean getPost_prefix() {
            return this.post_prefix;
        }

        public void setPost_prefix(PostPrefixBean postPrefixBean) {
            this.post_prefix = postPrefixBean;
        }

        public AnchorPowerBean getAnchor_power() {
            return this.anchor_power;
        }

        public void setAnchor_power(AnchorPowerBean anchorPowerBean) {
            this.anchor_power = anchorPowerBean;
        }

        public String getHas_game() {
            return this.has_game;
        }

        public void setHas_game(String str) {
            this.has_game = str;
        }

        public ForumButtonBean getForum_button() {
            return this.forum_button;
        }

        public void setForum_button(ForumButtonBean forumButtonBean) {
            this.forum_button = forumButtonBean;
        }

        public TagInfoBean getTag_info() {
            return this.tag_info;
        }

        public void setTag_info(TagInfoBean tagInfoBean) {
            this.tag_info = tagInfoBean;
        }

        public BannerListBean getBanner_list() {
            return this.banner_list;
        }

        public void setBanner_list(BannerListBean bannerListBean) {
            this.banner_list = bannerListBean;
        }

        public BannerBean getBanner() {
            return this.banner;
        }

        public void setBanner(BannerBean bannerBean) {
            this.banner = bannerBean;
        }

        public String getTids() {
            return this.tids;
        }

        public void setTids(String str) {
            this.tids = str;
        }

        public List<GoodClassifyBean> getGood_classify() {
            return this.good_classify;
        }

        public void setGood_classify(List<GoodClassifyBean> list) {
            this.good_classify = list;
        }

        public List<ManagersBean> getManagers() {
            return this.managers;
        }

        public void setManagers(List<ManagersBean> list) {
            this.managers = list;
        }

        public List<?> getTop_notice() {
            return this.top_notice;
        }

        public void setTop_notice(List<?> list) {
            this.top_notice = list;
        }

        public List<?> getBadges() {
            return this.badges;
        }

        public void setBadges(List<?> list) {
            this.badges = list;
        }

        public List<?> getForum_sign_calendar() {
            return this.forum_sign_calendar;
        }

        public void setForum_sign_calendar(List<?> list) {
            this.forum_sign_calendar = list;
        }
    }

    public static class FrsStarBean {

        private String has_frs_star;
        private List<?> trade;

        public static FrsStarBean objectFromData(String str) {
            return (FrsStarBean) new Gson().fromJson(str, FrsStarBean.class);
        }

        public static List<FrsStarBean> arrayFrsStarBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<FrsStarBean>>() {
            }.getType());
        }

        public String getHas_frs_star() {
            return this.has_frs_star;
        }

        public void setHas_frs_star(String str) {
            this.has_frs_star = str;
        }

        public List<?> getTrade() {
            return this.trade;
        }

        public void setTrade(List<?> list) {
            this.trade = list;
        }
    }

    public static class FrsTabInfoBean {

        private String tab_id;
        private String tab_name;
        private String tab_type;
        private String tab_url;

        public static FrsTabInfoBean objectFromData(String str) {
            return (FrsTabInfoBean) new Gson().fromJson(str, FrsTabInfoBean.class);
        }

        public static List<FrsTabInfoBean> arrayFrsTabInfoBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<FrsTabInfoBean>>() {
            }.getType());
        }

        public String getTab_name() {
            return this.tab_name;
        }

        public void setTab_name(String str) {
            this.tab_name = str;
        }

        public String getTab_url() {
            return this.tab_url;
        }

        public void setTab_url(String str) {
            this.tab_url = str;
        }

        public String getTab_type() {
            return this.tab_type;
        }

        public void setTab_type(String str) {
            this.tab_type = str;
        }

        public String getTab_id() {
            return this.tab_id;
        }

        public void setTab_id(String str) {
            this.tab_id = str;
        }
    }

    public static class GconAccountBean {

        private String has_account;
        private String menu_name;

        public static GconAccountBean objectFromData(String str) {
            return (GconAccountBean) new Gson().fromJson(str, GconAccountBean.class);
        }

        public static List<GconAccountBean> arrayGconAccountBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<GconAccountBean>>() {
            }.getType());
        }

        public String getHas_account() {
            return this.has_account;
        }

        public void setHas_account(String str) {
            this.has_account = str;
        }

        public String getMenu_name() {
            return this.menu_name;
        }

        public void setMenu_name(String str) {
            this.menu_name = str;
        }
    }

    public static class PageBean {

        private String cur_good_id;
        private int current_page;
        private int has_more;
        private int has_prev;
        private String offset;
        private int page_size;
        private long total_count;
        private int total_page;

        public static PageBean objectFromData(String str) {
            return (PageBean) new Gson().fromJson(str, PageBean.class);
        }

        public static List<PageBean> arrayPageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PageBean>>() {
            }.getType());
        }

        public int getPage_size() {
            return this.page_size;
        }

        public void setPage_size(int i) {
            this.page_size = i;
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

        public long getTotal_count() {
            return this.total_count;
        }

        public void setTotal_count(long j) {
            this.total_count = j;
        }

        public int getTotal_page() {
            return this.total_page;
        }

        public void setTotal_page(int i) {
            this.total_page = i;
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

        public String getCur_good_id() {
            return this.cur_good_id;
        }

        public void setCur_good_id(String str) {
            this.cur_good_id = str;
        }
    }

    public static class StarEnterBean {

        private String icon;
        private String time;
        private String title;
        private String type;
        private String url;
        private String weight;

        public static StarEnterBean objectFromData(String str) {
            return (StarEnterBean) new Gson().fromJson(str, StarEnterBean.class);
        }

        public static List<StarEnterBean> arrayStarEnterBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<StarEnterBean>>() {
            }.getType());
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getWeight() {
            return this.weight;
        }

        public void setWeight(String str) {
            this.weight = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String str) {
            this.time = str;
        }
    }

    public static class ThreadListBean implements Serializable {

        @SerializedName("abstract")
        private List<AbstractBean> abstractX;
        private AuthorBean author;
        private List<?> book_chapter;
        private String comment_num;
        private String create_time;
        private String fid;
        private String first_post_id;
        private String id;
        private String is_activity;
        private String is_bakan;
        private String is_book_chapter;
        private String is_bub;
        private String is_good;
        private String is_meizhi;
        private String is_membertop;
        private String is_notice;
        private String is_novel;
        private String is_novel_reward;
        private String is_novel_thank;
        private String is_ntitle;
        private String is_protal;
        private String is_top;
        private String is_voice_thread;
        private String is_vote;
        private LastReplyerBean last_replyer;
        private String last_time;
        private long last_time_int;
        private List<?> location;
        private List<MediaBean> media;
        private String media_num;
        private String meizhi_pic;
        private String reply_num;
        private String thread_type;
        private String thread_types;
        private String tid;
        private String tiebaInfoView;
        private String title;
        private String view_num;
        private List<?> voice_info;
        private ZanBean zan;

        public static class AbstractBean implements Serializable {

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

        public static class AuthorBean implements Serializable {

            private String fans_nickname;
            private List<?> iconinfo;
            private String id;
            private String is_interestman;
            private String is_mem;
            private String is_verify;
            private String meizhi_level;
            private String name;
            private String name_show;
            private List<?> new_tshow_icon;
            private List<?> pendant;
            private String portrait;
            private String seal_prefix;
            private List<?> tb_vip;
            private List<?> theme_card;
            private List<?> tshow_icon;
            private String type;

            public static AuthorBean objectFromData(String str) {
                return (AuthorBean) new Gson().fromJson(str, AuthorBean.class);
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AuthorBean>>() {
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

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getIs_verify() {
                return this.is_verify;
            }

            public void setIs_verify(String str) {
                this.is_verify = str;
            }

            public String getIs_interestman() {
                return this.is_interestman;
            }

            public void setIs_interestman(String str) {
                this.is_interestman = str;
            }

            public String getMeizhi_level() {
                return this.meizhi_level;
            }

            public void setMeizhi_level(String str) {
                this.meizhi_level = str;
            }

            public String getIs_mem() {
                return this.is_mem;
            }

            public void setIs_mem(String str) {
                this.is_mem = str;
            }

            public String getFans_nickname() {
                return this.fans_nickname;
            }

            public void setFans_nickname(String str) {
                this.fans_nickname = str;
            }

            public String getSeal_prefix() {
                return this.seal_prefix;
            }

            public void setSeal_prefix(String str) {
                this.seal_prefix = str;
            }

            public List<?> getIconinfo() {
                return this.iconinfo;
            }

            public void setIconinfo(List<?> list) {
                this.iconinfo = list;
            }

            public List<?> getTshow_icon() {
                return this.tshow_icon;
            }

            public void setTshow_icon(List<?> list) {
                this.tshow_icon = list;
            }

            public List<?> getNew_tshow_icon() {
                return this.new_tshow_icon;
            }

            public void setNew_tshow_icon(List<?> list) {
                this.new_tshow_icon = list;
            }

            public List<?> getTheme_card() {
                return this.theme_card;
            }

            public void setTheme_card(List<?> list) {
                this.theme_card = list;
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
        }

        public static class LastReplyerBean implements Serializable {

            private String id;
            private String is_verify;
            private String name;
            private String name_show;
            private String type;

            public static LastReplyerBean objectFromData(String str) {
                return (LastReplyerBean) new Gson().fromJson(str, LastReplyerBean.class);
            }

            public static List<LastReplyerBean> arrayLastReplyerBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LastReplyerBean>>() {
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

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getIs_verify() {
                return this.is_verify;
            }

            public void setIs_verify(String str) {
                this.is_verify = str;
            }
        }

        public static class MediaBean implements Serializable {

            private String big_pic;
            private String post_id;
            private String src_pic;
            private String type;

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

            public String getBig_pic() {
                return this.big_pic;
            }

            public void setBig_pic(String str) {
                this.big_pic = str;
            }

            public String getSrc_pic() {
                return this.src_pic;
            }

            public void setSrc_pic(String str) {
                this.src_pic = str;
            }

            public String getPost_id() {
                return this.post_id;
            }

            public void setPost_id(String str) {
                this.post_id = str;
            }
        }

        public static class ZanBean implements Serializable {

            private String is_liked;
            private String last_time;
            private List<LikerListBean> liker_list;
            private String num;

            public static class LikerListBean {

                private String id;
                private String is_verify;
                private String name;
                private String name_show;
                private String portrait;
                private String user_type;

                public static LikerListBean objectFromData(String str) {
                    return (LikerListBean) new Gson().fromJson(str, LikerListBean.class);
                }

                public static List<LikerListBean> arrayLikerListBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LikerListBean>>() {
                    }.getType());
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
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

                public String getName_show() {
                    return this.name_show;
                }

                public void setName_show(String str) {
                    this.name_show = str;
                }

                public String getUser_type() {
                    return this.user_type;
                }

                public void setUser_type(String str) {
                    this.user_type = str;
                }

                public String getIs_verify() {
                    return this.is_verify;
                }

                public void setIs_verify(String str) {
                    this.is_verify = str;
                }
            }

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

            public List<LikerListBean> getLiker_list() {
                return this.liker_list;
            }

            public void setLiker_list(List<LikerListBean> list) {
                this.liker_list = list;
            }
        }

        public static ThreadListBean objectFromData(String str) {
            return (ThreadListBean) new Gson().fromJson(str, ThreadListBean.class);
        }

        public static List<ThreadListBean> arrayThreadListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThreadListBean>>() {
            }.getType());
        }

        public String getTiebaInfoView() {
            return this.tiebaInfoView;
        }

        public void setTiebaInfoView(String str) {
            this.tiebaInfoView = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getTid() {
            return this.tid;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getReply_num() {
            return this.reply_num;
        }

        public void setReply_num(String str) {
            this.reply_num = str;
        }

        public String getView_num() {
            return this.view_num;
        }

        public void setView_num(String str) {
            this.view_num = str;
        }

        public String getLast_time() {
            return this.last_time;
        }

        public void setLast_time(String str) {
            this.last_time = str;
        }

        public long getLast_time_int() {
            return this.last_time_int;
        }

        public void setLast_time_int(long j) {
            this.last_time_int = j;
        }

        public String getThread_types() {
            return this.thread_types;
        }

        public void setThread_types(String str) {
            this.thread_types = str;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public void setCreate_time(String str) {
            this.create_time = str;
        }

        public String getIs_top() {
            return this.is_top;
        }

        public void setIs_top(String str) {
            this.is_top = str;
        }

        public String getIs_good() {
            return this.is_good;
        }

        public void setIs_good(String str) {
            this.is_good = str;
        }

        public String getIs_ntitle() {
            return this.is_ntitle;
        }

        public void setIs_ntitle(String str) {
            this.is_ntitle = str;
        }

        public String getIs_meizhi() {
            return this.is_meizhi;
        }

        public void setIs_meizhi(String str) {
            this.is_meizhi = str;
        }

        public String getIs_bub() {
            return this.is_bub;
        }

        public void setIs_bub(String str) {
            this.is_bub = str;
        }

        public String getIs_membertop() {
            return this.is_membertop;
        }

        public void setIs_membertop(String str) {
            this.is_membertop = str;
        }

        public String getIs_novel() {
            return this.is_novel;
        }

        public void setIs_novel(String str) {
            this.is_novel = str;
        }

        public String getIs_novel_thank() {
            return this.is_novel_thank;
        }

        public void setIs_novel_thank(String str) {
            this.is_novel_thank = str;
        }

        public String getIs_novel_reward() {
            return this.is_novel_reward;
        }

        public void setIs_novel_reward(String str) {
            this.is_novel_reward = str;
        }

        public String getIs_book_chapter() {
            return this.is_book_chapter;
        }

        public void setIs_book_chapter(String str) {
            this.is_book_chapter = str;
        }

        public String getIs_notice() {
            return this.is_notice;
        }

        public void setIs_notice(String str) {
            this.is_notice = str;
        }

        public String getComment_num() {
            return this.comment_num;
        }

        public void setComment_num(String str) {
            this.comment_num = str;
        }

        public String getIs_protal() {
            return this.is_protal;
        }

        public void setIs_protal(String str) {
            this.is_protal = str;
        }

        public String getIs_bakan() {
            return this.is_bakan;
        }

        public void setIs_bakan(String str) {
            this.is_bakan = str;
        }

        public String getIs_vote() {
            return this.is_vote;
        }

        public void setIs_vote(String str) {
            this.is_vote = str;
        }

        public String getMedia_num() {
            return this.media_num;
        }

        public void setMedia_num(String str) {
            this.media_num = str;
        }

        public String getMeizhi_pic() {
            return this.meizhi_pic;
        }

        public void setMeizhi_pic(String str) {
            this.meizhi_pic = str;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public LastReplyerBean getLast_replyer() {
            return this.last_replyer;
        }

        public void setLast_replyer(LastReplyerBean lastReplyerBean) {
            this.last_replyer = lastReplyerBean;
        }

        public String getFirst_post_id() {
            return this.first_post_id;
        }

        public void setFirst_post_id(String str) {
            this.first_post_id = str;
        }

        public ZanBean getZan() {
            return this.zan;
        }

        public void setZan(ZanBean zanBean) {
            this.zan = zanBean;
        }

        public String getIs_voice_thread() {
            return this.is_voice_thread;
        }

        public void setIs_voice_thread(String str) {
            this.is_voice_thread = str;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }

        public String getIs_activity() {
            return this.is_activity;
        }

        public void setIs_activity(String str) {
            this.is_activity = str;
        }

        public String getFid() {
            return this.fid;
        }

        public void setFid(String str) {
            this.fid = str;
        }

        public List<?> getBook_chapter() {
            return this.book_chapter;
        }

        public void setBook_chapter(List<?> list) {
            this.book_chapter = list;
        }

        public List<MediaBean> getMedia() {
            return this.media;
        }

        public void setMedia(List<MediaBean> list) {
            this.media = list;
        }

        public List<AbstractBean> getAbstractX() {
            return this.abstractX;
        }

        public void setAbstractX(List<AbstractBean> list) {
            this.abstractX = list;
        }

        public List<?> getLocation() {
            return this.location;
        }

        public void setLocation(List<?> list) {
            this.location = list;
        }

        public List<?> getVoice_info() {
            return this.voice_info;
        }

        public void setVoice_info(List<?> list) {
            this.voice_info = list;
        }
    }

    public static class UserBean {

        private BalvBean balv;
        private String bimg_url;
        private String id;
        private String ios_bimg_format;
        private String is_login;
        private String is_manager;
        private String is_mem;
        private String is_select_tail;
        private String name;
        private String name_show;
        private NewUserInfoBean new_user_info;
        private String no_un;
        private String portrait;
        private String type;
        private String userhide;

        public static class BalvBean {

            private String days_tofree;
            private String is_black;
            private String is_block;

            public static BalvBean objectFromData(String str) {
                return (BalvBean) new Gson().fromJson(str, BalvBean.class);
            }

            public static List<BalvBean> arrayBalvBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BalvBean>>() {
                }.getType());
            }

            public String getIs_block() {
                return this.is_block;
            }

            public void setIs_block(String str) {
                this.is_block = str;
            }

            public String getIs_black() {
                return this.is_black;
            }

            public void setIs_black(String str) {
                this.is_black = str;
            }

            public String getDays_tofree() {
                return this.days_tofree;
            }

            public void setDays_tofree(String str) {
                this.days_tofree = str;
            }
        }

        public static class NewUserInfoBean {

            private ParrPropsBean Parr_props;
            private ParrScoresBean Parr_scores;
            private String bottle_baw;
            private CardBean card;
            private DiamondBean diamond;
            private GameAdvBean game_adv;
            private GlobalBean global;
            private String heavy_user;
            private List<String> idea_name;
            private String is_lottery;
            private LbsBean lbs;
            private MParrPropsBean mParr_props;
            private String meizhi_level;
            private NewIconinfoBean new_iconinfo;
            private NoticeMaskBean notice_mask;
            private String paper;
            private String portrait_time;
            private PrivSetsBean priv_sets;
            private String tbscore_repeate_finish_time;
            private String ueg_profile;
            private String use_sig;
            private String user_id;
            private String user_name;
            private String user_sex;
            private String user_status;
            private String user_type;
            private VipInfoBean vipInfo;
            private VipexpInfoBean vipexp_info;
            private WapRnBean wap_rn;

            public static class CardBean {

                private String good_num;
                private String is_novice;
                private LikeForumBean like_forum;
                private ManagerInfoBean manager_info;
                private String op_time;
                private String post_num;

                public static class LikeForumBean {

                    @SerializedName("12")
                    private ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$12Bean _$12;
                    @SerializedName("13")
                    private ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean _$13;
                    @SerializedName("9")
                    private ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$9Bean _$9;

                    public static LikeForumBean objectFromData(String str) {
                        return (LikeForumBean) new Gson().fromJson(str, LikeForumBean.class);
                    }

                    public static List<LikeForumBean> arrayLikeForumBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LikeForumBean>>() {
                        }.getType());
                    }

                    public ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean get_$13() {
                        return this._$13;
                    }

                    public void set_$13(
                            ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean) {
                        this._$13 = threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$13Bean;
                    }

                    public ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$12Bean get_$12() {
                        return this._$12;
                    }

                    public void set_$12(
                            ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$12Bean threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$12Bean) {
                        this._$12 = threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$12Bean;
                    }

                    public ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$9Bean get_$9() {
                        return this._$9;
                    }

                    public void set_$9(
                            ThreadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$9Bean threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$9Bean) {
                        this._$9 = threadListPageBean$UserBean$NewUserInfoBean$CardBean$LikeForumBean$_$9Bean;
                    }
                }

                public static class ManagerInfoBean {

                    private AssistBean assist;
                    private ManagerBean manager;
                    private ProfessionManagerBean profession_manager;

                    public static class AssistBean {

                        private String count;
                        private List<?> forum_list;

                        public static AssistBean objectFromData(String str) {
                            return (AssistBean) new Gson().fromJson(str, AssistBean.class);
                        }

                        public static List<AssistBean> arrayAssistBeanFromData(String str) {
                            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AssistBean>>() {
                            }.getType());
                        }

                        public String getCount() {
                            return this.count;
                        }

                        public void setCount(String str) {
                            this.count = str;
                        }

                        public List<?> getForum_list() {
                            return this.forum_list;
                        }

                        public void setForum_list(List<?> list) {
                            this.forum_list = list;
                        }
                    }

                    public static class ManagerBean {

                        private String count;
                        private List<String> forum_list;

                        public static ManagerBean objectFromData(String str) {
                            return (ManagerBean) new Gson().fromJson(str, ManagerBean.class);
                        }

                        public static List<ManagerBean> arrayManagerBeanFromData(String str) {
                            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ManagerBean>>() {
                            }.getType());
                        }

                        public String getCount() {
                            return this.count;
                        }

                        public void setCount(String str) {
                            this.count = str;
                        }

                        public List<String> getForum_list() {
                            return this.forum_list;
                        }

                        public void setForum_list(List<String> list) {
                            this.forum_list = list;
                        }
                    }

                    public static class ProfessionManagerBean {

                        private String count;

                        public static ProfessionManagerBean objectFromData(String str) {
                            return (ProfessionManagerBean) new Gson().fromJson(str, ProfessionManagerBean.class);
                        }

                        public static List<ProfessionManagerBean> arrayProfessionManagerBeanFromData(
                                String str) {
                            return (List) new Gson()
                                    .fromJson(str, new TypeToken<ArrayList<ProfessionManagerBean>>() {
                                    }.getType());
                        }

                        public String getCount() {
                            return this.count;
                        }

                        public void setCount(String str) {
                            this.count = str;
                        }
                    }

                    public static ManagerInfoBean objectFromData(String str) {
                        return (ManagerInfoBean) new Gson().fromJson(str, ManagerInfoBean.class);
                    }

                    public static List<ManagerInfoBean> arrayManagerInfoBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ManagerInfoBean>>() {
                        }.getType());
                    }

                    public ManagerBean getManager() {
                        return this.manager;
                    }

                    public void setManager(ManagerBean managerBean) {
                        this.manager = managerBean;
                    }

                    public AssistBean getAssist() {
                        return this.assist;
                    }

                    public void setAssist(AssistBean assistBean) {
                        this.assist = assistBean;
                    }

                    public ProfessionManagerBean getProfession_manager() {
                        return this.profession_manager;
                    }

                    public void setProfession_manager(ProfessionManagerBean professionManagerBean) {
                        this.profession_manager = professionManagerBean;
                    }
                }

                public static CardBean objectFromData(String str) {
                    return (CardBean) new Gson().fromJson(str, CardBean.class);
                }

                public static List<CardBean> arrayCardBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<CardBean>>() {
                    }.getType());
                }

                public String getPost_num() {
                    return this.post_num;
                }

                public void setPost_num(String str) {
                    this.post_num = str;
                }

                public String getGood_num() {
                    return this.good_num;
                }

                public void setGood_num(String str) {
                    this.good_num = str;
                }

                public ManagerInfoBean getManager_info() {
                    return this.manager_info;
                }

                public void setManager_info(ManagerInfoBean managerInfoBean) {
                    this.manager_info = managerInfoBean;
                }

                public LikeForumBean getLike_forum() {
                    return this.like_forum;
                }

                public void setLike_forum(LikeForumBean likeForumBean) {
                    this.like_forum = likeForumBean;
                }

                public String getIs_novice() {
                    return this.is_novice;
                }

                public void setIs_novice(String str) {
                    this.is_novice = str;
                }

                public String getOp_time() {
                    return this.op_time;
                }

                public void setOp_time(String str) {
                    this.op_time = str;
                }
            }

            public static class DiamondBean {

                private String end_time;
                private String scores;

                public static DiamondBean objectFromData(String str) {
                    return (DiamondBean) new Gson().fromJson(str, DiamondBean.class);
                }

                public static List<DiamondBean> arrayDiamondBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<DiamondBean>>() {
                    }.getType());
                }

                public String getScores() {
                    return this.scores;
                }

                public void setScores(String str) {
                    this.scores = str;
                }

                public String getEnd_time() {
                    return this.end_time;
                }

                public void setEnd_time(String str) {
                    this.end_time = str;
                }
            }

            public static class GameAdvBean {

                private String ad_link;
                private String end_time;
                private String forum_link;
                private String start_time;

                public static GameAdvBean objectFromData(String str) {
                    return (GameAdvBean) new Gson().fromJson(str, GameAdvBean.class);
                }

                public static List<GameAdvBean> arrayGameAdvBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<GameAdvBean>>() {
                    }.getType());
                }

                public String getStart_time() {
                    return this.start_time;
                }

                public void setStart_time(String str) {
                    this.start_time = str;
                }

                public String getEnd_time() {
                    return this.end_time;
                }

                public void setEnd_time(String str) {
                    this.end_time = str;
                }

                public String getAd_link() {
                    return this.ad_link;
                }

                public void setAd_link(String str) {
                    this.ad_link = str;
                }

                public String getForum_link() {
                    return this.forum_link;
                }

                public void setForum_link(String str) {
                    this.forum_link = str;
                }
            }

            public static class GlobalBean {

                private String tbmall_newprops;

                public static GlobalBean objectFromData(String str) {
                    return (GlobalBean) new Gson().fromJson(str, GlobalBean.class);
                }

                public static List<GlobalBean> arrayGlobalBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<GlobalBean>>() {
                    }.getType());
                }

                public String getTbmall_newprops() {
                    return this.tbmall_newprops;
                }

                public void setTbmall_newprops(String str) {
                    this.tbmall_newprops = str;
                }
            }

            public static class LbsBean {

                private String lat;
                private String lng;
                private String time;

                public static LbsBean objectFromData(String str) {
                    return (LbsBean) new Gson().fromJson(str, LbsBean.class);
                }

                public static List<LbsBean> arrayLbsBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LbsBean>>() {
                    }.getType());
                }

                public String getLng() {
                    return this.lng;
                }

                public void setLng(String str) {
                    this.lng = str;
                }

                public String getLat() {
                    return this.lat;
                }

                public void setLat(String str) {
                    this.lat = str;
                }

                public String getTime() {
                    return this.time;
                }

                public void setTime(String str) {
                    this.time = str;
                }
            }

            public static class MParrPropsBean {

                private AllLevelBeanX all_level;
                private LevelBeanX level;

                public static class AllLevelBeanX {

                    @SerializedName("2")
                    private ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX _$2;

                    public static AllLevelBeanX objectFromData(String str) {
                        return (AllLevelBeanX) new Gson().fromJson(str, AllLevelBeanX.class);
                    }

                    public static List<AllLevelBeanX> arrayAllLevelBeanXFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AllLevelBeanX>>() {
                        }.getType());
                    }

                    public ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX get_$2() {
                        return this._$2;
                    }

                    public void set_$2(
                            ThreadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX threadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX) {
                        this._$2 = threadListPageBean$UserBean$NewUserInfoBean$MParrPropsBean$AllLevelBeanX$_$2BeanX;
                    }
                }

                public static class LevelBeanX {

                    private String end_time;
                    private String pic_url;
                    private String props_id;

                    public static LevelBeanX objectFromData(String str) {
                        return (LevelBeanX) new Gson().fromJson(str, LevelBeanX.class);
                    }

                    public static List<LevelBeanX> arrayLevelBeanXFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LevelBeanX>>() {
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

                public static MParrPropsBean objectFromData(String str) {
                    return (MParrPropsBean) new Gson().fromJson(str, MParrPropsBean.class);
                }

                public static List<MParrPropsBean> arrayMParrPropsBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MParrPropsBean>>() {
                    }.getType());
                }

                public AllLevelBeanX getAll_level() {
                    return this.all_level;
                }

                public void setAll_level(AllLevelBeanX allLevelBeanX) {
                    this.all_level = allLevelBeanX;
                }

                public LevelBeanX getLevel() {
                    return this.level;
                }

                public void setLevel(LevelBeanX levelBeanX) {
                    this.level = levelBeanX;
                }
            }

            public static class NewIconinfoBean {

                @SerializedName("1")
                private ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean _$1;
                @SerializedName("2")
                private ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$2BeanXX _$2;

                public static NewIconinfoBean objectFromData(String str) {
                    return (NewIconinfoBean) new Gson().fromJson(str, NewIconinfoBean.class);
                }

                public static List<NewIconinfoBean> arrayNewIconinfoBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<NewIconinfoBean>>() {
                    }.getType());
                }

                public ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean get_$1() {
                    return this._$1;
                }

                public void set_$1(
                        ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean threadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean) {
                    this._$1 = threadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$1Bean;
                }

                public ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$2BeanXX get_$2() {
                    return this._$2;
                }

                public void set_$2(
                        ThreadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$2BeanXX threadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$2BeanXX) {
                    this._$2 = threadListPageBean$UserBean$NewUserInfoBean$NewIconinfoBean$_$2BeanXX;
                }
            }

            public static class NoticeMaskBean {

                @SerializedName("1000")
                private String _$1000;
                @SerializedName("2")
                private String _$2;
                @SerializedName("3")
                private String _$3;
                @SerializedName("5")
                private String _$5;
                @SerializedName("6")
                private String _$6;
                @SerializedName("9")
                private String _$9;

                public static NoticeMaskBean objectFromData(String str) {
                    return (NoticeMaskBean) new Gson().fromJson(str, NoticeMaskBean.class);
                }

                public static List<NoticeMaskBean> arrayNoticeMaskBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<NoticeMaskBean>>() {
                    }.getType());
                }

                public String get_$2() {
                    return this._$2;
                }

                public void set_$2(String str) {
                    this._$2 = str;
                }

                public String get_$3() {
                    return this._$3;
                }

                public void set_$3(String str) {
                    this._$3 = str;
                }

                public String get_$5() {
                    return this._$5;
                }

                public void set_$5(String str) {
                    this._$5 = str;
                }

                public String get_$6() {
                    return this._$6;
                }

                public void set_$6(String str) {
                    this._$6 = str;
                }

                public String get_$9() {
                    return this._$9;
                }

                public void set_$9(String str) {
                    this._$9 = str;
                }

                public String get_$1000() {
                    return this._$1000;
                }

                public void set_$1000(String str) {
                    this._$1000 = str;
                }
            }

            public static class ParrPropsBean {

                @SerializedName("126")
                private ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean _$126;
                private AllLevelBean all_level;
                private LevelBean level;

                public static class AllLevelBean {

                    @SerializedName("2")
                    private ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean _$2;

                    public static AllLevelBean objectFromData(String str) {
                        return (AllLevelBean) new Gson().fromJson(str, AllLevelBean.class);
                    }

                    public static List<AllLevelBean> arrayAllLevelBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AllLevelBean>>() {
                        }.getType());
                    }

                    public ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean get_$2() {
                        return this._$2;
                    }

                    public void set_$2(
                            ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean) {
                        this._$2 = threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$AllLevelBean$_$2Bean;
                    }
                }

                public static class LevelBean {

                    private String end_time;
                    private String expired_notify;
                    private String expiring_notify;
                    private String left_num;
                    private String max_free_score;
                    private String open_status;
                    private String props_category;
                    private String props_id;
                    private String props_type;
                    private String update_time;
                    private String used_status;

                    public static LevelBean objectFromData(String str) {
                        return (LevelBean) new Gson().fromJson(str, LevelBean.class);
                    }

                    public static List<LevelBean> arrayLevelBeanFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LevelBean>>() {
                        }.getType());
                    }

                    public String getProps_id() {
                        return this.props_id;
                    }

                    public void setProps_id(String str) {
                        this.props_id = str;
                    }

                    public String getProps_type() {
                        return this.props_type;
                    }

                    public void setProps_type(String str) {
                        this.props_type = str;
                    }

                    public String getProps_category() {
                        return this.props_category;
                    }

                    public void setProps_category(String str) {
                        this.props_category = str;
                    }

                    public String getEnd_time() {
                        return this.end_time;
                    }

                    public void setEnd_time(String str) {
                        this.end_time = str;
                    }

                    public String getLeft_num() {
                        return this.left_num;
                    }

                    public void setLeft_num(String str) {
                        this.left_num = str;
                    }

                    public String getUpdate_time() {
                        return this.update_time;
                    }

                    public void setUpdate_time(String str) {
                        this.update_time = str;
                    }

                    public String getUsed_status() {
                        return this.used_status;
                    }

                    public void setUsed_status(String str) {
                        this.used_status = str;
                    }

                    public String getOpen_status() {
                        return this.open_status;
                    }

                    public void setOpen_status(String str) {
                        this.open_status = str;
                    }

                    public String getExpiring_notify() {
                        return this.expiring_notify;
                    }

                    public void setExpiring_notify(String str) {
                        this.expiring_notify = str;
                    }

                    public String getExpired_notify() {
                        return this.expired_notify;
                    }

                    public void setExpired_notify(String str) {
                        this.expired_notify = str;
                    }

                    public String getMax_free_score() {
                        return this.max_free_score;
                    }

                    public void setMax_free_score(String str) {
                        this.max_free_score = str;
                    }
                }

                public static ParrPropsBean objectFromData(String str) {
                    return (ParrPropsBean) new Gson().fromJson(str, ParrPropsBean.class);
                }

                public static List<ParrPropsBean> arrayParrPropsBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ParrPropsBean>>() {
                    }.getType());
                }

                public AllLevelBean getAll_level() {
                    return this.all_level;
                }

                public void setAll_level(AllLevelBean allLevelBean) {
                    this.all_level = allLevelBean;
                }

                public ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean get_$126() {
                    return this._$126;
                }

                public void set_$126(
                        ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean) {
                    this._$126 = threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean;
                }

                public LevelBean getLevel() {
                    return this.level;
                }

                public void setLevel(LevelBean levelBean) {
                    this.level = levelBean;
                }
            }

            public static class ParrScoresBean {

                private String i_money;
                private String i_other;
                private String i_total;
                private String level;
                private String limit;
                private String scores_fetch;
                private String scores_money;
                private String scores_other;
                private String scores_total;
                private String update_time;

                public static ParrScoresBean objectFromData(String str) {
                    return (ParrScoresBean) new Gson().fromJson(str, ParrScoresBean.class);
                }

                public static List<ParrScoresBean> arrayParrScoresBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ParrScoresBean>>() {
                    }.getType());
                }

                public String getScores_total() {
                    return this.scores_total;
                }

                public void setScores_total(String str) {
                    this.scores_total = str;
                }

                public String getScores_fetch() {
                    return this.scores_fetch;
                }

                public void setScores_fetch(String str) {
                    this.scores_fetch = str;
                }

                public String getScores_money() {
                    return this.scores_money;
                }

                public void setScores_money(String str) {
                    this.scores_money = str;
                }

                public String getScores_other() {
                    return this.scores_other;
                }

                public void setScores_other(String str) {
                    this.scores_other = str;
                }

                public String getUpdate_time() {
                    return this.update_time;
                }

                public void setUpdate_time(String str) {
                    this.update_time = str;
                }

                public String getI_money() {
                    return this.i_money;
                }

                public void setI_money(String str) {
                    this.i_money = str;
                }

                public String getI_other() {
                    return this.i_other;
                }

                public void setI_other(String str) {
                    this.i_other = str;
                }

                public String getI_total() {
                    return this.i_total;
                }

                public void setI_total(String str) {
                    this.i_total = str;
                }

                public String getLevel() {
                    return this.level;
                }

                public void setLevel(String str) {
                    this.level = str;
                }

                public String getLimit() {
                    return this.limit;
                }

                public void setLimit(String str) {
                    this.limit = str;
                }
            }

            public static class PrivSetsBean {

                private String group;
                private String like;
                private String location;
                private String post;

                public static PrivSetsBean objectFromData(String str) {
                    return (PrivSetsBean) new Gson().fromJson(str, PrivSetsBean.class);
                }

                public static List<PrivSetsBean> arrayPrivSetsBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PrivSetsBean>>() {
                    }.getType());
                }

                public String getLocation() {
                    return this.location;
                }

                public void setLocation(String str) {
                    this.location = str;
                }

                public String getLike() {
                    return this.like;
                }

                public void setLike(String str) {
                    this.like = str;
                }

                public String getPost() {
                    return this.post;
                }

                public void setPost(String str) {
                    this.post = str;
                }

                public String getGroup() {
                    return this.group;
                }

                public void setGroup(String str) {
                    this.group = str;
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

                public String getE_time() {
                    return this.e_time;
                }

                public void setE_time(String str) {
                    this.e_time = str;
                }

                public String getS_time() {
                    return this.s_time;
                }

                public void setS_time(String str) {
                    this.s_time = str;
                }

                public String getExt_score() {
                    return this.ext_score;
                }

                public void setExt_score(String str) {
                    this.ext_score = str;
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

                public String getV_level() {
                    return this.v_level;
                }

                public void setV_level(String str) {
                    this.v_level = str;
                }

                public String getIcon_url() {
                    return this.icon_url;
                }

                public void setIcon_url(String str) {
                    this.icon_url = str;
                }

                public String getV_status() {
                    return this.v_status;
                }

                public void setV_status(String str) {
                    this.v_status = str;
                }
            }

            public static class VipexpInfoBean {

                private String activated_num;
                private String create_time;
                private String seed_num;
                private String status;
                private String update_time;
                private String user_id;
                private String vip_id;

                public static VipexpInfoBean objectFromData(String str) {
                    return (VipexpInfoBean) new Gson().fromJson(str, VipexpInfoBean.class);
                }

                public static List<VipexpInfoBean> arrayVipexpInfoBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<VipexpInfoBean>>() {
                    }.getType());
                }

                public String getUser_id() {
                    return this.user_id;
                }

                public void setUser_id(String str) {
                    this.user_id = str;
                }

                public String getVip_id() {
                    return this.vip_id;
                }

                public void setVip_id(String str) {
                    this.vip_id = str;
                }

                public String getStatus() {
                    return this.status;
                }

                public void setStatus(String str) {
                    this.status = str;
                }

                public String getSeed_num() {
                    return this.seed_num;
                }

                public void setSeed_num(String str) {
                    this.seed_num = str;
                }

                public String getActivated_num() {
                    return this.activated_num;
                }

                public void setActivated_num(String str) {
                    this.activated_num = str;
                }

                public String getCreate_time() {
                    return this.create_time;
                }

                public void setCreate_time(String str) {
                    this.create_time = str;
                }

                public String getUpdate_time() {
                    return this.update_time;
                }

                public void setUpdate_time(String str) {
                    this.update_time = str;
                }
            }

            public static class WapRnBean {

                private String frsrn;
                private String pbrn;

                public static WapRnBean objectFromData(String str) {
                    return (WapRnBean) new Gson().fromJson(str, WapRnBean.class);
                }

                public static List<WapRnBean> arrayWapRnBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<WapRnBean>>() {
                    }.getType());
                }

                public String getFrsrn() {
                    return this.frsrn;
                }

                public void setFrsrn(String str) {
                    this.frsrn = str;
                }

                public String getPbrn() {
                    return this.pbrn;
                }

                public void setPbrn(String str) {
                    this.pbrn = str;
                }
            }

            public static NewUserInfoBean objectFromData(String str) {
                return (NewUserInfoBean) new Gson().fromJson(str, NewUserInfoBean.class);
            }

            public static List<NewUserInfoBean> arrayNewUserInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<NewUserInfoBean>>() {
                }.getType());
            }

            public String getUser_id() {
                return this.user_id;
            }

            public void setUser_id(String str) {
                this.user_id = str;
            }

            public String getUser_name() {
                return this.user_name;
            }

            public void setUser_name(String str) {
                this.user_name = str;
            }

            public String getUser_sex() {
                return this.user_sex;
            }

            public void setUser_sex(String str) {
                this.user_sex = str;
            }

            public String getUser_status() {
                return this.user_status;
            }

            public void setUser_status(String str) {
                this.user_status = str;
            }

            public String getMeizhi_level() {
                return this.meizhi_level;
            }

            public void setMeizhi_level(String str) {
                this.meizhi_level = str;
            }

            public String getPaper() {
                return this.paper;
            }

            public void setPaper(String str) {
                this.paper = str;
            }

            public CardBean getCard() {
                return this.card;
            }

            public void setCard(CardBean cardBean) {
                this.card = cardBean;
            }

            public ParrPropsBean getParr_props() {
                return this.Parr_props;
            }

            public void setParr_props(ParrPropsBean parrPropsBean) {
                this.Parr_props = parrPropsBean;
            }

            public String getPortrait_time() {
                return this.portrait_time;
            }

            public void setPortrait_time(String str) {
                this.portrait_time = str;
            }

            public MParrPropsBean getMParr_props() {
                return this.mParr_props;
            }

            public void setMParr_props(MParrPropsBean mParrPropsBean) {
                this.mParr_props = mParrPropsBean;
            }

            public String getTbscore_repeate_finish_time() {
                return this.tbscore_repeate_finish_time;
            }

            public void setTbscore_repeate_finish_time(String str) {
                this.tbscore_repeate_finish_time = str;
            }

            public String getUse_sig() {
                return this.use_sig;
            }

            public void setUse_sig(String str) {
                this.use_sig = str;
            }

            public NoticeMaskBean getNotice_mask() {
                return this.notice_mask;
            }

            public void setNotice_mask(NoticeMaskBean noticeMaskBean) {
                this.notice_mask = noticeMaskBean;
            }

            public WapRnBean getWap_rn() {
                return this.wap_rn;
            }

            public void setWap_rn(WapRnBean wapRnBean) {
                this.wap_rn = wapRnBean;
            }

            public PrivSetsBean getPriv_sets() {
                return this.priv_sets;
            }

            public void setPriv_sets(PrivSetsBean privSetsBean) {
                this.priv_sets = privSetsBean;
            }

            public NewIconinfoBean getNew_iconinfo() {
                return this.new_iconinfo;
            }

            public void setNew_iconinfo(NewIconinfoBean newIconinfoBean) {
                this.new_iconinfo = newIconinfoBean;
            }

            public String getIs_lottery() {
                return this.is_lottery;
            }

            public void setIs_lottery(String str) {
                this.is_lottery = str;
            }

            public GameAdvBean getGame_adv() {
                return this.game_adv;
            }

            public void setGame_adv(GameAdvBean gameAdvBean) {
                this.game_adv = gameAdvBean;
            }

            public VipexpInfoBean getVipexp_info() {
                return this.vipexp_info;
            }

            public void setVipexp_info(VipexpInfoBean vipexpInfoBean) {
                this.vipexp_info = vipexpInfoBean;
            }

            public String getUeg_profile() {
                return this.ueg_profile;
            }

            public void setUeg_profile(String str) {
                this.ueg_profile = str;
            }

            public DiamondBean getDiamond() {
                return this.diamond;
            }

            public void setDiamond(DiamondBean diamondBean) {
                this.diamond = diamondBean;
            }

            public VipInfoBean getVipInfo() {
                return this.vipInfo;
            }

            public void setVipInfo(VipInfoBean vipInfoBean) {
                this.vipInfo = vipInfoBean;
            }

            public String getHeavy_user() {
                return this.heavy_user;
            }

            public void setHeavy_user(String str) {
                this.heavy_user = str;
            }

            public String getBottle_baw() {
                return this.bottle_baw;
            }

            public void setBottle_baw(String str) {
                this.bottle_baw = str;
            }

            public LbsBean getLbs() {
                return this.lbs;
            }

            public void setLbs(LbsBean lbsBean) {
                this.lbs = lbsBean;
            }

            public ParrScoresBean getParr_scores() {
                return this.Parr_scores;
            }

            public void setParr_scores(ParrScoresBean parrScoresBean) {
                this.Parr_scores = parrScoresBean;
            }

            public String getUser_type() {
                return this.user_type;
            }

            public void setUser_type(String str) {
                this.user_type = str;
            }

            public GlobalBean getGlobal() {
                return this.global;
            }

            public void setGlobal(GlobalBean globalBean) {
                this.global = globalBean;
            }

            public List<String> getIdea_name() {
                return this.idea_name;
            }

            public void setIdea_name(List<String> list) {
                this.idea_name = list;
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

        public String getNo_un() {
            return this.no_un;
        }

        public void setNo_un(String str) {
            this.no_un = str;
        }

        public String getIs_manager() {
            return this.is_manager;
        }

        public void setIs_manager(String str) {
            this.is_manager = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getUserhide() {
            return this.userhide;
        }

        public void setUserhide(String str) {
            this.userhide = str;
        }

        public BalvBean getBalv() {
            return this.balv;
        }

        public void setBalv(BalvBean balvBean) {
            this.balv = balvBean;
        }

        public NewUserInfoBean getNew_user_info() {
            return this.new_user_info;
        }

        public void setNew_user_info(NewUserInfoBean newUserInfoBean) {
            this.new_user_info = newUserInfoBean;
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
    }

    public static ThreadListBean objectFromData(String str) {
        return (ThreadListBean) new Gson().fromJson(str, ThreadListBean.class);
    }

    public static List<ThreadListBean> arrayThreadListBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThreadListBean>>() {
        }.getType());
    }

    public ForumBean getForum() {
        return this.forum;
    }

    public void setForum(ForumBean forumBean) {
        this.forum = forumBean;
    }

    public FrsStarBean getFrs_star() {
        return this.frs_star;
    }

    public void setFrs_star(FrsStarBean frsStarBean) {
        this.frs_star = frsStarBean;
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

    public PageBean getPage() {
        return this.page;
    }

    public void setPage(PageBean pageBean) {
        this.page = pageBean;
    }

    public String getIs_new_url() {
        return this.is_new_url;
    }

    public void setIs_new_url(String str) {
        this.is_new_url = str;
    }

    public String getFortune_bag() {
        return this.fortune_bag;
    }

    public void setFortune_bag(String str) {
        this.fortune_bag = str;
    }

    public String getFortune_desc() {
        return this.fortune_desc;
    }

    public void setFortune_desc(String str) {
        this.fortune_desc = str;
    }

    public String getFrs_tab_default() {
        return this.frs_tab_default;
    }

    public void setFrs_tab_default(String str) {
        this.frs_tab_default = str;
    }

    public BottleBean getBottle() {
        return this.bottle;
    }

    public void setBottle(BottleBean bottleBean) {
        this.bottle = bottleBean;
    }

    public GconAccountBean getGcon_account() {
        return this.gcon_account;
    }

    public void setGcon_account(GconAccountBean gconAccountBean) {
        this.gcon_account = gconAccountBean;
    }

    public String getTwzhibo_pos() {
        return this.twzhibo_pos;
    }

    public void setTwzhibo_pos(String str) {
        this.twzhibo_pos = str;
    }

    public String getAsp_shown_info() {
        return this.asp_shown_info;
    }

    public void setAsp_shown_info(String str) {
        this.asp_shown_info = str;
    }

    public String getSort_type() {
        return this.sort_type;
    }

    public void setSort_type(String str) {
        this.sort_type = str;
    }

    public String getNeed_log() {
        return this.need_log;
    }

    public void setNeed_log(String str) {
        this.need_log = str;
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

    public List<ThreadListBean> getThread_list() {
        return this.thread_list;
    }

    public void setThread_list(List<ThreadListBean> list) {
        this.thread_list = list;
    }

    public List<?> getThread_id_list() {
        return this.thread_id_list;
    }

    public void setThread_id_list(List<?> list) {
        this.thread_id_list = list;
    }

    public List<FrsTabInfoBean> getFrs_tab_info() {
        return this.frs_tab_info;
    }

    public void setFrs_tab_info(List<FrsTabInfoBean> list) {
        this.frs_tab_info = list;
    }

    public List<StarEnterBean> getStar_enter() {
        return this.star_enter;
    }

    public void setStar_enter(List<StarEnterBean> list) {
        this.star_enter = list;
    }

    public List<?> getBanner_thread_list() {
        return this.banner_thread_list;
    }

    public void setBanner_thread_list(List<?> list) {
        this.banner_thread_list = list;
    }
}
