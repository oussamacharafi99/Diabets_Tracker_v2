package com.Diabetes.Controller;

import com.Diabetes.Models.Users.User;
import com.Diabetes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "list"; // Returns the HTML template for listing users
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User()); // Passes an empty User object to the form
        return "add"; // Returns the HTML form for adding a user
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user); // Calls the service method to save the user
        return "redirect:/users/"; // Redirects to the list of users after successful addition
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id); // Retrieves the user by ID
        model.addAttribute("user", user); // Passes the retrieved user to the form
        return "edit"; // Returns the HTML form for editing a user
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user); // Calls the service method to update the user
        return "redirect:/users"; // Redirects to the list of users after successful update
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Calls the service method to delete the user
        return "redirect:/users"; // Redirects to the list of users after successful deletion
    }
}
