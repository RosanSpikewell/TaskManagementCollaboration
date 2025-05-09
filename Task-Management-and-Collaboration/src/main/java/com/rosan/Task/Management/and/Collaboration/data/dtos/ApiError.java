package com.rosan.Task.Management.and.Collaboration.data.dtos;

import java.util.Date;

public class ApiError {

    private int statusCode;
    private String message;
    private Date timeStamp;

    public ApiError() {
    }

    public ApiError(int statusCode, String message, Date timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
