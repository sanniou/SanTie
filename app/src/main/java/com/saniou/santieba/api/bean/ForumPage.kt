package com.saniou.santieba.api.bean

import com.saniou.santieba.api.TiebaRequest
import com.sanniou.support.moshi.IgnoreJsonString2Json
import com.sanniou.support.moshi.IgnoreString2Object
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForumPage(
    @Json(name = "agree_banner")
    val agreeBanner: AgreeBanner = AgreeBanner(),
    @Json(name = "ala_stage_list")
    val alaStageList: List<Any> = listOf(),
    @Json(name = "anti")
    val anti: Anti = Anti(),
    @Json(name = "asp_shown_info")
    val aspShownInfo: String = "",
    @Json(name = "banner_thread_list")
    val bannerThreadList: List<Any> = listOf(),
    @Json(name = "business_promot")
    val businessPromot: List<Any> = listOf(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "filter_swan_thread")
    val filterSwanThread: String = "",
    @Json(name = "fortune_bag")
    val fortuneBag: String = "",
    @Json(name = "fortune_desc")
    val fortuneDesc: String = "",
    @Json(name = "forum")
    val forum: Forum = Forum(),
    @Json(name = "frs_star")
    val frsStar: FrsStar = FrsStar(),
    @Json(name = "frs_tab_default")
    val frsTabDefault: String = "",
    @Json(name = "frs_tab_info")
    val frsTabInfo: List<FrsTabInfo> = listOf(),
    @Json(name = "game_default_tab_id")
    val gameDefaultTabId: String = "",
    @Json(name = "gcon_account")
    val gconAccount: GconAccount = GconAccount(),
    @Json(name = "is_new_url")
    val isNewUrl: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "need_log")
    val needLog: String = "",
    @Json(name = "page")
    val page: Page = Page(),
    @Json(name = "partial_visible_toast")
    val partialVisibleToast: String = "",
    @Json(name = "private_forum_active_info")
    val privateForumActiveInfo: PrivateForumActiveInfo = PrivateForumActiveInfo(),
    @Json(name = "recom_post_topic")
    val recomPostTopic: List<Any> = listOf(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "smart_app_avatar")
    val smartAppAvatar: List<Any> = listOf(),
    @Json(name = "sort_type")
    val sortType: String = "",
    @Json(name = "star_enter")
    val starEnter: List<StarEnter> = listOf(),
    @Json(name = "thread_id_list")
    val threadIdList: List<Any> = listOf(),
    @Json(name = "thread_list")
    val threadList: List<Thread> = listOf(),
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "twzhibo_pos")
    val twzhiboPos: String = "",
    @Json(name = "user")
    val user: User = User(),
    @Json(name = "user_extend")
    val userExtend: UserExtend = UserExtend(),
    @Json(name = "video_auto_play")
    val videoAutoPlay: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class AgreeBanner(
        @Json(name = "icon_url")
        val iconUrl: String = "",
        @Json(name = "text")
        val text: String = "",
        @Json(name = "top_agree_user")
        val topAgreeUser: List<TopAgreeUser> = listOf(),
        @Json(name = "url")
        val url: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class TopAgreeUser(
            @Json(name = "agree_num")
            val agreeNum: String = "",
            @Json(name = "gender")
            val gender: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "rank")
            val rank: String = "",
            @Json(name = "user_id")
            val userId: String = "",
            @Json(name = "user_name")
            val userName: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Anti(
        @Json(name = "block_pop_info")
        val blockPopInfo: BlockPopInfo = BlockPopInfo(),
        @Json(name = "block_stat")
        val blockStat: String = "",
        @Json(name = "days_tofree")
        val daysTofree: String = "",
        @Json(name = "del_thread_text")
        val delThreadText: List<DelThreadText> = listOf(),
        @Json(name = "forbid_flag")
        val forbidFlag: String = "",
        @Json(name = "forbid_info")
        val forbidInfo: String = "",
        @Json(name = "has_chance")
        val hasChance: String = "",
        @Json(name = "hide_stat")
        val hideStat: String = "",
        @Json(name = "ifpost")
        val ifpost: String = "",
        @Json(name = "ifposta")
        val ifposta: String = "",
        @Json(name = "ifvoice")
        val ifvoice: String = "",
        @Json(name = "ifxiaoying")
        val ifxiaoying: String = "",
        @Json(name = "multi_delthread")
        val multiDelthread: String = "",
        @Json(name = "poll_message")
        val pollMessage: String = "",
        @Json(name = "tbs")
        val tbs: String = "",
        @Json(name = "vcode_stat")
        val vcodeStat: String = "",
        @Json(name = "video_local_message")
        val videoLocalMessage: String = "",
        @Json(name = "video_message")
        val videoMessage: String = "",
        @Json(name = "voice_message")
        val voiceMessage: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class BlockPopInfo(
            @Json(name = "ahead_info")
            val aheadInfo: String = "",
            @Json(name = "ahead_type")
            val aheadType: String = "",
            @Json(name = "ahead_url")
            val aheadUrl: String = "",
            @Json(name = "appeal_msg")
            val appealMsg: String = "",
            @Json(name = "appeal_status")
            val appealStatus: String = "",
            @Json(name = "block_info")
            val blockInfo: String = "",
            @Json(name = "can_post")
            val canPost: String = "",
            @Json(name = "ok_info")
            val okInfo: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class DelThreadText(
            @Json(name = "text_id")
            val textId: String = "",
            @Json(name = "text_info")
            val textInfo: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Forum(
        @Json(name = "accelerate_cotent")
        val accelerateCotent: String = "",
        @Json(name = "album_open_photo_frs")
        val albumOpenPhotoFrs: String = "",
        @Json(name = "anchor_power")
        val anchorPower: AnchorPower = AnchorPower(),
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "badges")
        val badges: List<Any> = listOf(),
        @Json(name = "banner")
        val banner: List<Any> = listOf(),
        @Json(name = "banner_list")
        val bannerList: BannerList = BannerList(),
        @Json(name = "can_use_accelerate")
        val canUseAccelerate: String = "",
        @Json(name = "cur_score")
        val curScore: String = "",
        @Json(name = "f_share_img")
        val fShareImg: String = "",
        @Json(name = "first_class")
        val firstClass: String = "",
        @Json(name = "forum_button")
        val forumButton: ForumButton = ForumButton(),
        @Json(name = "forum_game_label")
        val forumGameLabel: String = "",
        @Json(name = "forum_sign_calendar")
        val forumSignCalendar: List<Any> = listOf(),
        @Json(name = "forumvip_show_icon")
        val forumvipShowIcon: ForumvipShowIcon = ForumvipShowIcon(),
        @Json(name = "game_card")
        val gameCard: List<Any> = listOf(),
        @Json(name = "good_classify")
        val goodClassify: List<GoodClassify> = listOf(),
        @Json(name = "has_frs_star")
        val hasFrsStar: String = "",
        @Json(name = "has_game")
        val hasGame: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_exists")
        val isExists: String = "",
        @Json(name = "is_like")
        val isLike: String = "",
        @Json(name = "is_live_game_forum")
        val isLiveGameForum: String = "",
        @Json(name = "is_new_game_forum")
        val isNewGameForum: String = "",
        @Json(name = "is_readonly")
        val isReadonly: String = "",
        @Json(name = "is_search_people")
        val isSearchPeople: String = "",
        @Json(name = "is_show_all_top_thread")
        val isShowAllTopThread: String = "",
        @Json(name = "is_stage_forum")
        val isStageForum: String = "",
        @Json(name = "level_id")
        val levelId: String = "",
        @Json(name = "level_name")
        val levelName: String = "",
        @Json(name = "levelup_score")
        val levelupScore: String = "",
        @Json(name = "managers")
        val managers: List<Manager> = listOf(),
        @Json(name = "member_num")
        val memberNum: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "post_num")
        val postNum: String = "",
        @Json(name = "second_class")
        val secondClass: String = "",
        @Json(name = "sign_in_info")
        val signInInfo: SignInInfo = SignInInfo(),
        @Json(name = "slogan")
        val slogan: String = "",
        @Json(name = "tag_info")
        val tagInfo: TagInfo = TagInfo(),
        @Json(name = "theme_color")
        val themeColor: ThemeColor = ThemeColor(),
        @Json(name = "thread_num")
        val threadNum: String = "",
        @Json(name = "tids")
        val tids: String = "",
        @Json(name = "top_notice")
        val topNotice: List<Any> = listOf(),
        @Json(name = "user_level")
        val userLevel: String = "",
        @Json(name = "zhibo")
        val zhibo: Zhibo = Zhibo()
    ) {
        @JsonClass(generateAdapter = true)
        data class AnchorPower(
            @Json(name = "anchor_message")
            val anchorMessage: String = "",
            @Json(name = "have_power")
            val havePower: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class BannerList(
            @Json(name = "app")
            val app: List<Any> = listOf()
        )

        @JsonClass(generateAdapter = true)
        data class ForumButton(
            @Json(name = "is_blueV")
            val isBlueV: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class ForumvipShowIcon(
            @Json(name = "icon")
            val icon: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "url")
            val url: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class GoodClassify(
            @Json(name = "class_id")
            val classId: String = "",
            @Json(name = "class_name")
            val className: String = "",
            @Json(name = "id")
            val id: String = "",
            @Json(name = "name")
            val name: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Manager(
            @Json(name = "id")
            val id: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "show_name")
            val showName: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class SignInInfo(
            @Json(name = "forum_info")
            val forumInfo: ForumInfo = ForumInfo(),
            @Json(name = "user_info")
            val userInfo: UserInfo = UserInfo()
        ) {
            @JsonClass(generateAdapter = true)
            data class ForumInfo(
                @Json(name = "current_rank_info")
                val currentRankInfo: CurrentRankInfo = CurrentRankInfo(),
                @Json(name = "forum_info")
                val forumInfo: ForumInfoX = ForumInfoX(),
                @Json(name = "is_filter")
                val isFilter: String = "",
                @Json(name = "is_on")
                val isOn: String = "",
                @Json(name = "level_1_dir_name")
                val level1DirName: String = "",
                @Json(name = "level_2_dir_name")
                val level2DirName: String = "",
                @Json(name = "monthly_rank_info")
                val monthlyRankInfo: MonthlyRankInfo = MonthlyRankInfo(),
                @Json(name = "weekly_rank_info")
                val weeklyRankInfo: WeeklyRankInfo = WeeklyRankInfo(),
                @Json(name = "yesterday_rank_info")
                val yesterdayRankInfo: YesterdayRankInfo = YesterdayRankInfo()
            ) {
                @JsonClass(generateAdapter = true)
                data class CurrentRankInfo(
                    @Json(name = "dir_rate")
                    val dirRate: String = "",
                    @Json(name = "member_count")
                    val memberCount: String = "",
                    @Json(name = "sign_count")
                    val signCount: String = "",
                    @Json(name = "sign_rank")
                    val signRank: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class ForumInfoX(
                    @Json(name = "forum_id")
                    val forumId: String = "",
                    @Json(name = "level_1_dir_name")
                    val level1DirName: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class MonthlyRankInfo(
                    @Json(name = "member_count")
                    val memberCount: String = "",
                    @Json(name = "sign_count")
                    val signCount: String = "",
                    @Json(name = "sign_rank")
                    val signRank: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class WeeklyRankInfo(
                    @Json(name = "member_count")
                    val memberCount: String = "",
                    @Json(name = "sign_count")
                    val signCount: String = "",
                    @Json(name = "sign_rank")
                    val signRank: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class YesterdayRankInfo(
                    @Json(name = "dir_rate")
                    val dirRate: String = "",
                    @Json(name = "member_count")
                    val memberCount: String = "",
                    @Json(name = "sign_count")
                    val signCount: String = "",
                    @Json(name = "sign_rank")
                    val signRank: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class UserInfo(
                @Json(name = "c_sign_num")
                val cSignNum: Int = 0,
                @Json(name = "cont_sign_num")
                val contSignNum: String = "",
                @Json(name = "cout_total_sing_num")
                val coutTotalSingNum: String = "",
                @Json(name = "hun_sign_num")
                val hunSignNum: String = "",
                @Json(name = "is_org_disabled")
                val isOrgDisabled: String = "",
                @Json(name = "is_sign_in")
                val isSignIn: String = "",
                @Json(name = "miss_sign_num")
                val missSignNum: String = "",
                @Json(name = "sign_time")
                val signTime: String = "",
                @Json(name = "total_resign_num")
                val totalResignNum: String = "",
                @Json(name = "user_id")
                val userId: String = "",
                @Json(name = "user_sign_rank")
                val userSignRank: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class TagInfo(
            @Json(name = "color")
            val color: String = "",
            @Json(name = "forum_id")
            val forumId: String = "",
            @Json(name = "hot_value")
            val hotValue: String = "",
            @Json(name = "influence")
            val influence: String = "",
            @Json(name = "op_time")
            val opTime: String = "",
            @Json(name = "relation_weight")
            val relationWeight: String = "",
            @Json(name = "tag_id")
            val tagId: String = "",
            @Json(name = "tag_level")
            val tagLevel: String = "",
            @Json(name = "tag_name")
            val tagName: String = "",
            @Json(name = "tag_type")
            val tagType: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class ThemeColor(
            @Json(name = "dark")
            val dark: Dark = Dark(),
            @Json(name = "day")
            val day: Day = Day(),
            @Json(name = "night")
            val night: Night = Night()
        ) {
            @JsonClass(generateAdapter = true)
            data class Dark(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = "",
                @Json(name = "pattern_image")
                val patternImage: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Day(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = "",
                @Json(name = "pattern_image")
                val patternImage: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Night(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = "",
                @Json(name = "pattern_image")
                val patternImage: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class Zhibo(
            @Json(name = "forum")
            val forum: String = "",
            @Json(name = "has_lpost")
            val hasLpost: String = "",
            @Json(name = "int1")
            val int1: String = "",
            @Json(name = "lpost_type")
            val lpostType: String = "",
            @Json(name = "status")
            val status: String = "",
            @Json(name = "tid")
            val tid: String = "",
            @Json(name = "type")
            val type: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class FrsStar(
        @Json(name = "has_frs_star")
        val hasFrsStar: String = "",
        @Json(name = "trade")
        val trade: List<Any> = listOf()
    )

    @JsonClass(generateAdapter = true)
    data class FrsTabInfo(
        @Json(name = "tab_id")
        val tabId: String = "",
        @Json(name = "tab_name")
        val tabName: String = "",
        @Json(name = "tab_type")
        val tabType: String = "",
        @Json(name = "tab_url")
        val tabUrl: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class GconAccount(
        @Json(name = "has_account")
        val hasAccount: String = "",
        @Json(name = "menu_name")
        val menuName: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Page(
        @Json(name = "cur_good_id")
        val curGoodId: String = "",
        @Json(name = "current_page")
        val currentPage: String = "",
        @Json(name = "has_more")
        val hasMore: String = "",
        @Json(name = "has_prev")
        val hasPrev: String = "",
        @Json(name = "offset")
        val offset: String = "",
        @Json(name = "page_size")
        val pageSize: String = "",
        @Json(name = "total_count")
        val totalCount: String = "",
        @Json(name = "total_page")
        val totalPage: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class PrivateForumActiveInfo(
        @Json(name = "forum_brief")
        val forumBrief: String = "",
        @Json(name = "forum_share_url")
        val forumShareUrl: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class VideoInfo(
        @Json(name = "auditing")
        val auditing: String = "",
        @Json(name = "format_matched")
        val formatMatched: String = "",
        @Json(name = "is_vertical")
        val isVertical: String = "",
        @Json(name = "origin_video_url")
        val originVideoUrl: String = "",
        @Json(name = "play_count")
        val playCount: String = "",
        @Json(name = "thumbnail_height")
        val thumbnailHeight: String = "",
        @Json(name = "thumbnail_picid")
        val thumbnailPicid: String = "",
        @Json(name = "thumbnail_url")
        val thumbnailUrl: String = "",
        @Json(name = "thumbnail_width")
        val thumbnailWidth: String = "",
        @Json(name = "video_desc")
        val videoDesc: List<VideoDesc> = listOf(),
        @Json(name = "video_duration")
        val videoDuration: String = "",
        @Json(name = "video_format")
        val videoFormat: String = "",
        @Json(name = "video_from")
        val videoFrom: String = "",
        @Json(name = "video_height")
        val videoHeight: String = "",
        @Json(name = "video_length")
        val videoLength: String = "",
        @Json(name = "video_log_id")
        val videoLogId: String = "",
        @Json(name = "video_md5")
        val videoMd5: String = "",
        @Json(name = "video_type")
        val videoType: String = "",
        @Json(name = "video_url")
        val videoUrl: String = "",
        @Json(name = "video_width")
        val videoWidth: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class VideoDesc(
            @Json(name = "video_height")
            val videoHeight: String = "",
            @Json(name = "video_id")
            val videoId: String = "",
            @Json(name = "video_size")
            val videoSize: String = "",
            @Json(name = "video_url")
            val videoUrl: String = "",
            @Json(name = "video_width")
            val videoWidth: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class StarEnter(
        @Json(name = "icon")
        val icon: String = "",
        @Json(name = "time")
        val time: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "type")
        val type: String = "",
        @Json(name = "url")
        val url: String = "",
        @Json(name = "weight")
        val weight: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Thread(
        @Json(name = "abstract")
        val `abstract`: List<Abstract> = listOf(),
        @Json(name = "agree")
        val agree: Agree = Agree(),
        @Json(name = "agree_num")
        val agreeNum: String = "",
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "book_chapter")
        val bookChapter: List<Any> = listOf(),
        @Json(name = "comment_num")
        val commentNum: String = "",
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "disagree_num")
        val disagreeNum: String = "",
        @Json(name = "fid")
        val fid: String = "",
        @Json(name = "video_info")
        val videoInfo: VideoInfo = VideoInfo(),
        @Json(name = "first_post_content")
        val firstPostContent: List<FirstPostContent> = listOf(),
        @Json(name = "first_post_id")
        val firstPostId: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_activity")
        val isActivity: String = "",
        @Json(name = "is_bakan")
        val isBakan: String = "",
        @Json(name = "is_book_chapter")
        val isBookChapter: String = "",
        @Json(name = "is_bub")
        val isBub: String = "",
        @Json(name = "is_good")
        val isGood: String = "",
        @Json(name = "is_livepost")
        val isLivepost: String = "",
        @Json(name = "is_meizhi")
        val isMeizhi: String = "",
        @Json(name = "is_membertop")
        val isMembertop: String = "",
        @Json(name = "is_notice")
        val isNotice: String = "",
        @Json(name = "is_novel")
        val isNovel: String = "",
        @Json(name = "is_novel_reward")
        val isNovelReward: String = "",
        @Json(name = "is_novel_thank")
        val isNovelThank: String = "",
        @Json(name = "is_ntitle")
        val isNtitle: String = "",
        @Json(name = "is_partial_visible")
        val isPartialVisible: String = "",
        @Json(name = "is_pro_thread")
        val isProThread: String = "",
        @Json(name = "is_protal")
        val isProtal: String = "",
        @Json(name = "is_top")
        val isTop: String = "",
        @Json(name = "is_uegnaudited")
        val isUegnaudited: String = "",
        @Json(name = "is_voice_thread")
        val isVoiceThread: String = "",
        @Json(name = "is_vote")
        val isVote: String = "",
        @Json(name = "last_replyer")
        val lastReplyer: LastReplyer = LastReplyer(),
        @Json(name = "last_time")
        val lastTime: String = "",
        @Json(name = "last_time_int")
        val lastTimeInt: String = "",
        // @Json(name = "location")
        // val location: List<Any> = listOf(),
        @Json(name = "media")
        val media: List<Any> = listOf(),
        @Json(name = "media_num")
        val mediaNum: String = "",
        @Json(name = "meizhi_pic")
        val meizhiPic: String = "",
        @Json(name = "original_tid")
        val originalTid: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "share_num")
        val shareNum: String = "",
        @Json(name = "t_share_img")
        val tShareImg: String = "",
        @Json(name = "tab_id")
        val tabId: String = "",
        @Json(name = "tab_name")
        val tabName: String = "",
        @Json(name = "thread_id")
        val threadId: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "thread_types")
        val threadTypes: String = "",
        @Json(name = "tid")
        val tid: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "top_agree_post_id")
        val topAgreePostId: String = "",
        @Json(name = "view_num")
        val viewNum: String = "",
        @Json(name = "voice_info")
        val voiceInfo: List<VoiceInfo> = listOf(),
        @IgnoreJsonString2Json
        @Json(name = "zan")
        val zan: Zan = Zan()
    ) {

        @JsonClass(generateAdapter = true)
        data class Zan(
            @Json(name = "num")
            val num: String = "",
            @Json(name = "last_time")
            val lastTime: String = "",
            @Json(name = "user_id_list")
            val userIdList: List<String> = listOf()
        )

        @JsonClass(generateAdapter = true)
        data class VoiceInfo(
            @Json(name = "type")
            val type: String = "",
            @Json(name = "during_time")
            val duringTime: String = "",
            @Json(name = "voice_md5")
            val voiceMd5: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Abstract(
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Agree(
            @Json(name = "agree_num")
            val agreeNum: String = "",
            @Json(name = "agree_type")
            val agreeType: String = "",
            @Json(name = "diff_agree_num")
            val diffAgreeNum: String = "",
            @Json(name = "disagree_num")
            val disagreeNum: String = "",
            @Json(name = "has_agree")
            val hasAgree: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Author(
//            @Json(name = "ala_info")
//            val alaInfo: AlaInfo = AlaInfo(),
            @Json(name = "bawu_type")
            val bawuType: String = "",
            @Json(name = "bjh_avatar")
            val bjhAvatar: String = "",
            @Json(name = "bjh_avatar_flag")
            val bjhAvatarFlag: String = "",
            @Json(name = "bjh_v_intro")
            val bjhVIntro: String = "",
            @Json(name = "bjh_v_type")
            val bjhVType: String = "",
            @Json(name = "fans_nickname")
            val fansNickname: String = "",
            @Json(name = "iconinfo")
            val iconinfo: List<Iconinfo> = listOf(),
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_bawu")
            val isBawu: String = "",
            @Json(name = "is_interestman")
            val isInterestman: String = "",
            @Json(name = "is_mem")
            val isMem: String = "",
            @Json(name = "is_verify")
            val isVerify: String = "",
            @Json(name = "is_videobiggie")
            val isVideobiggie: String = "",
            @Json(name = "meizhi_level")
            val meizhiLevel: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
            @Json(name = "new_tshow_icon")
            val newTshowIcon: List<NewTshowIcon> = listOf(),
//            @Json(name = "pendant")
//            val pendant: Any = Any(),
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "seal_prefix")
            val sealPrefix: String = "",
            @Json(name = "sex")
            val sex: String = "",
            // @Json(name = "tb_vip")
            // val tbVip: List<Any> = listOf(),
            // @Json(name = "theme_card")
            // val themeCard: List<Any> = listOf(),
            @Json(name = "tshow_icon")
            val tshowIcon: List<TshowIcon> = listOf(),
            @Json(name = "type")
            val type: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class AlaInfo(
                @Json(name = "anchor_live")
                val anchorLive: String = "",
                @Json(name = "lat")
                val lat: String = "",
                @Json(name = "lng")
                val lng: String = "",
                // @Json(name = "location")
                // val location: String = "",
                @Json(name = "show_name")
                val showName: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Iconinfo(
                @Json(name = "icon")
                val icon: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "position")
                val position: Position = Position(),
                @Json(name = "sprite")
                val sprite: Sprite = Sprite(),
                @Json(name = "terminal")
                val terminal: Terminal = Terminal(),
                @Json(name = "value")
                val value: String = "",
                @Json(name = "weight")
                val weight: String = ""
            ) {
                @JsonClass(generateAdapter = true)
                data class Position(
                    @Json(name = "card")
                    val card: String = "",
                    @Json(name = "frs")
                    val frs: String = "",
                    @Json(name = "home")
                    val home: String = "",
                    @Json(name = "pb")
                    val pb: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Sprite(
                    @Json(name = "1")
                    val x1: String = "",
                    @Json(name = "2")
                    val x2: String = "",
                    @Json(name = "3")
                    val x3: String = "",
                    @Json(name = "4")
                    val x4: String = "",
                    @Json(name = "5")
                    val x5: String = "",
                    @Json(name = "6")
                    val x6: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Terminal(
                    @Json(name = "client")
                    val client: String = "",
                    @Json(name = "pc")
                    val pc: String = "",
                    @Json(name = "wap")
                    val wap: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class NewTshowIcon(
                @Json(name = "icon")
                val icon: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "url")
                val url: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TshowIcon(
                @Json(name = "icon")
                val icon: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "url")
                val url: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class FirstPostContent(
            @Json(name = "big_cdn_src")
            val bigCdnSrc: String = "",
            @Json(name = "bsize")
            val bsize: String = "",
            @Json(name = "c")
            val c: String = "",
            @Json(name = "cdn_src")
            val cdnSrc: String = "",
            @Json(name = "cdn_src_active")
            val cdnSrcActive: String = "",
            @Json(name = "is_long_pic")
            val isLongPic: String = "",
            @Json(name = "link")
            val link: String = "",
            @Json(name = "origin_size")
            val originSize: String = "",
            @Json(name = "origin_src")
            val originSrc: String = "",
            @Json(name = "show_original_btn")
            val showOriginalBtn: String = "",
            @Json(name = "size")
            val size: String = "",
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class LastReplyer(
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_verify")
            val isVerify: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        fun getMedias(): List<Media> {
            return media
                .filterIsInstance<Map<String, String>>()
                .map {
                    TiebaRequest.moshi.adapter(Media::class.java).fromJsonValue(it)!!
                }
        }

        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "big_pic")
            val bigPic: String = "",
            @Json(name = "is_long_pic")
            val isLongPic: String = "",
            @Json(name = "origin_pic")
            val originPic: String = "",
            @Json(name = "origin_size")
            val originSize: String = "",
            @Json(name = "post_id")
            val postId: String = "",
            @Json(name = "show_original_btn")
            val showOriginalBtn: String = "",
            @Json(name = "src_pic")
            val srcPic: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "vpic")
            val vpic: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class User(
        @Json(name = "balv")
        val balv: Balv = Balv(),
        @Json(name = "bawu_type")
        val bawuType: String = "",
        @Json(name = "bimg_url")
        val bimgUrl: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "ios_bimg_format")
        val iosBimgFormat: String = "",
        @Json(name = "is_bawu")
        val isBawu: String = "",
        @Json(name = "is_login")
        val isLogin: String = "",
        @Json(name = "is_manager")
        val isManager: String = "",
        @Json(name = "is_mem")
        val isMem: String = "",
        @Json(name = "is_select_tail")
        val isSelectTail: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "new_user_info")
        val newUserInfo: NewUserInfo = NewUserInfo(),
        @Json(name = "no_un")
        val noUn: String = "",
        @Json(name = "portrait")
        val portrait: String = "",
        @Json(name = "priv_thread")
        val privThread: String = "",
        @Json(name = "type")
        val type: String = "",
        @Json(name = "userhide")
        val userhide: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Balv(
            @Json(name = "days_tofree")
            val daysTofree: String = "",
            @Json(name = "is_black")
            val isBlack: String = "",
            @Json(name = "is_block")
            val isBlock: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class NewUserInfo(
//            @Json(name = "ala_info")
//            val alaInfo: AlaInfo = AlaInfo(),
            @Json(name = "card")
            val card: Card = Card(),
            @Json(name = "cdn_error")
            val cdnError: String = "",
            @Json(name = "display_name")
            val displayName: String = "",
            @Json(name = "duty")
            val duty: String = "",
            @Json(name = "forbidden_forumlist")
            val forbiddenForumlist: String = "",
            @Json(name = "free_flag")
            val freeFlag: String = "",
            @Json(name = "global")
            val global: Global = Global(),
            @Json(name = "heavy_user")
            val heavyUser: String = "",
            @Json(name = "idea_name")
            val ideaName: IdeaName = IdeaName(),
            @Json(name = "is_friend_imported")
            val isFriendImported: String = "",
            @Json(name = "is_group_owner")
            val isGroupOwner: String = "",
            @Json(name = "is_hardworking")
            val isHardworking: String = "",
            @Json(name = "is_tenyear")
            val isTenyear: String = "",
            @Json(name = "lbs")
            val lbs: Lbs = Lbs(),
            @Json(name = "mParr_props")
            val mParrProps: List<Any> = listOf(),
            @Json(name = "meizhi_level")
            val meizhiLevel: String = "",
            @Json(name = "new_active_forum")
            val newActiveForum: List<NewActiveForum> = listOf(),
            @Json(name = "new_iconinfo")
            val newIconinfo: NewIconinfo = NewIconinfo(),
            @Json(name = "paper")
            val paper: String = "",
            @Json(name = "Parr_props")
            val parrProps: ParrProps = ParrProps(),
            @Json(name = "Parr_scores")
            val parrScores: ParrScores = ParrScores(),
            @Json(name = "player_level_up")
            val playerLevelUp: String = "",
            @Json(name = "portrait_time")
            val portraitTime: String = "",
            @Json(name = "priv_sets")
            val privSets: PrivSets = PrivSets(),
            @Json(name = "score_card")
            val scoreCard: String = "",
            @Json(name = "superboy")
            val superboy: String = "",
            @Json(name = "tbguess_card")
            val tbguessCard: TbguessCard = TbguessCard(),
            @Json(name = "tbscore_repeate_finish_time")
            val tbscoreRepeateFinishTime: String = "",
            @Json(name = "ueg_profile")
            val uegProfile: String = "",
            @Json(name = "use_sig")
            val useSig: String = "",
            @Json(name = "user_id")
            val userId: String = "",
            @Json(name = "user_name")
            val userName: String = "",
            @Json(name = "user_sex")
            val userSex: String = "",
            @Json(name = "user_state")
            val userState: String = "",
            @Json(name = "user_status")
            val userStatus: String = "",
            @Json(name = "user_type")
            val userType: String = "",
            @Json(name = "wap_rn")
            val wapRn: WapRn = WapRn()
        ) {
            @JsonClass(generateAdapter = true)
            data class AlaInfo(
                @Json(name = "anchor_live")
                val anchorLive: String = "",
                @Json(name = "enter_live")
                val enterLive: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Card(
                @Json(name = "good_num")
                val goodNum: String = "",
                @Json(name = "is_novice")
                val isNovice: String = "",
                @Json(name = "like_forum")
                val likeForum: LikeForum = LikeForum(),
                @Json(name = "manager_info")
                val managerInfo: ManagerInfo = ManagerInfo(),
                @Json(name = "op_time")
                val opTime: String = "",
                @Json(name = "post_num")
                val postNum: String = ""
            ) {
                @JsonClass(generateAdapter = true)
                data class LikeForum(
                    @Json(name = "10")
                    val x10: X10 = X10(),
                    @Json(name = "11")
                    val x11: X11 = X11(),
                    @Json(name = "13")
                    val x13: X13 = X13(),
                    @Json(name = "14")
                    val x14: X14 = X14(),
                    @Json(name = "6")
                    val x6: X6 = X6(),
                    @Json(name = "9")
                    val x9: X9 = X9()
                ) {
                    @JsonClass(generateAdapter = true)
                    data class X10(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class X11(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class X13(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class X14(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class X6(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class X9(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )
                }

                @JsonClass(generateAdapter = true)
                data class ManagerInfo(
                    @Json(name = "assist")
                    val assist: Assist = Assist(),
                    @Json(name = "manager")
                    val manager: Manager = Manager(),
                    @Json(name = "profession_manager")
                    val professionManager: ProfessionManager = ProfessionManager()
                ) {
                    @JsonClass(generateAdapter = true)
                    data class Assist(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<Any> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class Manager(
                        @Json(name = "count")
                        val count: String = "",
                        @Json(name = "forum_list")
                        val forumList: List<String> = listOf()
                    )

                    @JsonClass(generateAdapter = true)
                    data class ProfessionManager(
                        @Json(name = "count")
                        val count: String = ""
                    )
                }
            }

            @JsonClass(generateAdapter = true)
            data class Global(
                @Json(name = "tbmall_newprops")
                val tbmallNewprops: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IdeaName(
                @Json(name = "10")
                val x10: String = "",
                @Json(name = "11")
                val x11: String = "",
                @Json(name = "13")
                val x13: String = "",
                @Json(name = "14")
                val x14: String = "",
                @Json(name = "15")
                val x15: String = "",
                @Json(name = "16")
                val x16: String = "",
                @Json(name = "18")
                val x18: String = "",
                @Json(name = "8")
                val x8: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lbs(
                @Json(name = "lat")
                val lat: String = "",
                @Json(name = "lng")
                val lng: String = "",
                @Json(name = "time")
                val time: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NewActiveForum(
                @Json(name = "fid")
                val fid: String = "",
                @Json(name = "fname")
                val fname: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NewIconinfo(
                @Json(name = "1")
                val x1: X1 = X1(),
                @Json(name = "2")
                val x2: List<Any> = listOf()
            ) {
                @JsonClass(generateAdapter = true)
                data class X1(
                    @Json(name = "category_id")
                    val categoryId: String = "",
                    @Json(name = "end_time")
                    val endTime: String = "",
                    @Json(name = "level")
                    val level: String = "",
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "slot_no")
                    val slotNo: String = "",
                    @Json(name = "slot_type")
                    val slotType: String = "",
                    @Json(name = "type")
                    val type: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class ParrProps(
                @Json(name = "all_level")
                val allLevel: String = "",
                @Json(name = "117")
                val x117: X117 = X117()
            ) {
                @JsonClass(generateAdapter = true)
                data class X117(
                    @Json(name = "1170001")
                    val x1170001: X1170001 = X1170001()
                ) {
                    @JsonClass(generateAdapter = true)
                    data class X1170001(
                        @Json(name = "left_num")
                        val leftNum: String = "",
                        @Json(name = "props_category")
                        val propsCategory: String = "",
                        @Json(name = "props_id")
                        val propsId: String = "",
                        @Json(name = "props_type")
                        val propsType: String = "",
                        @Json(name = "used_status")
                        val usedStatus: String = ""
                    )
                }
            }

            @JsonClass(generateAdapter = true)
            data class ParrScores(
                @Json(name = "level")
                val level: String = "",
                @Json(name = "limit")
                val limit: String = "",
                @Json(name = "scores_fetch")
                val scoresFetch: String = "",
                @Json(name = "scores_money")
                val scoresMoney: String = "",
                @Json(name = "scores_other")
                val scoresOther: String = "",
                @Json(name = "scores_total")
                val scoresTotal: String = "",
                @Json(name = "update_time")
                val updateTime: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PrivSets(
                @Json(name = "group")
                val group: String = "",
                @Json(name = "like")
                val like: String = "",
                @Json(name = "live")
                val live: String = "",
                // @Json(name = "location")
                // val location: String = "",
                @Json(name = "post")
                val post: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TbguessCard(
                @Json(name = "card_id")
                val cardId: String = "",
                @Json(name = "card_type")
                val cardType: String = "",
                @Json(name = "scores")
                val scores: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class WapRn(
                @Json(name = "frsrn")
                val frsrn: String = "",
                @Json(name = "pbrn")
                val pbrn: String = ""
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class UserExtend(
        @Json(name = "data")
        val `data`: List<Any> = listOf(),
        @Json(name = "tips")
        val tips: String = "",
        @Json(name = "user_extend_storey")
        val userExtendStorey: String = ""
    )
}