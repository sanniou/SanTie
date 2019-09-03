package com.saniou.santieba.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.Gson;
import com.saniou.santieba.api.bean.DataBean;
import com.saniou.santieba.api.bean.DataBean.DataBeanX;
import com.saniou.santieba.constant.ThreadContentType;
import com.saniou.santieba.utils.DateUtil;
import com.saniou.santieba.utils.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.lang3.StringUtils;

import static com.sanniou.common.databinding.ImageViewDatabindingAdapter.bindingImage;

public class TiebaAPI {
    @BindingAdapter(
            value = {"res", "error", "placeholder"},
            requireAll = false
    )
    public static void bindingImgeView(ImageView view, Object img, int error, int placeholder) {
        bindingImage(view, img, error, placeholder, false, false, false, false, false);
    }

    private static TiebaAPI tiebaAPI;
    private String BDUSS;
    private String addClientVersion;
    private String clientId;
    private String clientType;
    private String clientVersion;
    private Context context;
    private Map<String, String> headers = new HashMap();
    private String imei;
    private String littleTail;
    private Editor loginEdit;
    private SharedPreferences loginInfo;
    private String netType;
    private String newClientVersion;
    private Editor phoneEdit;
    private SharedPreferences phoneInfo;
    private SharedPreferences preferences;
    private String tbs;
    private String timestamp;
    private String uid;

    private TiebaAPI(Context context2) {
        this.context = context2;
        this.headers.put("Cookie", "ka=open");
        this.headers.put("net", ThreadContentType.IMAGE);
        this.headers.put("User-Agent", "bdtb for Android 6.9.2.1");
        this.headers.put("Pragma", "no-cache");
        this.loginInfo = context2.getSharedPreferences("login_info", 0);
        this.phoneInfo = context2.getSharedPreferences("phone_info", 0);
        StringBuilder sb = new StringBuilder();
        sb.append(context2.getPackageName());
        sb.append("_preferences");
        this.preferences = context2.getSharedPreferences(sb.toString(), 0);
        this.loginEdit = this.loginInfo.edit();
        this.phoneEdit = this.phoneInfo.edit();
        this.imei = this.phoneInfo.getString("imei", "");
        if (this.imei.isEmpty()) {
            this.imei = "352316052799040";
        }
        this.BDUSS = this.loginInfo.getString("BDUSS", "");
        this.uid = this.loginInfo.getString("ID", "");
        this.tbs = this.loginInfo.getString("tbs", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtils.LF);
        sb2.append(this.preferences.getString("little_tail", ""));
        this.littleTail = sb2.toString();
        this.netType = ThreadContentType.LINK;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("wappc_");
        sb3.append(DateUtil.getTimestamp());
        sb3.append("_");
        sb3.append(Math.floor(Math.random() * 1000.0d));
        this.clientId = sb3.toString();
        if (this.clientId.length() <= 0) {
            this.clientId = UUID.randomUUID().toString().replace("-", "");
            this.loginEdit.putString("client_id", this.clientId);
            this.loginEdit.apply();
        }
        this.clientType = ThreadContentType.EMOJI;
        this.clientVersion = "5.7.0";
        this.addClientVersion = "6.9.2.1";
        this.newClientVersion = "8.2.2";
    }

    public static synchronized TiebaAPI getInstance(Context context2) {
        TiebaAPI tiebaAPI2;
        synchronized (TiebaAPI.class) {
            if (tiebaAPI == null) {
                tiebaAPI = new TiebaAPI(context2);
            }
            tiebaAPI2 = tiebaAPI;
        }
        return tiebaAPI2;
    }

    private static String calsign(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : new TreeMap<>(map).entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        sb.append("tiebaclient!!!");
        return StringUtil.MD5(sb.toString());
    }

