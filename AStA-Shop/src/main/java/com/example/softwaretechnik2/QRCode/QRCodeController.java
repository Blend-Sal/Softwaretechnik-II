package com.example.softwaretechnik2.QRCode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QRCodeController extends QRCodeGenerator {

    String regex = "\\b(https?|ftp|file|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/QRCode")

    public String getQRCode(@RequestParam String link, Model model) {
        if (!link.matches(regex)) {
            return "error2";
        } else {
            return generateQRCode(link, model);
        }

    }
}