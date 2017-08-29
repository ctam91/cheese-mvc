package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Users" );
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Sign Up");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("user", user.getUser());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("verify", verify);
        model.addAttribute("title", "Sign Up");
        if(verify.equals(user.getPassword())){
            model.addAttribute("welcome", "Welcome " + user.getUser() + "!");
            return "user/index";
        } else{
            return "user/add";
        }
    }
}
