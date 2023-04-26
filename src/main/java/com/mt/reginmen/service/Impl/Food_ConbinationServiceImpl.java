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
import java.util.Objects;

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
    public String[] getInformation(int id) {
        String Information = food_conbinationDao.getInformation(id);

        String[] information = Information.split("#");

        return information;
    }

    public boolean function(String[] arr1,String[] arr2){
        for (String item : arr2) {
            boolean containsItem = false;
            for (String element : arr1) {
                if (Objects.equals(element, item)) {
                    containsItem = true;
                    break;
                }
            }
            if (!containsItem) {
                return false;
            }
        }
        return true;

    }

    @Override
    public List<Food_Conbination> getFcByLabel(String[] selectLabels) {
        List<Food_Conbination> fcs = food_conbinationDao.selectFoodLabel();
        List<Food_Conbination> list = new ArrayList<>();
        for (Food_Conbination food_conbination : fcs){
            String[] labels = food_conbination.getLabels_ids().split(",");
            if (function(labels,selectLabels)){
                list.add(food_conbination);
            }
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
