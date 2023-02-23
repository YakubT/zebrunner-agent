package com.solvd.zebrunner_agent;

public class TestBuffer {

    private static int testRunId;

    private static int testId;

    private static int sessionId;

    public static int getTestRunId() {
        return testRunId;
    }

    public static void setTestRunId(int testRunId) {
        TestBuffer.testRunId = testRunId;
    }

    public static int getTestId() {
        return testId;
    }

    public static void setTestId(int testId) {
        TestBuffer.testId = testId;
    }


    public static int getSessionId() {
        return sessionId;
    }

    public static void setSessionId(int sessionId) {
        TestBuffer.sessionId = sessionId;
    }
}
