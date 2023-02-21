package com.solvd.zebrunner_agent;

import com.solvd.zebrunner_agent.enums.TestStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ZebrunnerAgentTest {

    private static final Logger LOGGER = LogManager.getLogger(ZebrunnerAgentTest.class);

    @Test
    public void testAuthentication() {
        LOGGER.info(AuthService.getAuthToken());
        AuthService.refreshToken();
        LOGGER.info(AuthService.getAuthToken());
    }

    @Test
    public void testTestRunExecution() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun();
        TestExecutionService.finishTestRun();
    }

    @Test
    public void testTestExecutionPassed() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun();
        TestExecutionService.testExecutionStart("zebrunner-agent test");
        TestExecutionService.testExecutionFinish(TestStatus.PASSED);
        LOGGER.info(TestBuffer.getTestRunId());
        LOGGER.info(TestBuffer.getTestId());
        TestExecutionService.finishTestRun();
    }
}
