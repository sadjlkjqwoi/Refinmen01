package com.mt.reginmen.service;

import com.mt.reginmen.domain.Topics;

import java.util.HashSet;

public interface TopicService {
    public int addTopic(Topics topic);

    int IncreaseHot(int id);

    public int deleteTopic(int id);

//    public int selectTopic(String t_name);

    public HashSet<Topics> TopicSort();

    int addUser_idToTopic(int topic_id, String user_id);


}
