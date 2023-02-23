package com.solvd.zebrunner_agent.enums;

public enum ResponseKey {

    AUTH_TOKEN("authToken"),

    TEST_RUN("id"),

    TEST_ID("id"),

    SESSION_ID("id");

    private String value;

    ResponseKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
