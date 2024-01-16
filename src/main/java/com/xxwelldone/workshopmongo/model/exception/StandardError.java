package com.xxwelldone.workshopmongo.model.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Instant timeStamp;
    private HttpStatus status;
    private String error;
    private String msg;
    private String path;

    public StandardError(){}

    public StandardError(Instant timeStamp, HttpStatus status, String error, String msg, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.msg = msg;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
