package com.mt.reginmen.service;

import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.User;

import java.util.List;

public interface RegisterService {
    String register(User user);

    List<Label> showAllLabels();

    boolean getSelectLabel(String id, String labels_ids);

    List<Integer> AgeCount();

}
