package com.example.softwaretechnik2;

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
    public void setUp() {
        qrCodeController = new QRCodeController();
        model = new BindingAwareModelMap();
    }

    @Test
    public void testQRCodevalidlink() {
        String validLink = "https://youtube.com/";
        String result = qrCodeController.getQRCode(validLink, model);
        assertEquals("qrCode", result);
        assertTrue(model.containsAttribute("qrCode"));
    }

    @Test
    public void testQRCodeinvalidLink() {
        String invalidLink = "InvalidLink";
        String result = qrCodeController.getQRCode(invalidLink, model);
        assertEquals("error2", result);
        assertFalse(model.containsAttribute("qrCode"));
    }

    @Test
    public void testQRCodeemptyLink() {
        String emptyLink = "";
        String result = qrCodeController.getQRCode(emptyLink, model);
        assertEquals("error2", result);
        assertFalse(model.containsAttribute("qrCode"));
    }

    @Test
    public void testQRCodenullLink() {
        String nullLink = null;
        String result = qrCodeController.getQRCode(nullLink, model);
        assertEquals("error2", result);
        assertFalse(model.containsAttribute("qrCode"));
    }

}