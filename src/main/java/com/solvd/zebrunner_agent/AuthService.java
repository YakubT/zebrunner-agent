package com.solvd.zebrunner_agent;

import utils.PropertiesReader;
import utils.Resources;

public class AuthService {

    static {
        authToken = new PropertiesReader(Resources.AGENT_CONFIG.getValue()).getValue("access-token");
    }

    private static String authToken;

    public static String getAuthToken() {
        return authToken;
    }

    public static void refreshToken() {
        
    }
}
