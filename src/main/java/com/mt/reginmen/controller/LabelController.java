package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Label;

import com.mt.reginmen.service.Impl.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;
    /**
     * 个人页面用户标签的添加
     * @param label
     */
    @GetMapping("/addLabel")
    public void addLabel(@RequestBody Map<String, String> label) {
        String id = label.get("id");
        String labelsIds = label.get("labels_ids");
        labelService.addLabel(id,labelsIds);
    }

    /**
     * 个人页面用户标签的删除
     * @param user_id
     * @param label_id
     * @return
     */
//    @GetMapping("/deleteLabel")
//    public int deleteLabel(String user_id,int label_id) {
//        return labelService.deleteLabel(user_id,label_id);
//    }

    /**
     * 查找用户已有的标签
     * @param id
     * @return
     */
    @GetMapping("/findUser_label")
    public List<Label> findUser_label(String id){
        return labelService.findUser_label(id);
    }

    @GetMapping("/selectLabel")
    public Label selectLabel(String name) {
        return labelService.selectLabel(name);
    }
    /**
     * 大数据分析
     * 查找点击最多的前十标签
     * @return
     */
    @GetMapping("/findTop10")
    List<Label> findTop10(){
        return labelService.findTop10();
    }
    @GetMapping("/findOdds")
    List<Double> findOdds(){
        List<Label> labels=labelService.findTop10();
        List<Double> Odds=new ArrayList<>();
        for (int i = 0; i <labels.size() ; i++) {
            Odds.add(labels.get(i).getCount()/labelService.Sum());
        }
        return Odds;
    }

}
