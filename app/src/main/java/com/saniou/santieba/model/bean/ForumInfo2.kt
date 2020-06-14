package com.saniou.santieba.model.bean

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ForumInfo(
    @Json(name = "data")
    val `data`: Data = Data(),
    @Json(name = "error")
    val error: String = "",
    @Json(name = "no")
    val no: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "abstract_mode")
        val abstractMode: Int = 0,
        @Json(name = "abtest")
        val abtest: Abtest = Abtest(),
        @Json(name = "ad_feed")
        val adFeed: List<Any> = listOf(),
        @Json(name = "ad_floor")
        val adFloor: List<Int> = listOf(),
        @Json(name = "android_client_version")
        val androidClientVersion: String = "",
        @Json(name = "base")
        val base: Base = Base(),
        @Json(name = "bottom_menu")
        val bottomMenu: Any = Any(),
        @Json(name = "current_tab_id")
        val currentTabId: Int = 0,
        @Json(name = "discussion_post")
        val discussionPost: List<Any> = listOf(),
        @Json(name = "duoku_games")
        val duokuGames: List<Any> = listOf(),
        @Json(name = "fitSignPop")
        val fitSignPop: Any = Any(),
        @Json(name = "forum_seen")
        val forumSeen: List<Any> = listOf(),
        @Json(name = "frs_data")
        val frsData: FrsData = FrsData(),
        @Json(name = "frs_hotthread_floor")
        val frsHotthreadFloor: String = "",
        @Json(name = "gaokao_recom_forum")
        val gaokaoRecomForum: Any = Any(),
        @Json(name = "gaokao_tab_info")
        val gaokaoTabInfo: Any = Any(),
        @Json(name = "group_count")
        val groupCount: Any = Any(),
        @Json(name = "invoke_type")
        val invokeType: Int = 0,
        @Json(name = "is_newfrs")
        val isNewfrs: Int = 0,
        @Json(name = "like_forum")
        val likeForum: List<Any> = listOf(),
        @Json(name = "message")
        val message: Message = Message(),
        @Json(name = "meta")
        val meta: Meta = Meta(),
        @Json(name = "nav_tab_info")
        val navTabInfo: List<NavTabInfo> = listOf(),
        @Json(name = "nav_tab_list")
        val navTabList: List<NavTab> = listOf(),
        @Json(name = "net_type")
        val netType: Int = 0,
        @Json(name = "page")
        val page: Page = Page(),
        @Json(name = "pb_cut_floor")
        val pbCutFloor: String = "",
        @Json(name = "pbhotswitch")
        val pbhotswitch: Int = 0,
        @Json(name = "person_operate")
        val personOperate: PersonOperate = PersonOperate(),
        @Json(name = "post_form")
        val postForm: List<Any> = listOf(),
        @Json(name = "recommend_forum_list")
        val recommendForumList: List<Any> = listOf(),
        @Json(name = "redpacketflagext")
        val redpacketflagext: Redpacketflagext = Redpacketflagext(),
        @Json(name = "saveflow_pattern")
        val saveflowPattern: Int = 0,
        @Json(name = "show_as_bottom")
        val showAsBottom: Any = Any(),
        @Json(name = "show_as_top")
        val showAsTop: Any = Any(),
        @Json(name = "tokens")
        val tokens: Tokens = Tokens(),
        @Json(name = "Turnkey")
        val turnkey: List<Any> = listOf(),
        @Json(name = "user")
        val user: User = User(),
        @Json(name = "user_guide_pop")
        val userGuidePop: UserGuidePop = UserGuidePop(),
        @Json(name = "wreq")
        val wreq: Wreq = Wreq()
    ) {
        @JsonClass(generateAdapter = true)
        data class Abtest(
            @Json(name = "ue_revision")
            val ueRevision: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class Base(
            @Json(name = "baidu_id")
            val baiduId: String = "",
            @Json(name = "bdstoken")
            val bdstoken: String = "",
            @Json(name = "cms_data")
            val cmsData: Int = 0,
            @Json(name = "cur_url")
            val curUrl: String = "",
            @Json(name = "domain")
            val domain: String = "",
            @Json(name = "err_no")
            val errNo: Int = 0,
            @Json(name = "has_url_param")
            val hasUrlParam: Boolean = false,
            @Json(name = "is_support_cookie")
            val isSupportCookie: Boolean = false,
            @Json(name = "query_string")
            val queryString: String = "",
            @Json(name = "refer")
            val refer: Any = Any(),
            @Json(name = "request_uri")
            val requestUri: String = "",
            @Json(name = "tieba_err_no")
            val tiebaErrNo: Int = 0,
            @Json(name = "tieba_msg")
            val tiebaMsg: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class FrsData(
            @Json(name = "anti")
            val anti: Anti = Anti(),
            @Json(name = "badges")
            val badges: List<Any> = listOf(),
            @Json(name = "fortune_bag")
            val fortuneBag: Any = Any(),
            @Json(name = "forum")
            val forum: Forum = Forum(),
            @Json(name = "frs_for_app")
            val frsForApp: List<Any> = listOf(),
            @Json(name = "frs_star")
            val frsStar: FrsStar = FrsStar(),
            @Json(name = "group")
            val group: List<Any> = listOf(),
            @Json(name = "page")
            val page: Page = Page(),
            @Json(name = "thread_list")
            val threadList: List<Thread> = listOf(),
            @Json(name = "user")
            val user: User = User()
        ) {
            @JsonClass(generateAdapter = true)
            data class Anti(
                @Json(name = "block_stat")
                val blockStat: Int = 0,
                @Json(name = "days_tofree")
                val daysTofree: Int = 0,
                @Json(name = "forbid_flag")
                val forbidFlag: Int = 0,
                @Json(name = "forbid_info")
                val forbidInfo: String = "",
                @Json(name = "has_chance")
                val hasChance: Int = 0,
                @Json(name = "hide_stat")
                val hideStat: Int = 0,
                @Json(name = "ifpost")
                val ifpost: Int = 0,
                @Json(name = "ifposta")
                val ifposta: Int = 0,
                @Json(name = "tbs")
                val tbs: String = "",
                @Json(name = "vcode_stat")
                val vcodeStat: Int = 0
            )

            @JsonClass(generateAdapter = true)
            data class Forum(
                @Json(name = "activityhead_id")
                val activityheadId: Any = Any(),
                @Json(name = "activityhead_res_id")
                val activityheadResId: Any = Any(),
                @Json(name = "album_open_photo_frs")
                val albumOpenPhotoFrs: Boolean = false,
                @Json(name = "attrs")
                val attrs: Attrs = Attrs(),
                @Json(name = "avatar")
                val avatar: String = "",
                @Json(name = "banner")
                val banner: Banner = Banner(),
                @Json(name = "cur_score")
                val curScore: Int = 0,
                @Json(name = "data_type")
                val dataType: String = "",
                @Json(name = "first_class")
                val firstClass: String = "",
                @Json(name = "forum_button")
                val forumButton: ForumButton = ForumButton(),
                @Json(name = "good_classify")
                val goodClassify: List<GoodClassify> = listOf(),
                @Json(name = "has_frs_star")
                val hasFrsStar: Int = 0,
                @Json(name = "has_postpre")
                val hasPostpre: Boolean = false,
                @Json(name = "has_pro_zone")
                val hasProZone: Boolean = false,
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "is_exists")
                val isExists: Boolean = false,
                @Json(name = "isImageForum")
                val isImageForum: Boolean = false,
                @Json(name = "is_like")
                val isLike: Int = 0,
                @Json(name = "is_readonly")
                val isReadonly: String = "",
                @Json(name = "is_search_people")
                val isSearchPeople: Boolean = false,
                @Json(name = "is_stage_forum")
                val isStageForum: Boolean = false,
                @Json(name = "level_id")
                val levelId: Int = 0,
                @Json(name = "level_name")
                val levelName: String = "",
                @Json(name = "levelup_score")
                val levelupScore: Int = 0,
                @Json(name = "managers")
                val managers: List<Manager> = listOf(),
                @Json(name = "member_num")
                val memberNum: Int = 0,
                @Json(name = "name")
                val name: String = "",
                @Json(name = "pic_top_type")
                val picTopType: String = "",
                @Json(name = "portrait_url")
                val portraitUrl: String = "",
                @Json(name = "post_num")
                val postNum: Int = 0,
                @Json(name = "post_prefix")
                val postPrefix: PostPrefix = PostPrefix(),
                @Json(name = "pro_thread_num")
                val proThreadNum: Int = 0,
                @Json(name = "relation_forum")
                val relationForum: Any = Any(),
                @Json(name = "second_class")
                val secondClass: String = "",
                @Json(name = "sign_in_info")
                val signInInfo: SignInInfo = SignInInfo(),
                @Json(name = "slogan")
                val slogan: String = "",
                @Json(name = "smart_app_list")
                val smartAppList: List<Any> = listOf(),
                @Json(name = "swan_f_share_image")
                val swanFShareImage: String = "",
                @Json(name = "tag_info")
                val tagInfo: List<Any> = listOf(),
                @Json(name = "theme_color")
                val themeColor: ThemeColor = ThemeColor(),
                @Json(name = "thread_num")
                val threadNum: Int = 0,
                @Json(name = "tids")
                val tids: String = "",
                @Json(name = "top_notice")
                val topNotice: List<Any> = listOf(),
                @Json(name = "user_level")
                val userLevel: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Attrs(
                    @Json(name = "ala_live_count")
                    val alaLiveCount: Int = 0,
                    @Json(name = "bakan_p1")
                    val bakanP1: BakanP1 = BakanP1(),
                    @Json(name = "bonus_user_rank")
                    val bonusUserRank: BonusUserRank = BonusUserRank(),
                    @Json(name = "bottle_baw")
                    val bottleBaw: Int = 0,
                    @Json(name = "broadcast")
                    val broadcast: Int = 0,
                    @Json(name = "card_p1")
                    val cardP1: CardP1 = CardP1(),
                    @Json(name = "celebrity")
                    val celebrity: Celebrity = Celebrity(),
                    @Json(name = "customlink_p1")
                    val customlinkP1: CustomlinkP1 = CustomlinkP1(),
                    @Json(name = "doubletwo_p1")
                    val doubletwoP1: DoubletwoP1 = DoubletwoP1(),
                    @Json(name = "f_share_img")
                    val fShareImg: String = "",
                    @Json(name = "forum_card")
                    val forumCard: String = "",
                    @Json(name = "forum_grade")
                    val forumGrade: ForumGrade = ForumGrade(),
                    @Json(name = "forum_live")
                    val forumLive: List<ForumLive> = listOf(),
                    @Json(name = "forum_ordinary")
                    val forumOrdinary: ForumOrdinary = ForumOrdinary(),
                    @Json(name = "forumskin")
                    val forumskin: Forumskin = Forumskin(),
                    @Json(name = "frs_app_sug")
                    val frsAppSug: String = "",
                    @Json(name = "frs_banner")
                    val frsBanner: String = "",
                    @Json(name = "giftpkgs")
                    val giftpkgs: List<Giftpkg> = listOf(),
                    @Json(name = "group_count_in_forum")
                    val groupCountInForum: Int = 0,
                    @Json(name = "has_activityhead")
                    val hasActivityhead: HasActivityhead = HasActivityhead(),
                    @Json(name = "has_forum_tag")
                    val hasForumTag: Int = 0,
                    @Json(name = "have_ad")
                    val haveAd: Int = 0,
                    @Json(name = "is_smart_frs_forum")
                    val isSmartFrsForum: Int = 0,
                    @Json(name = "minigamead_p1")
                    val minigameadP1: MinigameadP1 = MinigameadP1(),
                    @Json(name = "noticemo_p1")
                    val noticemoP1: NoticemoP1 = NoticemoP1(),
                    @Json(name = "noticepc_p1")
                    val noticepcP1: NoticepcP1 = NoticepcP1(),
                    @Json(name = "novel")
                    val novel: Novel = Novel(),
                    @Json(name = "photo_p1")
                    val photoP1: PhotoP1 = PhotoP1(),
                    @Json(name = "prefix_p1")
                    val prefixP1: PrefixP1 = PrefixP1(),
                    @Json(name = "pushinfo")
                    val pushinfo: Pushinfo = Pushinfo(),
                    @Json(name = "redpackage_p1")
                    val redpackageP1: RedpackageP1 = RedpackageP1(),
                    @Json(name = "tab_name")
                    val tabName: String = "",
                    @Json(name = "tabs_info")
                    val tabsInfo: TabsInfo = TabsInfo(),
                    @Json(name = "tbread_book")
                    val tbreadBook: TbreadBook = TbreadBook(),
                    @Json(name = "theme_color")
                    val themeColor: String = "",
                    @Json(name = "toutu")
                    val toutu: Toutu = Toutu(),
                    @Json(name = "ueg_forum_vecotor")
                    val uegForumVecotor: String = "",
                    @Json(name = "video_p1")
                    val videoP1: VideoP1 = VideoP1(),
                    @Json(name = "zyqdefine")
                    val zyqdefine: Map<String, String> = mapOf(),
                    @Json(name = "zyqfriend")
                    val zyqfriend: List<String> = listOf(),
                    @Json(name = "zyqtitle")
                    val zyqtitle: String = ""
                ) {
                    @JsonClass(generateAdapter = true)
                    data class BakanP1(
                        @Json(name = "module_id")
                        val moduleId: Int = 0,
                        @Json(name = "style_id")
                        val styleId: Int = 0,
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class BonusUserRank(
                        @Json(name = "bn")
                        val bn: String = "",
                        @Json(name = "rk")
                        val rk: List<Rk> = listOf(),
                        @Json(name = "tn")
                        val tn: String = ""
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class Rk(
                            @Json(name = "level")
                            val level: Any = Any(),
                            @Json(name = "portrait")
                            val portrait: String = "",
                            @Json(name = "scores")
                            val scores: String = "",
                            @Json(name = "user_id")
                            val userId: String = "",
                            @Json(name = "user_name")
                            val userName: String = ""
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class CardP1(
                        @Json(name = "module_id")
                        val moduleId: String = "",
                        @Json(name = "style_id")
                        val styleId: String = "",
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class Celebrity(
                        @Json(name = "celebrity_status")
                        val celebrityStatus: String = "",
                        @Json(name = "fans_head_pic")
                        val fansHeadPic: String = "",
                        @Json(name = "fans_name")
                        val fansName: String = "",
                        @Json(name = "fans_tail_pic")
                        val fansTailPic: String = "",
                        @Json(name = "npc_info")
                        val npcInfo: List<NpcInfo> = listOf()
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class NpcInfo(
                            @Json(name = "cur_level")
                            val curLevel: Int = 0,
                            @Json(name = "level_id")
                            val levelId: Int = 0,
                            @Json(name = "level_name")
                            val levelName: String = "",
                            @Json(name = "npc_avatar")
                            val npcAvatar: String = "",
                            @Json(name = "npc_fans_name")
                            val npcFansName: String = "",
                            @Json(name = "npc_id")
                            val npcId: Int = 0,
                            @Json(name = "npc_name")
                            val npcName: String = "",
                            @Json(name = "npc_rank")
                            val npcRank: Int = 0,
                            @Json(name = "npc_vip_level")
                            val npcVipLevel: Int = 0,
                            @Json(name = "props_id")
                            val propsId: String = "",
                            @Json(name = "props_title")
                            val propsTitle: String = ""
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class CustomlinkP1(
                        @Json(name = "module_id")
                        val moduleId: String = "",
                        @Json(name = "style_id")
                        val styleId: String = "",
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class DoubletwoP1(
                        @Json(name = "module_id")
                        val moduleId: Int = 0,
                        @Json(name = "style_id")
                        val styleId: Int = 0,
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class ForumGrade(
                        @Json(name = "grade")
                        val grade: String = "",
                        @Json(name = "op_time")
                        val opTime: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class ForumLive(
                        @Json(name = "end_time")
                        val endTime: String = "",
                        @Json(name = "extra_info")
                        val extraInfo: ExtraInfo = ExtraInfo(),
                        @Json(name = "operator_flag")
                        val operatorFlag: String = "",
                        @Json(name = "start_time")
                        val startTime: String = "",
                        @Json(name = "task_id")
                        val taskId: String = "",
                        @Json(name = "thread_id")
                        val threadId: String = "",
                        @Json(name = "type")
                        val type: String = ""
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class ExtraInfo(
                            @Json(name = "is_new")
                            val isNew: String = ""
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class ForumOrdinary(
                        @Json(name = "153784329")
                        val x153784329: X153784329 = X153784329()
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class X153784329(
                            @Json(name = "is_has_read")
                            val isHasRead: String = "",
                            @Json(name = "reason")
                            val reason: String = "",
                            @Json(name = "status")
                            val status: String = "",
                            @Json(name = "task_id")
                            val taskId: String = "",
                            @Json(name = "")
                            val x: String = ""
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class Forumskin(
                        @Json(name = "has_skin")
                        val hasSkin: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class Giftpkg(
                        @Json(name = "end_time")
                        val endTime: String = "",
                        @Json(name = "package_id")
                        val packageId: String = "",
                        @Json(name = "start_time")
                        val startTime: String = "",
                        @Json(name = "user_name")
                        val userName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class HasActivityhead(
                        @Json(name = "has_act")
                        val hasAct: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class MinigameadP1(
                        @Json(name = "game_name")
                        val gameName: String = "",
                        @Json(name = "game_type")
                        val gameType: String = "",
                        @Json(name = "props_id")
                        val propsId: String = "",
                        @Json(name = "tdou_num")
                        val tdouNum: String = "",
                        @Json(name = "update_time")
                        val updateTime: String = "",
                        @Json(name = "user_id")
                        val userId: String = "",
                        @Json(name = "user_name")
                        val userName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class NoticemoP1(
                        @Json(name = "module_id")
                        val moduleId: String = "",
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class NoticepcP1(
                        @Json(name = "module_id")
                        val moduleId: String = "",
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class Novel(
                        @Json(name = "author_id")
                        val authorId: String = "",
                        @Json(name = "author_name")
                        val authorName: String = "",
                        @Json(name = "banner_link")
                        val bannerLink: String = "",
                        @Json(name = "banner_pic")
                        val bannerPic: String = "",
                        @Json(name = "chapter_max")
                        val chapterMax: String = "",
                        @Json(name = "chapter_min")
                        val chapterMin: String = "",
                        @Json(name = "chapter_num")
                        val chapterNum: String = "",
                        @Json(name = "is_novel")
                        val isNovel: String = "",
                        @Json(name = "novel_id")
                        val novelId: String = "",
                        @Json(name = "novel_name")
                        val novelName: String = "",
                        @Json(name = "partner_id")
                        val partnerId: String = "",
                        @Json(name = "publisher_id")
                        val publisherId: String = "",
                        @Json(name = "wangju_fid")
                        val wangjuFid: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class PhotoP1(
                        @Json(name = "module_id")
                        val moduleId: Int = 0,
                        @Json(name = "style_id")
                        val styleId: Int = 0,
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class PrefixP1(
                        @Json(name = "module_id")
                        val moduleId: Int = 0,
                        @Json(name = "style_id")
                        val styleId: Int = 0,
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class Pushinfo(
                        @Json(name = "description")
                        val description: String = "",
                        @Json(name = "keywords")
                        val keywords: String = "",
                        @Json(name = "tag_title")
                        val tagTitle: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class RedpackageP1(
                        @Json(name = "ranking")
                        val ranking: List<Any> = listOf(),
                        @Json(name = "send_scores")
                        val sendScores: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class TabsInfo(
                        @Json(name = "display_info")
                        val displayInfo: DisplayInfo = DisplayInfo(),
                        @Json(name = "tab_info")
                        val tabInfo: TabInfo = TabInfo()
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class DisplayInfo(
                            @Json(name = "1")
                            val x1: X1 = X1(),
                            @Json(name = "2")
                            val x2: X2 = X2()
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class X1(
                                @Json(name = "tab_id")
                                val tabId: String = "",
                                @Json(name = "tab_name")
                                val tabName: String = ""
                            )

                            @JsonClass(generateAdapter = true)
                            data class X2(
                                @Json(name = "tab_id")
                                val tabId: String = "",
                                @Json(name = "tab_name")
                                val tabName: String = ""
                            )
                        }

                        @JsonClass(generateAdapter = true)
                        data class TabInfo(
                            @Json(name = "39622")
                            val x39622: X39622 = X39622(),
                            @Json(name = "39623")
                            val x39623: X39623 = X39623()
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class X39622(
                                @Json(name = "create_time")
                                val createTime: String = "",
                                @Json(name = "create_uid")
                                val createUid: String = "",
                                @Json(name = "forum_id")
                                val forumId: String = "",
                                @Json(name = "id")
                                val id: String = "",
                                @Json(name = "inner_sort")
                                val innerSort: String = "",
                                @Json(name = "last_op_time")
                                val lastOpTime: String = "",
                                @Json(name = "last_op_uid")
                                val lastOpUid: String = "",
                                @Json(name = "status")
                                val status: String = "",
                                @Json(name = "tab_name")
                                val tabName: String = ""
                            )

                            @JsonClass(generateAdapter = true)
                            data class X39623(
                                @Json(name = "create_time")
                                val createTime: String = "",
                                @Json(name = "create_uid")
                                val createUid: String = "",
                                @Json(name = "forum_id")
                                val forumId: String = "",
                                @Json(name = "id")
                                val id: String = "",
                                @Json(name = "inner_sort")
                                val innerSort: String = "",
                                @Json(name = "last_op_time")
                                val lastOpTime: String = "",
                                @Json(name = "last_op_uid")
                                val lastOpUid: String = "",
                                @Json(name = "status")
                                val status: String = "",
                                @Json(name = "tab_name")
                                val tabName: String = ""
                            )
                        }
                    }

                    @JsonClass(generateAdapter = true)
                    data class TbreadBook(
                        @Json(name = "author")
                        val author: String = "",
                        @Json(name = "book_cover")
                        val bookCover: String = "",
                        @Json(name = "book_id")
                        val bookId: String = "",
                        @Json(name = "book_title")
                        val bookTitle: String = "",
                        @Json(name = "forum_pic")
                        val forumPic: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class Toutu(
                        @Json(name = "module_id")
                        val moduleId: String = "",
                        @Json(name = "style_id")
                        val styleId: String = "",
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class VideoP1(
                        @Json(name = "module_id")
                        val moduleId: Int = 0,
                        @Json(name = "style_id")
                        val styleId: Int = 0,
                        @Json(name = "style_name")
                        val styleName: String = ""
                    )
                }

                @JsonClass(generateAdapter = true)
                data class Banner(
                    @Json(name = "bannerType")
                    val bannerType: Int = 0,
                    @Json(name = "bannerUrl")
                    val bannerUrl: String = "",
                    @Json(name = "value")
                    val value: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class ForumButton(
                    @Json(name = "is_blueV")
                    val isBlueV: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class GoodClassify(
                    @Json(name = "class_id")
                    val classId: Int = 0,
                    @Json(name = "class_name")
                    val className: String = "",
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "name")
                    val name: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Manager(
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "name")
                    val name: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class PostPrefix(
                    @Json(name = "mode")
                    val mode: Int = 0,
                    @Json(name = "text")
                    val text: String = "",
                    @Json(name = "time")
                    val time: String = "",
                    @Json(name = "type")
                    val type: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class SignInInfo(
                    @Json(name = "forum_info")
                    val forumInfo: ForumInfo2 = ForumInfo2(),
                    @Json(name = "user_info")
                    val userInfo: UserInfo = UserInfo()
                ) {
                    @JsonClass(generateAdapter = true)
                    data class ForumInfo2(
                        @Json(name = "current_rank_info")
                        val currentRankInfo: CurrentRankInfo = CurrentRankInfo(),
                        @Json(name = "forum_info")
                        val forumInfo: ForumInfo3 = ForumInfo3(),
                        @Json(name = "is_filter")
                        val isFilter: Boolean = false,
                        @Json(name = "is_on")
                        val isOn: Boolean = false,
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
                            val memberCount: Int = 0,
                            @Json(name = "sign_count")
                            val signCount: Int = 0,
                            @Json(name = "sign_rank")
                            val signRank: Int = 0
                        )

                        @JsonClass(generateAdapter = true)
                        data class ForumInfo3(
                            @Json(name = "forum_id")
                            val forumId: Int = 0,
                            @Json(name = "level_1_dir_name")
                            val level1DirName: String = ""
                        )

                        @JsonClass(generateAdapter = true)
                        data class MonthlyRankInfo(
                            @Json(name = "member_count")
                            val memberCount: Int = 0,
                            @Json(name = "sign_count")
                            val signCount: Int = 0,
                            @Json(name = "sign_rank")
                            val signRank: Int = 0
                        )

                        @JsonClass(generateAdapter = true)
                        data class WeeklyRankInfo(
                            @Json(name = "member_count")
                            val memberCount: Int = 0,
                            @Json(name = "sign_count")
                            val signCount: Int = 0,
                            @Json(name = "sign_rank")
                            val signRank: Int = 0
                        )

                        @JsonClass(generateAdapter = true)
                        data class YesterdayRankInfo(
                            @Json(name = "dir_rate")
                            val dirRate: String = "",
                            @Json(name = "member_count")
                            val memberCount: Int = 0,
                            @Json(name = "sign_count")
                            val signCount: Int = 0,
                            @Json(name = "sign_rank")
                            val signRank: Int = 0
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class UserInfo(
                        @Json(name = "c_sign_num")
                        val cSignNum: Int = 0,
                        @Json(name = "cont_sign_num")
                        val contSignNum: Int = 0,
                        @Json(name = "cout_total_sing_num")
                        val coutTotalSingNum: Int = 0,
                        @Json(name = "hun_sign_num")
                        val hunSignNum: Int = 0,
                        @Json(name = "is_org_disabled")
                        val isOrgDisabled: Int = 0,
                        @Json(name = "is_sign_in")
                        val isSignIn: Int = 0,
                        @Json(name = "sign_time")
                        val signTime: Int = 0,
                        @Json(name = "total_resign_num")
                        val totalResignNum: Int = 0,
                        @Json(name = "user_id")
                        val userId: Int = 0,
                        @Json(name = "user_sign_rank")
                        val userSignRank: Int = 0
                    )
                }

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
                        val lightColor: String = ""
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
                val fans: Fans = Fans(),
                @Json(name = "focus")
                val focus: List<Any> = listOf(),
                @Json(name = "gender")
                val gender: Int = 0,
                @Json(name = "good")
                val good: Good = Good(),
                @Json(name = "has_frs_star")
                val hasFrsStar: Int = 0,
                @Json(name = "head")
                val head: String = "",
                @Json(name = "identify")
                val identify: Identify = Identify(),
                @Json(name = "info")
                val info: Info = Info(),
                @Json(name = "music")
                val music: Music = Music(),
                @Json(name = "mv")
                val mv: Mv = Mv(),
                @Json(name = "photo")
                val photo: Photo = Photo(),
                @Json(name = "top")
                val top: String = "",
                @Json(name = "video")
                val video: Video = Video()
            ) {
                @JsonClass(generateAdapter = true)
                data class Fans(
                    @Json(name = "is_get")
                    val isGet: Int = 0,
                    @Json(name = "left_time")
                    val leftTime: Int = 0,
                    @Json(name = "num")
                    val num: Int = 0,
                    @Json(name = "open")
                    val `open`: Int = 0,
                    @Json(name = "start_time")
                    val startTime: Any = Any()
                )

                @JsonClass(generateAdapter = true)
                data class Good(
                    @Json(name = "num")
                    val num: Any = Any()
                )

                @JsonClass(generateAdapter = true)
                data class Identify(
                    @Json(name = "id")
                    val id: Any = Any(),
                    @Json(name = "is_identify")
                    val isIdentify: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class Info(
                    @Json(name = "post_num")
                    val postNum: Any = Any(),
                    @Json(name = "user_num")
                    val userNum: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class Music(
                    @Json(name = "isopen")
                    val isopen: Int = 0,
                    @Json(name = "num")
                    val num: Any = Any(),
                    @Json(name = "pic")
                    val pic: Any = Any(),
                    @Json(name = "sid")
                    val sid: Any = Any()
                )

                @JsonClass(generateAdapter = true)
                data class Mv(
                    @Json(name = "isopen")
                    val isopen: Int = 0,
                    @Json(name = "num")
                    val num: Any = Any(),
                    @Json(name = "pic")
                    val pic: Any = Any(),
                    @Json(name = "sid")
                    val sid: Any = Any()
                )

                @JsonClass(generateAdapter = true)
                data class Photo(
                    @Json(name = "num")
                    val num: Any = Any(),
                    @Json(name = "pic")
                    val pic: Any = Any()
                )

                @JsonClass(generateAdapter = true)
                data class Video(
                    @Json(name = "num")
                    val num: Any = Any(),
                    @Json(name = "pic")
                    val pic: Any = Any()
                )
            }

            @JsonClass(generateAdapter = true)
            data class Page(
                @Json(name = "cur_good_id")
                val curGoodId: Int = 0,
                @Json(name = "current_page")
                val currentPage: Int = 0,
                @Json(name = "offset")
                val offset: Int = 0,
                @Json(name = "page_size")
                val pageSize: Int = 0,
                @Json(name = "total_count")
                val totalCount: Int = 0,
                @Json(name = "total_page")
                val totalPage: Int = 0
            )

            @JsonClass(generateAdapter = true)
            data class Thread(
                @Json(name = "abstract")
                val `abstract`: String = "",
                @Json(name = "act_info")
                val actInfo: List<Any> = listOf(),
                @Json(name = "act_media")
                val actMedia: List<Any> = listOf(),
                @Json(name = "agree")
                val agree: Agree = Agree(),
                @Json(name = "agree_num")
                val agreeNum: Int = 0,
                @Json(name = "ala_info")
                val alaInfo: Any = Any(),
                @Json(name = "author")
                val author: Author = Author(),
                @Json(name = "brand_fid_copy")
                val brandFidCopy: Any = Any(),
                @Json(name = "comment_num")
                val commentNum: Int = 0,
                @Json(name = "first_post_id")
                val firstPostId: Long = 0,
                @Json(name = "has_original_content")
                val hasOriginalContent: Int = 0,
                @Json(name = "id")
                val id: Long = 0,
                @Json(name = "is_activity")
                val isActivity: Int = 0,
                @Json(name = "is_ala_live_video")
                val isAlaLiveVideo: Boolean = false,
                @Json(name = "is_ala_share_thread")
                val isAlaShareThread: Boolean = false,
                @Json(name = "is_bakan")
                val isBakan: Int = 0,
                @Json(name = "is_bazhu_mask")
                val isBazhuMask: Int = 0,
                @Json(name = "is_bazhu_publicity")
                val isBazhuPublicity: Int = 0,
                @Json(name = "is_bazhu_recruit")
                val isBazhuRecruit: Int = 0,
                @Json(name = "is_bazhu_task")
                val isBazhuTask: Int = 0,
                @Json(name = "is_bazhu_vote")
                val isBazhuVote: Int = 0,
                @Json(name = "is_good")
                val isGood: Int = 0,
                @Json(name = "is_klose_top")
                val isKloseTop: Int = 0,
                @Json(name = "is_multi_forum")
                val isMultiForum: Int = 0,
                @Json(name = "is_notice")
                val isNotice: Int = 0,
                @Json(name = "is_ntitle")
                val isNtitle: Int = 0,
                @Json(name = "is_protal")
                val isProtal: Int = 0,
                @Json(name = "is_top")
                val isTop: Int = 0,
                @Json(name = "is_ugc_share")
                val isUgcShare: Int = 0,
                @Json(name = "is_voice_thread")
                val isVoiceThread: Int = 0,
                @Json(name = "is_vote")
                val isVote: Int = 0,
                @Json(name = "last_replyer")
                val lastReplyer: LastReplyer = LastReplyer(),
                @Json(name = "last_time")
                val lastTime: String = "",
                @Json(name = "last_time_int")
                val lastTimeInt: Int = 0,
                @Json(name = "location")
                val location: Any = Any(),
                @Json(name = "media")
                val media: List<Media> = listOf(),
                @Json(name = "media_num")
                val mediaNum: Int = 0,
                @Json(name = "ori_ugc_info")
                val oriUgcInfo: Any = Any(),
                @Json(name = "origin_thread_info")
                val originThreadInfo: Any = Any(),
                @Json(name = "reply_num")
                val replyNum: Int = 0,
                @Json(name = "share_num")
                val shareNum: Int = 0,
                @Json(name = "swan_t_share_image")
                val swanTShareImage: String = "",
                @Json(name = "thread_type")
                val threadType: Int = 0,
                @Json(name = "thread_types")
                val threadTypes: Long = 0,
                @Json(name = "thumbnail_centre_point")
                val thumbnailCentrePoint: Any = Any(),
                @Json(name = "tid")
                val tid: Long = 0,
                @Json(name = "title")
                val title: String = "",
                @Json(name = "top_agree_post")
                val topAgreePost: Any = Any(),
                @Json(name = "video_info")
                val videoInfo: List<Any> = listOf(),
                @Json(name = "view_num")
                val viewNum: Int = 0,
                @Json(name = "voice_info")
                val voiceInfo: List<Any> = listOf(),
                @Json(name = "zan")
                val zan: Any = Any()
            ) {
                @JsonClass(generateAdapter = true)
                data class Agree(
                    @Json(name = "agree_num")
                    val agreeNum: Int = 0,
                    @Json(name = "has_agree")
                    val hasAgree: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class Author(
                    @Json(name = "iconinfo")
                    val iconinfo: List<Iconinfo> = listOf(),
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "is_bawu")
                    val isBawu: Int = 0,
                    @Json(name = "is_interestman")
                    val isInterestman: Int = 0,
                    @Json(name = "is_verify")
                    val isVerify: Boolean = false,
                    @Json(name = "mParr_props")
                    val mParrProps: Any = Any(),
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "name_show")
                    val nameShow: String = "",
                    @Json(name = "new_iconinfo")
                    val newIconinfo: NewIconinfo = NewIconinfo(),
                    @Json(name = "portrait")
                    val portrait: String = "",
                    @Json(name = "tshow_icon")
                    val tshowIcon: List<TshowIcon> = listOf(),
                    @Json(name = "type")
                    val type: Int = 0,
                    @Json(name = "vipInfo")
                    val vipInfo: VipInfo = VipInfo()
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
                        val value: Int = 0,
                        @Json(name = "weight")
                        val weight: Int = 0
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class Position(
                            @Json(name = "card")
                            val card: Int = 0,
                            @Json(name = "frs")
                            val frs: Int = 0,
                            @Json(name = "home")
                            val home: Int = 0,
                            @Json(name = "pb")
                            val pb: Int = 0
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
                            val x4: String = ""
                        )

                        @JsonClass(generateAdapter = true)
                        data class Terminal(
                            @Json(name = "client")
                            val client: Int = 0,
                            @Json(name = "pc")
                            val pc: Int = 0,
                            @Json(name = "wap")
                            val wap: Int = 0
                        )
                    }

                    @JsonClass(generateAdapter = true)
                    data class NewIconinfo(
                        @Json(name = "1")
                        val x1: Any = Any(),
                        @Json(name = "2")
                        val x2: Any = Any(),
                        @Json(name = "3")
                        val x3: X3 = X3(),
                        @Json(name = "4")
                        val x4: X4 = X4()
                    ) {
                        @JsonClass(generateAdapter = true)
                        data class X3(
                            @Json(name = "category_id")
                            val categoryId: Int = 0,
                            @Json(name = "end_time")
                            val endTime: String = "",
                            @Json(name = "forum_list")
                            val forumList: String = "",
                            @Json(name = "icon")
                            val icon: String = "",
                            @Json(name = "intro")
                            val intro: String = "",
                            @Json(name = "intro_url")
                            val introUrl: String = "",
                            @Json(name = "is_advanced")
                            val isAdvanced: Int = 0,
                            @Json(name = "is_force")
                            val isForce: Int = 0,
                            @Json(name = "level")
                            val level: String = "",
                            @Json(name = "level_1")
                            val level1: Level1 = Level1(),
                            @Json(name = "name")
                            val name: String = "",
                            @Json(name = "pay_pic_pad")
                            val payPicPad: String = "",
                            @Json(name = "pay_pic_pc")
                            val payPicPc: String = "",
                            @Json(name = "position")
                            val position: Position = Position(),
                            @Json(name = "price")
                            val price: Int = 0,
                            @Json(name = "slot_no")
                            val slotNo: String = "",
                            @Json(name = "slot_type")
                            val slotType: String = "",
                            @Json(name = "sprite")
                            val sprite: Sprite = Sprite(),
                            @Json(name = "terminal")
                            val terminal: Terminal = Terminal(),
                            @Json(name = "title")
                            val title: String = "",
                            @Json(name = "title_url")
                            val titleUrl: String = "",
                            @Json(name = "type")
                            val type: Int = 0,
                            @Json(name = "value")
                            val value: String = "",
                            @Json(name = "weight")
                            val weight: Int = 0
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class Level1(
                                @Json(name = "icon_1")
                                val icon1: String = "",
                                @Json(name = "icon_2")
                                val icon2: String = "",
                                @Json(name = "icon_3")
                                val icon3: String = "",
                                @Json(name = "icon_4")
                                val icon4: String = "",
                                @Json(name = "icon_5")
                                val icon5: String = "",
                                @Json(name = "icon_6")
                                val icon6: String = "",
                                @Json(name = "level_info")
                                val levelInfo: LevelInfo = LevelInfo()
                            ) {
                                @JsonClass(generateAdapter = true)
                                data class LevelInfo(
                                    @Json(name = "forum_list")
                                    val forumList: String = "",
                                    @Json(name = "intro")
                                    val intro: String = "",
                                    @Json(name = "intro_url")
                                    val introUrl: String = "",
                                    @Json(name = "pay_pic_pad")
                                    val payPicPad: String = "",
                                    @Json(name = "pay_pic_pc")
                                    val payPicPc: String = "",
                                    @Json(name = "title")
                                    val title: String = "",
                                    @Json(name = "title_url")
                                    val titleUrl: String = ""
                                )
                            }

                            @JsonClass(generateAdapter = true)
                            data class Position(
                                @Json(name = "card")
                                val card: Int = 0,
                                @Json(name = "frs")
                                val frs: Int = 0,
                                @Json(name = "home")
                                val home: Int = 0,
                                @Json(name = "pb")
                                val pb: Int = 0
                            )

                            @JsonClass(generateAdapter = true)
                            data class Sprite(
                                @Json(name = "1")
                                val x1: String = ""
                            )

                            @JsonClass(generateAdapter = true)
                            data class Terminal(
                                @Json(name = "client")
                                val client: Int = 0,
                                @Json(name = "pc")
                                val pc: Int = 0,
                                @Json(name = "wap")
                                val wap: Int = 0
                            )
                        }

                        @JsonClass(generateAdapter = true)
                        data class X4(
                            @Json(name = "category_id")
                            val categoryId: Int = 0,
                            @Json(name = "end_time")
                            val endTime: String = "",
                            @Json(name = "forum_list")
                            val forumList: String = "",
                            @Json(name = "icon")
                            val icon: String = "",
                            @Json(name = "intro")
                            val intro: String = "",
                            @Json(name = "intro_url")
                            val introUrl: String = "",
                            @Json(name = "is_advanced")
                            val isAdvanced: Int = 0,
                            @Json(name = "is_force")
                            val isForce: Int = 0,
                            @Json(name = "level")
                            val level: String = "",
                            @Json(name = "level_1")
                            val level1: Level1 = Level1(),
                            @Json(name = "name")
                            val name: String = "",
                            @Json(name = "pay_pic_pad")
                            val payPicPad: String = "",
                            @Json(name = "pay_pic_pc")
                            val payPicPc: String = "",
                            @Json(name = "position")
                            val position: Position = Position(),
                            @Json(name = "price")
                            val price: Int = 0,
                            @Json(name = "slot_no")
                            val slotNo: String = "",
                            @Json(name = "slot_type")
                            val slotType: String = "",
                            @Json(name = "sprite")
                            val sprite: Sprite = Sprite(),
                            @Json(name = "terminal")
                            val terminal: Terminal = Terminal(),
                            @Json(name = "title")
                            val title: String = "",
                            @Json(name = "title_url")
                            val titleUrl: String = "",
                            @Json(name = "type")
                            val type: Int = 0,
                            @Json(name = "value")
                            val value: String = "",
                            @Json(name = "weight")
                            val weight: Int = 0
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class Level1(
                                @Json(name = "icon_1")
                                val icon1: String = "",
                                @Json(name = "icon_2")
                                val icon2: String = "",
                                @Json(name = "icon_3")
                                val icon3: String = "",
                                @Json(name = "icon_4")
                                val icon4: String = "",
                                @Json(name = "icon_5")
                                val icon5: String = "",
                                @Json(name = "icon_6")
                                val icon6: String = "",
                                @Json(name = "level_info")
                                val levelInfo: LevelInfo = LevelInfo()
                            ) {
                                @JsonClass(generateAdapter = true)
                                data class LevelInfo(
                                    @Json(name = "forum_list")
                                    val forumList: String = "",
                                    @Json(name = "intro")
                                    val intro: String = "",
                                    @Json(name = "intro_url")
                                    val introUrl: String = "",
                                    @Json(name = "pay_pic_pad")
                                    val payPicPad: String = "",
                                    @Json(name = "pay_pic_pc")
                                    val payPicPc: String = "",
                                    @Json(name = "title")
                                    val title: String = "",
                                    @Json(name = "title_url")
                                    val titleUrl: String = ""
                                )
                            }

                            @JsonClass(generateAdapter = true)
                            data class Position(
                                @Json(name = "card")
                                val card: Int = 0,
                                @Json(name = "frs")
                                val frs: Int = 0,
                                @Json(name = "home")
                                val home: Int = 0,
                                @Json(name = "pb")
                                val pb: Int = 0
                            )

                            @JsonClass(generateAdapter = true)
                            data class Sprite(
                                @Json(name = "1")
                                val x1: String = ""
                            )

                            @JsonClass(generateAdapter = true)
                            data class Terminal(
                                @Json(name = "client")
                                val client: Int = 0,
                                @Json(name = "pc")
                                val pc: Int = 0,
                                @Json(name = "wap")
                                val wap: Int = 0
                            )
                        }
                    }

                    @JsonClass(generateAdapter = true)
                    data class TshowIcon(
                        @Json(name = "icon")
                        val icon: String = "",
                        @Json(name = "name")
                        val name: String = "",
                        @Json(name = "url")
                        val url: String = ""
                    )

                    @JsonClass(generateAdapter = true)
                    data class VipInfo(
                        @Json(name = "a_score")
                        val aScore: Any = Any(),
                        @Json(name = "e_time")
                        val eTime: String = "",
                        @Json(name = "ext_score")
                        val extScore: String = "",
                        @Json(name = "icon_url")
                        val iconUrl: String = "",
                        @Json(name = "n_score")
                        val nScore: Int = 0,
                        @Json(name = "s_time")
                        val sTime: String = "",
                        @Json(name = "v_level")
                        val vLevel: Int = 0,
                        @Json(name = "v_status")
                        val vStatus: String = "",
                        @Json(name = "y_score")
                        val yScore: Int = 0
                    )
                }

                @JsonClass(generateAdapter = true)
                data class LastReplyer(
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "is_verify")
                    val isVerify: Boolean = false,
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "name_show")
                    val nameShow: String = "",
                    @Json(name = "type")
                    val type: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class Media(
                    @Json(name = "big_pic")
                    val bigPic: String = "",
                    @Json(name = "height")
                    val height: Int = 0,
                    @Json(name = "is_gif")
                    val isGif: Boolean = false,
                    @Json(name = "size")
                    val size: Int = 0,
                    @Json(name = "small_pic")
                    val smallPic: String = "",
                    @Json(name = "static_img")
                    val staticImg: String = "",
                    @Json(name = "type")
                    val type: String = "",
                    @Json(name = "water_pic")
                    val waterPic: String = "",
                    @Json(name = "width")
                    val width: Int = 0
                )
            }

            @JsonClass(generateAdapter = true)
            data class User(
                @Json(name = "balv")
                val balv: Balv = Balv(),
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "is_login")
                val isLogin: Boolean = false,
                @Json(name = "is_manager")
                val isManager: Int = 0,
                @Json(name = "name")
                val name: String = "",
                @Json(name = "name_show")
                val nameShow: String = "",
                @Json(name = "new_user_info")
                val newUserInfo: NewUserInfo = NewUserInfo(),
                @Json(name = "no_un")
                val noUn: Int = 0,
                @Json(name = "portrait")
                val portrait: String = "",
                @Json(name = "type")
                val type: Int = 0,
                @Json(name = "userhide")
                val userhide: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Balv(
                    @Json(name = "days_tofree")
                    val daysTofree: Int = 0,
                    @Json(name = "is_black")
                    val isBlack: Int = 0,
                    @Json(name = "is_block")
                    val isBlock: Int = 0
                )

                @JsonClass(generateAdapter = true)
                data class NewUserInfo(
                    @Json(name = "ala_info")
                    val alaInfo: AlaInfo = AlaInfo(),
                    @Json(name = "card")
                    val card: Card = Card(),
                    @Json(name = "cdn_error")
                    val cdnError: String = "",
                    @Json(name = "display_name")
                    val displayName: String = "",
                    @Json(name = "duty")
                    val duty: Int = 0,
                    @Json(name = "forbidden_forumlist")
                    val forbiddenForumlist: String = "",
                    @Json(name = "free_flag")
                    val freeFlag: String = "",
                    @Json(name = "global")
                    val global: Global = Global(),
                    @Json(name = "heavy_user")
                    val heavyUser: Int = 0,
                    @Json(name = "idea_name")
                    val ideaName: IdeaName = IdeaName(),
                    @Json(name = "is_friend_imported")
                    val isFriendImported: Int = 0,
                    @Json(name = "is_group_owner")
                    val isGroupOwner: Int = 0,
                    @Json(name = "is_hardworking")
                    val isHardworking: Int = 0,
                    @Json(name = "is_tenyear")
                    val isTenyear: Int = 0,
                    @Json(name = "mParr_props")
                    val mParrProps: List<Any> = listOf(),
                    @Json(name = "meizhi_level")
                    val meizhiLevel: Int = 0,
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
                    val scoreCard: Int = 0,
                    @Json(name = "superboy")
                    val superboy: String = "",
                    @Json(name = "tbguess_card")
                    val tbguessCard: TbguessCard = TbguessCard(),
                    @Json(name = "tbscore_repeate_finish_time")
                    val tbscoreRepeateFinishTime: String = "",
                    @Json(name = "ueg_profile")
                    val uegProfile: String = "",
                    @Json(name = "use_sig")
                    val useSig: Int = 0,
                    @Json(name = "user_id")
                    val userId: Int = 0,
                    @Json(name = "user_name")
                    val userName: String = "",
                    @Json(name = "user_sex")
                    val userSex: Int = 0,
                    @Json(name = "user_state")
                    val userState: Int = 0,
                    @Json(name = "user_status")
                    val userStatus: Int = 0,
                    @Json(name = "user_type")
                    val userType: Int = 0,
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
                        val goodNum: Int = 0,
                        @Json(name = "is_novice")
                        val isNovice: Int = 0,
                        @Json(name = "like_forum")
                        val likeForum: LikeForum = LikeForum(),
                        @Json(name = "manager_info")
                        val managerInfo: ManagerInfo = ManagerInfo(),
                        @Json(name = "op_time")
                        val opTime: Int = 0,
                        @Json(name = "post_num")
                        val postNum: Int = 0
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
                            @Json(name = "7")
                            val x7: X7 = X7(),
                            @Json(name = "9")
                            val x9: X9 = X9()
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class X10(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X11(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X13(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X14(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X6(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X7(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class X9(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )
                        }

                        @JsonClass(generateAdapter = true)
                        data class ManagerInfo(
                            @Json(name = "assist")
                            val assist: Assist = Assist(),
                            @Json(name = "manager")
                            val manager: Manager = Manager()
                        ) {
                            @JsonClass(generateAdapter = true)
                            data class Assist(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<Any> = listOf()
                            )

                            @JsonClass(generateAdapter = true)
                            data class Manager(
                                @Json(name = "count")
                                val count: Int = 0,
                                @Json(name = "forum_list")
                                val forumList: List<String> = listOf()
                            )
                        }
                    }

                    @JsonClass(generateAdapter = true)
                    data class Global(
                        @Json(name = "tbmall_newprops")
                        val tbmallNewprops: Int = 0
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
                    data class NewActiveForum(
                        @Json(name = "fid")
                        val fid: Int = 0,
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
                        val allLevel: Any = Any(),
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
                        val level: Int = 0,
                        @Json(name = "limit")
                        val limit: Int = 0,
                        @Json(name = "scores_fetch")
                        val scoresFetch: Int = 0,
                        @Json(name = "scores_money")
                        val scoresMoney: Int = 0,
                        @Json(name = "scores_other")
                        val scoresOther: Int = 0,
                        @Json(name = "scores_total")
                        val scoresTotal: Int = 0,
                        @Json(name = "update_time")
                        val updateTime: Int = 0
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

                    @JsonClass(generateAdapter = true)
                    data class TbguessCard(
                        @Json(name = "card_id")
                        val cardId: Int = 0,
                        @Json(name = "card_type")
                        val cardType: Int = 0,
                        @Json(name = "scores")
                        val scores: Int = 0
                    )

                    @JsonClass(generateAdapter = true)
                    data class WapRn(
                        @Json(name = "frsrn")
                        val frsrn: Int = 0,
                        @Json(name = "pbrn")
                        val pbrn: Int = 0
                    )
                }
            }
        }

        @JsonClass(generateAdapter = true)
        data class Message(
            @Json(name = "atme")
            val atme: Int = 0,
            @Json(name = "fans")
            val fans: Int = 0,
            @Json(name = "friend")
            val friend: Int = 0,
            @Json(name = "replyme")
            val replyme: Int = 0,
            @Json(name = "zan")
            val zan: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class Meta(
            @Json(name = "description")
            val description: String = "",
            @Json(name = "image")
            val image: String = "",
            @Json(name = "keywords")
            val keywords: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class NavTabInfo(
            @Json(name = "sort_type")
            val sortType: Int = 0,
            @Json(name = "tab_name")
            val tabName: String = "",
            @Json(name = "tab_type")
            val tabType: Int = 0,
            @Json(name = "tab_url")
            val tabUrl: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class NavTab(
            @Json(name = "tab_id")
            val tabId: Int = 0,
            @Json(name = "tab_name")
            val tabName: String = "",
            @Json(name = "tab_type")
            val tabType: Int = 0,
            @Json(name = "tab_url")
            val tabUrl: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Page(
            @Json(name = "current_page")
            val currentPage: Int = 0,
            @Json(name = "offset")
            val offset: Int = 0,
            @Json(name = "page_size")
            val pageSize: Int = 0,
            @Json(name = "pnum")
            val pnum: Int = 0,
            @Json(name = "req_num")
            val reqNum: Int = 0,
            @Json(name = "tnum")
            val tnum: Int = 0,
            @Json(name = "total_num")
            val totalNum: Any = Any(),
            @Json(name = "total_page")
            val totalPage: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class PersonOperate(
            @Json(name = "mul_id")
            val mulId: String = "",
            @Json(name = "mul_name")
            val mulName: String = "",
            @Json(name = "topic_id")
            val topicId: String = "",
            @Json(name = "topic_info")
            val topicInfo: TopicInfo = TopicInfo(),
            @Json(name = "topic_name")
            val topicName: String = "",
            @Json(name = "topic_pic")
            val topicPic: String = "",
            @Json(name = "topic_url")
            val topicUrl: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class TopicInfo(
                @Json(name = "content_num")
                val contentNum: String = "",
                @Json(name = "idx_num")
                val idxNum: String = "",
                @Json(name = "real_discuss_num")
                val realDiscussNum: Int = 0,
                @Json(name = "share_pic")
                val sharePic: String = "",
                @Json(name = "topic_desc")
                val topicDesc: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class Redpacketflagext(
            @Json(name = "redpacketflag")
            val redpacketflag: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class Tokens(
            @Json(name = "addThread")
            val addThread: String = "",
            @Json(name = "bottom_layer_length_to_top")
            val bottomLayerLengthToTop: String = "",
            @Json(name = "footer_client_down")
            val footerClientDown: String = "",
            @Json(name = "FrsAppGuide")
            val frsAppGuide: String = "",
            @Json(name = "Frs_message")
            val frsMessage: String = "",
            @Json(name = "Frs_reply")
            val frsReply: String = "",
            @Json(name = "frs_sign_in_pop")
            val frsSignInPop: String = "",
            @Json(name = "mylikePrompt")
            val mylikePrompt: String = "",
            @Json(name = "pageBottom")
            val pageBottom: String = "",
            @Json(name = "profile_FRS")
            val profileFRS: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class User(
            @Json(name = "abstract_low_discharge")
            val abstractLowDischarge: Int = 0,
            @Json(name = "email")
            val email: String = "",
            @Json(name = "id")
            val id: Int = 0,
            @Json(name = "is_half_user")
            val isHalfUser: Int = 0,
            @Json(name = "is_login")
            val isLogin: Boolean = false,
            @Json(name = "is_verify")
            val isVerify: Boolean = false,
            @Json(name = "mobilephone")
            val mobilephone: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_link")
            val nameLink: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
            @Json(name = "no_un")
            val noUn: String = "",
            @Json(name = "portrait")
            val portrait: String = "",
            @Json(name = "sid")
            val sid: String = "",
            @Json(name = "source_id")
            val sourceId: Int = 0,
            @Json(name = "temp_name")
            val tempName: String = "",
            @Json(name = "uid")
            val uid: Int = 0,
            @Json(name = "userhide")
            val userhide: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class UserGuidePop(
            @Json(name = "is_pop")
            val isPop: Int = 0
        )

        @JsonClass(generateAdapter = true)
        data class Wreq(
            @Json(name = "auth")
            val auth: String = "",
            @Json(name = "bd_page_type")
            val bdPageType: Int = 0,
            @Json(name = "browser")
            val browser: Browser = Browser(),
            @Json(name = "browser_type")
            val browserType: Int = 0,
            @Json(name = "can_up_pic")
            val canUpPic: Int = 0,
            @Json(name = "cid")
            val cid: Int = 0,
            @Json(name = "client")
            val client: Client = Client(),
            @Json(name = "cuid")
            val cuid: String = "",
            @Json(name = "current_clock")
            val currentClock: Int = 0,
            @Json(name = "fr")
            val fr: String = "",
            @Json(name = "from")
            val from: String = "",
            @Json(name = "from_source")
            val fromSource: Int = 0,
            @Json(name = "from_source_refer")
            val fromSourceRefer: String = "",
            @Json(name = "index_errcode")
            val indexErrcode: Int = 0,
            @Json(name = "isAndroidUnderFour")
            val isAndroidUnderFour: Boolean = false,
            @Json(name = "is_first_access_screen")
            val isFirstAccessScreen: Int = 0,
            @Json(name = "is_from_pc")
            val isFromPc: Int = 0,
            @Json(name = "is_iphone")
            val isIphone: Int = 0,
            @Json(name = "is_jump")
            val isJump: Boolean = false,
            @Json(name = "isLightApp")
            val isLightApp: Boolean = false,
            @Json(name = "is_native_browser")
            val isNativeBrowser: Int = 0,
            @Json(name = "is_voice_client_ad")
            val isVoiceClientAd: List<IsVoiceClientAd> = listOf(),
            @Json(name = "is_voice_open")
            val isVoiceOpen: List<IsVoiceOpen> = listOf(),
            @Json(name = "itb_tbs")
            val itbTbs: String = "",
            @Json(name = "kw")
            val kw: String = "",
            @Json(name = "lp")
            val lp: Int = 0,
            @Json(name = "net_speed")
            val netSpeed: String = "",
            @Json(name = "net_type")
            val netType: Int = 0,
            @Json(name = "network_type")
            val networkType: Int = 0,
            @Json(name = "new_cuid")
            val newCuid: String = "",
            @Json(name = "opfeature_version")
            val opfeatureVersion: String = "",
            @Json(name = "origin_bdps_word")
            val originBdpsWord: String = "",
            @Json(name = "originid")
            val originid: Int = 0,
            @Json(name = "os_id")
            val osId: String = "",
            @Json(name = "pd")
            val pd: Int = 0,
            @Json(name = "picArray")
            val picArray: PicArray = PicArray(),
            @Json(name = "pic_info")
            val picInfo: String = "",
            @Json(name = "pinf")
            val pinf: String = "",
            @Json(name = "pn")
            val pn: String = "",
            @Json(name = "pu")
            val pu: String = "",
            @Json(name = "rs5")
            val rs5: String = "",
            @Json(name = "rs6")
            val rs6: String = "",
            @Json(name = "see_lz")
            val seeLz: Int = 0,
            @Json(name = "show_postbox")
            val showPostbox: Int = 0,
            @Json(name = "sort_type")
            val sortType: String = "",
            @Json(name = "src")
            val src: Int = 0,
            @Json(name = "ssid")
            val ssid: String = "",
            @Json(name = "tbs")
            val tbs: String = "",
            @Json(name = "type")
            val type: Int = 0,
            @Json(name = "ua")
            val ua: Ua = Ua(),
            @Json(name = "uid")
            val uid: String = "",
            @Json(name = "word")
            val word: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class Browser(
                @Json(name = "browser_type")
                val browserType: Any = Any(),
                @Json(name = "browser_version")
                val browserVersion: String = "",
                @Json(name = "os_type")
                val osType: String = "",
                @Json(name = "os_version")
                val osVersion: String = "",
                @Json(name = "user_agent")
                val userAgent: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Client(
                @Json(name = "browser")
                val browser: Browser = Browser(),
                @Json(name = "device")
                val device: Device = Device(),
                @Json(name = "os")
                val os: Os = Os()
            ) {
                @JsonClass(generateAdapter = true)
                data class Browser(
                    @Json(name = "family")
                    val family: String = "",
                    @Json(name = "major")
                    val major: String = "",
                    @Json(name = "minor")
                    val minor: String = "",
                    @Json(name = "patch")
                    val patch: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Device(
                    @Json(name = "family")
                    val family: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Os(
                    @Json(name = "family")
                    val family: String = "",
                    @Json(name = "major")
                    val major: Any = Any(),
                    @Json(name = "minor")
                    val minor: Any = Any(),
                    @Json(name = "patch")
                    val patch: Any = Any(),
                    @Json(name = "patchMinor")
                    val patchMinor: Any = Any()
                )
            }

            @JsonClass(generateAdapter = true)
            data class IsVoiceClientAd(
                @Json(name = "data_1")
                val data1: String = "",
                @Json(name = "data_2")
                val data2: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IsVoiceOpen(
                @Json(name = "data_1")
                val data1: String = "",
                @Json(name = "data_2")
                val data2: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PicArray(
                @Json(name = "data")
                val `data`: List<Any> = listOf()
            )

            @JsonClass(generateAdapter = true)
            data class Ua(
                @Json(name = "is_android")
                val isAndroid: Int = 0,
                @Json(name = "is_ios6")
                val isIos6: Int = 0
            )
        }
    }
}