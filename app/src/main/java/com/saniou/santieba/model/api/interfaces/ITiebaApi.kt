package com.saniou.santieba.model.api.interfaces

import com.saniou.santieba.model.DislikeBean
import com.saniou.santieba.model.PhotoInfoBean
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.saniou.santieba.model.api.reqeust.SearchThreadFilter
import com.saniou.santieba.model.api.reqeust.SearchThreadOrder
import com.saniou.santieba.model.bean.FloorPage
import com.saniou.santieba.model.bean.ForumPage
import com.saniou.santieba.model.bean.ForumRecommend
import com.saniou.santieba.model.bean.StatusResponse
import com.saniou.santieba.model.bean.ThreadStore
import com.saniou.santieba.model.bean.UserInfo

interface ITiebaApi {
    /**
     * 个性推荐（每页 15 贴）
     *
     * @param loadType 加载类型（1 - 下拉刷新 2 - 加载更多）
     * @param page 分页页码
     */
    suspend fun personalized(
        loadType: Int,
        page: Int = 1
    ): StatusResponse

    /**
     * 给贴子/回复点赞
     *
     * **需登录**
     *
     * @param threadId 贴子 ID
     * @param postId 回复 ID
     */
    suspend fun agree(
        threadId: String,
        postId: String
    ): StatusResponse

    /**
     * 给贴子/回复点踩
     *
     * **需登录**
     *
     * @param threadId 贴子 ID
     * @param postId 回复 ID
     */
    suspend fun disagree(
        threadId: String,
        postId: String
    ): StatusResponse

    /**
     * 关注吧列表
     *
     * **需登录**
     */
    suspend fun forumRecommend(): ForumRecommend

    /**
     * 吧页面
     *
     * @param forumName 吧名
     * @param page 分页页码（从 1 开始）
     * @param sortType 排序类型 [com.huanchengfly.tieba.api.ForumSortType]
     * @param goodClassifyId 精品贴分类 ID
     */
    suspend fun forumPage(
        forumName: String,
        page: Int = 1,
        sortType: ForumSortType = ForumSortType.REPLY_TIME,
        goodClassifyId: String? = null
    ): ForumPage

    /**
     * 楼中楼页面
     *
     * @param threadId 贴 ID
     * @param page 分页页码
     * @param postId 回复 ID
     * @param subPostId 楼中楼回复 ID
     */
    suspend fun floor(
        threadId: String,
        page: Int = 1,
        postId: String?,
        subPostId: String?
    ): FloorPage

    /**
     * 查看用户关注的吧列表
     *
     * @param uid 用户 ID
     * @param page 分页页码（从 1 开始）
     */
    suspend fun userLikeForum(
        uid: String,
        page: Int = 1
    ): StatusResponse

    /**
     * 查看用户的所有主题贴/回复
     *
     * @param uid 用户 ID
     * @param page 分页页码（从 1 开始）
     * @param isThread 是否查看主题贴
     */
    suspend fun userPost(
        uid: String,
        page: Int = 1,
        isThread: Boolean = true
    ): StatusResponse

    /**
     * 查看图片
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴 ID
     * @param seeLz 是否只看楼主
     * @param picId 图片 ID
     * @param picIndex 图片索引
     * @param objType 原页面类型（pb - 贴页面 frs - 吧页面）
     * @param prev 不明，默认为 false
     */
    suspend fun picPage(
        forumId: String,
        forumName: String,
        threadId: String,
        seeLz: Boolean,
        picId: String,
        picIndex: String,
        objType: String,
        prev: Boolean
    ): StatusResponse

    /**
     * 用户信息
     *
     * @param uid 用户 ID
     */
    suspend fun profile(
        uid: String
    ): StatusResponse

    /**
     * 取关一个吧
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param tbs tbs（长）
     */
    suspend fun unlikeForum(
        forumId: String,
        forumName: String,
        tbs: String
    ): StatusResponse

