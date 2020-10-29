package xyz.k4czp3r.worktimes.model;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
    private final HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ApiErrorResponse(HttpStatus status) {
        this.status = status;
    }

    public ApiErrorResponse(HttpStatus status, Throwable ex) {
        this.status = status;
        this.message = ex.getMessage();
    }
}

