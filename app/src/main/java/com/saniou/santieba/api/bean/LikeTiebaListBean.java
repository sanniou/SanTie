package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class LikeTiebaListBean extends BaseBean {

    private List<?> banner;
    private int ctime;
    private String error_code;
    private List<ForumDirBean> forum_dir;
    private List<?> frequently_forum_info;
    private String group_count;
    private HotSearchBean hot_search;
    private String is_login;
    private String is_mem;
    private List<LikeForumBean> like_forum;
    private long logid;
    private String msign_level;
    private String msign_text;
    private String msign_valid;
    private List<?> new_banner_info;
    private List<?> new_recommend;
    private RecommendBean recommend;
    private List<?> recommend_forum_info;
    private String redirect;
    private String server_time;
    private int time;
    private List<?> topic;

    public static class ForumDirBean {

        private List<ChildMenuListBean> child_menu_list;
        private String default_logo_url;
        private String menu_id;
        private String menu_level;
        private String menu_name;
        private String menu_type;

        public static class ChildMenuListBean {

            private String menu_id;
            private String menu_level;
            private String menu_name;
            private String menu_type;

            public static ChildMenuListBean objectFromData(String str) {
                return (ChildMenuListBean) new Gson().fromJson(str, ChildMenuListBean.class);
            }

            public static List<ChildMenuListBean> arrayChildMenuListBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ChildMenuListBean>>() {
                }.getType());
            }

            public String getMenu_name() {
                return this.menu_name;
            }

            public void setMenu_name(String str) {
                this.menu_name = str;
            }

            public String getMenu_type() {
                return this.menu_type;
            }

            public void setMenu_type(String str) {
                this.menu_type = str;
            }

            public String getMenu_id() {
                return this.menu_id;
            }

            public void setMenu_id(String str) {
                this.menu_id = str;
            }

            public String getMenu_level() {
                return this.menu_level;
            }

            public void setMenu_level(String str) {
                this.menu_level = str;
            }
        }

        public static ForumDirBean objectFromData(String str) {
            return (ForumDirBean) new Gson().fromJson(str, ForumDirBean.class);
        }

        public static List<ForumDirBean> arrayForumDirBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ForumDirBean>>() {
            }.getType());
        }

        public String getMenu_name() {
            return this.menu_name;
        }

        public void setMenu_name(String str) {
            this.menu_name = str;
        }

        public String getMenu_type() {
            return this.menu_type;
        }

        public void setMenu_type(String str) {
            this.menu_type = str;
        }

        public String getMenu_id() {
            return this.menu_id;
        }

        public void setMenu_id(String str) {
            this.menu_id = str;
        }

        public String getMenu_level() {
            return this.menu_level;
        }

        public void setMenu_level(String str) {
            this.menu_level = str;
        }

        public String getDefault_logo_url() {
            return this.default_logo_url;
        }

        public void setDefault_logo_url(String str) {
            this.default_logo_url = str;
        }

        public List<ChildMenuListBean> getChild_menu_list() {
            return this.child_menu_list;
        }

        public void setChild_menu_list(List<ChildMenuListBean> list) {
            this.child_menu_list = list;
        }
    }

    public static class HotSearchBean {

        private String search_title;
        private SearchValueBean search_value;

        public static class SearchValueBean {

            private String desc;
            private String id;
            private String name;
            private String type;

            public static SearchValueBean objectFromData(String str) {
                return (SearchValueBean) new Gson().fromJson(str, SearchValueBean.class);
            }

            public static List<SearchValueBean> arraySearchValueBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SearchValueBean>>() {
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

        public static HotSearchBean objectFromData(String str) {
            return (HotSearchBean) new Gson().fromJson(str, HotSearchBean.class);
        }

        public static List<HotSearchBean> arrayHotSearchBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<HotSearchBean>>() {
            }.getType());
        }

        public String getSearch_title() {
            return this.search_title;
        }

        public void setSearch_title(String str) {
            this.search_title = str;
        }

        public SearchValueBean getSearch_value() {
            return this.search_value;
        }

        public void setSearch_value(SearchValueBean searchValueBean) {
            this.search_value = searchValueBean;
        }
    }

    public static class LikeForumBean {

        private String avatar;
        private String forum_id;
        private String forum_name;
        private String is_sign;
        private String level_id;

        public static LikeForumBean objectFromData(String str) {
            return (LikeForumBean) new Gson().fromJson(str, LikeForumBean.class);
        }

        public static List<LikeForumBean> arrayLikeForumBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LikeForumBean>>() {
            }.getType());
        }

        public String getForum_id() {
            return this.forum_id;
        }

        public void setForum_id(String str) {
            this.forum_id = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public String getIs_sign() {
            return this.is_sign;
        }

        public void setIs_sign(String str) {
            this.is_sign = str;
        }

        public String getForum_name() {
            return this.forum_name;
        }

        public void setForum_name(String str) {
            this.forum_name = str;
        }

        public String getLevel_id() {
            return this.level_id;
        }

        public void setLevel_id(String str) {
            this.level_id = str;
        }
    }

    public static class RecommendBean {

        private List<?> daily_forum;
        private List<RecommedForumBean> recommed_forum;

        public static class RecommedForumBean {

            private String avatar;
            private String forum_id;
            private String forum_name;
            private String is_like;
            private String member_count;
            private String slogan;
            private String thread_count;

            public static RecommedForumBean objectFromData(String str) {
                return (RecommedForumBean) new Gson().fromJson(str, RecommedForumBean.class);
            }

            public static List<RecommedForumBean> arrayRecommedForumBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<RecommedForumBean>>() {
                }.getType());
            }

            public String getForum_id() {
                return this.forum_id;
            }

            public void setForum_id(String str) {
                this.forum_id = str;
            }

            public String getForum_name() {
                return this.forum_name;
            }

            public void setForum_name(String str) {
                this.forum_name = str;
            }

            public String getAvatar() {
                return this.avatar;
            }

            public void setAvatar(String str) {
                this.avatar = str;
            }

            public String getSlogan() {
                return this.slogan;
            }

            public void setSlogan(String str) {
                this.slogan = str;
            }

            public String getMember_count() {
                return this.member_count;
            }

            public void setMember_count(String str) {
                this.member_count = str;
            }

            public String getThread_count() {
                return this.thread_count;
            }

            public void setThread_count(String str) {
                this.thread_count = str;
            }

            public String getIs_like() {
                return this.is_like;
            }

            public void setIs_like(String str) {
                this.is_like = str;
            }
        }

        public static RecommendBean objectFromData(String str) {
            return (RecommendBean) new Gson().fromJson(str, RecommendBean.class);
        }

        public static List<RecommendBean> arrayRecommendBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<RecommendBean>>() {
            }.getType());
        }

        public List<?> getDaily_forum() {
            return this.daily_forum;
        }

        public void setDaily_forum(List<?> list) {
            this.daily_forum = list;
        }

        public List<RecommedForumBean> getRecommed_forum() {
            return this.recommed_forum;
        }

        public void setRecommed_forum(List<RecommedForumBean> list) {
            this.recommed_forum = list;
        }
    }

    public static LikeTiebaListBean objectFromData(String str) {
        return (LikeTiebaListBean) new Gson().fromJson(str, LikeTiebaListBean.class);
    }

    public static List<LikeTiebaListBean> arrayLikeTiebaListBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<LikeTiebaListBean>>() {
        }.getType());
    }

    public RecommendBean getRecommend() {
        return this.recommend;
    }

    public void setRecommend(RecommendBean recommendBean) {
        this.recommend = recommendBean;
    }

    public String getIs_login() {
        return this.is_login;
    }

    public void setIs_login(String str) {
        this.is_login = str;
    }

    public String getMsign_valid() {
        return this.msign_valid;
    }

    public void setMsign_valid(String str) {
        this.msign_valid = str;
    }

    public String getMsign_text() {
        return this.msign_text;
    }

    public void setMsign_text(String str) {
        this.msign_text = str;
    }

    public String getMsign_level() {
        return this.msign_level;
    }

    public void setMsign_level(String str) {
        this.msign_level = str;
    }

    public String getGroup_count() {
        return this.group_count;
    }

    public void setGroup_count(String str) {
        this.group_count = str;
    }

    public String getIs_mem() {
        return this.is_mem;
    }

    public void setIs_mem(String str) {
        this.is_mem = str;
    }

    public HotSearchBean getHot_search() {
        return this.hot_search;
    }

    public void setHot_search(HotSearchBean hotSearchBean) {
        this.hot_search = hotSearchBean;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public void setRedirect(String str) {
        this.redirect = str;
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

    public List<?> getFrequently_forum_info() {
        return this.frequently_forum_info;
    }

    public void setFrequently_forum_info(List<?> list) {
        this.frequently_forum_info = list;
    }

    public List<LikeForumBean> getLike_forum() {
        return this.like_forum;
    }

    public void setLike_forum(List<LikeForumBean> list) {
        this.like_forum = list;
    }

    public List<?> getBanner() {
        return this.banner;
    }

    public void setBanner(List<?> list) {
        this.banner = list;
    }

    public List<?> getTopic() {
        return this.topic;
    }

    public void setTopic(List<?> list) {
        this.topic = list;
    }

    public List<ForumDirBean> getForum_dir() {
        return this.forum_dir;
    }

    public void setForum_dir(List<ForumDirBean> list) {
        this.forum_dir = list;
    }

    public List<?> getNew_recommend() {
        return this.new_recommend;
    }

    public void setNew_recommend(List<?> list) {
        this.new_recommend = list;
    }

    public List<?> getRecommend_forum_info() {
        return this.recommend_forum_info;
    }

    public void setRecommend_forum_info(List<?> list) {
        this.recommend_forum_info = list;
    }

    public List<?> getNew_banner_info() {
        return this.new_banner_info;
    }

    public void setNew_banner_info(List<?> list) {
        this.new_banner_info = list;
    }
}
