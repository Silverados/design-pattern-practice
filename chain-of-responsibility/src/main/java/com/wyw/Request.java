package com.wyw;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Request {

    private final RequestType requestType;

    private final String requestDescription;

    private boolean handled;

    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestDescription='" + requestDescription + '\'' +
                '}';
    }
}
