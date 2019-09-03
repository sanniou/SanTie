package com.saniou.santieba.inter;

import com.saniou.santieba.api.bean.UploadPicBean;

import java.util.List;

public interface OnPicUploadInter {

    void onUpload(List<UploadPicBean> list);
}
