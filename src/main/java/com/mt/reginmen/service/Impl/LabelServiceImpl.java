package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.LabelMapper;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Autowired
    DataServiceImpl dataService;


    @Override
    public int addLabel(Label label) {
        return labelMapper.addLabel(label);
    }

    @Override
    public int deleteLabel(int id) {
        return labelMapper.deleteLabel(id);
    }

    @Override
    public Label selectLabel(String name) {
        return labelMapper.selectLabel(name);
    }

    @Override
    public List<String> getLabelName(int min,int max) {
        List<String> names = new ArrayList<>();
        Map<Integer,Double> map = dataService.getLabelHot(min, max);
        List<Map.Entry<Integer,Double>> list = new ArrayList<>(map.entrySet());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getKey());
            names.add(labelMapper.getLabelName(list.get(i).getKey()));
        }
        return names;
    }

    @Override
    public List<Label> findTop10() {

        return labelMapper.findTop10();
    }

    @Override
    public double Sum() {
        return labelMapper.Sum();
    }


}
