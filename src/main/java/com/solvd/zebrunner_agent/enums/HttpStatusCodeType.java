package com.solvd.zebrunner_agent.enums;

public enum HttpStatusCodeType {

    OK(200),

    CREATED(201),

    ACCEPTED(202),

    OK_NO_CONTENT(204),

    BAD_REQUEST(400),

    UNAUTHORIZED(401),

    NOT_FOUND(404),

    INTERNAL_SERVER_ERROR(500);

    private int statusCode;

    HttpStatusCodeType(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}