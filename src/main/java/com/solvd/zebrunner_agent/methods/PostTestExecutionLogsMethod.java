package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.services.TestBuffer;

public class PostTestExecutionLogsMethod extends BaseApiMethod {

    public PostTestExecutionLogsMethod() {
        super("api/logs/post/rq.json", "api/logs/post/rs.json", "api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        setAuth();
    }
}