    public void forumrecommend(final APICallBack aPICallBack) {
        String l = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.loginInfo.getString("BDUSS", ""));
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.clientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("like_forum", ThreadContentType.LINK);
        hashMap.put("net_type", this.netType);
        hashMap.put("recommend", ThreadContentType.TEXT);
        hashMap.put("timestamp", l);
        hashMap.put("topic", ThreadContentType.TEXT);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/Forum2/forumrecommend")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void searchTieba(final APICallBack aPICallBack, String str) {
        String l = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("q", str);
        hashMap.put("timestamp", l);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/Forum2/sug")).headers(this.headers))
                .params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void searchPost(final APICallBack aPICallBack, String str, String str2) {
        HashMap hashMap = new HashMap();
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("pn", str);
        hashMap.put("rn", "25");
        hashMap.put("st_type", "search_post");
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("word", str2);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/s/searchpost")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void profile(final APICallBack aPICallBack) {
        HashMap hashMap = new HashMap();
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.clientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("need_post_count", ThreadContentType.LINK);
        hashMap.put("net_type", this.netType);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("uid", this.uid);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/u/user/profile")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void friendProfile(final APICallBack aPICallBack, String str) {
        HashMap hashMap = new HashMap();
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "6.0.0");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("need_post_count", ThreadContentType.LINK);
        hashMap.put("net_type", this.netType);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("uid", this.uid);
        hashMap.put("is_guest", ThreadContentType.LINK);
        hashMap.put("friend_uid", str);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/u/user/profile")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void msg(final APICallBack aPICallBack) {
        HashMap hashMap = new HashMap();
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("bookmark", ThreadContentType.LINK);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/s/msg")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void threadPage(final APICallBack aPICallBack, String str, int i, String str2) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.clientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        if (ThreadContentType.LINK.equals(str2)) {
            hashMap.put("is_good", str2);
        }
        hashMap.put("kw", str);
        hashMap.put("net_type", this.netType);
        hashMap.put("pn", String.valueOf(i));
        hashMap.put("q_type", ThreadContentType.EMOJI);
        hashMap.put("rn", "20");
        hashMap.put("scr_dip", ThreadContentType.TEXT);
        hashMap.put("scr_h", ThreadContentType.TEXT);
        hashMap.put("scr_w", ThreadContentType.TEXT);
        hashMap.put("st_type", "tb_forumlist");
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("with_group", ThreadContentType.TEXT);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/frs/page")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }


    public void addThread(final APICallBack aPICallBack, String str, String str2, String str3,
                          String str4, String str5, String str6) {
        if (this.littleTail.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(StringUtils.LF);
            sb.append(this.littleTail);
            str2 = sb.toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.addClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("anonymous", ThreadContentType.TEXT);
        hashMap.put("content", str2);
        hashMap.put("fid", str4);
        hashMap.put("from", "mini_baidu_appstore");
        hashMap.put("kw", str3);
        hashMap.put("subapp_type", "mini");
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", Long.toString(DateUtil.getTimestamp()));
        hashMap.put("title", str);
        Log.e("vcode_md5", str6);
        if (!str6.isEmpty()) {
            hashMap.put("vcode", str5);
            hashMap.put("vcode_md5", str6);
        }
        hashMap.put("versioncode", "101253632");
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/thread/add")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                Log.e(getClass().getName(), str);
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void addReply(final APICallBack aPICallBack, String str, String str2, String str3,
                         String str4, String str5, String str6) {
        if (this.littleTail.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(StringUtils.LF);
            sb.append(this.littleTail);
            str = sb.toString();
        }
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.addClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("anonymous", ThreadContentType.TEXT);
        hashMap.put("content", str);
        hashMap.put("fid", str3);
        hashMap.put("from", "tieba");
        hashMap.put("kw", str2);
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("tid", str4);
        hashMap.put("timestamp", this.timestamp);
        Log.e("vcode_md5", str6);
        if (!str6.isEmpty()) {
            Log.e("vcode_md5", "come in");
            hashMap.put("vcode", str5);
            hashMap.put("vcode_md5", str6);
        }
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/post/add")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void addReply2Someone(final APICallBack aPICallBack, String str, String str2, String str3,
                                 String str4, String str5, String str6, String str7, String str8) {
        if (this.littleTail.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(StringUtils.LF);
            sb.append(this.littleTail);
            str = sb.toString();
        }
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.addClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("anonymous", ThreadContentType.TEXT);
        hashMap.put("content", str);
        hashMap.put("fid", str3);
        hashMap.put("floor_num", str4);
        hashMap.put("from", "tieba");
        hashMap.put("kw", str2);
        hashMap.put("net_type", this.netType);
        hashMap.put("quote_id", str5);
        hashMap.put("tbs", this.tbs);
        hashMap.put("tid", str6);
        hashMap.put("timestamp", this.timestamp);
        Log.e("vcode_md5", str8);
        if (!str8.isEmpty()) {
            Log.e("vcode_md5", "come in");
            hashMap.put("vcode", str7);
            hashMap.put("vcode_md5", str8);
        }
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/post/add")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void likeForumList(final APICallBack aPICallBack) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.clientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("user_id", this.uid);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/Forum2/getforumlist")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void msign(final APICallBack aPICallBack, String str) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.clientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("forum_ids", str);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("user_id", this.uid);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/Forum2/msign")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void sign(final APICallBack aPICallBack, String str) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "6.1.0");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("kw", str);
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/Forum2/sign")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void likeTieba(final APICallBack aPICallBack, String str, String str2) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "6.6.0");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("fid", str);
        hashMap.put("from", "tieba");
        hashMap.put("kw", str2);
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/Forum2/like")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void unlikeTieba(final APICallBack aPICallBack, String str, String str2) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "6.6.0");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("fid", str);
        hashMap.put("from", "tieba");
        hashMap.put("kw", str2);
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/Forum2/unlike")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void upload(final APICallBack aPICallBack, File file, final int i) {
        RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        new OkHttpClient().newCall(new Builder().post(
                new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addPart(Headers.of("Content-Disposition", "form-data; name=BDUSS"),
                                RequestBody.create((MediaType) null, this.BDUSS)).addPart(Headers
                                .of("Content-Disposition", "form-data; name=pic; filename=pic; filename*=utf-8''pic"),
                        create).build()).url("http://c.tieba.baidu.com/c/c/img/upload")
                .headers(Headers.of(this.headers)).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException iOException) {
                aPICallBack.onFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                StringBuilder sb = new StringBuilder();
                sb.append(response.body().string());
                sb.append("`");
                sb.append(i);
                aPICallBack.onSuccess(sb.toString());
            }
        });
    }

    public void subFloor(final APICallBack aPICallBack, String str, String str2, String str3,
                         String str4) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "6.6.0");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("kz", str);
        hashMap.put("net_type", this.netType);
        if (str2 != null) {
            hashMap.put("pid", str2);
        }
        hashMap.put("pn", str4);
        hashMap.put("rn", "20");
        if (str3 != null) {
            hashMap.put("spid", str3);
        }
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/pb/floor")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void replyme(final APICallBack aPICallBack, String str) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "7.7.2");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("pn", str);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/u/feed/replyme")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void atme(final APICallBack aPICallBack, String str) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", "7.7.2");
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("pn", str);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/u/feed/atme")).headers(this.headers)).params((Map) hashMap)
                .build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void threadStore(final APICallBack aPICallBack, String str, String str2, String str3) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("offset", str);
        hashMap.put("rn", str2);
        hashMap.put("user_id", str3);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/f/post/threadstore")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void addStore(final APICallBack aPICallBack, String str, String str2) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        DataBean dataBean = new DataBean();
        dataBean.getClass();
        DataBeanX dataBeanX = new DataBean.DataBeanX();
        dataBeanX.setPid(str2);
        dataBeanX.setTid(str);
        dataBeanX.setStatus(ThreadContentType.TEXT);
        dataBeanX.setType(ThreadContentType.TEXT);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataBeanX);
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("data", new Gson().toJson((Object) arrayList));
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/post/addstore")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void rmStore(final APICallBack aPICallBack, String str) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("net_type", this.netType);
        hashMap.put("tbs", this.tbs);
        hashMap.put("tid", str);
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/c/post/rmstore")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void userPost(final APICallBack aPICallBack, String str, String str2) {
        this.timestamp = Long.toString(DateUtil.getTimestamp());
        HashMap hashMap = new HashMap();
        hashMap.put("BDUSS", this.BDUSS);
        hashMap.put("_client_id", this.clientId);
        hashMap.put("_client_type", this.clientType);
        hashMap.put("_client_version", this.newClientVersion);
        hashMap.put("_phone_imei", this.imei);
        hashMap.put("from", "tieba");
        hashMap.put("is_thread", ThreadContentType.LINK);
        hashMap.put("need_content", ThreadContentType.LINK);
        hashMap.put("net_type", this.netType);
        hashMap.put("pn", str);
        hashMap.put("rn", "20");
        hashMap.put("timestamp", this.timestamp);
        hashMap.put("uid", str2);
        hashMap.put("sign", calsign(hashMap));
        ((PostFormBuilder) ((PostFormBuilder) OkHttpUtils.post()
                .url("http://c.tieba.baidu.com/c/u/feed/userpost")).headers(this.headers))
                .params((Map) hashMap).build().execute(new StringCallback() {
            public void onError(Call call, Exception exc, int i) {
                aPICallBack.onFailure();
            }

            public void onResponse(String str, int i) {
                aPICallBack.onSuccess(str);
            }
        });
    }

    public void logout() {
        this.loginEdit.clear();
        this.phoneEdit.clear();
        this.loginEdit.commit();
        this.phoneEdit.commit();
        this.loginEdit = null;
        this.phoneEdit = null;
        this.loginInfo = null;
        this.phoneInfo = null;
        tiebaAPI = null;
    }

    public void reset() {
        tiebaAPI = null;
    }

    private static class OkHttpUtils {

        public static PostFormBuilder post() {
            return new PostFormBuilder();
        }
    }

    private static class PostFormBuilder {

        public PostFormBuilder url(String s) {
            return this;
        }

        public PostFormBuilder headers(Map<String, String> headers) {
            return this;
        }

        public PostFormBuilder params(Map hashMap) {
            return this;
        }

        public void execute(StringCallback stringCallback) {

        }

        public PostFormBuilder build() {
            return this;
        }
    }

    private class StringCallback {

    }

    private class APICallBack {

        public void onFailure() {

        }

        public void onSuccess(String str) {

        }
    }
}
