package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        model.addAttribute("cheese", new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        // Redirect to /cheese
        return "redirect:";
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

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable @Valid int cheeseId){
        // return something
        Cheese editCheese = CheeseData.getById(cheeseId);
        model.addAttribute(editCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("title", "Edit Cheese: " + editCheese.getName() + " (id=" + editCheese.getCheeseId() + ")" );
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(cheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("title", "Edit Cheese: " + cheese.getName() + " (id=" + cheese.getCheeseId() + ")" );
            return "cheese/edit";
        }
        Cheese editCheese = CheeseData.getById(cheese.getCheeseId());
        editCheese.setName(cheese.getName());
        editCheese.setDescription(cheese.getDescription());
        editCheese.setRating(cheese.getRating());
        return "redirect:";
    }
}
