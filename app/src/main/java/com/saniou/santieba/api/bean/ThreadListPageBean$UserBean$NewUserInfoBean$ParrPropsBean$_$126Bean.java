package com.saniou.santieba.api.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean {

    @SerializedName("1260038")
    private ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260038Bean _$1260038;
    @SerializedName("1260048")
    private ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean _$1260048;

    public static ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean objectFromData(
            String str) {
        return (ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean) new Gson()
                .fromJson(str, ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean.class);
    }

    public static List<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean> array_$126BeanFromData(
            String str) {
        return (List) new Gson().fromJson(str,
                new TypeToken<ArrayList<ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean>>() {
                }.getType());
    }

    public ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260038Bean get_$1260038() {
        return this._$1260038;
    }

    public void set_$1260038(
            ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260038Bean threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260038Bean) {
        this._$1260038 = threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260038Bean;
    }

    public ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean get_$1260048() {
        return this._$1260048;
    }

    public void set_$1260048(
            ThreadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean) {
        this._$1260048 = threadListPageBean$UserBean$NewUserInfoBean$ParrPropsBean$_$126Bean$_$1260048Bean;
    }
}
