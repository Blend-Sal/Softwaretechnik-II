package com.example.softwaretechnik2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    ProduktRepository repo;

    @Autowired
    DemoService demoService;

    @GetMapping("/demo")
    public String demo() {
        //repo.save(new Demo());
        //System.out.println(demoService.generateRandString());
        return "demo";
    }
}