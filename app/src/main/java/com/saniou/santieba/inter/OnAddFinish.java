package com.saniou.santieba.inter;

public interface OnAddFinish {

    void onFailed(String str);

    void onNeedVcode(String str, String str2);

    void onSuccess(String str);
}
