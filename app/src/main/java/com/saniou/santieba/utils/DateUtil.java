package com.saniou.santieba.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final int DAY = 4;
    private static final int HOUR = 3;
    private static final int MINUTE = 2;
    private static final int MONTH = 5;
    private static final int SECOND = 1;
    private static final int YEAR = 6;
    private static SimpleDateFormat sdf;

    public static long getTimestamp() {
        return new Date().getTime();
    }

    public static String getCurrentDate() {
        Date date = new Date();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getDateToString(long j) {
        Date date = new Date(j * 1000);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    public static int getDateToInt(long j, int i) {
        Date date = new Date(j * 1000);
        switch (i) {
            case 1:
                sdf = new SimpleDateFormat("ss");
                break;
            case 2:
                sdf = new SimpleDateFormat("mm");
                break;
            case 3:
                sdf = new SimpleDateFormat("HH");
                break;
            case 4:
                sdf = new SimpleDateFormat("dd");
                break;
            case 5:
                sdf = new SimpleDateFormat("MM");
                break;
            case 6:
                sdf = new SimpleDateFormat("yy");
                break;
        }
        return Integer.parseInt(sdf.format(date));
    }

    public static long getStringToDate(String str) {
        Date date;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        return date.getTime();
    }

    public static String getDisplayTime(long j) {
        int dateToInt = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 1);
        int dateToInt2 = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 2);
        int dateToInt3 = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 3);
        int dateToInt4 = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 4);
        int dateToInt5 = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 5);
        int dateToInt6 = getDateToInt((getStringToDate(getCurrentDate()) / 1000) - j, 6);
        if ((dateToInt6 != 70 || dateToInt5 != 1 || dateToInt4 != 1 || dateToInt3 < 8) && (
                dateToInt6 != 70 || dateToInt5 != 1 || dateToInt4 != 2 || dateToInt3 >= 8)) {
            return getDateToString(j);
        }
        if (dateToInt4 == 1 && dateToInt3 > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(dateToInt3 - 8));
            sb.append("小时前");
            return sb.toString();
        } else if (dateToInt4 == 2 && dateToInt3 < 8) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(dateToInt3 + 16));
            sb2.append("小时前");
            return sb2.toString();
        } else if (dateToInt2 > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(dateToInt2));
            sb3.append("分钟前");
            return sb3.toString();
        } else if (dateToInt <= 0) {
            return null;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(String.valueOf(dateToInt));
            sb4.append("秒前");
            return sb4.toString();
        }
    }
}
