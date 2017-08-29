package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String processAddCheese(@ModelAttribute Cheese newCheese){
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
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        // return something
        Cheese editCheese = CheeseData.getById(cheeseId);
        model.addAttribute(editCheese);
        model.addAttribute("title", "Edit Cheese: " + editCheese.getName() + " (id=" + editCheese.getCheeseId() + ")" );
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description){
        Cheese editCheese = CheeseData.getById(cheeseId);
        editCheese.setName(name);
        editCheese.setDescription(description);
        return "redirect:";
    }
}
