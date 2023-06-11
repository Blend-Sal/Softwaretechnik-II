package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.ShopInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopInformationController {
    private List<ShopInformation> shopInformationList = new ArrayList<>();

    @GetMapping("/shopinformation")
    public String showShopInformationForm(Model model) {
        ShopInformation shopInformation = new ShopInformation("", "", "", 0, "", 0, "");
        model.addAttribute("ShopInformation", shopInformation);
        return "shopinformation";
    }

    @PostMapping("/ShopInformation")
    public String saveShopInformation(@ModelAttribute ShopInformation shopInformation) {
        shopInformationList.add(shopInformation);

        return "redirect:/shopinformation";
    }
}


