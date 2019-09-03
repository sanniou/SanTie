package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SubPostBean extends BaseBean {

    private AntiBean anti;
    private int ctime;
    private String error_code;
    private String error_msg;
    private ForumBean forum;
    private long logid;
    private PageBean page;
    private PermBeanX perm;
    private PostBean post;
    private List<?> post_list;
    private String server_time;
    private List<SubpostListBean> subpost_list;
    private ThreadBean thread;
    private int time;
    private List<?> user;

    public static class AntiBean {

        private String forbid_flag;
        private String forbid_info;
        private String ifpost;
        private String ifposta;
        private String ifvoice;
        private String ifxiaoying;
        private String tbs;
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

        public String getIfxiaoying() {
            return this.ifxiaoying;
        }

        public void setIfxiaoying(String str) {
            this.ifxiaoying = str;
        }
    }

    public static class ForumBean {

        private String album_forum;
        private String album_good_smallflow;
        private String ban_pic_topic;
        private String first_class;
        private String forbid_flag;
        private String has_forum_light;
        private String has_paper;
        private String has_picture_frs;
        private String id;
        private String is_album_post;
        private String is_exists;
        private String is_like;
        private String is_meizhi;
        private String is_readonly;
        private List<ManagersBean> managers;
        private String name;
        private String no_post_pic;
        private String second_class;
        private String shield_post;

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

        public String getForbid_flag() {
            return this.forbid_flag;
        }

        public void setForbid_flag(String str) {
            this.forbid_flag = str;
        }

        public String getHas_forum_light() {
            return this.has_forum_light;
        }

        public void setHas_forum_light(String str) {
            this.has_forum_light = str;
        }

        public String getIs_like() {
            return this.is_like;
        }

        public void setIs_like(String str) {
            this.is_like = str;
        }

        public String getIs_readonly() {
            return this.is_readonly;
        }

        public void setIs_readonly(String str) {
            this.is_readonly = str;
        }

        public String getShield_post() {
            return this.shield_post;
        }

        public void setShield_post(String str) {
            this.shield_post = str;
        }

        public String getIs_meizhi() {
            return this.is_meizhi;
        }

        public void setIs_meizhi(String str) {
            this.is_meizhi = str;
        }

        public String getAlbum_forum() {
            return this.album_forum;
        }

        public void setAlbum_forum(String str) {
            this.album_forum = str;
        }

        public String getHas_picture_frs() {
            return this.has_picture_frs;
        }

        public void setHas_picture_frs(String str) {
            this.has_picture_frs = str;
        }

        public String getIs_album_post() {
            return this.is_album_post;
        }

        public void setIs_album_post(String str) {
            this.is_album_post = str;
        }

        public String getBan_pic_topic() {
            return this.ban_pic_topic;
        }

        public void setBan_pic_topic(String str) {
            this.ban_pic_topic = str;
        }

        public String getAlbum_good_smallflow() {
            return this.album_good_smallflow;
        }

        public void setAlbum_good_smallflow(String str) {
            this.album_good_smallflow = str;
        }

        public String getNo_post_pic() {
            return this.no_post_pic;
        }

        public void setNo_post_pic(String str) {
            this.no_post_pic = str;
        }

        public String getHas_paper() {
            return this.has_paper;
        }

        public void setHas_paper(String str) {
            this.has_paper = str;
        }

        public List<ManagersBean> getManagers() {
            return this.managers;
        }

        public void setManagers(List<ManagersBean> list) {
            this.managers = list;
        }
    }

    public static class PageBean {

        private String current_page;
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

        public String getTotal_page() {
            return this.total_page;
        }

        public void setTotal_page(String str) {
            this.total_page = str;
        }

        public String getTotal_count() {
            return this.total_count;
        }

        public void setTotal_count(String str) {
            this.total_count = str;
        }

        public String getCurrent_page() {
            return this.current_page;
        }

        public void setCurrent_page(String str) {
            this.current_page = str;
        }

        public String getPage_size() {
            return this.page_size;
        }

        public void setPage_size(String str) {
            this.page_size = str;
        }
    }

    public static class PermBeanX {

        private String block_type;
        private GradeBean grade;
        private PermBean perm;
        private String ueg_type;

        public static class GradeBean {

            private String cur_score;
            private String forum_id;
            private String func_name;
            private String in_time;
            private String is_black;
            private String is_like;
            private String level_id;
            private String level_name;
            private String like_num;
            private String score_left;
            private String user_id;

            public static GradeBean objectFromData(String str) {
                return (GradeBean) new Gson().fromJson(str, GradeBean.class);
            }

            public static List<GradeBean> arrayGradeBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<GradeBean>>() {
                }.getType());
            }

            public String getFunc_name() {
                return this.func_name;
            }

            public void setFunc_name(String str) {
                this.func_name = str;
            }

            public String getUser_id() {
                return this.user_id;
            }

            public void setUser_id(String str) {
                this.user_id = str;
            }

            public String getForum_id() {
                return this.forum_id;
            }

            public void setForum_id(String str) {
                this.forum_id = str;
            }

            public String getIs_like() {
                return this.is_like;
            }

            public void setIs_like(String str) {
                this.is_like = str;
            }

            public String getIs_black() {
                return this.is_black;
            }

            public void setIs_black(String str) {
                this.is_black = str;
            }

            public String getLike_num() {
                return this.like_num;
            }

            public void setLike_num(String str) {
                this.like_num = str;
            }

            public String getIn_time() {
                return this.in_time;
            }

            public void setIn_time(String str) {
                this.in_time = str;
            }

            public String getLevel_id() {
                return this.level_id;
            }

            public void setLevel_id(String str) {
                this.level_id = str;
            }

            public String getCur_score() {
                return this.cur_score;
            }

            public void setCur_score(String str) {
                this.cur_score = str;
            }

            public String getScore_left() {
                return this.score_left;
            }

            public void setScore_left(String str) {
                this.score_left = str;
            }

            public String getLevel_name() {
                return this.level_name;
            }

            public void setLevel_name(String str) {
                this.level_name = str;
            }
        }

        public static class PermBean {

            private String can_add_celebrity;
            private String can_add_manager_team;
            private String can_bws_FDS;
            private String can_bws_bawu_center;
            private String can_bws_bawu_info;
            private String can_bws_bawu_log;
            private String can_bws_filter_ip_tbs;
            private String can_bws_limit_bawu_log;
            private String can_cancel_mask_delete;
            private String can_cancel_mask_good;
            private String can_cancel_mask_top;
            private String can_del_manager_team;
            private String can_edit_bakan;
            private String can_edit_daquan;
            private String can_edit_gconforum;
            private String can_filter_id;
            private String can_filter_ip;
            private String can_mask_delete;
            private String can_mask_good;
            private String can_mask_top;
            private String can_member_top;
            private String can_op_FDS;
            private String can_op_as_4thmgr;
            private String can_op_as_broadcast_admin;
            private String can_op_as_category_editor;
            private String can_op_as_editor;
            private String can_op_as_entertainment_manager;
            private String can_op_as_operator;
            private String can_op_as_profession_manager;
            private String can_op_as_vertical_operator;
            private String can_op_common_bawu;
            private String can_op_disk;
            private String can_op_frsbg;
            private String can_op_good_class;
            private String can_op_pic;
            private String can_op_topic;
            private String can_op_video;
            private String can_op_wise_group;
            private String can_paper_ignore_vcode;
            private String can_pass_media_limit;
            private String can_post;
            private String can_post_frs;
            private String can_post_pb;
            private String can_send_memo;
            private String can_super;
            private String can_tobe_assist;
            private String can_tobe_editor;
            private String can_tobe_manager;
            private String can_toms_operator_alt_basic;
            private String can_toms_operator_basic;
            private String can_type1_audit_post;
            private String can_type2_audit_post;
            private String can_type3_audit_post;
            private String can_unknown;
            private String can_view_freq;
            private String can_vip_jubao;
            private String can_vote;

            public static PermBean objectFromData(String str) {
                return (PermBean) new Gson().fromJson(str, PermBean.class);
            }

            public static List<PermBean> arrayPermBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PermBean>>() {
                }.getType());
            }

            public String getCan_filter_id() {
                return this.can_filter_id;
            }

            public void setCan_filter_id(String str) {
                this.can_filter_id = str;
            }

            public String getCan_filter_ip() {
                return this.can_filter_ip;
            }

            public void setCan_filter_ip(String str) {
                this.can_filter_ip = str;
            }

            public String getCan_op_good_class() {
                return this.can_op_good_class;
            }

            public void setCan_op_good_class(String str) {
                this.can_op_good_class = str;
            }

            public String getCan_add_manager_team() {
                return this.can_add_manager_team;
            }

            public void setCan_add_manager_team(String str) {
                this.can_add_manager_team = str;
            }

            public String getCan_del_manager_team() {
                return this.can_del_manager_team;
            }

            public void setCan_del_manager_team(String str) {
                this.can_del_manager_team = str;
            }

            public String getCan_bws_bawu_info() {
                return this.can_bws_bawu_info;
            }

            public void setCan_bws_bawu_info(String str) {
                this.can_bws_bawu_info = str;
            }

            public String getCan_bws_bawu_center() {
                return this.can_bws_bawu_center;
            }

            public void setCan_bws_bawu_center(String str) {
                this.can_bws_bawu_center = str;
            }

            public String getCan_bws_bawu_log() {
                return this.can_bws_bawu_log;
            }

            public void setCan_bws_bawu_log(String str) {
                this.can_bws_bawu_log = str;
            }

            public String getCan_bws_FDS() {
                return this.can_bws_FDS;
            }

            public void setCan_bws_FDS(String str) {
                this.can_bws_FDS = str;
            }

            public String getCan_op_FDS() {
                return this.can_op_FDS;
            }

            public void setCan_op_FDS(String str) {
                this.can_op_FDS = str;
            }

            public String getCan_cancel_mask_delete() {
                return this.can_cancel_mask_delete;
            }

            public void setCan_cancel_mask_delete(String str) {
                this.can_cancel_mask_delete = str;
            }

            public String getCan_op_disk() {
                return this.can_op_disk;
            }

            public void setCan_op_disk(String str) {
                this.can_op_disk = str;
            }

            public String getCan_op_common_bawu() {
                return this.can_op_common_bawu;
            }

            public void setCan_op_common_bawu(String str) {
                this.can_op_common_bawu = str;
            }

            public String getCan_unknown() {
                return this.can_unknown;
            }

            public void setCan_unknown(String str) {
                this.can_unknown = str;
            }

            public String getCan_bws_filter_ip_tbs() {
                return this.can_bws_filter_ip_tbs;
            }

            public void setCan_bws_filter_ip_tbs(String str) {
                this.can_bws_filter_ip_tbs = str;
            }

            public String getCan_mask_delete() {
                return this.can_mask_delete;
            }

            public void setCan_mask_delete(String str) {
                this.can_mask_delete = str;
            }

            public String getCan_mask_good() {
                return this.can_mask_good;
            }

            public void setCan_mask_good(String str) {
                this.can_mask_good = str;
            }

            public String getCan_cancel_mask_good() {
                return this.can_cancel_mask_good;
            }

            public void setCan_cancel_mask_good(String str) {
                this.can_cancel_mask_good = str;
            }

            public String getCan_mask_top() {
                return this.can_mask_top;
            }

            public void setCan_mask_top(String str) {
                this.can_mask_top = str;
            }

            public String getCan_cancel_mask_top() {
                return this.can_cancel_mask_top;
            }

            public void setCan_cancel_mask_top(String str) {
                this.can_cancel_mask_top = str;
            }

            public String getCan_vote() {
                return this.can_vote;
            }

            public void setCan_vote(String str) {
                this.can_vote = str;
            }

            public String getCan_edit_bakan() {
                return this.can_edit_bakan;
            }

            public void setCan_edit_bakan(String str) {
                this.can_edit_bakan = str;
            }

            public String getCan_edit_daquan() {
                return this.can_edit_daquan;
            }

            public void setCan_edit_daquan(String str) {
                this.can_edit_daquan = str;
            }

            public String getCan_pass_media_limit() {
                return this.can_pass_media_limit;
            }

            public void setCan_pass_media_limit(String str) {
                this.can_pass_media_limit = str;
            }

            public String getCan_op_video() {
                return this.can_op_video;
            }

            public void setCan_op_video(String str) {
                this.can_op_video = str;
            }

            public String getCan_op_pic() {
                return this.can_op_pic;
            }

            public void setCan_op_pic(String str) {
                this.can_op_pic = str;
            }

            public String getCan_type3_audit_post() {
                return this.can_type3_audit_post;
            }

            public void setCan_type3_audit_post(String str) {
                this.can_type3_audit_post = str;
            }

            public String getCan_type2_audit_post() {
                return this.can_type2_audit_post;
            }

            public void setCan_type2_audit_post(String str) {
                this.can_type2_audit_post = str;
            }

            public String getCan_type1_audit_post() {
                return this.can_type1_audit_post;
            }

            public void setCan_type1_audit_post(String str) {
                this.can_type1_audit_post = str;
            }

            public String getCan_vip_jubao() {
                return this.can_vip_jubao;
            }

            public void setCan_vip_jubao(String str) {
                this.can_vip_jubao = str;
            }

            public String getCan_super() {
                return this.can_super;
            }

            public void setCan_super(String str) {
                this.can_super = str;
            }

            public String getCan_send_memo() {
                return this.can_send_memo;
            }

            public void setCan_send_memo(String str) {
                this.can_send_memo = str;
            }

            public String getCan_op_frsbg() {
                return this.can_op_frsbg;
            }

            public void setCan_op_frsbg(String str) {
                this.can_op_frsbg = str;
            }

            public String getCan_op_wise_group() {
                return this.can_op_wise_group;
            }

            public void setCan_op_wise_group(String str) {
                this.can_op_wise_group = str;
            }

            public String getCan_bws_limit_bawu_log() {
                return this.can_bws_limit_bawu_log;
            }

            public void setCan_bws_limit_bawu_log(String str) {
                this.can_bws_limit_bawu_log = str;
            }

            public String getCan_edit_gconforum() {
                return this.can_edit_gconforum;
            }

            public void setCan_edit_gconforum(String str) {
                this.can_edit_gconforum = str;
            }

            public String getCan_op_as_4thmgr() {
                return this.can_op_as_4thmgr;
            }

            public void setCan_op_as_4thmgr(String str) {
                this.can_op_as_4thmgr = str;
            }

            public String getCan_post() {
                return this.can_post;
            }

            public void setCan_post(String str) {
                this.can_post = str;
            }

            public String getCan_post_pb() {
                return this.can_post_pb;
            }

            public void setCan_post_pb(String str) {
                this.can_post_pb = str;
            }

            public String getCan_post_frs() {
                return this.can_post_frs;
            }

            public void setCan_post_frs(String str) {
                this.can_post_frs = str;
            }

            public String getCan_tobe_manager() {
                return this.can_tobe_manager;
            }

            public void setCan_tobe_manager(String str) {
                this.can_tobe_manager = str;
            }

            public String getCan_tobe_assist() {
                return this.can_tobe_assist;
            }

            public void setCan_tobe_assist(String str) {
                this.can_tobe_assist = str;
            }

            public String getCan_tobe_editor() {
                return this.can_tobe_editor;
            }

            public void setCan_tobe_editor(String str) {
                this.can_tobe_editor = str;
            }

            public String getCan_paper_ignore_vcode() {
                return this.can_paper_ignore_vcode;
            }

            public void setCan_paper_ignore_vcode(String str) {
                this.can_paper_ignore_vcode = str;
            }

            public String getCan_op_topic() {
                return this.can_op_topic;
            }

            public void setCan_op_topic(String str) {
                this.can_op_topic = str;
            }

            public String getCan_member_top() {
                return this.can_member_top;
            }

            public void setCan_member_top(String str) {
                this.can_member_top = str;
            }

            public String getCan_view_freq() {
                return this.can_view_freq;
            }

            public void setCan_view_freq(String str) {
                this.can_view_freq = str;
            }

            public String getCan_op_as_operator() {
                return this.can_op_as_operator;
            }

            public void setCan_op_as_operator(String str) {
                this.can_op_as_operator = str;
            }

            public String getCan_op_as_editor() {
                return this.can_op_as_editor;
            }

            public void setCan_op_as_editor(String str) {
                this.can_op_as_editor = str;
            }

            public String getCan_op_as_vertical_operator() {
                return this.can_op_as_vertical_operator;
            }

            public void setCan_op_as_vertical_operator(String str) {
                this.can_op_as_vertical_operator = str;
            }

            public String getCan_op_as_profession_manager() {
                return this.can_op_as_profession_manager;
            }

            public void setCan_op_as_profession_manager(String str) {
                this.can_op_as_profession_manager = str;
            }

            public String getCan_add_celebrity() {
                return this.can_add_celebrity;
            }

            public void setCan_add_celebrity(String str) {
                this.can_add_celebrity = str;
            }

            public String getCan_op_as_broadcast_admin() {
                return this.can_op_as_broadcast_admin;
            }

            public void setCan_op_as_broadcast_admin(String str) {
                this.can_op_as_broadcast_admin = str;
            }

            public String getCan_op_as_category_editor() {
                return this.can_op_as_category_editor;
            }

            public void setCan_op_as_category_editor(String str) {
                this.can_op_as_category_editor = str;
            }

            public String getCan_op_as_entertainment_manager() {
                return this.can_op_as_entertainment_manager;
            }

            public void setCan_op_as_entertainment_manager(String str) {
                this.can_op_as_entertainment_manager = str;
            }

            public String getCan_toms_operator_basic() {
                return this.can_toms_operator_basic;
            }

            public void setCan_toms_operator_basic(String str) {
                this.can_toms_operator_basic = str;
            }

            public String getCan_toms_operator_alt_basic() {
                return this.can_toms_operator_alt_basic;
            }

            public void setCan_toms_operator_alt_basic(String str) {
                this.can_toms_operator_alt_basic = str;
            }
        }

        public static PermBeanX objectFromData(String str) {
            return (PermBeanX) new Gson().fromJson(str, PermBeanX.class);
        }

        public static List<PermBeanX> arrayPermBeanXFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PermBeanX>>() {
            }.getType());
        }

        public PermBean getPerm() {
            return this.perm;
        }

        public void setPerm(PermBean permBean) {
            this.perm = permBean;
        }

        public String getBlock_type() {
            return this.block_type;
        }

        public void setBlock_type(String str) {
            this.block_type = str;
        }

        public String getUeg_type() {
            return this.ueg_type;
        }

        public void setUeg_type(String str) {
            this.ueg_type = str;
        }

        public GradeBean getGrade() {
            return this.grade;
        }

        public void setGrade(GradeBean gradeBean) {
            this.grade = gradeBean;
        }
    }

    public static class PostBean {

        private List<?> arr_video;
        private AuthorBean author;
        private String bimg_url;
        private List<ContentBean> content;
        private String floor;
        private String id;
        private String ios_bimg_format;
        private String is_bubble_thread;
        private String is_colorfull_thread;
        private String is_voice;
        private String is_vote;
        private List<?> lbs_info;
        private String ptype;
        private String skin_info;
        private String time;
        private String title;
        private String tpoint_post;
        private List<?> voice_info;

        public static class AuthorBean {

            private String ala_info;
            private String bawu_type;
            private String gender;
            private String god_data;
            private String id;
            private String is_bawu;
            private String is_like;
            private String is_mem;
            private String level_id;
            private String name;
            private String name_show;
            private List<?> new_tshow_icon;
            private List<?> pendant;
            private String portrait;
            private String seal_prefix;
            private SpringVirtualUserBean spring_virtual_user;
            private List<?> tb_vip;
            private List<?> tshow_icon;
            private String type;

            private static class SpringVirtualUserBean {

                private String is_virtual;
                private String url;

                private SpringVirtualUserBean() {
                }

                public static SpringVirtualUserBean objectFromData(String str) {
                    return (SpringVirtualUserBean) new Gson().fromJson(str, SpringVirtualUserBean.class);
                }

                public String getIs_virtual() {
                    return this.is_virtual;
                }

                public void setIs_virtual(String str) {
                    this.is_virtual = str;
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

            public String getIs_mem() {
                return this.is_mem;
            }

            public void setIs_mem(String str) {
                this.is_mem = str;
            }

            public String getGod_data() {
                return this.god_data;
            }

            public void setGod_data(String str) {
                this.god_data = str;
            }

            public String getSeal_prefix() {
                return this.seal_prefix;
            }

            public void setSeal_prefix(String str) {
                this.seal_prefix = str;
            }

            public String getAla_info() {
                return this.ala_info;
            }

            public void setAla_info(String str) {
                this.ala_info = str;
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

            public SpringVirtualUserBean getSpring_virtual_user() {
                return this.spring_virtual_user;
            }

            public void setSpring_virtual_user(SpringVirtualUserBean springVirtualUserBean) {
                this.spring_virtual_user = springVirtualUserBean;
            }
        }

        public static class ContentBean {

            private String c;
            private String link;
            private String text;
            private String type;
            private String uid;

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

            public String getUid() {
                return this.uid;
            }

            public void setUid(String str) {
                this.uid = str;
            }

            public String getLink() {
                return this.link;
            }

            public void setLink(String str) {
                this.link = str;
            }
        }

        public static PostBean objectFromData(String str) {
            return (PostBean) new Gson().fromJson(str, PostBean.class);
        }

        public static List<PostBean> arrayPostBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PostBean>>() {
            }.getType());
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

        public String getTime() {
            return this.time;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public String getIs_vote() {
            return this.is_vote;
        }

        public void setIs_vote(String str) {
            this.is_vote = str;
        }

        public String getPtype() {
            return this.ptype;
        }

        public void setPtype(String str) {
            this.ptype = str;
        }

        public String getIs_voice() {
            return this.is_voice;
        }

        public void setIs_voice(String str) {
            this.is_voice = str;
        }

        public String getIs_bubble_thread() {
            return this.is_bubble_thread;
        }

        public void setIs_bubble_thread(String str) {
            this.is_bubble_thread = str;
        }

        public String getIs_colorfull_thread() {
            return this.is_colorfull_thread;
        }

        public void setIs_colorfull_thread(String str) {
            this.is_colorfull_thread = str;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
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

        public String getTpoint_post() {
            return this.tpoint_post;
        }

        public void setTpoint_post(String str) {
            this.tpoint_post = str;
        }

        public String getSkin_info() {
            return this.skin_info;
        }

        public void setSkin_info(String str) {
            this.skin_info = str;
        }

        public List<ContentBean> getContent() {
            return this.content;
        }

        public void setContent(List<ContentBean> list) {
            this.content = list;
        }

        public List<?> getLbs_info() {
            return this.lbs_info;
        }

        public void setLbs_info(List<?> list) {
            this.lbs_info = list;
        }

        public List<?> getVoice_info() {
            return this.voice_info;
        }

        public void setVoice_info(List<?> list) {
            this.voice_info = list;
        }

        public List<?> getArr_video() {
            return this.arr_video;
        }

        public void setArr_video(List<?> list) {
            this.arr_video = list;
        }
    }

    public static class SubpostListBean {

        private AuthorBeanXX author;
        private List<ContentBeanX> content;
        private String floor;
        private String id;
        private String is_giftpost;
        private String originPostView;
        private String ptype;
        private long time;
        private String title;
        private List<VoiceInfoBean> voice_info;

        public static class AuthorBeanXX {

            private String ala_info;
            private String gender;
            private String god_data;
            private String id;
            private String is_like;
            private String is_mem;
            private String level_id;
            private String name;
            private String name_show;
            private List<?> new_tshow_icon;
            private String portrait;
            private String seal_prefix;
            private List<?> tshow_icon;
            private String type;

            public static AuthorBeanXX objectFromData(String str) {
                return (AuthorBeanXX) new Gson().fromJson(str, AuthorBeanXX.class);
            }

            public static List<AuthorBeanXX> arrayAuthorBeanXXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AuthorBeanXX>>() {
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

            public String getGender() {
                return this.gender;
            }

            public void setGender(String str) {
                this.gender = str;
            }

            public String getIs_mem() {
                return this.is_mem;
            }

            public void setIs_mem(String str) {
                this.is_mem = str;
            }

            public String getGod_data() {
                return this.god_data;
            }

            public void setGod_data(String str) {
                this.god_data = str;
            }

            public String getSeal_prefix() {
                return this.seal_prefix;
            }

            public void setSeal_prefix(String str) {
                this.seal_prefix = str;
            }

            public String getAla_info() {
                return this.ala_info;
            }

            public void setAla_info(String str) {
                this.ala_info = str;
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
        }

        public static class ContentBeanX {

            private String c;
            private String link;
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

            public String getUid() {
                return this.uid;
            }

            public void setUid(String str) {
                this.uid = str;
            }

            public String getLink() {
                return this.link;
            }

            public void setLink(String str) {
                this.link = str;
            }

            public String getVoice_md5() {
                return this.voice_md5;
            }

            public void setVoice_md5(String str) {
                this.voice_md5 = str;
            }
        }

        public static class VoiceInfoBean {

            private String during_time;
            private String is_sub;
            private String type;
            private String voice_md5;

            public static VoiceInfoBean objectFromData(String str) {
                return (VoiceInfoBean) new Gson().fromJson(str, VoiceInfoBean.class);
            }

            public static List<VoiceInfoBean> arrayVoiceInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<VoiceInfoBean>>() {
                }.getType());
            }

            public String getType() {
                return this.type;
            }

            public void setType(String str) {
                this.type = str;
            }

            public String getDuring_time() {
                return this.during_time;
            }

            public void setDuring_time(String str) {
                this.during_time = str;
            }

            public String getVoice_md5() {
                return this.voice_md5;
            }

            public void setVoice_md5(String str) {
                this.voice_md5 = str;
            }

            public String getIs_sub() {
                return this.is_sub;
            }

            public void setIs_sub(String str) {
                this.is_sub = str;
            }
        }

        public static SubpostListBean objectFromData(String str) {
            return (SubpostListBean) new Gson().fromJson(str, SubpostListBean.class);
        }

        public static List<SubpostListBean> arraySubpostListBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SubpostListBean>>() {
            }.getType());
        }

        public String getOriginPostView() {
            return this.originPostView;
        }

        public void setOriginPostView(String str) {
            this.originPostView = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public String getPtype() {
            return this.ptype;
        }

        public void setPtype(String str) {
            this.ptype = str;
        }

        public String getIs_giftpost() {
            return this.is_giftpost;
        }

        public void setIs_giftpost(String str) {
            this.is_giftpost = str;
        }

        public AuthorBeanXX getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBeanXX authorBeanXX) {
            this.author = authorBeanXX;
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

        public List<ContentBeanX> getContent() {
            return this.content;
        }

        public void setContent(List<ContentBeanX> list) {
            this.content = list;
        }

        public List<VoiceInfoBean> getVoice_info() {
            return this.voice_info;
        }

        public void setVoice_info(List<VoiceInfoBean> list) {
            this.voice_info = list;
        }
    }

    public static class ThreadBean {

        private AuthorBeanX author;
        private String collect_mark_pid;
        private String collect_status;
        private String comment_num;
        private String ecom;
        private String id;
        private String isLzDeleteAll;
        private String is_ad;
        private String pids;
        private String reply_num;
        private String repost_num;
        private String thread_type;
        private String title;
        private TopicBean topic;
        private TwzhiboInfoBean twzhibo_info;
        private String valid_post_num;

        public static class AuthorBeanX {

            private String ala_info;
            private String id;
            private String is_like;
            private String is_mem;
            private String level_id;
            private String name;
            private String name_show;
            private List<?> new_tshow_icon;
            private String portrait;
            private List<?> tshow_icon;
            private String type;

            public static AuthorBeanX objectFromData(String str) {
                return (AuthorBeanX) new Gson().fromJson(str, AuthorBeanX.class);
            }

            public static List<AuthorBeanX> arrayAuthorBeanXFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<AuthorBeanX>>() {
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

            public String getIs_mem() {
                return this.is_mem;
            }

            public void setIs_mem(String str) {
                this.is_mem = str;
            }

            public String getAla_info() {
                return this.ala_info;
            }

            public void setAla_info(String str) {
                this.ala_info = str;
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
        }

        public static class TopicBean {

            private String is_live_post;
            private String is_lpost;
            private String is_topic;
            private String lpost_type;
            private String topic_type;

            public static TopicBean objectFromData(String str) {
                return (TopicBean) new Gson().fromJson(str, TopicBean.class);
            }

            public static List<TopicBean> arrayTopicBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TopicBean>>() {
                }.getType());
            }

            public String getIs_topic() {
                return this.is_topic;
            }

            public void setIs_topic(String str) {
                this.is_topic = str;
            }

            public String getTopic_type() {
                return this.topic_type;
            }

            public void setTopic_type(String str) {
                this.topic_type = str;
            }

            public String getIs_live_post() {
                return this.is_live_post;
            }

            public void setIs_live_post(String str) {
                this.is_live_post = str;
            }

            public String getIs_lpost() {
                return this.is_lpost;
            }

            public void setIs_lpost(String str) {
                this.is_lpost = str;
            }

            public String getLpost_type() {
                return this.lpost_type;
            }

            public void setLpost_type(String str) {
                this.lpost_type = str;
            }
        }

        public static class TwzhiboInfoBean {

            private String content;
            private String forumId;
            private String forumName;
            private String forum_id;
            private String forum_name;
            private String freqNum;
            private String freq_num;
            private String isHeadline;
            private String isNewHeadline;
            private String is_deleted;
            private String is_headline;
            private String is_new_headline;
            private List<?> labelInfo;
            private List<?> label_info;
            private List<?> labels;
            private String lastModifiedTime;
            private String lastPostId;
            private String last_modified_time;
            private String last_post_id;
            private String livecoverSrc;
            private String livecover_src;
            private List<MediaBean> media;
            private String postNum;
            private String post_num;
            private String raw_abstract_media;
            private String replyNum;
            private String reply_num;
            private String threadId;
            private String thread_id;
            private String title;
            private UserBean user;
            private String userId;
            private UserInfoBean userInfo;
            private String user_id;

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

            public static class UserBean {

                private String fansNickname;
                private String fansNum;
                private String fans_nickname;
                private String fans_num;
                private String id;
                private String name;
                private String portrait;
                private String userId;
                private String userName;

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

                public String getUserId() {
                    return this.userId;
                }

                public void setUserId(String str) {
                    this.userId = str;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public String getUserName() {
                    return this.userName;
                }

                public void setUserName(String str) {
                    this.userName = str;
                }

                public String getFansNum() {
                    return this.fansNum;
                }

                public void setFansNum(String str) {
                    this.fansNum = str;
                }

                public String getFans_num() {
                    return this.fans_num;
                }

                public void setFans_num(String str) {
                    this.fans_num = str;
                }

                public String getFansNickname() {
                    return this.fansNickname;
                }

                public void setFansNickname(String str) {
                    this.fansNickname = str;
                }

                public String getFans_nickname() {
                    return this.fans_nickname;
                }

                public void setFans_nickname(String str) {
                    this.fans_nickname = str;
                }

                public String getPortrait() {
                    return this.portrait;
                }

                public void setPortrait(String str) {
                    this.portrait = str;
                }
            }

            public static class UserInfoBean {

                private String fansNickname;
                private String fansNum;
                private String fans_nickname;
                private String fans_num;
                private String id;
                private String name;
                private String portrait;
                private String userId;
                private String userName;

                public static UserInfoBean objectFromData(String str) {
                    return (UserInfoBean) new Gson().fromJson(str, UserInfoBean.class);
                }

                public static List<UserInfoBean> arrayUserInfoBeanFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<UserInfoBean>>() {
                    }.getType());
                }

                public String getId() {
                    return this.id;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public String getUserId() {
                    return this.userId;
                }

                public void setUserId(String str) {
                    this.userId = str;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public String getUserName() {
                    return this.userName;
                }

                public void setUserName(String str) {
                    this.userName = str;
                }

                public String getFansNum() {
                    return this.fansNum;
                }

                public void setFansNum(String str) {
                    this.fansNum = str;
                }

                public String getFans_num() {
                    return this.fans_num;
                }

                public void setFans_num(String str) {
                    this.fans_num = str;
                }

                public String getFansNickname() {
                    return this.fansNickname;
                }

                public void setFansNickname(String str) {
                    this.fansNickname = str;
                }

                public String getFans_nickname() {
                    return this.fans_nickname;
                }

                public void setFans_nickname(String str) {
                    this.fans_nickname = str;
                }

                public String getPortrait() {
                    return this.portrait;
                }

                public void setPortrait(String str) {
                    this.portrait = str;
                }
            }

            public static TwzhiboInfoBean objectFromData(String str) {
                return (TwzhiboInfoBean) new Gson().fromJson(str, TwzhiboInfoBean.class);
            }

            public static List<TwzhiboInfoBean> arrayTwzhiboInfoBeanFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<TwzhiboInfoBean>>() {
                }.getType());
            }

            public String getThreadId() {
                return this.threadId;
            }

            public void setThreadId(String str) {
                this.threadId = str;
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

            public String getContent() {
                return this.content;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public String getUserId() {
                return this.userId;
            }

            public void setUserId(String str) {
                this.userId = str;
            }

            public String getUser_id() {
                return this.user_id;
            }

            public void setUser_id(String str) {
                this.user_id = str;
            }

            public String getRaw_abstract_media() {
                return this.raw_abstract_media;
            }

            public void setRaw_abstract_media(String str) {
                this.raw_abstract_media = str;
            }

            public String getReplyNum() {
                return this.replyNum;
            }

            public void setReplyNum(String str) {
                this.replyNum = str;
            }

            public String getReply_num() {
                return this.reply_num;
            }

            public void setReply_num(String str) {
                this.reply_num = str;
            }

            public String getForumId() {
                return this.forumId;
            }

            public void setForumId(String str) {
                this.forumId = str;
            }

            public String getForum_id() {
                return this.forum_id;
            }

            public void setForum_id(String str) {
                this.forum_id = str;
            }

            public String getForumName() {
                return this.forumName;
            }

            public void setForumName(String str) {
                this.forumName = str;
            }

            public String getForum_name() {
                return this.forum_name;
            }

            public void setForum_name(String str) {
                this.forum_name = str;
            }

            public String getLivecoverSrc() {
                return this.livecoverSrc;
            }

            public void setLivecoverSrc(String str) {
                this.livecoverSrc = str;
            }

            public String getLivecover_src() {
                return this.livecover_src;
            }

            public void setLivecover_src(String str) {
                this.livecover_src = str;
            }

            public String getLastModifiedTime() {
                return this.lastModifiedTime;
            }

            public void setLastModifiedTime(String str) {
                this.lastModifiedTime = str;
            }

            public String getLast_modified_time() {
                return this.last_modified_time;
            }

            public void setLast_modified_time(String str) {
                this.last_modified_time = str;
            }

            public String getLastPostId() {
                return this.lastPostId;
            }

            public void setLastPostId(String str) {
                this.lastPostId = str;
            }

            public String getLast_post_id() {
                return this.last_post_id;
            }

            public void setLast_post_id(String str) {
                this.last_post_id = str;
            }

            public String getFreqNum() {
                return this.freqNum;
            }

            public void setFreqNum(String str) {
                this.freqNum = str;
            }

            public String getFreq_num() {
                return this.freq_num;
            }

            public void setFreq_num(String str) {
                this.freq_num = str;
            }

            public String getIs_deleted() {
                return this.is_deleted;
            }

            public void setIs_deleted(String str) {
                this.is_deleted = str;
            }

            public UserBean getUser() {
                return this.user;
            }

            public void setUser(UserBean userBean) {
                this.user = userBean;
            }

            public UserInfoBean getUserInfo() {
                return this.userInfo;
            }

            public void setUserInfo(UserInfoBean userInfoBean) {
                this.userInfo = userInfoBean;
            }

            public String getPostNum() {
                return this.postNum;
            }

            public void setPostNum(String str) {
                this.postNum = str;
            }

            public String getPost_num() {
                return this.post_num;
            }

            public void setPost_num(String str) {
                this.post_num = str;
            }

            public String getIsHeadline() {
                return this.isHeadline;
            }

            public void setIsHeadline(String str) {
                this.isHeadline = str;
            }

            public String getIs_headline() {
                return this.is_headline;
            }

            public void setIs_headline(String str) {
                this.is_headline = str;
            }

            public String getIsNewHeadline() {
                return this.isNewHeadline;
            }

            public void setIsNewHeadline(String str) {
                this.isNewHeadline = str;
            }

            public String getIs_new_headline() {
                return this.is_new_headline;
            }

            public void setIs_new_headline(String str) {
                this.is_new_headline = str;
            }

            public List<MediaBean> getMedia() {
                return this.media;
            }

            public void setMedia(List<MediaBean> list) {
                this.media = list;
            }

            public List<?> getLabels() {
                return this.labels;
            }

            public void setLabels(List<?> list) {
                this.labels = list;
            }

            public List<?> getLabel_info() {
                return this.label_info;
            }

            public void setLabel_info(List<?> list) {
                this.label_info = list;
            }

            public List<?> getLabelInfo() {
                return this.labelInfo;
            }

            public void setLabelInfo(List<?> list) {
                this.labelInfo = list;
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

        public String getValid_post_num() {
            return this.valid_post_num;
        }

        public void setValid_post_num(String str) {
            this.valid_post_num = str;
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

        public String getComment_num() {
            return this.comment_num;
        }

        public void setComment_num(String str) {
            this.comment_num = str;
        }

        public String getIsLzDeleteAll() {
            return this.isLzDeleteAll;
        }

        public void setIsLzDeleteAll(String str) {
            this.isLzDeleteAll = str;
        }

        public String getIs_ad() {
            return this.is_ad;
        }

        public void setIs_ad(String str) {
            this.is_ad = str;
        }

        public String getEcom() {
            return this.ecom;
        }

        public void setEcom(String str) {
            this.ecom = str;
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

        public TopicBean getTopic() {
            return this.topic;
        }

        public void setTopic(TopicBean topicBean) {
            this.topic = topicBean;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getPids() {
            return this.pids;
        }

        public void setPids(String str) {
            this.pids = str;
        }

        public TwzhiboInfoBean getTwzhibo_info() {
            return this.twzhibo_info;
        }

        public void setTwzhibo_info(TwzhiboInfoBean twzhiboInfoBean) {
            this.twzhibo_info = twzhiboInfoBean;
        }

        public AuthorBeanX getAuthor() {
            return this.author;
        }

        public void setAuthor(AuthorBeanX authorBeanX) {
            this.author = authorBeanX;
        }
    }

    public static SubPostBean objectFromData(String str) {
        return (SubPostBean) new Gson().fromJson(str, SubPostBean.class);
    }

    public static List<SubPostBean> arraySubPostBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SubPostBean>>() {
        }.getType());
    }

    public PostBean getPost() {
        return this.post;
    }

    public void setPost(PostBean postBean) {
        this.post = postBean;
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

    public ForumBean getForum() {
        return this.forum;
    }

    public void setForum(ForumBean forumBean) {
        this.forum = forumBean;
    }

    public PermBeanX getPerm() {
        return this.perm;
    }

    public void setPerm(PermBeanX permBeanX) {
        this.perm = permBeanX;
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

    public List<SubpostListBean> getSubpost_list() {
        return this.subpost_list;
    }

    public void setSubpost_list(List<SubpostListBean> list) {
        this.subpost_list = list;
    }

    public List<?> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<?> list) {
        this.post_list = list;
    }

    public List<?> getUser() {
        return this.user;
    }

    public void setUser(List<?> list) {
        this.user = list;
    }
}
