package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.FoodMapper;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodDao;
    @Autowired
    DataServiceImpl dataService;

    @Override
    public Food selectFoodByName(String name) {
        return foodDao.selectFoodByName(name);
    }

    @Override
    public Food selectFoodById(int id) {
        return foodDao.selectFoodById(id);
    }

    @Override
    public HashSet<Food> RecommendedFood(String id) {
        String Label = dataService.getUserLabel(id);
        String[] labels = Label.split(",");
        HashSet<Food> foods = new HashSet<>();
        for (String s : labels) {
            foods.add(foodDao.selectFoodByLabel(s));
        }
        System.out.println(foods);
        return foods;
    }


}
