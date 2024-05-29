package com.project.cybrary.user;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
        if (keyword.isBlank()){
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            return "allUsers";
        }
        List<User> users = userRepository.findUserByUsername(keyword);
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/allUsers")
    public String getAllUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model){
        User user = userRepository.findById(id)
                .orElseThrow(
                    ()-> new IllegalArgumentException("User not found")
                );
        model.addAttribute("user",user);
        return "getUser";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User()); // Add the "user" object to the model
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Save the user to the database or perform any necessary actions
        userRepository.save(user);

        // Add the "user" model attribute to the model
        model.addAttribute("user", user);

        // Redirect to the login page or any other desired view
        return "redirect:/users/login";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, User user, Model model){
        userRepository.save(user);
        model.addAttribute("user",user);
        return "getUser";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        User user = userRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("User not found")
                );
        userRepository.delete(user);
        return "redirect:/users/allUsers";
    }
}
