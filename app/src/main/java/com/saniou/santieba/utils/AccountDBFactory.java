package com.saniou.santieba.utils;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AccountDBFactory {

    public SQLiteDatabase createDataBase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return SQLiteDatabase.openOrCreateDatabase(sb.toString(), null);
    }

    public void createTables(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
