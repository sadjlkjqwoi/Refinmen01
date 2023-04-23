package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.DataMapper;
import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
