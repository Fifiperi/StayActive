package fsre.stayactive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkoutController {

    @GetMapping("/user/gender")
    public String showGender(){
        return "user/gender";
    }
}
