package com.eazybytes.demo.type;

import com.eazybytes.demo.entity.Account;

public class ILoginReponse {
    String message = null;
    Account account = null;
    String token = null;

    public ILoginReponse(String message, Account account, String token) {
        this.message = message;
        this.account = account;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
