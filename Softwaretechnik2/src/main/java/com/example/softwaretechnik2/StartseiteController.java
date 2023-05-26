package com.example.softwaretechnik2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartseiteController {



    @GetMapping("/start")
    public String startseite() {
        return "start";
    }
}
