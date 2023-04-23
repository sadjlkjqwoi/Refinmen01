package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Topics;

import com.mt.reginmen.service.Impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    @GetMapping("/addTopic")
    public int addTopic(@RequestBody Topics topic) {
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

    @GetMapping("/TopicSort")
    public List<Topics> TopicSort() {
        return topicService.TopicSort();
    }

    @RequestMapping("/addUser_idToTopic")
    public int addUser_idToTopic(int topic_id,String user_id) {
        return topicService.addUser_idToTopic(topic_id, user_id);
    }


}
