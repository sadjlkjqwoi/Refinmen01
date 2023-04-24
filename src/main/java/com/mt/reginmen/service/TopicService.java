package com.mt.reginmen.service;

import com.mt.reginmen.domain.Topics;

import java.util.HashSet;
import java.util.List;

public interface TopicService {
    public int addTopic(Topics topic);

    int IncreaseHot(int id);

    public int deleteTopic(int id);

//    public int selectTopic(String t_name);

    public List<Topics> TopicSort();

    int addReviewToTopic(int topic_id, int Review_id);


}
