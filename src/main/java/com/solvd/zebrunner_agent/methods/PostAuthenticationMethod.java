package com.solvd.zebrunner_agent.methods;


public class PostAuthenticationMethod extends BaseApiMethod {

    public PostAuthenticationMethod() {
        super("api/authentication/post/rq.json", "api/authentication/post/rs.json","api/agent.properties");
        replaceUrlPlaceholder("base_url", getAgentConfig().getValue("hostname"));
    }
}
