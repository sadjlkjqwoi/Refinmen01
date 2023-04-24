package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Label;

import com.mt.reginmen.service.Impl.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;

    @GetMapping("/addLabel")
    public int addLabel(@RequestBody Label label) {
        return labelService.addLabel(label);
    }

    @GetMapping("/deleteLabel")
    public int deleteLabel(int id) {
        return labelService.deleteLabel(id);
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
