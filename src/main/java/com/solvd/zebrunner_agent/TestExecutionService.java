package com.solvd.zebrunner_agent;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.solvd.zebrunner_agent.enums.ResponseKey;
import com.solvd.zebrunner_agent.enums.TestStatus;
import com.solvd.zebrunner_agent.methods.PostTestRunStartMethod;
import com.solvd.zebrunner_agent.methods.PostTestExecutionStartMethod;
import com.solvd.zebrunner_agent.methods.PostTestSessionCompleteMethod;
import com.solvd.zebrunner_agent.methods.PutTestExecutionFinishMethod;
import com.solvd.zebrunner_agent.methods.PutTestRunExecutionFinishMethod;


public class TestExecutionService {

    public static void startTestRun(String RunName) {
        PostTestRunStartMethod postTestRunStartMethod = new PostTestRunStartMethod(RunName);
        Validator.isExpectStatusOK(postTestRunStartMethod);
        Response response = postTestRunStartMethod.callAPI();
        TestBuffer.setTestRunId(JsonPath.from(response.asString()).get(ResponseKey.TEST_RUN.getValue()));
    }

    public static void finishTestRun() {
        PutTestRunExecutionFinishMethod putTestRunExecutionFinishMethod = new PutTestRunExecutionFinishMethod();
        Validator.isExpectStatusOK(putTestRunExecutionFinishMethod);
        putTestRunExecutionFinishMethod.callAPI();
    }

    public static void testExecutionStart(String name, String claasName, String methodName) {
        PostTestExecutionStartMethod postTestExecutionStartMethod = new PostTestExecutionStartMethod(name,
                claasName, methodName);
        Validator.isExpectStatusOK(postTestExecutionStartMethod);
        Response response = postTestExecutionStartMethod.callAPI();
        TestBuffer.setTestId(JsonPath.from(response.asString()).get(ResponseKey.TEST_ID.getValue()));
    }

    public static void testExecutionFinish(TestStatus status) {
        PutTestExecutionFinishMethod putTestExecutionFinishMethod = new PutTestExecutionFinishMethod(status);
        Validator.isExpectStatusOK(putTestExecutionFinishMethod);
        putTestExecutionFinishMethod.addProperty("result", status.getValue());
        Response response = putTestExecutionFinishMethod.callAPI();
    }

    public static void testSessionComplete() {
        PostTestSessionCompleteMethod postTestSessionCompleteMethod = new PostTestSessionCompleteMethod();
        Validator.isExpectStatusOK(postTestSessionCompleteMethod);
        Response response = postTestSessionCompleteMethod.callAPI();
        TestBuffer.setSessionId(JsonPath.from(response.asString()).get(ResponseKey.SESSION_ID.getValue()));
    }
}
