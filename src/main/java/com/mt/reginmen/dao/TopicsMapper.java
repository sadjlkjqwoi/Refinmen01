package com.mt.reginmen.dao;


import com.mt.reginmen.domain.Topics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface TopicsMapper {

    int addTopic(Topics topic);

    int deleteTopic(int id);

    List<Topics> TopicSort();

    int IncreaseHot(int id);

    int addReviewToTopic(int topic_id, int Review_id);

}
