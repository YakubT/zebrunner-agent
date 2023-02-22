package com.solvd.zebrunner_agent;

import com.solvd.zebrunner_agent.enums.TestStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ZebrunnerAgentTest {

    private static final Logger LOGGER = LogManager.getLogger(ZebrunnerAgentTest.class);

    @Test
    public void testAuthentication() {
        AuthService.refreshToken();
    }

    @Test
    public void testTestRunExecution() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent authentication");
        TestExecutionService.finishTestRun();
    }

    @Test(dataProvider = "testStatuses")
    public void testTestExecution(TestStatus testStatus) {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent data provider test");
        TestExecutionService.testExecutionStart("zebrunner-agent test");
        TestExecutionService.testExecutionFinish(testStatus);
        TestExecutionService.finishTestRun();
    }

    @Test
    public void testTestExecutionInOneRun() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent tests in one run");
        for (TestStatus testStatus:TestStatus.values()) {
            TestExecutionService.testExecutionStart("zebrunner-agent test "+testStatus.getValue());
            TestExecutionService.testExecutionFinish(testStatus);
        }

        TestExecutionService.finishTestRun();
    }

    @DataProvider(name = "testStatuses")
    public Object[][] dataProvider() {
        return new Object[][]{{TestStatus.PASSED}, {TestStatus.FAILED},
                {TestStatus.SKIPPED}, {TestStatus.ABORTED}};
    }
}
