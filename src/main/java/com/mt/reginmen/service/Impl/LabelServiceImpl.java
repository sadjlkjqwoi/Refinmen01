package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.LabelMapper;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Override
    public int addLabel(Label label) {
        return labelMapper.addLabel(label);
    }

    @Override
    public int deleteLabel(int id) {
        return labelMapper.deleteLabel(id);
    }

    @Override
    public Label selectLabel(String name) {
        return labelMapper.selectLabel(name);
    }
}
