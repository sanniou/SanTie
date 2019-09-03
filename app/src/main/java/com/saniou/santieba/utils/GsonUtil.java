package com.saniou.santieba.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saniou.santieba.api.bean.ThreadListPageBean.ThreadListBean.MediaBean;
import com.saniou.santieba.utils.deserializer.MediaGsonDeserializer;

public class GsonUtil {

    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.create();

    static {
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("pendant"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("location"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("signature"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("pb_live"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("ala_info"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("add_post_list"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("twzhibo_info"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("spring_virtual_user"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("window"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("logid"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("post_prefix"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("theme_card"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("banner"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("zan"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("iconinfo"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("lbs_info"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("new_user_info"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("tb_vip"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("god_data"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("poll_info"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("star_enter"));
        gsonBuilder.addDeserializationExclusionStrategy(createExclusion("book_chapter"));
        gsonBuilder.registerTypeAdapter(MediaBean.class, new MediaGsonDeserializer());
    }

    private static ExclusionStrategy createExclusion(final String str) {
        return new ExclusionStrategy() {
            @Override
            public boolean shouldSkipClass(Class<?> cls) {
                return false;
            }

            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().equals(str);
            }
        };
    }

    public static Gson getGson() {
        return gson;
    }
}
