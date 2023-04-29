package com.example.softwaretechnik2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Controller
public class QRCodeController {

    @GetMapping("/QR-Code")
    public String getQRCode(Model model) throws IOException {
        String qrCodeString = "https://www.example.com/"; // replace with your QR code data
        ByteArrayOutputStream outputStream = QRCode.from(qrCodeString).to(ImageType.PNG).stream();
        String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());
        model.addAttribute("qrCode", qrCodeBase64);
        return "qrCode";
    }

}