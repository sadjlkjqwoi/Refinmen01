package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Reviews_data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Reviews_dataMapper {
    void addReviews(Reviews_data reviews_data);
    void deleteReviews(int id);
    List<Reviews_data> findAllReviews(int data_id);
}
