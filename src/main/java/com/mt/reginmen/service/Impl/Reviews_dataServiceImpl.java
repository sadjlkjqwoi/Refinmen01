package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.Reviews_data;
import com.mt.reginmen.service.Reviews_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reviews_dataServiceImpl implements Reviews_dataService {
    @Autowired
    private Reviews_data reviews_data;

    @Override
    public void addReviews(String user_id, int data_id, String content) {
        reviews_data.addReviews(user_id, data_id, content);
    }
}
