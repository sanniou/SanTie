package com.saniou.santieba.api.bean;

public class PureTieMessage {

    public static String NO_UPDATE_MESSAGE = "已经是最新版了";
    public static String SERVER_ERROR = "20001";
    public static String SERVER_ERROR_MESSAGE = "服务器内部错误";
    public static String SIGN_VERIFY_FAILED = "10001";
    public static String SIGN_VERIFY_FAILED_MESSAGE = "校验失败";
    public static String SUCCESS = "0";
    public static String UPDATE_AVILIABLE_MESSAGE = "发现新版本";
    public static String VIP_VERIFY_FAILED = "10002";
    public static String VIP_VERIFY_FAILED_MESSAGE = "还不是VIP";
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
