package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Reviews_data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Reviews_dataMapper {
    void addReviews(Reviews_data reviews_data);
    void deleteReviews(int id);
    void addReview_idToData(int data_id,String id);
}
