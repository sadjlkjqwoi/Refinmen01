package com.mt.reginmen.service;

import com.mt.reginmen.domain.Label;

public interface LabelService {

    int addLabel(Label label);

    int deleteLabel(int id);

    Label selectLabel(String name);

}
