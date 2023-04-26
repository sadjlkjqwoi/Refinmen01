package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Food_Conbination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface Food_ConbinationMapper {


    Food_Conbination selectFood_ConbinationById(int id);

    List<Food_Conbination> selectFood_ConbinationByName(String name);


    List<Food_Conbination> selectFoodLabel();

    String getInformation(int id);

}
