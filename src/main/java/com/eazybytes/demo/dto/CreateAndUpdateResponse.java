package com.eazybytes.demo.dto;

import java.util.Optional;

public class CreateAndUpdateResponse<T> {
    private Optional<T> data = null;
    private String message;
    private boolean error;

    public CreateAndUpdateResponse(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public Optional<T> getData() {
        return data;
    }

    public void setData(Optional<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
