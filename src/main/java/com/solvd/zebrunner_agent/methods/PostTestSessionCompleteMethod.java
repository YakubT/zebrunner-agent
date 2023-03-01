package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.services.TestBuffer;

public class PostTestSessionCompleteMethod extends BaseApiMethod {

    public PostTestSessionCompleteMethod() {
        super("api/session/post/rq.json","api/session/post/rs.json","api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        addProperty("initiatedAt",DateTime.now());
        setAuth();
    }
}
