package com.test.springboot_test.assumtion;

public class ConnectionChecker {

    private String uri;

    public ConnectionChecker(String uri) {
        this.uri = uri;
    }

    public boolean connect() {
        return false;
    }

}
