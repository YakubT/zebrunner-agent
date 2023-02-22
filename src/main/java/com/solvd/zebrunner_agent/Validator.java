package com.solvd.zebrunner_agent;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.solvd.zebrunner_agent.enums.HttpStatusCodeType;

public class Validator {

    public static void isExpectStatusOK(AbstractApiMethodV2 apiMethod) {
        apiMethod.request.expect().statusCode(HttpStatusCodeType.OK.getStatusCode());
    }
}
