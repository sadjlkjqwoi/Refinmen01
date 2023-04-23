package com.mt.reginmen.controller;


import com.mt.reginmen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String test(String id, String password) {
        return loginService.login(id, password);
    }

}
