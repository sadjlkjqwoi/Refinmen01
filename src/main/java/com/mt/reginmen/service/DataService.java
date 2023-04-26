package com.mt.reginmen.service;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Reviews_data;

import java.util.List;
import java.util.Map;

public interface DataService {
    String getUserLabel(String id);


    List<Data> findDataByLabel(String label);

    List<Data> findAllDatas();


    Reviews_data findReviewsById(int id);

    List<Data> findDataByCount();

    void click(int id);

    Map<Integer,Double> getLabelHot(int min, int max);

    List<Data> findAllData();
}
