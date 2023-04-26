package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.DataMapper;
import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public String getUserLabel(String id) {

        String label = dataMapper.getUserLabel(id);
        return label;
    }

    @Override
    public List<Data> findDataByLabel(String label) {
        List<Data> datas = new ArrayList<>();
        datas = dataMapper.findDataByLabel(label);
        return datas;
    }

    @Override
    public List<Data> findAllDatas() {
        return dataMapper.findAllData();
    }


    @Override
    public Reviews_data findReviewsById(int id) {
        return dataMapper.findReviewsById(id);
    }

    @Override
    public List<Data> findDataByCount() {
        return dataMapper.findDataByCount();
    }

    public void click(int id) {
        dataMapper.click(id);
    }

    @Override
    public Map<Integer,Double> getLabelHot(int min,int max) {
        List<String> labels = dataMapper.getLabelHot(min, max);
        ArrayList<String> label = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String l:labels){
            String[] a = l.split(",");
            label.addAll(Arrays.asList(a));
        }
        System.out.println(label.size());
        int count = 0;
        for (String obj : label){
            if (map.containsKey(obj)){
                count++;
                map.put(obj,map.get(obj)+1);
            }else {
                map.put(obj,1);
            }
        }
        List<Integer> hotLabels = new ArrayList<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1, o2) -> (o2.getValue() - o1.getValue()));
        for (int i=0;i<5;i++){
            hotLabels.add(Integer.valueOf(list.get(i).getKey()));
            System.out.println((double)Integer.valueOf(list.get(i).getValue())/ label.size());
        }

        Map<Integer,Double> map1 = new HashMap<>();

        for (int i=0;i< hotLabels.size();i++){
            map1.put(Integer.valueOf(list.get(i).getKey()),(double)Integer.valueOf(list.get(i).getValue())/ label.size());
        }

        return map1;
    }

    @Override
    public List<Data> findAllData() {
        return dataMapper.findAllDatas();
    }
}
