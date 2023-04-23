package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Reviews_topics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Reviews_topicsMapper {

    int addReviews_topics(Reviews_topics reviews_topics);


    int deleteReviews_topics(int id);


}
