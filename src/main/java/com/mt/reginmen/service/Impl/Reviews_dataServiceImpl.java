package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.Reviews_dataMapper;
import com.mt.reginmen.domain.Reviews_data;
import com.mt.reginmen.service.Reviews_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reviews_dataServiceImpl implements Reviews_dataService {
    @Autowired
    private Reviews_dataMapper reviews_dataMapper;

    @Override
    public void addReviews(Reviews_data reviews_data) {
        reviews_dataMapper.addReviews(reviews_data);
    }

    @Override
    public void deleteReviews(int id) {
        reviews_dataMapper.deleteReviews(id);
    }
}
