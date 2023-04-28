package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.LabelMapper;
import com.mt.reginmen.dao.RegisterMapper;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Autowired
    DataServiceImpl dataService;
    @Autowired
    RegisterMapper registerMapper;

    /**
     * 个人页面添加个性化标签
     * @param id
     * @param labels_ids
     * @return
     */
    @Override
    public int addLabel(String id,String labels_ids) {
        return labelMapper.addLabel(id,labels_ids);
    }

    /**
     * 个人页面个性化标签的删除    ！！！暂未实现
     * @param id
     * @return
     */
    @Override
    public int deleteLabel(int id) {
        return labelMapper.deleteLabel(id);
    }

    @Override
    public Label selectLabel(String name) {
        return labelMapper.selectLabel(name);
    }

//    @Override
//    public List<String> getLabelName(int min,int max) {
//        List<String> names = new ArrayList<>();
//        Map<Integer,Double> map = dataService.getLabelHot(min, max);
//        List<Map.Entry<Integer,Double>> list = new ArrayList<>(map.entrySet());
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getKey());
//            names.add(labelMapper.getLabelName(list.get(i).getKey()));
//        }
//        return names;
//    }

    @Override
    public List<Label> findTop10() {

        return labelMapper.findTop10();
    }

    @Override
    public double Sum() {
        return labelMapper.Sum();
    }

    @Override
    public String getLabelName(int id) {
        return labelMapper.getLabelName(id);
    }

    /**
     * 查询用户已有的标签
     * @param user_id
     * @return
     */
    public List<Label> findUser_label(String user_id){
        String label=registerMapper.findUserLabels(user_id);
        String []labels=label.split(",");
        List<Label> labelList=new ArrayList<>();
        for (int i = 0; i <labels.length ; i++) {
            Label label1=labelMapper.getLabelById(Integer.parseInt(labels[i]));
            labelList.add(label1);
        }
        return labelList;
    }

}
