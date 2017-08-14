package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses" );
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(@RequestParam String cheeseName, @RequestParam String cheeseDescription){

        if(!cheeseName.equals("") & isAlpha(cheeseName)){
            cheeses.put(cheeseName, cheeseDescription);
            // Redirect to /cheese
        } return "redirect:";

    }

    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String displayDeleteForm(Model model){
        model.addAttribute("title", "Delete Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheese(@RequestParam ArrayList<String> cheeseNameDelete){
        for(String cheese : cheeseNameDelete){
            cheeses.remove(cheese);
        }
        // Redirect to /cheese
        return "redirect:";
    }

    public boolean isAlpha(String param){
        boolean isCharacter = true;
        for(Character c : param.toCharArray()){
            if(!c.isLetter(c)){
                isCharacter = false;
                break;
            }
        } return isCharacter;
    }
}
