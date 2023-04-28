package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelMapper {

    int addLabel(String id,String labels_ids);

    int deleteLabel(int id);

    Label selectLabel(String name);

    String getLabelName(int id);
    /**
     * 大数据分析
     * 查找点击最多的前十标签
     * @return
     */
    List<Label> findTop10();

    /**
     * 计算总的次数
     * @return
     */
    double Sum();

    Label getLabelById(int id);

}
