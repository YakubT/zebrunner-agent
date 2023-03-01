package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.services.TestBuffer;

public class PutTestRunExecutionFinishMethod extends BaseApiMethod {
    public PutTestRunExecutionFinishMethod() {
        super("api/testrun/put/rq.json", "api/testrun/put/rs.json", "api/agent.properties");
        replaceUrlPlaceholder("id", String.valueOf(TestBuffer.getTestRunId()));
        addProperty("endedAt",DateTime.now().toString());
        setAuth();
    }
}
