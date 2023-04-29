package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Reviews_topics;
import com.mt.reginmen.service.Impl.Reviews_topicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class Reviews_topicsController {

    @Autowired
    Reviews_topicsServiceImpl reviews_topicsService;


    @PostMapping("/addReviews_topics")
    public int addReviews_topics(@RequestBody Reviews_topics reviews_topics) {
        System.out.println(reviews_topics);
        return reviews_topicsService.addReviews_topics(reviews_topics);
    }


    //先搁置删除自己的评论
    @DeleteMapping("/deleteReviews_topics")
    public int deleteReviews_topics(int id) {
        return reviews_topicsService.deleteReviews_topics(id);
    }

    //获得所有人发表的评论
    @GetMapping("/AllReviews_topics")
    public List<Reviews_topics> AllReviews_topics(int id){
        return reviews_topicsService.AllReviews_topics(id);
    }

}
