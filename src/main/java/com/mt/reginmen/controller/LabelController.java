package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Label;

import com.mt.reginmen.service.Impl.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("label")
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

}
