package com.mt.reginmen.service;

import com.mt.reginmen.domain.Label;

import java.util.List;
import java.util.Map;

public interface LabelService {

    int addLabel(String id,String labels_ids);

    int deleteLabel(int id);

    Label selectLabel(String name);

//    List<String> getLabelName(int min,int max);
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

    String getLabelName(int id);
    public List<Label> findUser_label(String user_id);

}
