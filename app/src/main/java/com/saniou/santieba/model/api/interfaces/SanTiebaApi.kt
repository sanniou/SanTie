package com.saniou.santieba.model.api.interfaces

import android.os.Build
import android.text.TextUtils
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.constant.CODE_SUCCESS
import com.saniou.santieba.constant.ERROR_CODE_SUCCESS
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.model.DislikeBean
import com.saniou.santieba.model.ImageUtil
import com.saniou.santieba.model.PhotoInfoBean
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.saniou.santieba.model.api.reqeust.SearchThreadFilter
import com.saniou.santieba.model.api.reqeust.SearchThreadOrder
import com.saniou.santieba.model.api.reqeust.TiebaRetrofit
import com.saniou.santieba.model.bean.DataDTO
import com.saniou.santieba.model.bean.FloorPage
import com.saniou.santieba.model.bean.ForumPage
import com.saniou.santieba.model.bean.ForumRecommend
import com.saniou.santieba.model.bean.StatusResponse
import com.saniou.santieba.model.bean.ThreadStore
import com.saniou.santieba.model.bean.UserInfo
import com.saniou.santieba.model.bean.WebForumPage
import com.saniou.santieba.viewmodel.MARK_STATE
import com.sanniou.support.exception.ApiErrorException
import com.squareup.moshi.Types
import java.io.FileInputStream
import java.io.IOException
import java.net.URLEncoder

object SanTiebaApi : ITiebaApi {
    override suspend fun personalized(loadType: Int, page: Int): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.personalized(loadType, page)

    override suspend fun agree(
        threadId: String,
        postId: String
    ): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.agree(postId, threadId)

    override suspend fun disagree(
        threadId: String,
        postId: String
    ): StatusResponse = TiebaRetrofit.MINI_TIEBA_API.disagree(postId, threadId)

    override suspend fun forumRecommend(): ForumRecommend =
        TiebaRetrofit.MINI_TIEBA_API.forumRecommend()

