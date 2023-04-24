package com.mt.reginmen.service.Impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.mt.reginmen.dao.FoodMapper;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<String[]> getFoodInformation() {
        List<String> AllFoodInformation = foodDao.getFoodInformation();
        List<String[]> list = new ArrayList<>();
        for (String s : AllFoodInformation){
            String[] information = s.split("#");
            list.add(information);
        }
        return list;
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
