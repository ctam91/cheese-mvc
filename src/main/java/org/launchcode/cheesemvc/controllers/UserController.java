package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Users" );
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @RequestMapping(value="userId={userId}", method = RequestMethod.GET)
    public String displayUser(Model model, @PathVariable int userId){
        // return something
        User user = UserData.getById(userId);
        model.addAttribute(user);
        return "user/userId";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser, Errors errors){

        if(errors.hasErrors()){
            model.addAttribute("title", "Sign Up");
            model.addAttribute(newUser);
            return "user/add";
        }
        UserData.add(newUser);
        model.addAttribute("welcome", "Welcome " + newUser.getUser() + "!");
        model.addAttribute("title", "Home");
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }
}
