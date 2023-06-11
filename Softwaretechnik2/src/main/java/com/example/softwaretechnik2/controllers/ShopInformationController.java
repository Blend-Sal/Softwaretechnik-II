package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.ShopInformation;
import com.example.softwaretechnik2.repositories.ShopInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopInformationController {

    @Autowired
    ShopInfoRepository repo;

    @GetMapping("/shopinformation")
    public String showShopInformationForm(Model model) {
        ShopInformation info = repo.findShopInformationByName("AStA-Shop");
        ShopInformation shopInformation = new ShopInformation();
        model = info == null ? model.addAttribute("ShopInformation", shopInformation)
                : model.addAttribute("ShopInformation", info);
        if (!model.containsAttribute("editing")) {
            model.addAttribute("editing", false);
        }
        return "shopinformation";
    }

    //putmapping mit update ist sinnvoller
    @PostMapping("/shopinformation")
    public String postShopInformation(@ModelAttribute ShopInformation newShopInfo, @RequestParam("editing") boolean editing, RedirectAttributes redirectAttributes) {
        repo.deleteShopInformationByName("AStA-Shop");
        repo.save(newShopInfo);
        editing = false;
        redirectAttributes.addFlashAttribute("editing", editing);
        return "redirect:/shopinformation";
    }

    @PostMapping("/shopinformation/edit")
    public String editShopInformation(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("editing", true);
        return "redirect:/shopinformation";
    }
}