package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeseDao.findAll());
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
        cheeseDao.save(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String displayDeleteForm(Model model){
        model.addAttribute("title", "Delete Cheese");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheese(@RequestParam int [] cheeseIds){
        for (int cheeseID : cheeseIds){
            cheeseDao.delete(cheeseID);
        }
        return "redirect:";
    }

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable @Valid int cheeseId){
        // return something
        Cheese editCheese = cheeseDao.findOne(cheeseId);
        model.addAttribute(editCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("title", "Edit Cheese: " + editCheese.getName() + " (id=" + editCheese.getId() + ")" );
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(cheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("title", "Edit Cheese: " + cheese.getName() + " (id=" + cheese.getId()+ ")" );
            return "cheese/edit";
        }
        Cheese editCheese = cheeseDao.findOne(cheese.getId());
        editCheese.setName(cheese.getName());
        editCheese.setDescription(cheese.getDescription());
        editCheese.setRating(cheese.getRating());
        return "redirect:";
    }
}
