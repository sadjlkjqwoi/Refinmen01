package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.Impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodServiceImpl foodService;


    @GetMapping("/getFoodByName")
    public Food selectFoodByName(String name) {
        Food food = foodService.selectFoodByName(name);
        return food;
    }

    @GetMapping("/getFoodById")
    public Food selectFoodById(int id) {
        Food food = foodService.selectFoodById(id);
        return food;
    }

    //这个方法需要改
    @GetMapping("/RecommendedFood")
    public HashSet<Food> RecommendedFood(String id) {
        HashSet<Food> foods = foodService.RecommendedFood(id);
        return foods;
    }

}
