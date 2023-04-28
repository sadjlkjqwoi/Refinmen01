package com.mt.reginmen.service;

public interface LoginService {
    String login(String id, String password);
    int findUserAge(String id);
}
