package com.solvd.zebrunner_agent;

import com.solvd.zebrunner_agent.enums.TestStatus;
import com.solvd.zebrunner_agent.methods.PostTestExecutionStartMethod;
import com.solvd.zebrunner_agent.methods.PutTestExecutionFinishMethod;
import com.solvd.zebrunner_agent.methods.PutTestRunExecutionFinishMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.solvd.zebrunner_agent.methods.PostTestRunStartMethod;
import com.solvd.zebrunner_agent.enums.ResponseKey;

public class TestExecutionService {

    public static void startTestRun(String RunName) {
        PostTestRunStartMethod postTestRunStartMethod = new PostTestRunStartMethod(RunName);
        Response response = postTestRunStartMethod.callAPI();
        TestBuffer.setTestRunId(JsonPath.from(response.asString()).get(ResponseKey.TEST_RUN.getValue()));
    }

    public static void finishTestRun() {
        PutTestRunExecutionFinishMethod putTestRunExecutionFinishMethod = new PutTestRunExecutionFinishMethod();
        putTestRunExecutionFinishMethod.callAPI();
    }

    public static void testExecutionStart(String name) {
        PostTestExecutionStartMethod postTestExecutionStartMethod = new PostTestExecutionStartMethod(name);
        Response response = postTestExecutionStartMethod.callAPI();
        TestBuffer.setTestId(JsonPath.from(response.asString()).get(ResponseKey.TEST_ID.getValue()));
    }

    public static void testExecutionFinish(TestStatus status) {
        PutTestExecutionFinishMethod putTestExecutionFinishMethod = new PutTestExecutionFinishMethod(status);
        putTestExecutionFinishMethod.addProperty("result",status.getValue());;
        Response response = putTestExecutionFinishMethod.callAPI();
    }
}
