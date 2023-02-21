package com.solvd.zebrunner_agent;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.solvd.zebrunner_agent.enums.ResponseKey;
import com.solvd.zebrunner_agent.methods.PostAuthenticationMethod;
import com.solvd.zebrunner_agent.utils.PropertiesReader;
import com.solvd.zebrunner_agent.utils.enums.Resources;

public class AuthService {

    static {
        authToken = new PropertiesReader(Resources.AGENT_CONFIG.getValue()).getValue("token");
    }

    private static String authToken;

    public static String getAuthToken() {
        return authToken;
    }

    public static void refreshToken() {
        Response response = new PostAuthenticationMethod().callAPI();
        AuthService.authToken = JsonPath.from(response.asString()).get(ResponseKey.AUTH_TOKEN.getValue()).toString();
    }
}
