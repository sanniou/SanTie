package com.saniou.santieba.api.bean;

import java.util.Map;

public class UpdateBean {

    private PureTieMessage message;
    private Map<String, String> versionInfo;

    public PureTieMessage getMessage() {
        return this.message;
    }

    public void setMessage(PureTieMessage pureTieMessage) {
        this.message = pureTieMessage;
    }

    public Map<String, String> getVersionInfo() {
        return this.versionInfo;
    }

    public void setVersionInfo(Map<String, String> map) {
        this.versionInfo = map;
    }
}
