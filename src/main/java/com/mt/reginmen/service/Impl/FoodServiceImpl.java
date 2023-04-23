package com.mt.reginmen.service.Impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.mt.reginmen.dao.FoodMapper;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodDao;
    @Autowired
    DataServiceImpl dataService;

    @Override
    public List<Food> selectFoodByName(String name) {
        return foodDao.selectFoodByName(name);
    }

    @Override
    public Food selectFoodById(int id) {
        return foodDao.selectFoodById(id);
    }

    @Override
    public List<Food> selectFoodLabel() {
        return foodDao.selectFoodLabel();
    }

    @Override
    public HashSet<Food> RecommendedFood(String id) {
        String Label = dataService.getUserLabel(id);
        String[] labels = Label.split(",");
        HashSet<Food> RecommendedFood = new HashSet<>();
        List<Food> foods = foodDao.selectFoodLabel();
        for (Food food : foods){
            String a = food.getLabels_ids();
            String[] b = a.split(",");

            for(int i=0;i< b.length;i++){
                for (int j=0;j< labels.length;j++){
                    if (b[i].equals(labels[j])){
                        RecommendedFood.add(food);
                        break;
                    }
                }
            }
        }
        return RecommendedFood;
    }


}
