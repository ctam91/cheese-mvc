package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses" );
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(@RequestParam String cheeseName, @RequestParam String cheeseDescription){

        if(!cheeseName.equals("") & isAlpha(cheeseName)){
            Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
            CheeseData.add(newCheese);
            // Redirect to /cheese
            return "redirect:";
        } else{
            return "redirect:/cheese/add";
        }

    }

    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String displayDeleteForm(Model model){
        model.addAttribute("title", "Delete Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheese(@RequestParam int [] cheeseIds){
        for (int cheeseID : cheeseIds){
            CheeseData.remove(cheeseID);
        }
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
