package com.mt.reginmen.dao;


import com.mt.reginmen.domain.Topics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Mapper
public interface TopicsMapper {

    int addTopic(Topics topic);

    int deleteTopic(int id);

//    Topics selectTopic(String t_name);

    HashSet<Topics> TopicSort();

    int IncreaseHot(int id);

    int addUser_idToTopic(int topic_id, String user_id);

}
