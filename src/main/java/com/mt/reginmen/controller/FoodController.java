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

    //输出所有食物
    @GetMapping("/selectFoodLabel")
    public List<Food> selectFoodLabel(){
        return foodService.selectFoodLabel();
    }

    //给用户推荐Label相同的食物
    @GetMapping("/RecommendedFood")
    public HashSet<Food> RecommendedFood(String id) {
        return foodService.RecommendedFood(id);
    }


    //获得食物详细信息
    @GetMapping("/getFoodInformation")
    public String[] getFoodInformation(int id){
        return foodService.getFoodInformation(id);
    }

    //用户选择标签筛选食物
    @GetMapping("/getFoodByLabel")
    public List<Food> getFoodByLabel(String[] selectLabels){
        return foodService.getFoodByLabel(selectLabels);
    }

}
