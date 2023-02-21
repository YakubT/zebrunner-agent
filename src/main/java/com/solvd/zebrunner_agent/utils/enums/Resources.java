package com.solvd.zebrunner_agent.utils.enums;

public enum Resources {

    AGENT_CONFIG("./src/test/resources/api/agent.properties");

    private final String path;

    Resources (String path) {
        this.path = path;
    }

    public String getValue() {
        return this.path;
    }
}
