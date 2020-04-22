package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FloorPage(
    @Json(name = "anti")
    val anti: Anti = Anti(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "display_forum")
    val displayForum: DisplayForum = DisplayForum(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "forum")
    val forum: Forum = Forum(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "page")
    val page: Page = Page(),
    @Json(name = "perm")
    val perm: Perm = Perm(),
    @Json(name = "post")
    val post: Post = Post(),
//    @Json(name = "post_list")
//    val postList: List<Any> = listOf(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "subpost_list")
    val subpostList: List<Subpost> = listOf(),
    @Json(name = "thread")
    val thread: Thread = Thread(),
    @Json(name = "time")
    val time: Int = 0
//    @Json(name = "user")
//    val user: List<Any> = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Anti(
        @Json(name = "del_thread_text")
        val delThreadText: List<DelThreadText> = listOf(),
        @Json(name = "forbid_flag")
        val forbidFlag: String = "",
        @Json(name = "forbid_info")
        val forbidInfo: String = "",
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
        @Json(name = "reply_private_flag")
        val replyPrivateFlag: String = "",
        @Json(name = "tbs")
        val tbs: String = "",
        @Json(name = "voice_message")
        val voiceMessage: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class DelThreadText(
            @Json(name = "text_id")
            val textId: String = "",
            @Json(name = "text_info")
            val textInfo: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class DisplayForum(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "ext")
        val ext: String = "",
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
        @Json(name = "is_signed")
        val isSigned: String = "",
        @Json(name = "level_id")
        val levelId: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "second_class")
        val secondClass: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Forum(
        @Json(name = "album_forum")
        val albumForum: String = "",
        @Json(name = "album_good_smallflow")
        val albumGoodSmallflow: String = "",
        @Json(name = "ban_pic_topic")
        val banPicTopic: String = "",
        @Json(name = "first_class")
        val firstClass: String = "",
        @Json(name = "forbid_flag")
        val forbidFlag: String = "",
        @Json(name = "has_forum_light")
        val hasForumLight: String = "",
        @Json(name = "has_paper")
        val hasPaper: String = "",
        @Json(name = "has_picture_frs")
        val hasPictureFrs: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_album_post")
        val isAlbumPost: String = "",
        @Json(name = "is_brand_forum")
        val isBrandForum: String = "",
        @Json(name = "is_exists")
        val isExists: String = "",
        @Json(name = "is_like")
        val isLike: String = "",
        @Json(name = "is_meizhi")
        val isMeizhi: String = "",
        @Json(name = "is_readonly")
        val isReadonly: String = "",
        @Json(name = "managers")
        val managers: List<Manager> = listOf(),
        @Json(name = "name")
        val name: String = "",
        @Json(name = "no_post_pic")
        val noPostPic: String = "",
        @Json(name = "second_class")
        val secondClass: String = "",
        @Json(name = "shield_post")
        val shieldPost: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Manager(
            @Json(name = "id")
            val id: String = "",
            @Json(name = "name")
            val name: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Page(
        @Json(name = "current_page")
        val currentPage: String = "",
        @Json(name = "page_size")
        val pageSize: String = "",
        @Json(name = "total_count")
        val totalCount: String = "",
        @Json(name = "total_page")
        val totalPage: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Perm(
        @Json(name = "block_type")
        val blockType: String = "",
        @Json(name = "grade")
        val grade: Grade = Grade(),
        @Json(name = "perm")
        val perm: PermX = PermX(),
//        @Json(name = "tip")
//        val tip: List<Any> = listOf(),
        @Json(name = "ueg_type")
        val uegType: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Grade(
            @Json(name = "cur_score")
            val curScore: String = "",
            @Json(name = "forum_id")
            val forumId: String = "",
            @Json(name = "func_name")
            val funcName: String = "",
            @Json(name = "in_time")
            val inTime: String = "",
            @Json(name = "is_black")
            val isBlack: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
            @Json(name = "is_top")
            val isTop: String = "",
            @Json(name = "level_id")
            val levelId: String = "",
            @Json(name = "level_name")
            val levelName: String = "",
            @Json(name = "like_num")
            val likeNum: String = "",
            @Json(name = "score_left")
            val scoreLeft: String = "",
            @Json(name = "user_id")
            val userId: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class PermX(
            @Json(name = "can_add_celebrity")
            val canAddCelebrity: String = "",
            @Json(name = "can_add_manager_team")
            val canAddManagerTeam: String = "",
            @Json(name = "can_bws_bawu_center")
            val canBwsBawuCenter: String = "",
            @Json(name = "can_bws_bawu_info")
            val canBwsBawuInfo: String = "",
            @Json(name = "can_bws_bawu_log")
            val canBwsBawuLog: String = "",
            @Json(name = "can_bws_FDS")
            val canBwsFDS: String = "",
            @Json(name = "can_bws_filter_ip_tbs")
            val canBwsFilterIpTbs: String = "",
            @Json(name = "can_bws_limit_bawu_log")
            val canBwsLimitBawuLog: String = "",
            @Json(name = "can_cancel_mask_delete")
            val canCancelMaskDelete: String = "",
            @Json(name = "can_cancel_mask_good")
            val canCancelMaskGood: String = "",
            @Json(name = "can_cancel_mask_top")
            val canCancelMaskTop: String = "",
            @Json(name = "can_del_manager_team")
            val canDelManagerTeam: String = "",
            @Json(name = "can_edit_bakan")
            val canEditBakan: String = "",
            @Json(name = "can_edit_daquan")
            val canEditDaquan: String = "",
            @Json(name = "can_edit_gconforum")
            val canEditGconforum: String = "",
            @Json(name = "can_filter_id")
            val canFilterId: String = "",
            @Json(name = "can_filter_ip")
            val canFilterIp: String = "",
            @Json(name = "can_mask_delete")
            val canMaskDelete: String = "",
            @Json(name = "can_mask_good")
            val canMaskGood: String = "",
            @Json(name = "can_mask_top")
            val canMaskTop: String = "",
            @Json(name = "can_member_top")
            val canMemberTop: String = "",
            @Json(name = "can_op_as_4thmgr")
            val canOpAs4thmgr: String = "",
            @Json(name = "can_op_as_broadcast_admin")
            val canOpAsBroadcastAdmin: String = "",
            @Json(name = "can_op_as_category_editor")
            val canOpAsCategoryEditor: String = "",
            @Json(name = "can_op_as_editor")
            val canOpAsEditor: String = "",
            @Json(name = "can_op_as_entertainment_manager")
            val canOpAsEntertainmentManager: String = "",
            @Json(name = "can_op_as_operator")
            val canOpAsOperator: String = "",
            @Json(name = "can_op_as_profession_manager")
            val canOpAsProfessionManager: String = "",
            @Json(name = "can_op_as_vertical_operator")
            val canOpAsVerticalOperator: String = "",
            @Json(name = "can_op_common_bawu")
            val canOpCommonBawu: String = "",
            @Json(name = "can_op_disk")
            val canOpDisk: String = "",
            @Json(name = "can_op_FDS")
            val canOpFDS: String = "",
            @Json(name = "can_op_frsbg")
            val canOpFrsbg: String = "",
            @Json(name = "can_op_good_class")
            val canOpGoodClass: String = "",
            @Json(name = "can_op_pic")
            val canOpPic: String = "",
            @Json(name = "can_op_topic")
            val canOpTopic: String = "",
            @Json(name = "can_op_video")
            val canOpVideo: String = "",
            @Json(name = "can_op_wise_group")
            val canOpWiseGroup: String = "",
            @Json(name = "can_paper_ignore_vcode")
            val canPaperIgnoreVcode: String = "",
            @Json(name = "can_pass_media_limit")
            val canPassMediaLimit: String = "",
            @Json(name = "can_post")
            val canPost: String = "",
            @Json(name = "can_post_frs")
            val canPostFrs: String = "",
            @Json(name = "can_post_pb")
            val canPostPb: String = "",
            @Json(name = "can_send_memo")
            val canSendMemo: String = "",
            @Json(name = "can_super")
            val canSuper: String = "",
            @Json(name = "can_tobe_assist")
            val canTobeAssist: String = "",
            @Json(name = "can_tobe_editor")
            val canTobeEditor: String = "",
            @Json(name = "can_tobe_manager")
            val canTobeManager: String = "",
            @Json(name = "can_tobe_pri_content_assist")
            val canTobePriContentAssist: String = "",
            @Json(name = "can_tobe_pri_manage_assist")
            val canTobePriManageAssist: String = "",
            @Json(name = "can_toms_operator_alt_basic")
            val canTomsOperatorAltBasic: String = "",
            @Json(name = "can_toms_operator_basic")
            val canTomsOperatorBasic: String = "",
            @Json(name = "can_type1_audit_post")
            val canType1AuditPost: String = "",
            @Json(name = "can_type2_audit_post")
            val canType2AuditPost: String = "",
            @Json(name = "can_type3_audit_post")
            val canType3AuditPost: String = "",
            @Json(name = "can_type4_audit_post")
            val canType4AuditPost: String = "",
            @Json(name = "can_type5_audit_post")
            val canType5AuditPost: String = "",
            @Json(name = "can_unknown")
            val canUnknown: String = "",
            @Json(name = "can_view_freq")
            val canViewFreq: String = "",
            @Json(name = "can_vip_jubao")
            val canVipJubao: String = "",
            @Json(name = "can_vote")
            val canVote: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Post(
        @Json(name = "agree")
        val agree: Agree = Agree(),
//        @Json(name = "arr_video")
//        val arrVideo: List<Any> = listOf(),
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "baijiahao_info")
        val baijiahaoInfo: String = "",
        @Json(name = "bimg_url")
        val bimgUrl: String = "",
        @Json(name = "content")
        val content: List<Content> = listOf(),
        @Json(name = "floor")
        val floor: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "ios_bimg_format")
        val iosBimgFormat: String = "",
        @Json(name = "is_bubble_thread")
        val isBubbleThread: String = "",
        @Json(name = "is_colorfull_thread")
        val isColorfullThread: String = "",
        @Json(name = "is_voice")
        val isVoice: String = "",
        @Json(name = "is_vote")
        val isVote: String = "",
//        @Json(name = "lbs_info")
//        val lbsInfo: List<Any> = listOf(),
        @Json(name = "ptype")
        val ptype: String = "",
        @Json(name = "show_squared")
        val showSquared: String = "",
        @Json(name = "skin_info")
        val skinInfo: String = "",
        @Json(name = "time")
        val time: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "tpoint_post")
        val tpointPost: String = ""
//        @Json(name = "voice_info")
//        val voiceInfo: List<Any> = listOf()
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
//            @Json(name = "ala_info")
//            val alaInfo: AlaInfo = AlaInfo(),
//            @Json(name = "baijiahao_info")
//            val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
            @Json(name = "bawu_type")
            val bawuType: String = "",
            @Json(name = "gender")
            val gender: String = "",
            @Json(name = "god_data")
            val godData: String = "",
            @Json(name = "iconinfo")
            val iconinfo: List<Iconinfo> = listOf(),
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_bawu")
            val isBawu: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
            @Json(name = "is_mem")
            val isMem: String = "",
            @Json(name = "level_id")
            val levelId: Int = 0,
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
//            @Json(name = "new_tshow_icon")
//            val newTshowIcon: List<Any> = listOf(),
            @Json(name = "novel_fans_info")
            val novelFansInfo: NovelFansInfo = NovelFansInfo(),
//            @Json(name = "pendant")
//            val pendant: List<Any> = listOf(),
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "seal_prefix")
            val sealPrefix: String = "",
//            @Json(name = "spring_virtual_user")
//            val springVirtualUser: List<Any> = listOf(),
//            @Json(name = "tb_vip")
//            val tbVip: List<Any> = listOf(),
//            @Json(name = "tshow_icon")
//            val tshowIcon: List<Any> = listOf(),
            @Json(name = "type")
            val type: String = "",
            @Json(name = "uk")
            val uk: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class AlaInfo(
                @Json(name = "anchor_level_present")
                val anchorLevelPresent: String = "",
                @Json(name = "anchor_level_previous")
                val anchorLevelPrevious: String = "",
                @Json(name = "lat")
                val lat: String = "",
                @Json(name = "lng")
                val lng: String = "",
                @Json(name = "location")
                val location: String = "",
                @Json(name = "show_name")
                val showName: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BaijiahaoInfo(
                @Json(name = "avatar")
                val avatar: String = ""
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
                    val x1: String = ""
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
            data class NovelFansInfo(
                @Json(name = "level")
                val level: String = "",
                @Json(name = "level_icon")
                val levelIcon: String = "",
                @Json(name = "level_name")
                val levelName: String = ""
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class Subpost(
        @Json(name = "agree")
        val agree: Agree = Agree(),
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "content")
        val content: List<Content> = listOf(),
        @Json(name = "floor")
        val floor: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_giftpost")
        val isGiftpost: String = "",
//        @Json(name = "location")
//        val location: List<Any> = listOf(),
        @Json(name = "ptype")
        val ptype: String = "",
        @Json(name = "time")
        val time: String = "",
        @Json(name = "title")
        val title: String = ""
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
//            @Json(name = "ala_info")
//            val alaInfo: Any = Any(),
            @Json(name = "baijiahao_info")
            val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
            @Json(name = "bawu_type")
            val bawuType: String = "",
            @Json(name = "gender")
            val gender: String = "",
            @Json(name = "god_data")
            val godData: String = "",
            @Json(name = "iconinfo")
            val iconinfo: List<Iconinfo> = listOf(),
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_bawu")
            val isBawu: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
            @Json(name = "is_mem")
            val isMem: String = "",
            @Json(name = "level_id")
            val levelId: Int = 0,
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
//            @Json(name = "new_tshow_icon")
//            val newTshowIcon: List<Any> = listOf(),
//            @Json(name = "pendant")
//            val pendant: Any = Any(),
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "seal_prefix")
            val sealPrefix: String = "",
//            @Json(name = "tb_vip")
//            val tbVip: List<Any> = listOf(),
//            @Json(name = "tshow_icon")
//            val tshowIcon: List<Any> = listOf(),
            @Json(name = "type")
            val type: String = "",
            @Json(name = "uk")
            val uk: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class BaijiahaoInfo(
                @Json(name = "avatar")
                val avatar: String = ""
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
        }
    }

    @JsonClass(generateAdapter = true)
    data class Thread(
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "collect_mark_pid")
        val collectMarkPid: String = "",
        @Json(name = "collect_status")
        val collectStatus: String = "",
        @Json(name = "comment_num")
        val commentNum: String = "",
        @Json(name = "ecom")
        val ecom: String = "",
        @Json(name = "fid")
        val fid: String = "",
        @Json(name = "fname")
        val fname: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_ad")
        val isAd: String = "",
        @Json(name = "isLzDeleteAll")
        val isLzDeleteAll: String = "",
        @Json(name = "is_multiforum_thread")
        val isMultiforumThread: String = "",
        @Json(name = "pids")
        val pids: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "repost_num")
        val repostNum: String = "",
        @Json(name = "thread_id")
        val threadId: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "topic")
        val topic: Topic = Topic(),
//        @Json(name = "twzhibo_info")
//        val twzhiboInfo: TwzhiboInfo = TwzhiboInfo(),
        @Json(name = "user_id")
        val userId: String = "",
        @Json(name = "valid_post_num")
        val validPostNum: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Author(
//            @Json(name = "ala_info")
//            val alaInfo: AlaInfo = AlaInfo(),
            @Json(name = "baijiahao_info")
            val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
            @Json(name = "id")
            val id: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
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
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "tshow_icon")
            val tshowIcon: List<TshowIcon> = listOf(),
            @Json(name = "type")
            val type: String = "",
            @Json(name = "uk")
            val uk: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class AlaInfo(
                @Json(name = "lat")
                val lat: String = "",
                @Json(name = "lng")
                val lng: String = "",
                @Json(name = "location")
                val location: String = "",
                @Json(name = "show_name")
                val showName: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BaijiahaoInfo(
                @Json(name = "avatar")
                val avatar: String = ""
            )

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
        data class Topic(
            @Json(name = "is_live_post")
            val isLivePost: String = "",
            @Json(name = "is_lpost")
            val isLpost: String = "",
            @Json(name = "is_topic")
            val isTopic: String = "",
            @Json(name = "lpost_type")
            val lpostType: String = "",
            @Json(name = "topic_type")
            val topicType: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class TwzhiboInfo(
            @Json(name = "content")
            val content: String = "",
            @Json(name = "forumId")
            val forumId: String = "",
            @Json(name = "forum_name")
            val forumName: String = "",
            @Json(name = "freq_num")
            val freqNum: String = "",
            @Json(name = "is_deleted")
            val isDeleted: String = "",
            @Json(name = "is_headline")
            val isHeadline: String = "",
            @Json(name = "is_new_headline")
            val isNewHeadline: String = "",
//            @Json(name = "label_info")
//            val labelInfo: List<Any> = listOf(),
//            @Json(name = "labels")
//            val labels: List<Any> = listOf(),
            @Json(name = "last_modified_time")
            val lastModifiedTime: String = "",
            @Json(name = "lastPostId")
            val lastPostId: String = "",
            @Json(name = "livecover_src")
            val livecoverSrc: String = "",
            @Json(name = "media")
            val media: String = "",
            @Json(name = "post_num")
            val postNum: String = "",
            @Json(name = "raw_abstract_media")
            val rawAbstractMedia: String = "",
            @Json(name = "replyNum")
            val replyNum: String = "",
            @Json(name = "thread_id")
            val threadId: String = "",
            @Json(name = "title")
            val title: String = "",
            @Json(name = "user")
            val user: User = User(),
            @Json(name = "user_id")
            val userId: String = "",
            @Json(name = "userInfo")
            val userInfo: UserInfo = UserInfo()
        ) {
            @JsonClass(generateAdapter = true)
            data class User(
                @Json(name = "fansNickname")
                val fansNickname: String = "",
                @Json(name = "fans_num")
                val fansNum: String = "",
                @Json(name = "id")
                val id: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "portrait")
                val portrait: String = "",
                @Json(name = "userId")
                val userId: String = "",
                @Json(name = "userName")
                val userName: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class UserInfo(
                @Json(name = "fansNickname")
                val fansNickname: String = "",
                @Json(name = "fans_num")
                val fansNum: String = "",
                @Json(name = "id")
                val id: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "portrait")
                val portrait: String = "",
                @Json(name = "userId")
                val userId: String = "",
                @Json(name = "userName")
                val userName: String = ""
            )
        }
    }
}