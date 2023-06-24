package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.ShopInformation;
import com.example.softwaretechnik2.repositories.ShopInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShopInformationTest {

    @Autowired
    private ShopInfoRepository shopInfoRepository;

    @Test
    public void testFindShopInformationByName() {
        ShopInformation shopInfo = new ShopInformation();
        shopInfo.setName("Test Shop");
        shopInfoRepository.save(shopInfo);

        ShopInformation foundShopInfo = shopInfoRepository.findShopInformationByName("Test Shop");
        assertNotNull(foundShopInfo);
        assertEquals("Test Shop", foundShopInfo.getName());
    }

    @Test
    public void testDeleteShopInformationByName() {
        ShopInformation shopInfo = new ShopInformation();
        shopInfo.setName("Test Shop");
        shopInfoRepository.save(shopInfo);

        shopInfoRepository.deleteShopInformationByName("Test Shop");
        ShopInformation foundShopInfo = shopInfoRepository.findShopInformationByName("Test Shop");
        assertNull(foundShopInfo);
    }

    // Test if the ShopInformation's street can be set and retrieved correctly
    @Test
    void setAndGetStreetTest() {
        ShopInformation street = new ShopInformation();
        String streetTest = "Schanzenbarg 29";
        street.setStreet(streetTest);
        assertEquals(streetTest, street.getStreet());
    }

    // Test if the ShopInformation's city can be set and retrieved correctly
    @Test
    void setAndGetCityTest() {
        ShopInformation city = new ShopInformation();
        String cityTest = "Bad Oldesloe";
        city.setCity(cityTest);
        assertEquals(cityTest, city.getCity());
    }

    // Test if the ShopInformation's building number can be set and retrieved correctly
    @Test
    void setAndGetBuildingTest() {
        ShopInformation building = new ShopInformation();
        int buildingnum = 25;
        building.setBuilding(buildingnum);
        assertEquals(buildingnum, building.getBuilding());
    }

    // Test if the ShopInformation's email can be set and retrieved correctly
    @Test
    void setAndGetEmailTest() {
        ShopInformation email = new ShopInformation();
        String emailTest = "test@gmail.com";
        email.setEmail(emailTest);
        assertEquals(emailTest, email.getEmail());
    }

    // Test if the ShopInformation's phone can be set and retrieved correctly
    @Test
    void setAndGetPhoneTest() {
        ShopInformation mobile = new ShopInformation();
        String mobileTest = "+49 451 300 - 5116";
        mobile.setPhone(mobileTest);
        assertEquals(mobileTest, mobile.getPhone());
    }

    // Test if the ShopInformation's open hours can be set and retrieved correctly
    @Test
    void setAndGetOpenhoursTest() {
        ShopInformation openHours = new ShopInformation();
        String openHoursTest = "07:00 - 12:00";
        openHours.setOpenHours(openHoursTest);
        assertEquals(openHoursTest, openHours.getOpenHours());
    }

    // Test if the ShopInformation's name can be set and retrieved correctly
    @Test
    void setAndGetNameTest() {
        ShopInformation name = new ShopInformation();
        String nameTest = "Lukas";
        name.setName(nameTest);
        assertEquals(nameTest, name.getName());
    }

    // Test if the ShopInformation's toString method returns the correct output
    @Test
    void toStringTest() {
        ShopInformation shopInformation = new ShopInformation();
        shopInformation.setName("ASTaShop-Lübeck");
        shopInformation.setStreet("Segebergerstraße 18");
        shopInformation.setCity("Bad Oldesloe");
        shopInformation.setBuilding(4);
        shopInformation.setEmail("blend.salihu@stud.th-luebeck.de");
        shopInformation.setPhone("+49 174 532 - 1234");
        shopInformation.setOpenHours("08:00 - 16:00");

        String output = "ShopInformation{" + "name='" + shopInformation.getName() + '\''
                + ", street='" + shopInformation.getStreet() + '\''
                + ", city='" + shopInformation.getCity() + '\''
                + ", building=" + shopInformation.getBuilding()
                + ", email='" + shopInformation.getEmail() + '\''
                + ", phone='" + shopInformation.getPhone() + '\''
                + ", openHours='" + shopInformation.getOpenHours() + '\''
                + '}';

        assertEquals(shopInformation.toString(), output);

    }


}


