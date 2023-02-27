package com.solvd.zebrunner_agent;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.zebrunner_agent.enums.ResponseKey;
import com.solvd.zebrunner_agent.methods.PostAuthenticationMethod;
import com.solvd.zebrunner_agent.utils.PropertiesReader;
import com.solvd.zebrunner_agent.utils.enums.Resources;


public class AuthService {

    private static final Logger LOGGER = LogManager.getLogger(AuthService.class);

    static {
        authToken = new PropertiesReader(Resources.AGENT_CONFIG.getValue()).getDecrypted("token");
    }

    private static String authToken;

    public static String getAuthToken() {
        return authToken;
    }

    public static void refreshToken() {
        PostAuthenticationMethod postAuthenticationMethod = new PostAuthenticationMethod();
        Validator.isExpectedStatusOK(postAuthenticationMethod);
        Response response = postAuthenticationMethod.callAPI();
        Validator.validateResponse(postAuthenticationMethod);
        AuthService.authToken = JsonPath.from(response.asString()).get(ResponseKey.AUTH_TOKEN.getValue()).toString();
    }
}
