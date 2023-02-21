package com.solvd.zebrunner_agent.enums;

public enum ResponseKey {

    AUTH_TOKEN("authToken");

    private String value;

    ResponseKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
