package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.TestBuffer;
import org.joda.time.DateTime;

public class PutTestSessionFinishMethod extends BaseApiMethod {

    public PutTestSessionFinishMethod() {
        super("api/session/put/rq.json","api/session/put/rs.json","api/agent.properties");
        addProperty("endedAt", DateTime.now());
        addProperty("testRunId", TestBuffer.getTestRunId());
        addProperty("testSessionId",TestBuffer.getSessionId());
    }
}
