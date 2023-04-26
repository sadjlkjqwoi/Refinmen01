package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Food_Conbination;
import com.mt.reginmen.service.Impl.Food_ConbinationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
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

    //获得所有食谱
    @GetMapping("/getFoodLabel")
    public List<Food_Conbination> selectFoodLabel(){
        return food_conbinationService.selectFoodLabel();
    }


    //根据用户Label推荐食谱
    @GetMapping("/RecommendedFoodConbination")
    public HashSet<Food_Conbination> RecommendedFood_Conbination(String id){
        return food_conbinationService.RecommendedFood_Conbination(id);
    }


    //获得食谱的详细信息
    @GetMapping("/getInformation")
    public String[] getInformation(int id){
        return food_conbinationService.getInformation(id);
    }

    //用户选择标签筛选食谱
    @GetMapping("/getFcByLabel")
    public List<Food_Conbination> getFcByLabel(String[] selectLabels){
        return food_conbinationService.getFcByLabel(selectLabels);
    }


}
