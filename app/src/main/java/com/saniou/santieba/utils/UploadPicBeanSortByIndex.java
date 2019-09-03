package com.saniou.santieba.utils;

import com.saniou.santieba.api.bean.UploadPicBean;

import java.util.Comparator;

public class UploadPicBeanSortByIndex implements Comparator {

    public int compare(Object obj, Object obj2) {
        UploadPicBean uploadPicBean = (UploadPicBean) obj;
        UploadPicBean uploadPicBean2 = (UploadPicBean) obj2;
        if (uploadPicBean.getIndex() > uploadPicBean2.getIndex()) {
            return 1;
        }
        return uploadPicBean.getIndex() < uploadPicBean2.getIndex() ? -1 : 0;
    }
}
