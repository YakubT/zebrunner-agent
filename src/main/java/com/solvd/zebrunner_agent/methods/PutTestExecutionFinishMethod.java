package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.enums.TestStatus;
import com.solvd.zebrunner_agent.services.TestBuffer;

public class PutTestExecutionFinishMethod extends BaseApiMethod {

    public PutTestExecutionFinishMethod(TestStatus testStatus) {
        super("api/singletest/put/rq.json", "api/singletest/put/rs.json","api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        replaceUrlPlaceholder("testId", String.valueOf(TestBuffer.getTestId()));
        addProperty("endedAt",DateTime.now());
        setAuth();
    }
}
