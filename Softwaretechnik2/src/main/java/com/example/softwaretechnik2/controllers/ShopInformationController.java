package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.ShopInformation;
import com.example.softwaretechnik2.repositories.ShopInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShopInformationController {

    // Autowired ShopInfoRepository for shop information-related operations
    @Autowired
    ShopInfoRepository repo;

    // GET mapping for the shop information form
    @GetMapping("/shopinformation")
    public String showShopInformationForm(Model model) {
        ShopInformation info = repo.findShopInformationByName("AStA-Shop");
        ShopInformation shopInformation = new ShopInformation();

        // Add the existing shop information or a new one to the model
        model = info == null ? model.addAttribute("ShopInformation", shopInformation)
                : model.addAttribute("ShopInformation", info);

        // Add the "editing" attribute to the model if it's not present
        if (!model.containsAttribute("editing")) {
            model.addAttribute("editing", false);
        }

        return "shopinformation";
    }

    // POST mapping for updating shop information
    @PostMapping("/shopinformation")
    public String postShopInformation(@ModelAttribute ShopInformation newShopInfo,
                                      @RequestParam("editing") boolean editing,
                                      RedirectAttributes redirectAttributes) {
        // Delete the existing shop information and save the new one
        repo.deleteShopInformationByName("AStA-Shop");
        repo.save(newShopInfo);

        // Set the "editing" attribute to false
        editing = false;
        redirectAttributes.addFlashAttribute("editing", editing);
        return "redirect:/shopinformation";
    }

    // POST mapping for enabling editing of shop information
    @PostMapping("/shopinformation/edit")
    public String editShopInformation(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("editing", true);
        return "redirect:/shopinformation";
    }
}
