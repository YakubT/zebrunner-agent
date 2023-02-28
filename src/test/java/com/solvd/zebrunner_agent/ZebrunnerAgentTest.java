package com.solvd.zebrunner_agent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.solvd.zebrunner_agent.enums.TestStatus;

public class ZebrunnerAgentTest {

    private static final Logger LOGGER = LogManager.getLogger(ZebrunnerAgentTest.class);

    @Test
    public void testAuthentication() {
        AuthService.refreshToken();
    }

    @Test
    public void testTestRunExecution() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent testTestRun");
        TestExecutionService.finishTestRun();
    }

    @Test(dataProvider = "testStatuses")
    public void testTestExecution(TestStatus testStatus) {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent data provider test");
        TestExecutionService.testExecutionStart("zebrunner-agent test " + testStatus.getValue(), ZebrunnerAgentTest.class.getName(),
                "testTestExecution");
        TestExecutionService.testExecutionFinish(testStatus);
        TestExecutionService.finishTestRun();
    }

    @Test
    public void testTestExecutionInOneRun() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent tests in one run");
        for (TestStatus testStatus : TestStatus.values()) {
            TestExecutionService.testExecutionStart("zebrunner-agent test " + testStatus.getValue(),
                    ZebrunnerAgentTest.class.getName(),
                    "testTestExecutionInOneRun");
            TestExecutionService.testExecutionFinish(testStatus);
        }

        TestExecutionService.finishTestRun();
    }

    @Test
    public void testSession() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent test session");
        TestExecutionService.testSessionComplete();
        TestExecutionService.testExecutionStart("zebrunner-agent test ", ZebrunnerAgentTest.class.getName(),
                "testSession");
        TestExecutionService.testExecutionFinish(TestStatus.PASSED);
        TestExecutionService.finishTestRun();
    }

    @Test
    public void testLabels() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent test session with labels");
        TestExecutionService.testExecutionStart("zebrunner-agent test ", ZebrunnerAgentTest.class.getName(),
                "testLabels");
        TestExecutionService.attachLabelToRunningTest("zebrunner label feature","regression");
        TestExecutionService.testExecutionFinish(TestStatus.PASSED);
        TestExecutionService.finishTestRun();
    }

    @Test
    public void testLogs() {
        AuthService.refreshToken();
        TestExecutionService.startTestRun("Zebrunner Agent test session with logs");
        TestExecutionService.testExecutionStart("zebrunner-agent test ", ZebrunnerAgentTest.class.getName(),
                "testLogs");
        TestExecutionService.addLogsToRunningTest("Anatolii");
        TestExecutionService.testExecutionFinish(TestStatus.PASSED);
        TestExecutionService.finishTestRun();
    }
    @DataProvider(name = "testStatuses")
    public Object[][] dataProvider() {
        return new Object[][]{{TestStatus.PASSED}, {TestStatus.FAILED},
                {TestStatus.SKIPPED}, {TestStatus.ABORTED}};
    }
}
