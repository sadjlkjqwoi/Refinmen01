package com.mt.reginmen.service;

import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Food_Conbination;
import com.mt.reginmen.domain.User;

import java.util.HashSet;
import java.util.List;

public interface Food_ConbinationService {
    public Food_Conbination selectFood_ConbinationById(int id);

    public List<Food_Conbination> selectFood_ConbinationByName(String name);

    public HashSet<Food_Conbination> RecommendedFood_Conbination(String id);

    public List<Food_Conbination> selectFoodLabel();

    public String[] getInformation(int id);

    public List<Food_Conbination> getFcByLabel(String[] selectLabels);

}