package com.mt.reginmen.service;

import com.mt.reginmen.domain.User;

public interface LoginService {
    String login(String id, String password);
    int findUserAge(String id);
    User findUser(String id);
}
