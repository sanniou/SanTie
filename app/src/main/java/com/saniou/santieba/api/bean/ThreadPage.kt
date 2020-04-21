package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThreadPage(
//    @Json(name = "ala_info")
//    val alaInfo: Any = Any(),
    @Json(name = "anti")
    val anti: Anti = Anti(),
//    @Json(name = "banner_list")
//    val bannerList: BannerList = BannerList(),
    @Json(name = "business_promot_info")
    val businessPromotInfo: BusinessPromotInfo = BusinessPromotInfo(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "display_forum")
    val displayForum: DisplayForum = DisplayForum(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "fold_tip")
    val foldTip: String = "",
    @Json(name = "forum")
    val forum: Forum = Forum(),
    @Json(name = "has_floor")
    val hasFloor: String = "",
    @Json(name = "is_new_url")
    val isNewUrl: String = "",
//    @Json(name = "location")
//    val location: Any = Any(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "page")
    val page: Page = Page(),
    @Json(name = "partial_visible_toast")
    val partialVisibleToast: String = "",
    @Json(name = "pb_sort_info")
    val pbSortInfo: List<PbSortInfo> = listOf(),
    @Json(name = "post_list")
    val postList: List<Post> = listOf(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "sort_type")
    val sortType: String = "",
    @Json(name = "switch_read_open")
    val switchReadOpen: String = "",
    @Json(name = "thread")
    val thread: Thread = Thread(),
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "user")
    val user: User = User(),
    @Json(name = "user_list")
    val userList: List<UserX> = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Anti(
        @Json(name = "forbid_flag")
        val forbidFlag: String = "",
        @Json(name = "forbid_info")
        val forbidInfo: String = "",
        @Json(name = "ifaddition")
        val ifaddition: String = "",
        @Json(name = "ifpost")
        val ifpost: String = "",
        @Json(name = "ifposta")
        val ifposta: String = "",
        @Json(name = "ifvoice")
        val ifvoice: String = "",
        @Json(name = "ifxiaoying")
        val ifxiaoying: String = "",
        @Json(name = "reply_private_flag")
        val replyPrivateFlag: String = "",
        @Json(name = "tbs")
        val tbs: String = "",
        @Json(name = "video_message")
        val videoMessage: String = "",
        @Json(name = "voice_message")
        val voiceMessage: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class BusinessPromotInfo(
        @Json(name = "is_headlinepost")
        val isHeadlinepost: String = "",
        @Json(name = "is_promot")
        val isPromot: String = "",
        @Json(name = "is_s_card")
        val isSCard: String = ""
//        @Json(name = "send_card_info")
//        val sendCardInfo: Any = Any()
    )

    @JsonClass(generateAdapter = true)
    data class DisplayForum(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "first_class")
        val firstClass: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_brand_forum")
        val isBrandForum: String = "",
        @Json(name = "is_exists")
        val isExists: String = "",
        @Json(name = "is_liked")
        val isLiked: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "second_class")
        val secondClass: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Forum(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "first_class")
        val firstClass: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_brand_forum")
        val isBrandForum: String = "",
        @Json(name = "is_exists")
        val isExists: String = "",
        @Json(name = "is_liked")
        val isLiked: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "second_class")
        val secondClass: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Page(
        @Json(name = "current_page")
        val currentPage: String = "",
        @Json(name = "has_more")
        val hasMore: String = "",
        @Json(name = "has_prev")
        val hasPrev: String = "",
        @Json(name = "new_total_page")
        val newTotalPage: String = "",
        @Json(name = "offset")
        val offset: String = "",
        @Json(name = "page_size")
        val pageSize: String = "",
        @Json(name = "pnum")
        val pnum: String = "",
        @Json(name = "req_num")
        val reqNum: String = "",
        @Json(name = "tnum")
        val tnum: String = "",
        @Json(name = "total_num")
        val totalNum: String = "",
        @Json(name = "total_page")
        val totalPage: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class PbSortInfo(
        @Json(name = "sort_name")
        val sortName: String = "",
        @Json(name = "sort_type")
        val sortType: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Post(
//        @Json(name = "arr_video")
//        val arrVideo: Any = Any(),
        @Json(name = "author_id")
        val authorId: String = "",
        @Json(name = "bimg_url")
        val bimgUrl: String = "",
        @Json(name = "content")
        val content: List<Content> = listOf(),
        @Json(name = "floor")
        val floor: String = "",
        @Json(name = "fold_tip")
        val foldTip: String = "",
        @Json(name = "from_thread_id")
        val fromThreadId: String = "",
        @Json(name = "has_signature")
        val hasSignature: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "ios_bimg_format")
        val iosBimgFormat: String = "",
        @Json(name = "is_fold")
        val isFold: String = "",
        @Json(name = "is_post_visible")
        val isPostVisible: String = "",
        @Json(name = "is_top_agree_post")
        val isTopAgreePost: String = "",
        @Json(name = "is_vote")
        val isVote: String = "",
//        @Json(name = "lbs_info")
//        val lbsInfo: Any = Any(),
        @Json(name = "need_log")
        val needLog: String = "",
//        @Json(name = "pb_live")
//        val pbLive: String = "",
        @Json(name = "show_squared")
        val showSquared: String = "",
//        @Json(name = "signature")
//        val signature: Any = Any(),
        @Json(name = "sub_post_list")
        val subPostList: SubPostList = SubPostList(),
        @Json(name = "sub_post_number")
        val subPostNumber: Int = 0,
//        @Json(name = "tail_info")
//        val tailInfo: Any = Any(),
        @Json(name = "time")
        val time: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "v_forum_id")
        val vForumId: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class SubPostList(
            @Json(name = "pid")
            val pid: String = "",
            @Json(name = "author_id")
            val authorId: String = "",
            @Json(name = "fold_tip")
            val foldTip: String = "",
            @Json(name = "sub_post_list")
            val subPostList: List<SubPostContent> = listOf()
        )

        @JsonClass(generateAdapter = true)
        data class SubPostContent(
            @Json(name = "id")
            val id: String = "",
            @Json(name = "content")
            val content: List<Content> = listOf(),
            @Json(name = "time")
            val time: String = "",
            @Json(name = "floor")
            val floor: String = "",
            @Json(name = "author_id")
            val authorId: String = "",
            @Json(name = "title")
            val title: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Thread(
        @Json(name = "agree")
        val agree: Agree = Agree(),
        @Json(name = "agree_num")
        val agreeNum: String = "",
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "collect_mark_pid")
        val collectMarkPid: String = "",
        @Json(name = "collect_status")
        val collectStatus: String = "",
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_activity")
        val isActivity: String = "",
        @Json(name = "is_bazhu_apply")
        val isBazhuApply: String = "",
        @Json(name = "is_bub")
        val isBub: String = "",
        @Json(name = "is_link_thread")
        val isLinkThread: String = "",
        @Json(name = "is_ntitle")
        val isNtitle: String = "",
        @Json(name = "is_partial_visible")
        val isPartialVisible: String = "",
//        @Json(name = "location")
//        val location: Any = Any(),
        @Json(name = "no_smart_pb")
        val noSmartPb: String = "",
        @Json(name = "pids")
        val pids: String = "",
        @Json(name = "post_id")
        val postId: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "repost_num")
        val repostNum: String = "",
        @Json(name = "rich_title")
        val richTitle: List<RichTitle> = listOf(),
        @Json(name = "share_num")
        val shareNum: String = "",
        @Json(name = "t_share_img")
        val tShareImg: String = "",
        @Json(name = "thread_info")
        val threadInfo: ThreadInfo = ThreadInfo(),
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "topic")
        val topic: Topic = Topic(),
        @Json(name = "twzhibo_info")
        val twzhiboInfo: TwzhiboInfo = TwzhiboInfo(),
        @Json(name = "zan")
        val zan: Zan = Zan()
    ) {
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
            @Json(name = "agree_num")
            val agreeNum: String = "",
//            @Json(name = "ala_info")
//            val alaInfo: Any = Any(),
//            @Json(name = "baijiahao_info")
//            val baijiahaoInfo: String = "",
            @Json(name = "bawu_type")
            val bawuType: String = "",
            @Json(name = "esport_data")
            val esportData: String = "",
            @Json(name = "fans_nickname")
            val fansNickname: String = "",
            @Json(name = "fans_num")
            val fansNum: String = "",
            @Json(name = "gender")
            val gender: String = "",
            @Json(name = "gift_num")
            val giftNum: String = "",
//            @Json(name = "god_data")
//            val godData: String = "",
            @Json(name = "has_concerned")
            val hasConcerned: String = "",
//            @Json(name = "iconinfo")
//            val iconinfo: Any = Any(),
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_bawu")
            val isBawu: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
            @Json(name = "level_id")
            val levelId: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
//            @Json(name = "new_tshow_icon")
//            val newTshowIcon: Any = Any(),
//            @Json(name = "pendant")
//            val pendant: Any = Any(),
            @Json(name = "portrait")
            val portrait: String = "",
//            @Json(name = "priv_sets")
//            val privSets: Any = Any(),
            @Json(name = "seal_prefix")
            val sealPrefix: String = "",
//            @Json(name = "spring_virtual_user")
//            val springVirtualUser: Any = Any(),
//            @Json(name = "tb_vip")
//            val tbVip: Any = Any(),
            @Json(name = "thread_num")
            val threadNum: String = "",
//            @Json(name = "tshow_icon")
//            val tshowIcon: Any = Any(),
            @Json(name = "type")
            val type: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class AlaInfo(
                @Json(name = "location")
                val location: String = "",
                @Json(name = "show_name")
                val showName: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PrivSets(
                @Json(name = "group")
                val group: String = "",
                @Json(name = "like")
                val like: String = "",
                @Json(name = "live")
                val live: String = "",
                @Json(name = "location")
                val location: String = "",
                @Json(name = "post")
                val post: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class RichTitle(
            @Json(name = "link")
            val link: String = "",
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class ThreadInfo(
            @Json(name = "agree_num")
            val agreeNum: String = "",
            @Json(name = "antispam_info")
            val antispamInfo: AntispamInfo = AntispamInfo(),
            @Json(name = "create_time")
            val createTime: String = "",
            @Json(name = "disagree_num")
            val disagreeNum: String = "",
            @Json(name = "first_post_id")
            val firstPostId: String = "",
            @Json(name = "forum_id")
            val forumId: String = "",
            @Json(name = "forum_name")
            val forumName: String = "",
            @Json(name = "freq_num")
            val freqNum: String = "",
            @Json(name = "from_thread_id")
            val fromThreadId: String = "",
            @Json(name = "good_types")
            val goodTypes: String = "",
            @Json(name = "inner_tab_id")
            val innerTabId: String = "",
            @Json(name = "is_deleted")
            val isDeleted: String = "",
            @Json(name = "is_uegnaudited")
            val isUegnaudited: String = "",
            @Json(name = "last_modified_time")
            val lastModifiedTime: String = "",
            @Json(name = "last_post_deleted")
            val lastPostDeleted: String = "",
            @Json(name = "last_post_id")
            val lastPostId: String = "",
            @Json(name = "last_user_id")
            val lastUserId: String = "",
            @Json(name = "last_user_ip")
            val lastUserIp: String = "",
            @Json(name = "last_user_ip6")
            val lastUserIp6: String = "",
            @Json(name = "news_id")
            val newsId: String = "",
            @Json(name = "phone_type")
            val phoneType: String = "",
            @Json(name = "post_num")
            val postNum: String = "",
            @Json(name = "post_prefix")
            val postPrefix: String = "",
            @Json(name = "rank_icon")
            val rankIcon: RankIcon = RankIcon(),
            @Json(name = "share_num")
            val shareNum: String = "",
            @Json(name = "share_user_num")
            val shareUserNum: String = "",
            @Json(name = "storecount")
            val storecount: String = "",
            @Json(name = "t_share_img")
            val tShareImg: String = "",
            @Json(name = "thread_classes")
            val threadClasses: String = "",
            @Json(name = "thread_id")
            val threadId: String = "",
            @Json(name = "thread_types")
            val threadTypes: String = "",
//            @Json(name = "thumbnail_centre_point")
//            val thumbnailCentrePoint: ThumbnailCentrePoint = ThumbnailCentrePoint(),
            @Json(name = "title")
            val title: String = "",
            @Json(name = "title_prefix")
            val titlePrefix: String = "",
            @Json(name = "top_types")
            val topTypes: String = "",
            @Json(name = "tstore_type")
            val tstoreType: String = "",
            @Json(name = "user_id")
            val userId: String = "",
            @Json(name = "user_ip")
            val userIp: String = "",
            @Json(name = "user_ip6")
            val userIp6: String = "",
            @Json(name = "vote_id")
            val voteId: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class AntispamInfo(
                @Json(name = "deepimginfo_score")
                val deepimginfoScore: String = "",
                @Json(name = "ocr_score")
                val ocrScore: String = "",
                @Json(name = "porn")
                val porn: String = "",
                @Json(name = "porn_score")
                val pornScore: String = "",
                @Json(name = "replyRnnScore")
                val replyRnnScore: String = "",
                @Json(name = "scoreNum_porn")
                val scoreNumPorn: String = "",
                @Json(name = "scoreNum_porn_title")
                val scoreNumPornTitle: String = "",
                @Json(name = "sexy_score")
                val sexyScore: String = "",
                @Json(name = "textScore")
                val textScore: String = "",
                @Json(name = "threadRnnScore")
                val threadRnnScore: String = "",
                @Json(name = "urate_score")
                val urateScore: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class RankIcon(
                @Json(name = "rank_type")
                val rankType: String = "",
                @Json(name = "ranking")
                val ranking: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ThumbnailCentrePoint(
                @Json(name = "tag_2")
                val tag2: List<Tag2> = listOf()
            ) {
                @JsonClass(generateAdapter = true)
                data class Tag2(
                    @Json(name = "center_multi")
                    val centerMulti: List<String> = listOf(),
                    @Json(name = "center_single")
                    val centerSingle: List<String> = listOf(),
                    @Json(name = "height")
                    val height: String = "",
                    @Json(name = "pic_id")
                    val picId: String = "",
                    @Json(name = "width")
                    val width: String = ""
                )
            }
        }

        @JsonClass(generateAdapter = true)
        data class Topic(
            @Json(name = "is_lpost")
            val isLpost: String = "",
            @Json(name = "link")
            val link: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class TwzhiboInfo(
            @Json(name = "is_copytwzhibo")
            val isCopytwzhibo: String = "",
            @Json(name = "user")
            val user: User = User()
        ) {
            @JsonClass(generateAdapter = true)
            data class User(
                @Json(name = "tw_anchor_info")
                val twAnchorInfo: TwAnchorInfo = TwAnchorInfo()
            ) {
                @JsonClass(generateAdapter = true)
                data class TwAnchorInfo(
                    @Json(name = "anchor_level")
                    val anchorLevel: String = "",
                    @Json(name = "caller_msg")
                    val callerMsg: String = "",
                    @Json(name = "fans_num")
                    val fansNum: String = "",
                    @Json(name = "follow")
                    val follow: String = "",
                    @Json(name = "gifts_num")
                    val giftsNum: String = "",
                    @Json(name = "guide")
                    val guide: String = "",
                    @Json(name = "in_black_list")
                    val inBlackList: String = "",
                    @Json(name = "month_update_days")
                    val monthUpdateDays: String = "",
                    @Json(name = "newfloor")
                    val newfloor: String = "",
                    @Json(name = "set_cover")
                    val setCover: String = ""
                )
            }
        }

        @JsonClass(generateAdapter = true)
        data class Zan(
            @Json(name = "is_liked")
            val isLiked: String = "",
            @Json(name = "last_time")
            val lastTime: String = "",
            @Json(name = "num")
            val num: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class User(
        @Json(name = "bimg_end_time")
        val bimgEndTime: String = "",
        @Json(name = "bimg_url")
        val bimgUrl: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "ios_bimg_format")
        val iosBimgFormat: String = "",
        @Json(name = "is_like")
        val isLike: String = "",
        @Json(name = "is_login")
        val isLogin: String = "",
        @Json(name = "is_manager")
        val isManager: String = "",
        @Json(name = "is_mem")
        val isMem: String = "",
        @Json(name = "is_select_tail")
        val isSelectTail: String = "",
        @Json(name = "left_call_num")
        val leftCallNum: String = "",
        @Json(name = "level_id")
        val levelId: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "pay_member_info")
        val payMemberInfo: PayMemberInfo = PayMemberInfo(),
//        @Json(name = "pendant")
//        val pendant: Any = Any(),
        @Json(name = "portrait")
        val portrait: String = "",
        @Json(name = "seal_prefix")
        val sealPrefix: String = "",
//        @Json(name = "spring_virtual_user")
//        val springVirtualUser: Any = Any(),
        @Json(name = "type")
        val type: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class PayMemberInfo(
            @Json(name = "end_time")
            val endTime: String = "",
            @Json(name = "pic_url")
            val picUrl: String = "",
            @Json(name = "props_id")
            val propsId: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class UserX(
        @Json(name = "agree_num")
        val agreeNum: String = "",
//        @Json(name = "ala_info")
//        val alaInfo: Any = Any(),
//        @Json(name = "baijiahao_info")
//        val baijiahaoInfo: String = "",
        @Json(name = "bawu_type")
        val bawuType: String = "",
        @Json(name = "fans_nickname")
        val fansNickname: String = "",
        @Json(name = "fans_num")
        val fansNum: String = "",
        @Json(name = "gender")
        val gender: String = "",
        @Json(name = "gift_num")
        val giftNum: String = "",
//        @Json(name = "god_data")
//        val godData: String = "",
        @Json(name = "has_concerned")
        val hasConcerned: String = "",
//        @Json(name = "iconinfo")
//        val iconinfo: Any = Any(),
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_bawu")
        val isBawu: String = "",
        @Json(name = "is_mem")
        val isMem: String = "",
        @Json(name = "level_id")
        val levelId: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "new_tshow_icon")
        val newTshowIcon: List<NewTshowIcon> = listOf(),
//        @Json(name = "pendant")
//        val pendant: Any = Any(),
        @Json(name = "portrait")
        val portrait: String = "",
        @Json(name = "seal_prefix")
        val sealPrefix: String = "",
//        @Json(name = "spring_virtual_user")
//        val springVirtualUser: Any = Any(),
//        @Json(name = "tb_vip")
//        val tbVip: Any = Any(),
        @Json(name = "thread_num")
        val threadNum: String = "",
        @Json(name = "tshow_icon")
        val tshowIcon: List<TshowIcon> = listOf()
    ) {
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
}