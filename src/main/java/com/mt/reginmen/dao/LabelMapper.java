package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Label;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabelMapper {

    int addLabel(Label label);

    int deleteLabel(int id);

    Label selectLabel(String name);

    String getLabelName(int id);

}
