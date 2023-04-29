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
        String id = user.getId();
        String password = user.getPassword();
        System.out.println(id);
        System.out.println(password);
        return loginService.login(id, password);
    }

    /**
     * 返回用户是哪个年龄阶层
     * @param id
     * @return
     */
    @GetMapping("/findUserAge")
    public int findUserAge(String id){
       return loginService.findUserAge(id);
    }


    @GetMapping("/findUser")
    public User findUser(String id) {
        return loginService.findUser(id);
    }

}
