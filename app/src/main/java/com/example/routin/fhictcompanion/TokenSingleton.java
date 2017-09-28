package com.example.routin.fhictcompanion;

/**
 * Created by coen on 21/09/2017.
 */

public class TokenSingleton {
    private static final TokenSingleton ourInstance = new TokenSingleton();

    static TokenSingleton getInstance() {
        return ourInstance;
    }

    private TokenSingleton() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
