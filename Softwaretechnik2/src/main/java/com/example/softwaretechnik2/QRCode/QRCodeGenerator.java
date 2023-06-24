package com.example.softwaretechnik2.QRCode;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;

public class QRCodeGenerator {

    // Method for generating a QR code from a given link
    public static String generateQRCode(@RequestParam String link, Model model) {

        // Generate a QR code with a size of 400x400 pixels and output it as a PNG image
        ByteArrayOutputStream outputStream = QRCode.from(link).withSize(400, 400).to(ImageType.PNG).stream();

        // Encode the QR code image as a Base64 string
        String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());

        // Add the Base64-encoded QR code to the model
        model.addAttribute("qrCode", qrCodeBase64);

        // Return the QR code view
        return "qrCode";
    }
}


