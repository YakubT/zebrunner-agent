package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.TestBuffer;

public class PostTestExecutionStartMethod extends BaseApiMethod {

    public PostTestExecutionStartMethod(String name, String className, String methodName) {
        super("api/singletest/post/rq.json", "api/singletest/post/rs.json","api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        addProperty("startedAt", DateTime.now());
        addProperty("name",name);
        addProperty("className",className);
        addProperty("methodName",methodName);
        setAuth();
    }
}
