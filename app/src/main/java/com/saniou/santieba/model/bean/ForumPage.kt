package com.saniou.santieba.model.bean

import com.sanniou.support.moshi.IgnoreJsonString2Json
import com.sanniou.support.moshi.IgnoreJsonString2List
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForumPage(
    // @Json(name = "activityhead")
    // val activityhead: List<Any> = listOf(),
    @Json(name = "agree_banner")
    val agreeBanner: AgreeBanner = AgreeBanner(),
    // @Json(name = "ala_stage_list")
    // val alaStageList: List<Any> = listOf(),
    @Json(name = "anti")
    val anti: Anti = Anti(),
    @Json(name = "asp_shown_info")
    val aspShownInfo: String = "",
    // @Json(name = "banner_thread_list")
    // val bannerThreadList: List<Any> = listOf(),
    // @Json(name = "business_promot")
    // val businessPromot: List<Any> = listOf(),
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
    // @Json(name = "frs_game_tab_info")
    // val frsGameTabInfo: List<Any> = listOf(),
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
    // @Json(name = "recom_post_topic")
    // val recomPostTopic: List<Any> = listOf(),
    @Json(name = "server_time")
    val serverTime: String = "",
    // @Json(name = "smart_app_avatar")
    // val smartAppAvatar: List<Any> = listOf(),
    @Json(name = "sort_type")
    val sortType: String = "",
    @Json(name = "star_enter")
    val starEnter: List<StarEnter> = listOf(),
    // @Json(name = "thread_id_list")
    // val threadIdList: List<Any> = listOf(),
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
    @Json(name = "user_list")
    val userList: List<User2> = listOf(),
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
        val banner: Banner = Banner(),
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
        val userLevel: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class AnchorPower(
            @Json(name = "anchor_message")
            val anchorMessage: String = "",
            @Json(name = "have_power")
            val havePower: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Banner(
            @Json(name = "desc")
            val desc: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class BannerList(
            @Json(name = "app")
            val app: List<App> = listOf(),
            @Json(name = "hot_topic")
            val hotTopic: HotTopic = HotTopic()
        ) {
            @JsonClass(generateAdapter = true)
            data class App(
                @Json(name = "abtest")
                val abtest: String = "",
                @Json(name = "apk_name")
                val apkName: String = "",
                @Json(name = "apk_url")
                val apkUrl: String = "",
                @Json(name = "app_time")
                val appTime: String = "",
                @Json(name = "cpid")
                val cpid: String = "",
                @Json(name = "deep_url")
                val deepUrl: String = "",
                @Json(name = "ext_info")
                val extInfo: String = "",
                @Json(name = "first_name")
                val firstName: String = "",
                @Json(name = "goods_info")
                val goodsInfo: List<GoodsInfo> = listOf(),
                @Json(name = "id")
                val id: String = "",
                @Json(name = "ios_url")
                val iosUrl: String = "",
                @Json(name = "loc_code")
                val locCode: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "plan_id")
                val planId: String = "",
                @Json(name = "pos_name")
                val posName: String = "",
                @Json(name = "price")
                val price: String = "",
                @Json(name = "second_name")
                val secondName: String = "",
                @Json(name = "url")
                val url: String = "",
                @Json(name = "url_type")
                val urlType: String = "",
                @Json(name = "user_id")
                val userId: String = "",
                @Json(name = "verify")
                val verify: String = ""
            ) {
                @JsonClass(generateAdapter = true)
                data class GoodsInfo(
                    @Json(name = "ad_source")
                    val adSource: String = "",
                    @Json(name = "button_text")
                    val buttonText: String = "",
                    @Json(name = "button_url")
                    val buttonUrl: String = "",
                    @Json(name = "card_desc")
                    val cardDesc: String = "",
                    @Json(name = "card_tag")
                    val cardTag: String = "",
                    @Json(name = "close_info")
                    val closeInfo: CloseInfo = CloseInfo(),
                    @Json(name = "goods_style")
                    val goodsStyle: String = "",
                    @Json(name = "height")
                    val height: String = "",
                    @Json(name = "id")
                    val id: String = "",
                    @Json(name = "label_measure")
                    val labelMeasure: String = "",
                    @Json(name = "label_text")
                    val labelText: String = "",
                    @Json(name = "label_visible")
                    val labelVisible: String = "",
                    @Json(name = "lego_card")
                    val legoCard: String = "",
                    @Json(name = "pop_window_text")
                    val popWindowText: String = "",
                    @Json(name = "tag_name")
                    val tagName: String = "",
                    @Json(name = "tag_name_url")
                    val tagNameUrl: String = "",
                    @Json(name = "tag_name_wh")
                    val tagNameWh: String = "",
                    @Json(name = "thread_pic")
                    val threadPic: String = "",
                    @Json(name = "thread_title")
                    val threadTitle: String = "",
                    @Json(name = "user_name")
                    val userName: String = "",
                    @Json(name = "user_portrait")
                    val userPortrait: String = "",
                    @Json(name = "width")
                    val width: String = ""
                ) {
                    @JsonClass(generateAdapter = true)
                    data class CloseInfo(
                        @Json(name = "action_control")
                        val actionControl: ActionControl = ActionControl(),
                        @Json(name = "reasons")
                        val reasons: List<String> = listOf(),
                        @Json(name = "support_close")
                        val supportClose: String = ""
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class ActionControl(
                            @Json(name = "name")
                            val name: String = "",
                            @Json(name = "text_color")
                            val textColor: String = "",
                            @Json(name = "text_color_pressed")
                            val textColorPressed: String = "",
                            @Json(name = "url")
                            val url: String = ""
                        )
                    }
                }
            }

            @JsonClass(generateAdapter = true)
            data class HotTopic(
                @Json(name = "recom_title")
                val recomTitle: String = "",
                @Json(name = "topic_list")
                val topicList: List<Topic> = listOf()
            ) {
                @JsonClass(generateAdapter = true)
                data class Topic(
                    @Json(name = "tag")
                    val tag: String = "",
                    @Json(name = "topic_id")
                    val topicId: String = "",
                    @Json(name = "topic_name")
                    val topicName: String = "",
                    @Json(name = "type")
                    val type: String = ""
                )
            }
        }

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
            val className: String = ""
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
                @Json(name = "is_filter")
                val isFilter: String = "",
                @Json(name = "is_on")
                val isOn: String = ""
            ) {
                @JsonClass(generateAdapter = true)
                data class CurrentRankInfo(
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
            @Json(name = "tag_id")
            val tagId: String = "",
            @Json(name = "tag_name")
            val tagName: String = ""
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
    }

    @JsonClass(generateAdapter = true)
    data class FrsStar(
        @Json(name = "fans")
        val fans: String = "",
        @Json(name = "gender")
        val gender: String = "",
        @Json(name = "has_frs_star")
        val hasFrsStar: String = "",
        @Json(name = "head")
        val head: String = "",
        @Json(name = "head_size")
        val headSize: String = "",
        @Json(name = "star_forum_headimg")
        val starForumHeadimg: String = "",
        @Json(name = "top")
        val top: String = "",
        @Json(name = "top_size")
        val topSize: String = "",
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
        @Json(name = "author_id")
        val authorId: String = "",
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
        @Json(name = "first_post_content")
        val firstPostContent: List<Content> = listOf(),
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
        @Json(name = "is_good")
        val isGood: String = "",
        @Json(name = "is_live_post")
        val isLivepost: String = "",
        @Json(name = "is_link_thread")
        val isLinkThread: String = "",
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
        @Json(name = "is_voice_thread")
        val isVoiceThread: String = "",
        @Json(name = "is_vote")
        val isVote: String = "",
        @Json(name = "last_time")
        val lastTime: String = "",
        @Json(name = "last_time_int")
        val lastTimeInt: String = "",
        @Json(name = "link_url_code")
        val linkUrlCode: String = "",
        @Json(name = "location")
        val location: Any = Any(),
        @Json(name = "media")
        val media: List<Media> = listOf(),
        @Json(name = "media_num")
        val mediaNum: String = "",
        @Json(name = "meizhi_pic")
        val meizhiPic: String = "",
        @Json(name = "nid")
        val nid: String = "",
        @Json(name = "original_tid")
        val originalTid: String = "",
        @Json(name = "post_list")
        val postList: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "share_num")
        val shareNum: String = "",
        @Json(name = "t_share_img")
        val tShareImg: String = "",
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
        @Json(name = "video_info")
        val videoInfo: VideoInfo = VideoInfo(),
        @Json(name = "view_num")
        val viewNum: String = "",
        @Json(name = "voice_info")
        val voiceInfo: List<Any> = listOf(),
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
            @IgnoreJsonString2List
            @Json(name = "user_id_list")
            val userIdList: List<String> = listOf()
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
            @Json(name = "during_time")
            val duringTime: String = "",
            @Json(name = "e_type")
            val eType: String = "",
            @Json(name = "height")
            val height: String = "",
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
            @Json(name = "src")
            val src: String = "",
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "width")
            val width: String = ""
        )

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
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class VideoInfo(
            @Json(name = "auditing")
            val auditing: String = "",
            @Json(name = "cover_text")
            val coverText: String = "",
            @Json(name = "first_frame_cover")
            val firstFrameCover: String = "",
            @Json(name = "format_matched")
            val formatMatched: String = "",
            @Json(name = "is_private")
            val isPrivate: String = "",
            @Json(name = "is_vertical")
            val isVertical: String = "",
            @Json(name = "origin_video_url")
            val originVideoUrl: String = "",
            @Json(name = "play_count")
            val playCount: String = "",
            @Json(name = "thumbnail_height")
            val thumbnailHeight: String = "",
            @Json(name = "thumbnail_url")
            val thumbnailUrl: String = "",
            @Json(name = "thumbnail_width")
            val thumbnailWidth: String = "",
            @Json(name = "video_desc")
            val videoDesc: List<VideoDesc> = listOf(),
            @Json(name = "video_duration")
            val videoDuration: String = "",
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

    @JsonClass(generateAdapter = true)
    data class User2(
        @Json(name = "ala_info")
        val alaInfo: Any = Any(),
        @Json(name = "baijiahao_info")
        val baijiahaoInfo: String = "",
        @Json(name = "bawu_type")
        val bawuType: String = "",
        @Json(name = "fans_nickname")
        val fansNickname: String = "",
        @Json(name = "fans_num")
        val fansNum: String = "",
        @Json(name = "gender")
        val gender: String = "",
        // @Json(name = "god_data")
        // val godData: String = "",
        @Json(name = "iconinfo")
        val iconinfo: List<Iconinfo> = listOf(),
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_bawu")
        val isBawu: String = "",
        @Json(name = "is_mem")
        val isMem: String = "",
        @Json(name = "is_videobiggie")
        val isVideobiggie: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        // @Json(name = "new_tshow_icon")
        // val newTshowIcon: List<Any> = listOf(),
        // @Json(name = "pendant")
        // val pendant: List<Any> = listOf(),
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
        // @Json(name = "tshow_icon")
        // val tshowIcon: List<Any> = listOf(),
        @Json(name = "type")
        val type: String = ""
    ) {
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
    }
}