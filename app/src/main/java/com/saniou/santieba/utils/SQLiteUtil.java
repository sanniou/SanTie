package com.saniou.santieba.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SQLiteUtil {

    public static SQLiteDatabase createOrOpenDataBase(String str, Context context) {
        return context.openOrCreateDatabase(str, 0, null);
    }

    public static void createTables(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> query(SQLiteDatabase sqLiteDatabase, String str) {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        try {
            Cursor query = sqLiteDatabase.query(str, null, null, null, null, null, null);
            if (query.moveToFirst()) {
                do {
                    TreeMap<String, String> treeMap = new TreeMap<>();
                    query.getColumnCount();
                    for (int i = 0; i < query.getColumnCount(); i++) {
                        treeMap.put(query.getColumnName(i), query.getString(i));
                    }
                    arrayList.add(treeMap);
                } while (query.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void insert(SQLiteDatabase sQLiteDatabase, String str, Map<String, String> map) {
        try {
            ContentValues contentValues = new ContentValues();
            for (Entry entry : map.entrySet()) {
                contentValues.put(entry.getKey().toString(), entry.getValue().toString());
            }
            sQLiteDatabase.insert(str, null, contentValues);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues,
                              String str2, String[] strArr) {
        try {
            sQLiteDatabase.update(str, contentValues, str2, strArr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDataBase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.close();
    }
}
