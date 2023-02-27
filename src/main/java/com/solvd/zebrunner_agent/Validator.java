package com.solvd.zebrunner_agent;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.solvd.zebrunner_agent.enums.HttpStatusCodeType;

public class Validator {

    public static void isExpectedStatusOK(AbstractApiMethodV2 apiMethod) {
        apiMethod.request.expect().statusCode(HttpStatusCodeType.OK.getStatusCode());
    }

    public static void isExpectedStatusEquals(AbstractApiMethodV2 apiMethod, HttpStatusCodeType httpStatusCodeType) {
        apiMethod.request.expect().statusCode(httpStatusCodeType.getStatusCode());
    }
}
