package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.AuthService;

import java.util.Properties;

public class PostAuthenticationMethod extends BaseApiMethod {

    public PostAuthenticationMethod() {
        super("api/authentication/post/rq.json", "api/authentication/post/rs.json","api/agent.properties");
        replaceUrlPlaceholder("base_url", getAgentConfig().getValue("hostname"));
    }
}
