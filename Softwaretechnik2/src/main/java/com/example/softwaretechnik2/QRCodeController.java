package com.example.softwaretechnik2;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.regex.*;
import java.io.ByteArrayOutputStream;

@Controller
public class QRCodeController {

    String regex = "\\b(https?|ftp|file|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/QRCode")

    public String getQRCode(@RequestParam String link, Model model) {
        if (!link.matches(regex)) {
            return "error2";
        } else {
            ByteArrayOutputStream outputStream = QRCode.from(link).withSize(400, 400).to(ImageType.PNG).stream();
            String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());
            model.addAttribute("qrCode", qrCodeBase64);
            return "qrCode";
        }

    }
}