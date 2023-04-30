package com.example.softwaretechnik2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QRCodeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/QR-Code")
    public String getQRCode(@RequestParam String link, Model model) throws IOException {
        ByteArrayOutputStream outputStream = QRCode.from(link).to(ImageType.PNG).stream();
        String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());
        model.addAttribute("qrCode", qrCodeBase64);
        return "qrCode";
    }

}