package com.saniou.santieba.utils;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class EmojiUtil {

    private static HashMap<String, ArrayList<String>> emojiCatagorys;
    private static HashMap<String, String> emojiMapping;

    public static void init(Context context) {
        Gson gson = GsonUtil.getGson();
        String json = getJson("emoji_mapping.json", context);
        String json2 = getJson("emoji_catagory.json", context);
        emojiMapping = (HashMap) gson.fromJson(json, HashMap.class);
        emojiCatagorys = (HashMap) gson.fromJson(json2, HashMap.class);
    }

    public static String getEmojiName(String str) {
        return (String) emojiMapping.get(str);
    }

    public static ArrayList<String> getEmojiNames() {
        return (ArrayList) emojiCatagorys.get("emojiResNames");
    }

    public static ArrayList<String> getAliNames() {
        return (ArrayList) emojiCatagorys.get("aliResNames");
    }

    public static ArrayList<String> getDuBearNames() {
        return (ArrayList) emojiCatagorys.get("duBearResNames");
    }

    public static ArrayList<String> getOtherNames() {
        return (ArrayList) emojiCatagorys.get("otherResNames");
    }

    public static String getJson(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
