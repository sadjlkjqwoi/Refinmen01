package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Food;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper {

    Food selectFoodByName(String name);

    Food selectFoodById(int id);

    Food selectFoodByLabel(String label);


}
