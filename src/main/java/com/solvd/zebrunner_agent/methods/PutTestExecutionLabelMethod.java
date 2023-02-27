package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.TestBuffer;

public class PutTestExecutionLabelMethod extends BaseApiMethod {
    public PutTestExecutionLabelMethod() {
        super("api/label/put/rq.json","api/label/put/rs.json","api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        replaceUrlPlaceholder("testId", String.valueOf(TestBuffer.getTestId()));
        setAuth();
    }
}
