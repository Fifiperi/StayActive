package fsre.stayactive.controllers;

<<<<<<< HEAD
import fsre.stayactive.models.Workout;
import fsre.stayactive.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
<<<<<<< HEAD
>>>>>>> a7064fb (poruka)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping("/user/gender")
    public String showGender(){
        return "user/gender";
=======
import fsre.stayactive.models.User;
import fsre.stayactive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkoutController {
@Autowired
UserRepository userRepository;
    @GetMapping("/User")
    public String listUsers (Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("User", users);
        return "User/index";
>>>>>>> 8be0287 (poruka)
    }

    @GetMapping("/user/female")
    public String showFemale(Model model){
        List<Workout> sveVjezbe = workoutRepository.findAll();
        Collections.shuffle(sveVjezbe);
        List<Workout> vjezbe = sveVjezbe.subList(0, 6);
        System.out.println(vjezbe.get(0).toString());
        model.addAttribute("vjezbe", vjezbe);
        return "user/female";
    }

}


