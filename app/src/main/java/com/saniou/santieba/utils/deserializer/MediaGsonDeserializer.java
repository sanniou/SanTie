package com.saniou.santieba.utils.deserializer;

import com.google.gson.*;
import com.saniou.santieba.api.bean.ThreadListPageBean.ThreadListBean.MediaBean;

import org.apache.commons.text.StringSubstitutor;

import java.lang.reflect.Type;

public class MediaGsonDeserializer implements JsonDeserializer<MediaBean> {

    @Override
    public MediaBean deserialize(JsonElement jsonElement, Type type,
                                 JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            if (!jsonElement.toString().startsWith("{") || !jsonElement.toString()
                    .endsWith(StringSubstitutor.DEFAULT_VAR_END)) {
                MediaBean mediaBean = new MediaBean();
                mediaBean.setType("10086");
                return mediaBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return (MediaBean) new Gson().fromJson(jsonElement.toString(), MediaBean.class);
        } catch (Exception e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }
}
