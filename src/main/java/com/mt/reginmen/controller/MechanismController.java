package com.mt.reginmen.controller;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Mechanism;
import com.mt.reginmen.service.MechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class MechanismController {
    @Autowired
    private MechanismService mechanismService;

    @GetMapping("/findAllMechanism")
    List<Mechanism> findAllMechanism() {
        return mechanismService.findAllMechanism();
    }
}
