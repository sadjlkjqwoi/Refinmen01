package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Food_Conbination;
import com.mt.reginmen.service.Impl.Food_ConbinationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/FoodConbination")
public class Food_ConbinationController {

    @Autowired
    Food_ConbinationServiceImpl food_conbinationService;

    @GetMapping("/getFoodConbinationById")
    public Food_Conbination selectFood_ConbinationById(int id){
        return food_conbinationService.selectFood_ConbinationById(id);
    }

    @GetMapping("/getFoodConbinationByName")
    public List<Food_Conbination> selectFood_ConbinationByName(String name){
        return food_conbinationService.selectFood_ConbinationByName(name);
    }

    @GetMapping("/getFoodLabel")
    public List<Food_Conbination> selectFoodLabel(){
        return food_conbinationService.selectFoodLabel();
    }


    @GetMapping("/RecommendedFoodConbination")
    public HashSet<Food_Conbination> RecommendedFood_Conbination(String id){
        return food_conbinationService.RecommendedFood_Conbination(id);
    }

}
