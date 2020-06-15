package com.saniou.santieba.utils;

import androidx.databinding.ViewDataBinding;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * fix DataBinding not receiving LiveData updates after navigation to other fragment and return.
 * when use navigation ,it will replace fragments when change ui , so the last fragment will call destroy,and ViewDataBinding unregister all LiveData.
 * when back to the last, fragment recreate but not new instance, in this time mLocalFieldObservers in ViewDataBinding had been set, so cannot register new LiveData Observer.
 * we need reset mLocalFieldObservers by use reflect.
 */
public class DataBindingNavigationFixUtils {

    public static final String LISTENER_NAME = "mLocalFieldObservers";
    public static final String WEAK_LISTENER = "androidx.databinding.ViewDataBinding$WeakListener";

    public static void fixListener(ViewDataBinding binding) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field field = ViewDataBinding.class.getDeclaredField(LISTENER_NAME);
        field.setAccessible(true);

        Class<?> classType = Class.forName(WEAK_LISTENER);
        // 创建一个长度为相同的字符串数组
        Object array = Array.newInstance(classType, Array.getLength(field.get(binding)));
        field.set(binding,array);
    }

}
