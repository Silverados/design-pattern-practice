package com.wyw;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RequestHandler {

    private final RequestHandler next;

    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }

    protected void printHandling(Request request) {
        System.out.println("handler " + request);
    }

    @Override
    public abstract String toString();
}
