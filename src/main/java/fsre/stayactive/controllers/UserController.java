package fsre.stayactive.controllers;

import fsre.stayactive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(){

        return "user/login";
    }

}
