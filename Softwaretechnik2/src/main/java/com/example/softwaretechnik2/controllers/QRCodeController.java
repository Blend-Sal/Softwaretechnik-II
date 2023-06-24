package com.example.softwaretechnik2.controllers;


import com.example.softwaretechnik2.QRCode.QRCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QRCodeController extends QRCodeGenerator {

    // Regular expression to validate the input URL
    String regex = "\\b(https?|ftp|file|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    // GET mapping for the QR code input form
    @GetMapping("/qrcodeinput")
    public String qrcodeinput() {
        return "qrcodeinput";
    }

    // POST mapping for generating the QR code
    @PostMapping("/QRCode")
    public String getQRCode(@RequestParam String link, Model model) {
        // Validate the input URL using the regular expression
        if (!link.matches(regex)) {
            return "error2";
        } else {
            // Generate the QR code and return the result
            return generateQRCode(link, model);
        }
    }
}



