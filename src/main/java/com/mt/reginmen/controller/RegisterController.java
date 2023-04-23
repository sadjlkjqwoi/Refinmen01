package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return registerService.register(user);
    }

    /**
     * 展示所有标签
     *
     * @return
     */
    @GetMapping("/showAllLabels")
    List<Label> showAllLabels() {
        return registerService.showAllLabels();
    }

    /**
     * 获取用户选择的标签
     *
     * @param id
     * @param labels_ids
     * @return
     */
    @RequestMapping("/getSelectLabel")
    public boolean getSelectLabel(String id, String labels_ids) {
        registerService.getSelectLabel(id, labels_ids);
        return true;
    }

}
