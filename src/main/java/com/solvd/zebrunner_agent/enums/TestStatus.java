package com.solvd.zebrunner_agent.enums;

public enum TestStatus {

    PASSED("PASSED"),

    FAILED("FAILED"),

    ABORTED("ABORTED"),

    SKIPPED("SKIPPED");

    private String value;

    TestStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
