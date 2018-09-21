package com.petrokomplekt.core.Authorization;

public class AuthToken {

    private String token;

    public AuthToken(){

    }

    AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}