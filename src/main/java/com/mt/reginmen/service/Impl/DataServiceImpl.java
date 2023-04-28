package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.DataMapper;
import com.mt.reginmen.dao.LabelMapper;
import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataServiceImpl implements DataService {


    @Autowired
    private DataMapper dataMapper;

    @Autowired
    LabelMapper labelMapper;


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
    public List<List<Label>> getLabelTop3() {
        List<String> labels1 = dataMapper.getLabelTop3(16,44);
        List<String> labels2 = dataMapper.getLabelTop3(45,60);
        List<String> labels3 = dataMapper.getLabelTop3(61,999);
        ArrayList<String> label1 = new ArrayList<>();
        ArrayList<String> label2 = new ArrayList<>();
        ArrayList<String> label3 = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        for (String l1 : labels1){
            String[] a = l1.split(",");
            label1.addAll(Arrays.asList(a));
        }
        for (String l1 : labels2){
            String[] a = l1.split(",");
            label2.addAll(Arrays.asList(a));
        }
        for (String l1 : labels3){
            String[] a = l1.split(",");
            label3.addAll(Arrays.asList(a));
        }
        for (String obj : label1){
            if (map1.containsKey(obj)){
                map1.put(obj,map1.get(obj)+1);
            }else map1.put(obj,1);
        }
        for (String obj : label2){
            if (map2.containsKey(obj)){
                map2.put(obj,map2.get(obj)+1);
            }else map2.put(obj,1);
        }
        for (String obj : label3){
            if (map3.containsKey(obj)){
                map3.put(obj,map3.get(obj)+1);
            }else map3.put(obj,1);
        }
        List<Integer> hotLabels1 = new ArrayList<>();
        List<Integer> hotLabels2 = new ArrayList<>();
        List<Integer> hotLabels3 = new ArrayList<>();
        List<Map.Entry<String,Integer>> list1 = new ArrayList<>(map1.entrySet());
        List<Map.Entry<String,Integer>> list2 = new ArrayList<>(map2.entrySet());
        List<Map.Entry<String,Integer>> list3 = new ArrayList<>(map3.entrySet());
        list1.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        list2.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        list3.sort((o1, o2) -> (o2.getValue() - o1.getValue()));

        for (int i=0;i<3;i++){
            hotLabels1.add(Integer.valueOf(list1.get(i).getKey()));
            hotLabels2.add(Integer.valueOf(list2.get(i).getKey()));
            hotLabels3.add(Integer.valueOf(list3.get(i).getKey()));
        }

        List<Label> n1 = new ArrayList<>();
        List<Label> n2 = new ArrayList<>();
        List<Label> n3 = new ArrayList<>();

        for (Integer i : hotLabels1){
            n1.add(labelMapper.getLabelById(i));
        }
        for (Integer i : hotLabels2){
            n2.add(labelMapper.getLabelById(i));
        }
        for (Integer i : hotLabels3){
            n3.add(labelMapper.getLabelById(i));
        }

        List<List<Label>> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);

        return list;
    }

    @Override
    public List<Data> findAllData() {
        return dataMapper.findAllDatas();
    }

    @Override
    public List<Integer> getLabelByAge(int min,int max) {
        List<String> labels1 = dataMapper.getLabelTop3(min,max);
        ArrayList<String> label1 = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (String l1 : labels1){
            String[] a = l1.split(",");
            label1.addAll(Arrays.asList(a));
        }
        for (String obj : label1){
            if (map1.containsKey(obj)){
                map1.put(obj,map1.get(obj)+1);
            }else map1.put(obj,1);
        }
        List<Integer> hotLabels1 = new ArrayList<>();
        List<Map.Entry<String,Integer>> list1 = new ArrayList<>(map1.entrySet());
        list1.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        List<Integer> labels=new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            labels.add(Integer.parseInt(list1.get(i).getKey()));
        }
        return labels;
    }

}
