package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Topics;

import com.mt.reginmen.service.Impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@Controller
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    @RequestMapping(value = "addTopic/{topic}", method = RequestMethod.GET)
    public int addTopic(@PathVariable Topics topic) {
        return topicService.addTopic(topic);
    }

    @RequestMapping(value = "deleteTopic/{id}", method = RequestMethod.GET)
    public int deleteTopic(@PathVariable int id) {
        return topicService.deleteTopic(id);
    }

    @RequestMapping(value = "IncreaseHot", method = RequestMethod.GET)
    public int IncreaseHot(@PathVariable int id) {
        return topicService.IncreaseHot(id);
    }

    @RequestMapping(value = "TopicSort", method = RequestMethod.GET)
    public HashSet<Topics> TopicSort() {
        return topicService.TopicSort();
    }

    @RequestMapping(value = "addUser_idToTopic/topic_id={topic_id},user_id={user_id}", method = RequestMethod.GET)
    public int addUser_idToTopic(@PathVariable int topic_id, @PathVariable String user_id) {
        return topicService.addUser_idToTopic(topic_id, user_id);
    }


}
