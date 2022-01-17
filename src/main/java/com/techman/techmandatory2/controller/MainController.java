package com.techman.techmandatory2.controller;



import com.techman.techmandatory2.model.User;
import com.techman.techmandatory2.repo.UserRepo;
import com.techman.techmandatory2.repo.OutsideUserRepo;
import com.techman.techmandatory2.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    OutsideUserRepo outsideUserRepo;

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }

    @GetMapping("/")
    public String showHome(Model model)
    {
        //get logged in user
        User user = securityUtil.getLoggedInUser();

//        List<Booking> bookings;

//        if (user.getRole().equals("ROLE_ADMIN") || user.getRole().equals("ROLE_SECRETARY"))
//        {
//            model.addAttribute("bookings", bookingRepo.findAll());
//        }
//        else
//        {
//            model.addAttribute("bookings", bookingRepo.findByUser(user));
//        }
        return "index";
    }

    @GetMapping("/signUp")
    public String showSignUp(Model model)
    {
        model.addAttribute("errorMessage", null);
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(Model model, @ModelAttribute("user") User user)
    {
        //check if username is taken
        if (userRepo.existsByUsername(user.getUsername())){
            model.addAttribute("user", user);
            model.addAttribute("errorMessage", "Email is already taken. Please user another email address.");
            return "signUp";
        }

        //encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //set role
        user.setRole("ROLE_USER");

        //save the user
        userRepo.save(user);

        return "redirect:/signUp?created";
    }


}