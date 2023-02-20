package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.AuthService;

public class PostAuthenticationMethod extends BaseApiMethod {

    public PostAuthenticationMethod() {
        super("api/authentication/post/rq.json", "api/authentication/post/rs.json",get);
        replaceUrlPlaceholder("base_url", getAgentConfig().getValue("hostname"));
        setHeaders("Authorization=Bearer " + AuthService.getAuthToken());

    }
}
