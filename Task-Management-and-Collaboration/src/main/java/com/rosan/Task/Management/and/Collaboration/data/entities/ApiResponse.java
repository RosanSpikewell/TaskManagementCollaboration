package com.rosan.Task.Management.and.Collaboration.data.entities;



import java.util.Date;

public class ApiResponse<T>{

    private int statusCode;
    private String message;
    private T data;
    private Date timeStamp;

    public ApiResponse() {
    }

    public ApiResponse(int statusCode, String message, T data, Date timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
