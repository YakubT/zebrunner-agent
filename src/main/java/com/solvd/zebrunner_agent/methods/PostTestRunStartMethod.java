package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.TestBuffer;


public class PostTestRunStartMethod extends BaseApiMethod {

    public PostTestRunStartMethod() {
        super("api/testrun/post/rq.json", "api/testrun/post/rs.json", "api/agent.properties");
        this.addBodyParameter("startedAt", "2023-21-02");
        addUrlParameter("projectKey",getAgentConfig().getValue("projectKey"));
        setAuth();
    }


}
