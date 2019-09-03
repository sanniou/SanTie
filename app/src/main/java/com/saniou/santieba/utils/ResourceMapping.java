package com.saniou.santieba.utils;

import java.lang.reflect.Field;

public class ResourceMapping {

    public static int getResId(String str, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            return declaredField.getInt(declaredField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