    /**
     * 关注一个吧
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param tbs tbs（长）
     */
    suspend fun likeForum(
        forumId: String,
        forumName: String,
        tbs: String
    ): StatusResponse

    /**
     * 吧签到
     *
     * **需登录**
     *
     * @param forumName 吧名
     * @param tbs tbs
     */
    suspend fun sign(
        forumName: String,
        tbs: String
    ): StatusResponse

    /**
     * 删除自己的贴子
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴子 ID
     */
    suspend fun delThread(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String
    ): StatusResponse

    /**
     * 删除贴子中的回复
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴子 ID
     * @param postId 回复 ID
     * @param isFloor 是否为楼中楼回复
     * @param delMyPost 是否为当前登录用户回复
     */
    suspend fun delPost(
        forumId: String,
        forumName: String,
        threadId: String,
        postId: String,
        tbs: String,
        isFloor: Boolean,
        delMyPost: Boolean
    ): StatusResponse

    /**
     * 吧内搜索
     *
     * @param keyword 搜索关键词
     * @param forumName 搜索吧名
     * @param onlyThread 是否仅搜索主题贴
     * @param page 分页页码（从 1 开始）
     * @param pageSize 每页贴数（默认 30）
     */
    suspend fun searchPost(
        keyword: String,
        forumName: String,
        onlyThread: Boolean = false,
        page: Int = 1,
        pageSize: Int = 30
    ): StatusResponse

    /**
     * 搜索用户
     *
     * @param keyword 搜索关键词
     */
    suspend fun searchUser(
        keyword: String
    ): StatusResponse

    /**
     * 消息提醒数
     *
     * **需登录**
     */
    suspend fun msg(): StatusResponse

    /**
     * 查看收藏贴列表
     *
     * **需登录**
     *
     * @param page 分页页码（从 0 开始）
     * @param pageSize 每页贴数（默认 20）
     */
    suspend fun threadStore(
        offset: Int = 0
    ): ThreadStore

    /**
     * 移除收藏
     *
     * **需登录**
     *
     * @param threadId 贴子 ID
     * @param tbs tbs
     */
    suspend fun removeStore(
        threadId: String,
        tbs: String
    ): StatusResponse

    /**
     * 添加/更新收藏
     *
     * **需登录**
     *
     * @param threadId 贴子 ID
     * @param postId 收藏到的回复 ID
     * @param tbs tbs
     */
    suspend fun addStore(
        threadId: String,
        postId: String,
        lzOnly: Boolean,
        reverse: Boolean,
        tbs: String
    ): StatusResponse

    /**
     * 回复我的消息列表
     *
     * **需登录**
     *
     * @param page 分页页码（从 1 开始）
     */
    suspend fun replyMe(
        page: Int = 1
    ): StatusResponse

    /**
     * 提到我的消息列表
     *
     * **需登录**
     *
     * @param page 分页页码（从 1 开始）
     */
    suspend fun atMe(
        page: Int = 1
    ): StatusResponse

    /**
     * 贴页面
     *
     * @param threadId 贴 ID
     * @param page 分页页码（从 1 开始）
     * @param seeLz 是否只看楼主
     * @param reverse 是否逆序
     */
    suspend fun threadContent(
        threadId: String,
        page: Int = 1,
        seeLz: Boolean = false,
        reverse: Boolean = false
    ): StatusResponse

    /**
     * 贴页面
     *
     * @param threadId 贴 ID
     * @param postId 回复 ID
     * @param seeLz 是否只看楼主
     * @param reverse 是否逆序
     */
    suspend fun threadContent(
        threadId: String,
        postId: String?,
        seeLz: Boolean = false,
        reverse: Boolean = false
    ): StatusResponse

