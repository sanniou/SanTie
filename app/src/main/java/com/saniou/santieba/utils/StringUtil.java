package com.saniou.santieba.utils;

import com.alibaba.android.arouter.utils.TextUtils;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String parseUnicodeToStr(String str) {
        Matcher matcher = Pattern.compile("&#\\d*;").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer,
                    Character.toString((char) Integer.parseInt(matcher.group(0).replaceAll("(&#)|;", ""))));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String decodeHtml(String str) {
        return StringEscapeUtils.unescapeHtml4(str);
    }

    public static String encodeHtml(String str) {
        return StringEscapeUtils.escapeHtml4(str);
    }

    public static String filterHtml(String str) {
        String str2;
        String replace = str.replaceAll("^<(?!br|img)[^>]+>|<(?!br|img)[^>]+>$", "").trim()
                .replace("<br>", StringUtils.LF);
        Matcher matcher = Pattern.compile("<img src=\"(.*?)\">").matcher(replace);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, EmojiUtil.getEmojiName(matcher.group(1)));
            z = true;
        }
        if (z) {
            matcher.appendTail(stringBuffer);
            str2 = parseUnicodeToStr(stringBuffer.toString());
        } else {
            str2 = parseUnicodeToStr(replace);
        }
        return decodeHtml(str2);
    }

    public static String decodeUnicode(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    i2 = i;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < 4) {
                        int i5 = i2 + 1;
                        char charAt3 = str.charAt(i2);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = ((i4 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i4 = (((i4 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i4 = (((i4 << 4) + 10) + charAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                }
                        }
                        i3++;
                        i2 = i5;
                    }
                    stringBuffer.append((char) i4);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = 9;
                    } else if (charAt2 == 'r') {
                        charAt2 = CharUtils.CR;
                    } else if (charAt2 == 'n') {
                        charAt2 = 10;
                    } else if (charAt2 == 'f') {
                        charAt2 = 12;
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    public static String md54(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static final String MD5(String str) {
        byte[] digest;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            char[] cArr2 = new char[(bytes.length * 2)];
            int i = 0;
            for (byte b : instance.digest()) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String showTiebaMemberNum(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        if (i < 10000) {
            StringBuilder sb = new StringBuilder();
            sb.append("关注: ");
            sb.append(i);
            return sb.toString();
        } else if (i > 9999999) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("关注: ");
            double d = (double) i;
            Double.isNaN(d);
            sb2.append(decimalFormat.format(d / 1.0E7d));
            sb2.append("kw");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("关注: ");
            double d2 = (double) i;
            Double.isNaN(d2);
            sb3.append(decimalFormat.format(d2 / 10000.0d));
            sb3.append("w");
            return sb3.toString();
        }
    }

    public static String showTiebaPostNum(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        if (i < 10000) {
            StringBuilder sb = new StringBuilder();
            sb.append("发帖: ");
            sb.append(i);
            return sb.toString();
        } else if (i > 9999999) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("发帖: ");
            double d = (double) i;
            Double.isNaN(d);
            sb2.append(decimalFormat.format(d / 1.0E7d));
            sb2.append("kw");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("发帖: ");
            double d2 = (double) i;
            Double.isNaN(d2);
            sb3.append(decimalFormat.format(d2 / 10000.0d));
            sb3.append("w");
            return sb3.toString();
        }
    }

    public static String showNum(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        if (i < 1000) {
            return String.valueOf(i);
        }
        if (i < 10000) {
            StringBuilder sb = new StringBuilder();
            double d = (double) i;
            Double.isNaN(d);
            sb.append(decimalFormat.format(d / 1000.0d));
            sb.append("K");
            return sb.toString();
        } else if (i < 100000000) {
            StringBuilder sb2 = new StringBuilder();
            double d2 = (double) i;
            Double.isNaN(d2);
            sb2.append(decimalFormat.format(d2 / 10000.0d));
            sb2.append("W");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d3 = (double) i;
            Double.isNaN(d3);
            sb3.append(decimalFormat.format(d3 / 1.0E8d));
            sb3.append("E");
            return sb3.toString();
        }
    }

    public static String nameShow(String str, String str2, String str3) {
        if (str == null) {
            str = str2;
        }
        if (str2 == null) {
            str2 = "";
        }
        if ("name".equals(str3)) {
            return str;
        }
        if ("nick".equals(str3) || str.equals(str2)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
