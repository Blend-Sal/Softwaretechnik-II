package com.example.softwaretechnik2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @Autowired
    DemoRepo repo;

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public String demo() {
        repo.save(new Demo());
        System.out.println(demoService.generateRandString());
        return "demo";
    }
}