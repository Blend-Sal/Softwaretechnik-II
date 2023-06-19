package com.example.softwaretechnik2;

import com.example.softwaretechnik2.controllers.QRCodeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QRCodeControllerTest {

    private QRCodeController qrCodeController;
    private Model model;

    @BeforeEach
    void setUp() {
        // Initialize QRCodeController and Model before each test
        qrCodeController = new QRCodeController();
        model = new BindingAwareModelMap();
    }

    @Test
    void testQRCodevalidlink() {
        // Test if a valid link generates a QR code and returns the correct view
        String validLink = "https://youtube.com/";
        String result = qrCodeController.getQRCode(validLink, model);
        assertEquals("qrCode", result);
        assertTrue(model.containsAttribute("qrCode"));
    }

    @Test
    void testQRCodeinvalidLink() {
        // Test if an invalid link returns an error view and does not contain a QR code attribute
        String invalidLink = "InvalidLink";
        String result = qrCodeController.getQRCode(invalidLink, model);
        assertEquals("error2", result);
        assertFalse(model.containsAttribute("qrCode"));
    }

    @Test
    void testQRCodeemptyLink() {
        // Test if an empty link returns an error view and does not contain a QR code attribute
        String emptyLink = "";
        String result = qrCodeController.getQRCode(emptyLink, model);
        assertEquals("error2", result);
        assertFalse(model.containsAttribute("qrCode"));
    }
}


