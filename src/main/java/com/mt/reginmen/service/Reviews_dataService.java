package com.mt.reginmen.service;

import com.mt.reginmen.dao.Reviews_data;

public interface Reviews_dataService {
    void addReviews(String user_id,int data_id,String content);
}
