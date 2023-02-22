package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

public class PostTestRunStartMethod extends BaseApiMethod {

    public PostTestRunStartMethod(String runName) {
        super("api/testrun/post/rq.json", "api/testrun/post/rs.json", "api/agent.properties");
        addProperty("startedAt", DateTime.now());
        addProperty("runName",runName);
        addUrlParameter("projectKey", getAgentConfig().getValue("projectKey"));
        setAuth();
    }

}
