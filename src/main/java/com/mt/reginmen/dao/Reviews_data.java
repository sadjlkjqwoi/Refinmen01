package com.mt.reginmen.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Reviews_data {

    void addReviews(String user_id,int data_id,String content);
}
