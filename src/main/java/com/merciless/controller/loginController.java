package com.merciless.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if(!StringUtils.isEmpty(username) && password.equals("123456")) {
            session.setAttribute("loginuser", username);
            return "redirect:/main.html";
        }
        else
            model.addAttribute("msg", "密码错误");
            return "index";
    }
}
