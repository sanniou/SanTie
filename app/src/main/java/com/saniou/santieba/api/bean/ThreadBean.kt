package com.saniou.santieba.api.bean


data class Thread(
    val `abstract`: List<Abstract>,
    val agree: Agree,
    val agree_num: String,
    val author: Author,
    val comment_num: String,
    val create_time: String,
    val disagree_num: String,
    val fid: String,
    val first_post_id: String,
    val id: String,
    val is_activity: String,
    val is_bakan: String,
    val is_book_chapter: String,
    val is_bub: String,
    val is_good: Int,
    val is_livepost: Int,
    val is_meizhi: String,
    val is_membertop: String,
    val is_notice: String,
    val is_novel: String,
    val is_novel_reward: String,
    val is_novel_thank: String,
    val is_ntitle: String,
    val is_partial_visible: String,
    val is_pro_thread: String,
    val is_protal: String,
    val is_top: Int,
    val is_uegnaudited: String,
    val is_voice_thread: String,
    val is_vote: String,
    val last_replyer: LastReplyer,
    val last_time: String,
    val last_time_int: String,
    val media: List<Media>,
    val media_num: String,
    val meizhi_pic: String,
    val original_tid: String,
    val reply_num: String,
    val share_num: String,
    val thread_id: String,
    val thread_type: String,
    val thread_types: String,
    val tid: String,
    val title: String,
    val top_agree_post_id: String,
    val view_num: String
)

data class Media(
    val type: String,
    val show_original_btn: String,
    val is_long_pic: String,
    val big_pic: String,
    val src_pic: String,
    val origin_pic: String,
    val origin_size: String,
    val post_id: String
)

data class Author(
    val gender: String,
    val god_data: String,
    val is_like: String,
    val level_id: String,
    val uk: String,
    val bawu_type: String,
    val fans_nickname: String,
    val id: String,
    val is_bawu: String,
    val is_interestman: String,
    val is_mem: String,
    val is_verify: String,
    val is_videobiggie: String,
    val meizhi_level: String,
    val name: String,
    val name_show: String,
    val portrait: String,
    val seal_prefix: String,
    val sex: String,
    val type: String
)

data class LastReplyer(
    val id: String,
    val is_verify: String,
    val name: String,
    val name_show: String,
    val type: String
)

data class Agree(
    val agree_num: String,
    val agree_type: String,
    val diff_agree_num: String,
    val disagree_num: String,
    val has_agree: String
)

data class Abstract(
    val text: String,
    val type: String
)

data class Anti(
    val block_pop_info: BlockPopInfo,
    val block_stat: String,
    val days_tofree: String,
    val del_thread_text: List<DelThreadText>,
    val forbid_flag: String,
    val forbid_info: String,
    val has_chance: String,
    val hide_stat: String,
    val ifpost: String,
    val ifposta: String,
    val ifvoice: String,
    val ifxiaoying: String,
    val multi_delthread: String,
    val poll_message: String,
    val tbs: String,
    val vcode_stat: String,
    val video_local_message: String,
    val video_message: String,
    val voice_message: String,
    val ifaddition: String,
    val reply_private_flag: String
)

data class BlockPopInfo(
    val ahead_info: String,
    val ahead_type: String,
    val ahead_url: String,
    val appeal_msg: String,
    val appeal_status: String,
    val block_info: String,
    val can_post: String,
    val ok_info: String
)

data class DelThreadText(
    val text_id: String,
    val text_info: String
)

data class FrsStar(
    val has_frs_star: String
)

data class Page(
    val cur_good_id: String,
    val current_page: String,
    val total_count: String,
    val has_more: Int,
    val has_prev: String,
    val new_total_page: String,
    val offset: String,
    val page_size: Int,
    val pnum: String,
    val req_num: String,
    val tnum: String,
    val total_num: String,
    val total_page: String
)

data class UserExtend(
    val tips: String,
    val user_extend_storey: String
)

data class FrsTabInfo(
    val tab_id: String,
    val tab_name: String,
    val tab_type: String,
    val tab_url: String
)

data class PrivateForumActiveInfo(
    val forum_brief: String,
    val forum_share_url: String
)

data class GconAccount(
    val has_account: String,
    val menu_name: String
)

data class Forum(
    val accelerate_cotent: String,
    val album_open_photo_frs: String,
    val anchor_power: AnchorPower,
    val avatar: String,
    val cur_score: String,
    val first_class: String,
    val forum_button: ForumButton,
    val forum_game_label: String,
    val good_classify: List<GoodClassify>,
    val has_frs_star: String,
    val has_game: String,
    val id: String,
    val is_exists: String,
    val is_like: Int,
    val is_live_game_forum: String,
    val is_new_game_forum: String,
    val is_readonly: String,
    val is_search_people: String,
    val is_show_all_top_thread: String,
    val is_stage_forum: String,
    val level_id: String,
    val level_name: String,
    val levelup_score: String,
    val managers: List<Manager>,
    val member_num: String,
    val name: String,
    val post_num: String,
    val second_class: String,
    val sign_in_info: SignInInfo,
    val slogan: String,
    val tag_info: TagInfo,
    val theme_color: ThemeColor,
    val thread_num: String,
    val tids: String,
    val user_level: String
)