    /**
     * 推荐“不感兴趣”
     *
     * **需登录**
     *
     * @param dislikeBean “不感兴趣”信息 [com.huanchengfly.tieba.post.models.DislikeBean]
     * @param stoken stoken
     */
    suspend fun submitDislike(
        dislikeBean: DislikeBean,
        stoken: String
    ): StatusResponse

    /**
     * 关注用户（web 接口）
     *
     * **需登录**
     *
     * @param portrait 头像
     * @param tbs tbs
     */
    suspend fun follow(
        portrait: String,
        tbs: String
    ): StatusResponse

    /**
     * 取关用户（web 接口）
     *
     * **需登录**
     *
     * @param portrait 头像
     * @param tbs tbs
     */
    suspend fun unfollow(
        portrait: String,
        tbs: String
    ): StatusResponse

    suspend fun hotMessageList(): StatusResponse

    /**
     * 登录用户信息
     *
     * @param cookie 登录 Cookie 信息
     */
    suspend fun myInfo(
        cookie: String
    ): UserInfo

    /**
     * 搜索吧
     *
     * @param keyword 关键词
     */
    suspend fun searchForum(
        keyword: String
    ): StatusResponse

    /**
     * 搜索贴
     *
     * @param keyword 关键词
     * @param page 分页页码
     * @param order 排序设置 [com.huanchengfly.tieba.api.SearchThreadOrder]
     * @param filter 过滤设置 [com.huanchengfly.tieba.api.SearchThreadFilter]
     */
    suspend fun searchThread(
        keyword: String,
        page: Int,
        order: SearchThreadOrder,
        filter: SearchThreadFilter
    ): StatusResponse

    /**
     * 上传图片（web 接口）
     *
     * **需登录**
     */
    suspend fun webUploadPic(
        photoInfoBean: PhotoInfoBean
    ): StatusResponse

    /**
     * 回贴 - 回复主题贴（web 接口）
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴子 ID
     * @param tbs tbs
     * @param content 回复内容
     * @param imgInfo 图片
     * @param nickName 昵称
     * @param pn 页码
     * @param bsk BSK
     */
    suspend fun webReply(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String,
        content: String,
        imgInfo: String?,
        nickName: String,
        pn: String,
        bsk: String
    ): StatusResponse

    /**
     * 回贴 - 回复别人的回复（web 接口）
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴子 ID
     * @param tbs tbs
     * @param content 回复内容
     * @param imgInfo 图片
     * @param nickName 昵称
     * @param postId 回复 ID
     * @param floor 回复楼层
     * @param pn 页码
     * @param bsk BSK
     */
    suspend fun webReply(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String,
        content: String,
        imgInfo: String?,
        nickName: String,
        postId: String,
        floor: String,
        pn: String,
        bsk: String
    ): StatusResponse

    /**
     * 回贴 - 回复楼中楼（web 接口）
     *
     * **需登录**
     *
     * @param forumId 吧 ID
     * @param forumName 吧名
     * @param threadId 贴子 ID
     * @param tbs tbs
     * @param content 回复内容
     * @param imgInfo 图片
     * @param nickName 昵称
     * @param postId 回复 ID
     * @param replyPostId 楼中楼 ID
     * @param floor 回复楼层
     * @param pn 页码
     * @param bsk BSK
     */
    suspend fun webReply(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String,
        content: String,
        imgInfo: String?,
        nickName: String,
        postId: String,
        replyPostId: String,
        floor: String,
        pn: String,
        bsk: String
    ): StatusResponse

    /**
     * 吧页面（web 接口）
     *
     * @param forumName 吧名
     * @param page 分页页码
     * @param goodClassifyId 精品贴分类 ID
     * @param sortType 贴排序类型
     * @param pageSize 每页贴数（默认 30）
     */
    suspend fun webForumPage(
        forumName: String,
        page: Int,
        goodClassifyId: String? = null,
        sortType: ForumSortType = ForumSortType.REPLY_TIME,
        pageSize: Int = 30
    ): StatusResponse
}