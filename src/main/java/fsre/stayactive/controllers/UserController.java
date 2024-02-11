package fsre.stayactive.controllers;

import fsre.stayactive.models.Role;
import fsre.stayactive.models.User;
import fsre.stayactive.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login"; // Return the login form template
    }



    @GetMapping("user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Add an empty user object to the model
        return "user/register"; // Return the registration form template
    }

    @PostMapping("user/register")
    public String processRegistration(@Valid User user, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors){
            model.addAttribute("user", user);
            return "user/register";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passwordEncoded = encoder.encode(user.getLozinka());
            user.setLozinka(passwordEncoded);
            user.setPotvrdaLozinke(passwordEncoded);
            user.setRole(Role.KORISNIK);
            userRepository.save(user);
            return "redirect:/user/login";
        }
    }
}