package com.solvd.zebrunner_agent.methods;

import org.joda.time.DateTime;

import com.solvd.zebrunner_agent.services.TestBuffer;

public class PutTestSessionFinishMethod extends BaseApiMethod {

    public PutTestSessionFinishMethod() {
        super("api/session/put/rq.json","api/session/put/rs.json","api/agent.properties");
        addProperty("endedAt", DateTime.now());
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        replaceUrlPlaceholder("testSessionId",String.valueOf(TestBuffer.getSessionId()));
        setAuth();
    }
}