data class GoodClassify(
    val class_id: String,
    val class_name: String,
    val id: String,
    val name: String
)

data class ForumvipShowIcon(
    val icon: String,
    val name: String,
    val url: String
)

data class ForumButton(
    val is_blueV: String
)

data class SignInInfo(
    val forum_info: ForumInfo,
    val user_info: UserInfo
)

data class ForumInfo(
    val current_rank_info: CurrentRankInfo,
    val forum_info: ForumInfoX,
    val is_filter: String,
    val is_on: String,
    val level_1_dir_name: String,
    val level_2_dir_name: String,
    val monthly_rank_info: MonthlyRankInfo,
    val weekly_rank_info: WeeklyRankInfo,
    val yesterday_rank_info: YesterdayRankInfo
)

data class WeeklyRankInfo(
    val member_count: String,
    val sign_count: String,
    val sign_rank: String
)

data class YesterdayRankInfo(
    val dir_rate: String,
    val member_count: String,
    val sign_count: String,
    val sign_rank: String
)

data class ForumInfoX(
    val forum_id: String,
    val level_1_dir_name: String
)

data class MonthlyRankInfo(
    val member_count: String,
    val sign_count: String,
    val sign_rank: String
)

data class CurrentRankInfo(
    val dir_rate: String,
    val member_count: String,
    val sign_count: String,
    val sign_rank: String
)

data class UserInfo(
    val c_sign_num: String,
    val cont_sign_num: String,
    val cout_total_sing_num: String,
    val hun_sign_num: String,
    val is_org_disabled: String,
    val is_sign_in: Int,
    val miss_sign_num: String,
    val sign_time: String,
    val total_resign_num: String,
    val user_id: String,
    val user_sign_rank: String
)


data class TagInfo(
    val color: String,
    val tag_id: String,
    val tag_name: String
)

data class AnchorPower(
    val anchor_message: String,
    val have_power: String
)

data class Manager(
    val id: String,
    val name: String
)

data class StarEnter(
    val icon: String,
    val time: String,
    val title: String,
    val type: String,
    val url: String,
    val weight: String
)

data class User(
    val balv: Balv,
    val bawu_type: String,
    val bimg_url: String,
    val id: String,
    val ios_bimg_format: String,
    val is_bawu: String,
    val is_login: String,
    val is_manager: String,
    val is_mem: String,
    val is_select_tail: String,
    val name: String,
    val name_show: String,
    val new_user_info: NewUserInfo,
    val no_un: String,
    val portrait: String,
    val priv_thread: String,
    val type: String,
    val userhide: String
)

data class NewUserInfo(
    val Parr_scores: ParrScores,
    val card: Card,
    val cdn_error: String,
    val display_name: String,
    val duty: String,
    val free_flag: String,
    val global: Global,
    val heavy_user: String,
    val is_friend_imported: String,
    val is_group_owner: String,
    val is_hardworking: String,
    val is_tenyear: String,
    val lbs: Lbs,
    val meizhi_level: String,
    val new_active_forum: List<NewActiveForum>,
    val paper: String,
    val portrait_time: String,
//        val priv_sets: PrivSets,
    val score_card: String,
    val superboy: String,
    val tbguess_card: TbguessCard,
    val tbscore_repeate_finish_time: String,
    val ueg_profile: String,
    val use_sig: String,
    val user_id: String,
    val user_name: String,
    val user_sex: String,
    val user_status: String,
    val user_type: String,
    val wap_rn: WapRn
)

data class TbguessCard(
    val card_id: String,
    val card_type: String,
    val scores: String
)

data class WapRn(
    val frsrn: String,
    val pbrn: String
)

data class ParrScores(
    val level: String,
    val limit: String,
    val scores_fetch: String,
    val scores_money: String,
    val scores_other: String,
    val scores_total: String,
    val update_time: String
)

data class Card(
    val good_num: String,
    val is_novice: String,
    val manager_info: ManagerInfo,
    val op_time: String,
    val post_num: String
)

data class ManagerInfo(
    val assist: Assist,
    val manager: ManagerX,
    val profession_manager: ProfessionManager
)

data class ProfessionManager(
    val count: String
)

data class Assist(
    val count: String
)

data class ManagerX(
    val count: String,
    val forum_list: List<String>
)


data class Lbs(
    val lat: String,
    val lng: String,
    val time: String
)

data class NewActiveForum(
    val fid: String,
    val fname: String
)

data class Global(
    val tbmall_newprops: String
)

data class Balv(
    val days_tofree: String,
    val is_black: String,
    val is_block: String
)

data class Bottle(
    val has_enter_display: String,
    val tid: String
)