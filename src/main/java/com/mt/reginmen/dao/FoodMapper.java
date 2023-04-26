package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<Food> selectFoodByName(String name);

    Food selectFoodById(int id);

    List<Food> selectFoodLabel();

    String  getFoodInformation(int id);

}
