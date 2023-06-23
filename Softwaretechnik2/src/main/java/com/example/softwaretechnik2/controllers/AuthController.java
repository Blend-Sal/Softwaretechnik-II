package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Lob;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import java.io.File;
import java.io.IOException;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@AllArgsConstructor
@Controller
public class AuthController {

    // Autowired UserService for user-related operations
    @Autowired
    private UserService userService;

    // GET mapping for the login page
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // GET mapping for the login error page
    @GetMapping("/login-error")
    public String loginerror(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("loginError", "Passwort oder E-Mail Adresse ungültig");
        return "login";
    }

    // GET mapping for the start page
    @GetMapping("start")
    public String start() {
        return "start";
    }

    // GET mapping for the registration form
    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // POST mapping for saving the registration data
    @NotNull
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User user,
                               BindingResult result, HttpServletRequest request,
                               Model model) {
        String email = user.getEmail();
        String password = user.getPassword();
        String confirmedPassword = user.getConfirmedPassword();
        User existing = userService.findByEmail(email);

        // Check if the email is already registered
        if (existing != null) {
            result.rejectValue("email", null, "bereits registriert!");
        }

        // Check if the passwords match
        if (!password.equals(confirmedPassword)) {
            result.rejectValue("password", null, "Passwörter stimmen nicht überein");
        }

        // If there are any errors, return to the registration form
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        // Save the user and log in
        userService.saveUser(user);
        try {
            request.login(email, password);
        } catch (ServletException e) {
            LOGGER.error("Error while login ", e);
        }

        // Redirect to the login page
        return "redirect:/login";
    }

    // url for accessing the asta-shop logo
    @GetMapping("/logo")
    public ResponseEntity<Resource> getImage() throws IOException {
        Resource imageResource = new ClassPathResource("static/AStA-Logo.jpg");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(imageResource);
    }
}
