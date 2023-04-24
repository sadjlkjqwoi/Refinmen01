package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.Food_ConbinationMapper;
import com.mt.reginmen.domain.Food;
import com.mt.reginmen.domain.Food_Conbination;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.Food_ConbinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class Food_ConbinationServiceImpl implements Food_ConbinationService {

    @Autowired
    Food_ConbinationMapper food_conbinationDao;

    @Autowired
    DataServiceImpl dataService;

    @Override
    public Food_Conbination selectFood_ConbinationById(int id){
        return food_conbinationDao.selectFood_ConbinationById(id);
    }
    @Override
    public List<Food_Conbination> selectFood_ConbinationByName(String name){
        return food_conbinationDao.selectFood_ConbinationByName(name);
    }

    @Override
    public List<Food_Conbination> selectFoodLabel() {
        return food_conbinationDao.selectFoodLabel();
    }

    @Override
    public List<String[]> getInformation() {
        List<String> AllFoodInformation = food_conbinationDao.getInformation();
        List<String[]> list = new ArrayList<>();
        for (String s : AllFoodInformation){
            String[] information = s.split("#");
            list.add(information);
        }
        return list;
    }

    @Override
    public HashSet<Food_Conbination> RecommendedFood_Conbination(String id){
        String Label = dataService.getUserLabel(id);
        String[] labels = Label.split(",");
        HashSet<Food_Conbination> RecommendedFc = new HashSet<>();
        List<Food_Conbination> fcs = food_conbinationDao.selectFoodLabel();
        for (Food_Conbination fc : fcs){
            String a = fc.getLabels_ids();
            String[] b = a.split(",");

            for(int i=0;i< b.length;i++){
                for (int j=0;j< labels.length;j++){
                    if (b[i].equals(labels[j])){
                        RecommendedFc.add(fc);
                        break;
                    }
                }
            }
        }
        return RecommendedFc;
    }

}
