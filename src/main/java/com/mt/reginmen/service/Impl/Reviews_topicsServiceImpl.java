package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.Reviews_topicsMapper;
import com.mt.reginmen.dao.TopicsMapper;
import com.mt.reginmen.domain.Reviews_topics;
import com.mt.reginmen.service.Reviews_topicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reviews_topicsServiceImpl implements Reviews_topicsService {

    @Autowired
    Reviews_topicsMapper reviews_topicsMapper;

    @Autowired
    TopicsMapper topicsDao;

    @Override
    public int addReviews_topics(Reviews_topics reviews_topics) {
        topicsDao.addReviewToTopic(reviews_topics.getTopics_id(),reviews_topics.getId());
        return reviews_topicsMapper.addReviews_topics(reviews_topics);
    }

    @Override
    public int deleteReviews_topics(int id) {
        return reviews_topicsMapper.deleteReviews_topics(id);
    }

    @Override
    public List<Reviews_topics> AllReviews_topics() {
        return reviews_topicsMapper.AllReviews_topics();
    }
}
