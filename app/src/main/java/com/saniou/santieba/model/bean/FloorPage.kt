package com.saniou.santieba.model.bean

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
    @Json(name = "forum")
    val forum: Forum = Forum(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "page")
    val page: Page = Page(),
    // @Json(name = "perm")
    // val perm: Perm = Perm(),
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
            // @Json(name = "god_data")
            // val godData: List<Any> = listOf(),
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
            data class Iconinfo(
                @Json(name = "icon")
                val icon: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "position")
                val position: Position = Position(),
                // @Json(name = "sprite")
                // val sprite: Sprite = Sprite(),
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
            // @Json(name = "god_data")
            // val godData: String = "",
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
            // @Json(name = "new_tshow_icon")
            // val newTshowIcon: List<Any> = listOf(),
            @Json(name = "portrait")
            val portrait: String = "",
            // @Json(name = "tshow_icon")
            // val tshowIcon: List<Any> = listOf(),
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
    }
}