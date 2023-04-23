package com.mt.reginmen.controller;

import com.mt.reginmen.service.Reviews_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Reviews_dataController {
    @Autowired
    private Reviews_dataService reviews_dataService;
    @GetMapping("/addReviews")
    void addReviews(String user_id,int data_id,String content){
        reviews_dataService.addReviews(user_id, data_id, content);
    }
}
