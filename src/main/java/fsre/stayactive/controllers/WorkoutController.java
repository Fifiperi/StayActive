package fsre.stayactive.controllers;

import fsre.stayactive.models.Workout;
import fsre.stayactive.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
