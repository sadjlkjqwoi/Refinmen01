package com.mt.reginmen.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.mt.reginmen.domain.Topics;

import com.mt.reginmen.service.Impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    @PostMapping("/addTopic")
    public int addTopic(@RequestBody Topics topic) {
        System.out.println(topic);
        return topicService.addTopic(topic);
    }

    @RequestMapping("/deleteTopic")
    public int deleteTopic(int id) {
        return topicService.deleteTopic(id);
    }

    @RequestMapping("/IncreaseHot")
    public int IncreaseHot(int id) {
        return topicService.IncreaseHot(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/TopicSort")
    public List<Topics> TopicSort() {
        return topicService.TopicSort();
    }

    @RequestMapping("/addReviewToTopic")
    public int addReviewToTopic(int topic_id, int Review_id) {
        return topicService.addReviewToTopic(topic_id, Review_id);
    }


}
