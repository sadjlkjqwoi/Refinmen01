package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Mechanism;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MechanismMapper {
    List<Mechanism> findAllMechanism();
}
