package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Reviews_topics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Reviews_topicsMapper {

    int addReviews_topics(Reviews_topics reviews_topics);


    int deleteReviews_topics(int id);

    List<Reviews_topics> AllReviews_topics(int id);


}
