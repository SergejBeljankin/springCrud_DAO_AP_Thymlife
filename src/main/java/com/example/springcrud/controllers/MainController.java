package com.example.springcrud.controllers;

import com.example.springcrud.entities.User;
import com.example.springcrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;

@RestController
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


//    @GetMapping("/")
//    public String homePage(){
//        return "home";
//    }
    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return  "Защищено от доступа <br>рады вас приветствовать: " + user.getUsername() + " " + user.getEmail();
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile(){
        return "read profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins(){
        return "admins page";
    }
}
