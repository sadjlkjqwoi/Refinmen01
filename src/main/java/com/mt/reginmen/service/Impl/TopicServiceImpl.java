package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.TopicsMapper;
import com.mt.reginmen.domain.Topics;
import com.mt.reginmen.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicsMapper topicsDao;

    @Override
    public int addTopic(Topics topic) {
        return topicsDao.addTopic(topic);
    }

    @Override
    public int IncreaseHot(int id) {
        return topicsDao.IncreaseHot(id);
    }

    @Override
    public int deleteTopic(int id) {
        return topicsDao.deleteTopic(id);
    }

    @Override
    public List<Topics> TopicSort() {
        return topicsDao.TopicSort();

    }

    @Override
    public int addUser_idToTopic(int topic_id, String user_id) {
        return topicsDao.addUser_idToTopic(topic_id, user_id);
    }
//    @Override
//    public Topics selectTopic(String t_name){
//        return topicsDao.selectTopic(t_name);
//    }


}
