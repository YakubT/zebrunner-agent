package utils;

public enum Resources {

    AGENT_CONFIG("./src/main/resources/agent.properties");

    String path;
    Resources (String path) {
        this.path = path;
    }

    public String getValue() {
        return this.path;
    }
}
