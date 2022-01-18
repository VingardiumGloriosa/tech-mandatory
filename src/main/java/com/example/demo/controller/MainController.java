package com.example.demo.controller;

import com.example.demo.model.Protocol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHome(Model model)
    {
        model.addAttribute("protocol", new Protocol());

        return "index";
    }

}
