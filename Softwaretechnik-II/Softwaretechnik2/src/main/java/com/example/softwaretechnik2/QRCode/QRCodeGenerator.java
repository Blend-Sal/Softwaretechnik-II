package com.example.softwaretechnik2.QRCode;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;

public class QRCodeGenerator {

    public static String generateQRCode(@RequestParam String link, Model model) {

        ByteArrayOutputStream outputStream = QRCode.from(link).withSize(400, 400).to(ImageType.PNG).stream();
        String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());
        System.out.println(qrCodeBase64);
        model.addAttribute("qrCode", qrCodeBase64);
        return "qrCode";
    }
}
