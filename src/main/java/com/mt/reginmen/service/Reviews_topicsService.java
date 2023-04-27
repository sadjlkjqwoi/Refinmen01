package com.mt.reginmen.service;


import com.mt.reginmen.domain.Reviews_topics;

import java.util.List;

public interface Reviews_topicsService {
    int addReviews_topics(Reviews_topics reviews_topics);

    int deleteReviews_topics(int id);

    List<Reviews_topics> AllReviews_topics(int id);
}
