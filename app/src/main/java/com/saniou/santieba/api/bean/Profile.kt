package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Profile(
    @Json(name = "ala_live_info")
    val alaLiveInfo: Any = Any(),
    @Json(name = "ala_live_record")
    val alaLiveRecord: Any = Any(),
    @Json(name = "anti")
    val anti: Anti = Anti(),
    @Json(name = "anti_stat")
    val antiStat: AntiStat = AntiStat(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "duxiaoman")
    val duxiaoman: Duxiaoman = Duxiaoman(),
    @Json(name = "dynamic_list")
    val dynamicList: Any = Any(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "goods_win")
    val goodsWin: GoodsWin = GoodsWin(),
    @Json(name = "highs")
    val highs: Any = Any(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "mask_type")
    val maskType: String = "",
    @Json(name = "newest_dynamic_list")
    val newestDynamicList: Any = Any(),
    @Json(name = "nickname_info")
    val nicknameInfo: NicknameInfo = NicknameInfo(),
    @Json(name = "post_list")
    val postList: List<Post> = listOf(),
    @Json(name = "recom_swan_list")
    val recomSwanList: Any = Any(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "tainfo")
    val tainfo: Tainfo = Tainfo(),
    @Json(name = "tbbookrack")
    val tbbookrack: Any = Any(),
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "uc_card")
    val ucCard: UcCard = UcCard(),
    @Json(name = "url_map")
    val urlMap: List<UrlMap> = listOf(),
    @Json(name = "user")
    val user: User = User(),
    @Json(name = "user_agree_info")
    val userAgreeInfo: UserAgreeInfo = UserAgreeInfo(),
    @Json(name = "user_god_info")
    val userGodInfo: Any = Any(),
    @Json(name = "video_channel_info")
    val videoChannelInfo: VideoChannelInfo = VideoChannelInfo(),
    @Json(name = "window")
    val window: Any = Any()
) {
    @JsonClass(generateAdapter = true)
    data class Anti(
        @Json(name = "tbs")
        val tbs: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class AntiStat(
        @Json(name = "block_stat")
        val blockStat: String = "",
        @Json(name = "days_tofree")
        val daysTofree: String = "",
        @Json(name = "has_chance")
        val hasChance: String = "",
        @Json(name = "hide_stat")
        val hideStat: String = "",
        @Json(name = "vcode_stat")
        val vcodeStat: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Duxiaoman(
        @Json(name = "is_end")
        val isEnd: String = "",
        @Json(name = "total_cash")
        val totalCash: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class GoodsWin(
        @Json(name = "goods_url")
        val goodsUrl: String = "",
        @Json(name = "show")
        val show: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class NicknameInfo(
        @Json(name = "left_days")
        val leftDays: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Post(
        @Json(name = "abstract")
        val `abstract`: List<Abstract> = listOf(),
        @Json(name = "agree_num")
        val agreeNum: String = "",
        @Json(name = "content")
        val content: String = "",
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "diff_agree_num")
        val diffAgreeNum: String = "",
        @Json(name = "disagree_num")
        val disagreeNum: String = "",
        @Json(name = "first_post_content")
        val firstPostContent: List<FirstPostContent> = listOf(),
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "freq_num")
        val freqNum: String = "",
        @Json(name = "is_ntitle")
        val isNtitle: String = "",
        @Json(name = "is_post_deleted")
        val isPostDeleted: String = "",
        @Json(name = "is_pro_thread")
        val isProThread: String = "",
        @Json(name = "is_remain")
        val isRemain: String = "",
        @Json(name = "is_thread")
        val isThread: String = "",
        @Json(name = "is_uegnaudited")
        val isUegnaudited: String = "",
        @Json(name = "is_view_year")
        val isViewYear: String = "",
        @Json(name = "media")
        val media: List<Media> = listOf(),
        @Json(name = "post_id")
        val postId: String = "",
        @Json(name = "ptype")
        val ptype: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "share_num")
        val shareNum: String = "",
        @Json(name = "thread_id")
        val threadId: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "user_id")
        val userId: String = "",
        @Json(name = "user_name")
        val userName: String = "",
        @Json(name = "user_portrait")
        val userPortrait: String = "",
        @Json(name = "video_info")
        val videoInfo: VideoInfo = VideoInfo()
    ) {
        @JsonClass(generateAdapter = true)
        data class Abstract(
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class FirstPostContent(
            @Json(name = "bsize")
            val bsize: String = "",
            @Json(name = "c")
            val c: String = "",
            @Json(name = "during_time")
            val duringTime: String = "",
            @Json(name = "e_type")
            val eType: String = "",
            @Json(name = "height")
            val height: String = "",
            @Json(name = "link")
            val link: String = "",
            @Json(name = "origin_size")
            val originSize: String = "",
            @Json(name = "origin_src")
            val originSrc: String = "",
            @Json(name = "size")
            val size: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "width")
            val width: String = "",
            @Json(name = "uid")
            val uid: String = "",
            @Json(name = "un")
            val un: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "big_pic")
            val bigPic: String = "",
            @Json(name = "dynamic_pic")
            val dynamicPic: String = "",
            @Json(name = "height")
            val height: String = "",
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
            @Json(name = "small_pic")
            val smallPic: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "src_pic")
            val srcPic: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "vhsrc")
            val vhsrc: String = "",
            @Json(name = "vpic")
            val vpic: String = "",
            @Json(name = "vsrc")
            val vsrc: String = "",
            @Json(name = "water_pic")
            val waterPic: String = "",
            @Json(name = "width")
            val width: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class VideoInfo(
            @Json(name = "auditing")
            val auditing: String = "",
            @Json(name = "format_matched")
            val formatMatched: String = "",
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
            @Json(name = "version_h265")
            val versionH265: String = "",
            @Json(name = "video_desc")
            val videoDesc: List<VideoDesc> = listOf(),
            @Json(name = "video_desc_cae")
            val videoDescCae: List<VideoDescCae> = listOf(),
            @Json(name = "video_desc_h265")
            val videoDescH265: List<VideoDescH265> = listOf(),
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

            @JsonClass(generateAdapter = true)
            data class VideoDescCae(
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

            @JsonClass(generateAdapter = true)
            data class VideoDescH265(
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
    data class Tainfo(
        @Json(name = "distanceinfo")
        val distanceinfo: Distanceinfo = Distanceinfo(),
        @Json(name = "friend_add_type")
        val friendAddType: String = "",
        @Json(name = "friendnum")
        val friendnum: String = "",
        @Json(name = "groupnum")
        val groupnum: String = "",
        @Json(name = "hide_user_feed")
        val hideUserFeed: String = "",
        @Json(name = "is_friend")
        val isFriend: String = "",
        @Json(name = "reply_list")
        val replyList: Any = Any(),
        @Json(name = "userClientVersionIsLower")
        val userClientVersionIsLower: String = "",
        @Json(name = "userIosHightestVerSion")
        val userIosHightestVerSion: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Distanceinfo(
            @Json(name = "distance")
            val distance: String = "",
            @Json(name = "time")
            val time: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class UcCard(
        @Json(name = "doc")
        val doc: String = "",
        @Json(name = "icon")
        val icon: String = "",
        @Json(name = "jmp")
        val jmp: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "uc_cards")
        val ucCards: List<UcCardX> = listOf()
    ) {
        @JsonClass(generateAdapter = true)
        data class UcCardX(
            @Json(name = "jmp")
            val jmp: String = "",
            @Json(name = "pic")
            val pic: String = "",
            @Json(name = "tip")
            val tip: String = "",
            @Json(name = "title")
            val title: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class UrlMap(
        @Json(name = "id")
        val id: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "url")
        val url: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class User(
//        @Json(name = "ala_info")
//        val alaInfo: AlaInfo = AlaInfo(),
        @Json(name = "baijiahao_info")
        val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
        @Json(name = "bg_pic")
        val bgPic: String = "",
        @Json(name = "bookmark_count")
        val bookmarkCount: String = "",
        @Json(name = "bookmark_new_count")
        val bookmarkNewCount: String = "",
        @Json(name = "can_modify_avatar")
        val canModifyAvatar: String = "",
        @Json(name = "concern_num")
        val concernNum: String = "",
        @Json(name = "consume_info")
        val consumeInfo: Any = Any(),
        @Json(name = "fans_num")
        val fansNum: String = "",
        @Json(name = "friend_num")
        val friendNum: String = "",
        @Json(name = "has_bottle_enter")
        val hasBottleEnter: String = "",
        @Json(name = "has_concerned")
        val hasConcerned: String = "",
        @Json(name = "iconinfo")
        val iconinfo: List<Iconinfo> = listOf(),
        @Json(name = "id")
        val id: String = "",
        @Json(name = "intro")
        val intro: String = "",
        @Json(name = "is_fans")
        val isFans: String = "",
        @Json(name = "is_invited")
        val isInvited: String = "",
        @Json(name = "is_mask")
        val isMask: String = "",
        @Json(name = "is_mem")
        val isMem: String = "",
        @Json(name = "is_show_redpacket")
        val isShowRedpacket: String = "",
        @Json(name = "like_forum_num")
        val likeForumNum: String = "",
        @Json(name = "modify_avatar_desc")
        val modifyAvatarDesc: String = "",
        @Json(name = "my_like_num")
        val myLikeNum: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "outer_id")
        val outerId: String = "",
        @Json(name = "parr_scores")
        val parrScores: ParrScores = ParrScores(),
        @Json(name = "pay_member_info")
        val payMemberInfo: PayMemberInfo = PayMemberInfo(),
        @Json(name = "pendant")
        val pendant: Any = Any(),
        @Json(name = "portrait")
        val portrait: String = "",
        @Json(name = "portraith")
        val portraith: String = "",
        @Json(name = "post_num")
        val postNum: String = "",
        @Json(name = "priv_sets")
        val privSets: PrivSets = PrivSets(),
        @Json(name = "profit_list")
        val profitList: Any = Any(),
        @Json(name = "repost_num")
        val repostNum: String = "",
        @Json(name = "seal_prefix")
        val sealPrefix: String = "",
        @Json(name = "sex")
        val sex: String = "",
        @Json(name = "tb_age")
        val tbAge: String = "",
        @Json(name = "tb_vip")
        val tbVip: Any = Any(),
        @Json(name = "thread_num")
        val threadNum: String = "",
        @Json(name = "total_visitor_num")
        val totalVisitorNum: String = "",
//        @Json(name = "tshow_icon")
//        val tshowIcon: Any = Any(),
        @Json(name = "tw_anchor_info")
        val twAnchorInfo: Any = Any(),
        @Json(name = "user_pics")
        val userPics: List<UserPic> = listOf(),
        @Json(name = "vip_close_ad")
        val vipCloseAd: VipCloseAd = VipCloseAd(),
        @Json(name = "vipInfo")
        val vipInfo: VipInfo = VipInfo(),
        @Json(name = "visitor_num")
        val visitorNum: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class UserPic(
            @Json(name = "small")
            val small: String = "",
            @Json(name = "big")
            val big: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class AlaInfo(
            @Json(name = "ala_id")
            val alaId: String = "",
            @Json(name = "level_exp")
            val levelExp: String = "",
            @Json(name = "level_id")
            val levelId: String = "",
            @Json(name = "live_id")
            val liveId: String = "",
            @Json(name = "live_status")
            val liveStatus: String = "",
            @Json(name = "verify_info_status")
            val verifyInfoStatus: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class BaijiahaoInfo(
            @Json(name = "auth_desc")
            val authDesc: String = "",
            @Json(name = "auth_id")
            val authId: String = "",
            @Json(name = "avatar")
            val avatar: String = "",
            @Json(name = "avatar_h")
            val avatarH: String = "",
            @Json(name = "brief")
            val brief: String = "",
            @Json(name = "name")
            val name: String = ""
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
        data class PayMemberInfo(
            @Json(name = "end_time")
            val endTime: String = "",
            @Json(name = "expire_remind")
            val expireRemind: String = "",
            @Json(name = "props_id")
            val propsId: String = "",
            @Json(name = "url")
            val url: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Pendant(
            @Json(name = "img_url")
            val imgUrl: String = "",
            @Json(name = "props_id")
            val propsId: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class PrivSets(
            @Json(name = "friend")
            val friend: String = "",
            @Json(name = "group")
            val group: String = "",
            @Json(name = "like")
            val like: String = "",
            @Json(name = "live")
            val live: String = "",
            @Json(name = "location")
            val location: String = "",
            @Json(name = "post")
            val post: String = "",
            @Json(name = "reply")
            val reply: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class VipCloseAd(
            @Json(name = "forum_close")
            val forumClose: Any = Any(),
            @Json(name = "is_open")
            val isOpen: String = "",
            @Json(name = "vip_close")
            val vipClose: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class VipInfo(
            @Json(name = "a_score")
            val aScore: String = "",
            @Json(name = "e_time")
            val eTime: String = "",
            @Json(name = "ext_score")
            val extScore: String = "",
            @Json(name = "icon_url")
            val iconUrl: String = "",
            @Json(name = "n_score")
            val nScore: String = "",
            @Json(name = "s_time")
            val sTime: String = "",
            @Json(name = "v_level")
            val vLevel: String = "",
            @Json(name = "v_status")
            val vStatus: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class UserAgreeInfo(
        @Json(name = "total_agree_num")
        val totalAgreeNum: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class VideoChannelInfo(
        @Json(name = "follow_channel")
        val followChannel: String = "",
        @Json(name = "man_channel")
        val manChannel: String = ""
    )
}