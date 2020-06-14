package com.saniou.santieba.model;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;


import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;

import java.util.UUID;

public class UIDUtil {
    @SuppressLint("HardwareIds")
    public static String getAndroidId() {
        String androidId = Settings.Secure.getString(Utils.getApp().getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId == null ? "" : androidId;
    }

    public static String getNewCUID() {
        return "baidutiebaapp" + getUUID();
    }

    private static String getCUID() {
        String androidId = getAndroidId();
        String imei = PhoneUtils.getIMEI();
        return MD5Util.toMd5((Build.VERSION.SDK_INT < Build.VERSION_CODES.M ? imei + androidId + getUUID() : "com.baidu" + androidId).getBytes()).toUpperCase();
    }

    public static String getFinalCUID() {
        String imei = PhoneUtils.getIMEI();
        if (TextUtils.isEmpty(imei)) {
            imei = "0";
        }
        return getCUID() + "|" + new StringBuffer(imei).reverse().toString();
    }

    public static String getUUID() {
        String uuid = SPUtils.getInstance()
                .getString("uuid", null);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
            SPUtils.getInstance()
                    .put("uuid", uuid);
        }
        return uuid;
    }
}