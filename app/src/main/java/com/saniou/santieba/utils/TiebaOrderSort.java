package com.saniou.santieba.utils;

import com.saniou.santieba.api.bean.LikeTiebaListBean.LikeForumBean;

import java.util.Comparator;
import java.util.List;

public class TiebaOrderSort implements Comparator<LikeForumBean> {

    private List<String> tiebaOrder;

    public TiebaOrderSort(List<String> list) {
        this.tiebaOrder = list;
    }

    public int compare(LikeForumBean likeForumBean, LikeForumBean likeForumBean2) {
        if (this.tiebaOrder.indexOf(likeForumBean2.getForum_id()) < 0
                || this.tiebaOrder.indexOf(likeForumBean.getForum_id()) < 0) {
            return 1;
        }
        if (this.tiebaOrder.indexOf(likeForumBean.getForum_id()) < this.tiebaOrder
                .indexOf(likeForumBean2.getForum_id())) {
            return -1;
        }
        if (this.tiebaOrder.indexOf(likeForumBean.getForum_id()) > this.tiebaOrder
                .indexOf(likeForumBean2.getForum_id())) {
            return 1;
        }
        return 0;
    }
}
