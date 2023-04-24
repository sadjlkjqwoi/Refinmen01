package com.mt.reginmen.service;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public interface FoodService {
    public List<Food> selectFoodByName(String name);

    public Food selectFoodById(int id);

    public HashSet<Food> RecommendedFood(String id);
    List<Food> selectFoodLabel();

    List<String[]> getFoodInformation();
}
