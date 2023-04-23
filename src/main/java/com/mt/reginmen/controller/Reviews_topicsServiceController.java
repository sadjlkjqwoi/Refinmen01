package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Reviews_topics;
import com.mt.reginmen.service.Impl.Reviews_topicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Reviews_topics")
public class Reviews_topicsServiceController {

    @Autowired
    Reviews_topicsServiceImpl reviews_topicsService;

    @GetMapping("/addReviews_topics")
    public int addReviews_topics(@RequestBody Reviews_topics reviews_topics) {
        return reviews_topicsService.addReviews_topics(reviews_topics);
    }

    @DeleteMapping("/deleteReviews_topics")
    public int deleteReviews_topics(int id) {
        return reviews_topicsService.deleteReviews_topics(id);
    }


}
