package com.mt.reginmen.controller;


import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String test(@RequestBody User user) {
        return loginService.login(user.getId(), user.getPassword());
    }

}
