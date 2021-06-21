package com.merciless.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class logoutController {

    @GetMapping("/signout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
