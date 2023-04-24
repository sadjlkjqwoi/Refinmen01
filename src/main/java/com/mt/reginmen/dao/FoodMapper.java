package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> selectFoodByName(String name);

    Food selectFoodById(int id);

    Food selectFoodByLabel(String label);

    List<Food> selectFoodLabel();

    List<String> getFoodInformation();

}