    override suspend fun forumPage(
        forumName: String, page: Int, sortType: ForumSortType, goodClassifyId: String?
    ): ForumPage =
        TiebaRetrofit.MINI_TIEBA_API.forumPage(forumName, page, sortType.value, goodClassifyId)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }

    override suspend fun floor(
        threadId: String, page: Int, postId: String?, subPostId: String?
    ): FloorPage =
        TiebaRetrofit.MINI_TIEBA_API.floor(threadId, page, postId, subPostId)

    override suspend fun userLikeForum(
        uid: String, page: Int
    ): StatusResponse {
        val myUid = AccountUtil.getUid(Utils.getApp())
        return TiebaRetrofit.MINI_TIEBA_API.userLikeForum(
            page = page,
            uid = myUid,
            friendUid = if (!TextUtils.equals(uid, myUid)) uid else null,
            is_guest = if (!TextUtils.equals(uid, myUid)) "1" else null

        )
    }

    override suspend fun userPost(
        uid: String, page: Int, isThread: Boolean
    ): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.userPost(uid, page, if (isThread) 1 else 0)

    override suspend fun picPage(
        forumId: String,
        forumName: String,
        threadId: String,
        seeLz: Boolean,
        picId: String,
        picIndex: String,
        objType: String,
        prev: Boolean
    ): StatusResponse = TiebaRetrofit.MINI_TIEBA_API.picPage(
        forumId,
        forumName,
        threadId,
        picId,
        picIndex,
        objType,
        prev = if (prev) 1 else 0,
        not_see_lz = if (seeLz) 0 else 1
    )

    override suspend fun profile(uid: String): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.profile(uid)

    override suspend fun unlikeForum(
        forumId: String, forumName: String, tbs: String
    ): StatusResponse = TiebaRetrofit.MINI_TIEBA_API.unlikeForum(forumId, forumName, tbs)

    override suspend fun likeForum(
        forumId: String, forumName: String, tbs: String
    ): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.likeForum(forumId, forumName, tbs)

    override suspend fun sign(forumName: String, tbs: String): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.sign(forumName, tbs)

    override suspend fun delThread(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String
    ): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.delThread(forumId, forumName, threadId, tbs)

    override suspend fun delPost(
        forumId: String,
        forumName: String,
        threadId: String,
        postId: String,
        tbs: String,
        isFloor: Boolean,
        delMyPost: Boolean
    ): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.delPost(
            forumId,
            forumName,
            threadId,
            postId,
            tbs,
            is_floor = if (isFloor) 1 else 0,
            src = if (isFloor) 3 else 1,
            is_vip_del = if (delMyPost) 0 else 1,
            delete_my_post = if (delMyPost) 1 else 0
        )

    override suspend fun searchPost(
        keyword: String, forumName: String, onlyThread: Boolean, page: Int, pageSize: Int
    ): StatusResponse = TiebaRetrofit.MINI_TIEBA_API.searchPost(
        keyword,
        forumName,
        page,
        pageSize,
        only_thread = if (onlyThread) 1 else 0
    )

    override suspend fun searchUser(keyword: String): StatusResponse =
        TiebaRetrofit.MINI_TIEBA_API.searchUser(keyword)

    override suspend fun msg(): StatusResponse = TiebaRetrofit.NEW_TIEBA_API.msg()

    override suspend fun threadStore(offset: Int): ThreadStore =
        TiebaRetrofit.NEW_TIEBA_API.threadStore(
            RANGE_NUMBER,
            offset,
            AccountUtil.getUid(Utils.getApp())
        )

    override suspend fun removeStore(threadId: String, tbs: String): StatusResponse =
        TiebaRetrofit.NEW_TIEBA_API.removeStore(threadId, tbs)

    override suspend fun addStore(
        threadId: String, postId: String, lzOnly: Boolean,
        reverse: Boolean, tbs: String
    ): StatusResponse =
        TiebaRetrofit.NEW_TIEBA_API.addStore(
            TiebaRequest.moshi.adapter<List<DataDTO>>(
                Types.newParameterizedType(
                    List::class.java,
                    DataDTO::class.java
                )
            ).toJson(
                listOf(
                    DataDTO(
                        postId,
                        when {
                            lzOnly && reverse -> MARK_STATE.SINGLE_REVERSE.value
                            lzOnly && !reverse -> MARK_STATE.SINGLE_NORMAL.value
                            reverse -> MARK_STATE.REVERSE.value
                            !reverse -> MARK_STATE.NORMAL.value
                            else -> MARK_STATE.NORMAL.value
                        },
                        threadId
                    )
                )
            )

            , tbs
        )

    override suspend fun replyMe(page: Int): StatusResponse =
        TiebaRetrofit.NEW_TIEBA_API.replyMe(page)

    override suspend fun atMe(page: Int): StatusResponse = TiebaRetrofit.NEW_TIEBA_API.atMe(page)

    override suspend fun threadContent(
        threadId: String, page: Int, seeLz: Boolean, reverse: Boolean
    ): StatusResponse = TiebaRetrofit.OFFICIAL_TIEBA_API.threadContent(
        threadId,
        page,
        last = if (reverse) "1" else null,
        r = if (reverse) "1" else null,
        lz = if (seeLz) 1 else 0
    )

    override suspend fun threadContent(
        threadId: String, postId: String?, seeLz: Boolean, reverse: Boolean
    ): StatusResponse = TiebaRetrofit.OFFICIAL_TIEBA_API.threadContent(
        threadId,
        postId,
        last = if (reverse) "1" else null,
        r = if (reverse) "1" else null,
        lz = if (seeLz) 1 else 0
    )

    // fixme
    override suspend fun submitDislike(
        dislikeBean: DislikeBean,
        stoken: String
    ): StatusResponse =
        TiebaRetrofit.OFFICIAL_TIEBA_API.submitDislike("listOf(dislikeBean).toJson()", stoken)

    override suspend fun follow(
        portrait: String, tbs: String
    ): StatusResponse = TiebaRetrofit.WEB_TIEBA_API.follow(
        "https://tieba.baidu.com/i/?portrait=${URLEncoder.encode(
            portrait,
            "UTF-8"
        )}&cuid=&auth=&uid=&ssid=&from=&uid=&pu=&bd_page_type=2&auth=&originid=&mo_device=1&tbs=${tbs}&action=follow&op=follow"
    )

    override suspend fun unfollow(
        portrait: String, tbs: String
    ): StatusResponse = TiebaRetrofit.WEB_TIEBA_API.follow(
        "https://tieba.baidu.com/i/?portrait=${URLEncoder.encode(
            portrait,
            "UTF-8"
        )}&cuid=&auth=&uid=&ssid=&from=&uid=&pu=&bd_page_type=2&auth=&originid=&mo_device=1&tbs=${tbs}&action=follow&op=unfollow"
    )

    override suspend fun hotMessageList(): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.hotMessageList()

    override suspend fun myInfo(cookie: String): UserInfo =
        TiebaRetrofit.WEB_TIEBA_API.myInfo(cookie)

    override suspend fun searchForum(keyword: String): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.searchForum(keyword)

    override suspend fun searchThread(
        keyword: String, page: Int, order: SearchThreadOrder, filter: SearchThreadFilter
    ): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.searchThread(
            keyword,
            page,
            order.toString(),
            filter.toString()
        )

    override suspend fun webUploadPic(photoInfoBean: PhotoInfoBean): StatusResponse {
        var base64: String? = null
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            base64 = ImageUtil.imageToBase64(photoInfoBean.file)
        } else {
            try {
                Utils.getApp().contentResolver.openAssetFileDescriptor(
                    photoInfoBean.fileUri,
                    "r"
                )?.use { afd ->
                    base64 =
                        ImageUtil.imageToBase64(FileInputStream(afd.parcelFileDescriptor.fileDescriptor))
                }
            } catch (e: IOException) {
                e.printStackTrace()
                base64 = null
            }
        }
        return TiebaRetrofit.WEB_TIEBA_API.webUploadPic(base64)
    }

    override suspend fun webReply(
        forumId: String,
        forumName: String,
        threadId: String,
        tbs: String,
        content: String,
        imgInfo: String?,
        nickName: String,
        pn: String,
        bsk: String
    ): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.webReply(
            content = content,
            imgInfo = imgInfo ?: "",
            forumId = forumId,
            forumName = forumName,
            tbs = tbs,
            threadId = threadId,
            nickName = nickName,
            bsk = bsk,
            referer = "https://tieba.baidu.com/p/$threadId?lp=5028&mo_device=1&is_jingpost=0&pn=$pn&"
        )

    override suspend fun webReply(
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
    ): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.webReply(
            content = content,
            imgInfo = imgInfo ?: "",
            forumId = forumId,
            forumName = forumName,
            tbs = tbs,
            threadId = threadId,
            nickName = nickName,
            postId = postId,
            floor = floor,
            bsk = bsk,
            referer = "https://tieba.baidu.com/p/$threadId?lp=5028&mo_device=1&is_jingpost=0&pn=$pn&"
        )

    override suspend fun webReply(
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
    ): StatusResponse =
        TiebaRetrofit.WEB_TIEBA_API.webReply(
            content = content,
            imgInfo = imgInfo ?: "",
            forumId = forumId,
            forumName = forumName,
            tbs = tbs,
            threadId = threadId,
            nickName = nickName,
            postId = postId,
            replyPostId = replyPostId,
            floor = floor,
            bsk = bsk,
            referer = "https://tieba.baidu.com/p/$threadId?lp=5028&mo_device=1&is_jingpost=0&pn=$pn&"
        )

    override suspend fun webForumPage(
        forumName: String,
        page: Int,
        goodClassifyId: String?,
        sortType: ForumSortType,
        pageSize: Int
    ): WebForumPage.Data =
        TiebaRetrofit.WEB_TIEBA_API.frs(
            forumName,
            (page - 1) * pageSize,
            sortType.value,
            goodClassifyId
        ).run {
            if (error.isNotEmpty()) {
                throw ApiErrorException(-1, error)
            }
            data
        }
}