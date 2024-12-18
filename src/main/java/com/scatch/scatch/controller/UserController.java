package com.scatch.scatch.controller;

import com.scatch.scatch.model.UserModel;
import com.scatch.scatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserModel user) {

        UserModel userExists = userService.findByEmail(user.getEmail());
        if(userExists != null){
//            System.out.println("User with this email already exists plz login.");
            return "redirect:/?alreadyExists";
        }

        userService.addUser(user);
        return "redirect:/?success";
    }
}
