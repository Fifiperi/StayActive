package fsre.stayactive.controllers;

import fsre.stayactive.models.User;
import fsre.stayactive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String lozinka) {
        // Process login logic using Spring Security for authentication
        // You may customize this part based on your authentication approach
        // For now, let's assume a simple check using UserRepository
        User user = userRepository.findByEmail(email);
        if (user != null && user.getLozinka().equals(lozinka)) {
            // Successful login, redirect to home page
            return "redirect:user/gender";
        } else {
            // Failed login, show an error (you may add an error message to the model)
            return "user/login";
        }
    }

    @GetMapping("user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Add an empty user object to the model
        return "user/register"; // Return the registration form template
    }

    @PostMapping("user/register")
    public String processRegistration(User user) {
        // Process registration logic (create user, store in the database, etc.)
        // You can use userRepository.save(user) here
        // For simplicity, let's assume no duplicate email check for now
        userRepository.save(user);

        // Redirect to login page after successful registration
        return "redirect:user/login";
    }
}