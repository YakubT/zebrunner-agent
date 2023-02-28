package com.solvd.zebrunner_agent;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.zebrunner_agent.enums.ResponseKey;
import com.solvd.zebrunner_agent.enums.TestStatus;
import com.solvd.zebrunner_agent.enums.HttpStatusCodeType;
import com.solvd.zebrunner_agent.methods.PostTestExecutionLogsMethod;
import com.solvd.zebrunner_agent.methods.PostTestExecutionStartMethod;
import com.solvd.zebrunner_agent.methods.PostTestRunStartMethod;
import com.solvd.zebrunner_agent.methods.PostTestSessionCompleteMethod;
import com.solvd.zebrunner_agent.methods.PutTestExecutionLabelMethod;
import com.solvd.zebrunner_agent.methods.PutTestExecutionFinishMethod;
import com.solvd.zebrunner_agent.methods.PutTestRunExecutionFinishMethod;
import com.solvd.zebrunner_agent.methods.PutTestSessionFinishMethod;

public class TestExecutionService {

    private static final Logger LOGGER = LogManager.getLogger(TestExecutionService.class);

    public static void startTestRun(String RunName) {
        PostTestRunStartMethod postTestRunStartMethod = new PostTestRunStartMethod(RunName);
        Validator.isExpectedStatusOK(postTestRunStartMethod);
        Response response = postTestRunStartMethod.callAPI();
        TestBuffer.setTestRunId(JsonPath.from(response.asString()).get(ResponseKey.TEST_RUN.getValue()));
        Validator.validateResponse(postTestRunStartMethod);
    }

    public static void finishTestRun() {
        PutTestRunExecutionFinishMethod putTestRunExecutionFinishMethod = new PutTestRunExecutionFinishMethod();
        Validator.isExpectedStatusOK(putTestRunExecutionFinishMethod);
        putTestRunExecutionFinishMethod.callAPI();
        Validator.validateResponse(putTestRunExecutionFinishMethod);
    }

    public static void testExecutionStart(String name, String claasName, String methodName) {
        PostTestExecutionStartMethod postTestExecutionStartMethod = new PostTestExecutionStartMethod(name,
                claasName, methodName);
        Validator.isExpectedStatusOK(postTestExecutionStartMethod);
        Response response = postTestExecutionStartMethod.callAPI();
        Validator.validateResponse(postTestExecutionStartMethod);
        TestBuffer.setTestId(JsonPath.from(response.asString()).get(ResponseKey.TEST_ID.getValue()));
    }

    public static void testExecutionFinish(TestStatus status) {
        PutTestExecutionFinishMethod putTestExecutionFinishMethod = new PutTestExecutionFinishMethod(status);
        Validator.isExpectedStatusOK(putTestExecutionFinishMethod);
        putTestExecutionFinishMethod.addProperty("result", status.getValue());
        Response response = putTestExecutionFinishMethod.callAPI();
        Validator.validateResponse(putTestExecutionFinishMethod);
    }

    public static void testSessionComplete() {
        PostTestSessionCompleteMethod postTestSessionCompleteMethod = new PostTestSessionCompleteMethod();
        Validator.isExpectedStatusOK(postTestSessionCompleteMethod);
        Response response = postTestSessionCompleteMethod.callAPI();
        Validator.validateResponse(postTestSessionCompleteMethod);
        TestBuffer.setSessionId(JsonPath.from(response.asString()).get(ResponseKey.SESSION_ID.getValue()));
    }

    public static void testSessionFinish() {
        PutTestSessionFinishMethod putTestSessionFinishMethod = new PutTestSessionFinishMethod();
        Validator.isExpectedStatusOK(putTestSessionFinishMethod);
        Validator.validateResponse(putTestSessionFinishMethod);
        putTestSessionFinishMethod.callAPI();
    }

    public static void attachLabelToRunningTest(String feature, String group) {
        PutTestExecutionLabelMethod putTestExecutionLabelMethod = new PutTestExecutionLabelMethod();
        putTestExecutionLabelMethod.addProperty("feature", feature);
        putTestExecutionLabelMethod.addProperty("group", group);
        Validator.isExpectedStatusEquals(putTestExecutionLabelMethod, HttpStatusCodeType.OK_NO_CONTENT);
        putTestExecutionLabelMethod.callAPI();
    }

    public static void addLogsToRunningTest(String message) {
        PostTestExecutionLogsMethod postTestExecutionLogsMethod = new PostTestExecutionLogsMethod();
        Validator.isExpectedStatusEquals(postTestExecutionLogsMethod, HttpStatusCodeType.ACCEPTED);
        postTestExecutionLogsMethod.addProperty("test_id", TestBuffer.getTestId());
        postTestExecutionLogsMethod.addProperty("message",message);
        postTestExecutionLogsMethod.callAPI();
    }
}
