package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.MechanismMapper;
import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Mechanism;
import com.mt.reginmen.service.MechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanismServiceImpl implements MechanismService {
    @Autowired
    private MechanismMapper mechanismMapper;

    @Override
    public List<Mechanism> findAllMechanism() {
        return mechanismMapper.findAllMechanism();
    }
}
