package com.mt.reginmen.service;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public interface FoodService {
    public Food selectFoodByName(String name);

    public Food selectFoodById(int id);

    public HashSet<Food> RecommendedFood(String id);
}
