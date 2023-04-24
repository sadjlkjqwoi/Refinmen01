package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.Impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class FoodController {

    @Autowired
    FoodServiceImpl foodService;


    @GetMapping("/getFoodByName")
    public List<Food> selectFoodByName(String name) {
        return foodService.selectFoodByName(name);
    }

    @GetMapping("/getFoodById")
    public Food selectFoodById(int id) {
        return foodService.selectFoodById(id);
    }

    @GetMapping("/selectFoodLabel")
    public List<Food> selectFoodLabel(){
        return foodService.selectFoodLabel();
    }

    @GetMapping("/RecommendedFood")
    public HashSet<Food> RecommendedFood(String id) {
        return foodService.RecommendedFood(id);
    }

    @GetMapping("/getFoodInformation")
    public List<String[]> getFoodInformation(){
        return foodService.getFoodInformation();
    }

}
