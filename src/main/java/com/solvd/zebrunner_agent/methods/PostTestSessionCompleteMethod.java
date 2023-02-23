package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.TestBuffer;
import org.joda.time.DateTime;

public class PostTestSessionCompleteMethod extends BaseApiMethod {

    public PostTestSessionCompleteMethod() {
        super("api/session/post/rq.json","api/session/post/rq.json","api/agent.properties");
        replaceUrlPlaceholder("testRunId", String.valueOf(TestBuffer.getTestRunId()));
        addProperty("initiatedAt",DateTime.now());
        addProperty("startedAt", DateTime.now());
        setAuth();
    }
}
