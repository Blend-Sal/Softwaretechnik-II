package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.ShopInformation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShopInformationTest extends ShopInformation {


    @Test
    void setStreet() {
        ShopInformation street = new ShopInformation();
        String streetTest = "Schanzenbarg 29";
        assertTrue(street.setStreet(streetTest));
    }

    @Test
    void setCity() {
        ShopInformation city = new ShopInformation();
        String cityTest = "Bad Oldesloe";
        assertTrue(city.setCity(cityTest));

    }

    @Test
    void setBuilding() {
        ShopInformation building = new ShopInformation();
        int buildingnum = 25;
        assertTrue(building.setBuilding(buildingnum));
    }

    @Test
    void setEmail() {
        ShopInformation email = new ShopInformation();
        String emailTest = "test@gmail.com";
        assertTrue(email.setEmail(emailTest));
    }

    @Test
    void setPhone() {
        ShopInformation mobile = new ShopInformation();
        String mobileTest = "04531 801688";
        assertFalse(mobile.setPhone(mobileTest));
    }

    @Test
    void setOpenhours() {
        ShopInformation openHours = new ShopInformation();
        String openHoursTest = "07:00 - 12:00";
        assertTrue(openHours.setOpenHours(openHoursTest));
    }

    @Test
    void setName() {
        ShopInformation name = new ShopInformation();
        String nameTest = "Lukas";
        assertTrue(name.setName(nameTest)


        );
    }

    @Test
    void getStreetTest() {
        ShopInformation street = new ShopInformation();
        String streetTest = "Schanzenbarg 12";
        street.setStreet(streetTest);
        assertEquals(streetTest, street.getStreet());
    }

    @Test
    void getCityTest() {
        ShopInformation city = new ShopInformation();
        String cityTest = "Bad Oldesloe";
        city.setCity(cityTest);
        assertEquals(cityTest, city.getCity());
    }

    @Test
    void getBuildingTest() {
        ShopInformation building = new ShopInformation();
        int buildingTest = 10;
        building.setBuilding(buildingTest);
        assertEquals(buildingTest, building.getBuilding());
    }

    @Test
    void getEmailTest() {
        ShopInformation email = new ShopInformation();
        String emailTest = "test@gmail.com";
        email.setEmail(emailTest);
        assertEquals(emailTest, email.getEmail());
    }

    @Test
    void getPhoneTest() {
        ShopInformation phone = new ShopInformation();
        String phoneTest = "+49 451 300 - 5116";
        phone.setPhone(phoneTest);
        assertEquals(phoneTest, phone.getPhone());
    }

    @Test
    void getOpenHoursTest() {
        ShopInformation openHours = new ShopInformation();
        String openHoursTest = "10:00 - 20:00";
        openHours.setOpenHours(openHoursTest);
        assertEquals(openHoursTest, openHours.getOpenHours());
    }

    @Test
    void getNameTest() {
        ShopInformation name = new ShopInformation();
        String nameTest = "Igor";
        name.setName(nameTest);
        assertEquals(nameTest, name.getName());
    }

}
