package com.mt.reginmen.service;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.Reviews_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DataService {

    String getUserLabel(String id);


    List<Data> findDataByLabel(String label);

    List<Data> findAllDatas();


    Reviews_data findReviewsById(int id);

    List<Data> findDataByCount();

    void click(int id);

    List<List<Label>> getLabelTop3();

    List<Data> findAllData();


    List<Integer> getLabelByAge(int min,int max);

}
