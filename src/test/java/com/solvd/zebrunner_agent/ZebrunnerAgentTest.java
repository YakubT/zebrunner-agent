package com.solvd.zebrunner_agent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ZebrunnerAgentTest {

    private static final Logger LOGGER = LogManager.getLogger(ZebrunnerAgentTest.class);

    @Test
    public void testAuthentification() {
       AuthService.refreshToken();
       LOGGER.info(AuthService.getAuthToken());
    }
}
