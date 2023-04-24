package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.Reviews_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class Reviews_dataController {
    @Autowired
    private Reviews_dataService reviews_dataService;
    @GetMapping("/addReviews")
    void addReviews(@RequestBody Reviews_data reviews_data){
        reviews_dataService.addReviews(reviews_data);
    }
    @DeleteMapping("/deleteReviews")
    void deleteReviews(int id){
        reviews_dataService.deleteReviews(id);
    }
}
