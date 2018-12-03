package com.richardson.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {
    /*
    route definitions:
    add: cheese/add
    remove: cheese/remove
    index: ""
     */

    ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheesename) {
        cheeses.add(cheesename);
        return "redirect:";

    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String removeCheese(Model model){
        model.addAttribute("title", "Remove A Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheesename){
        cheeses.remove(cheesename);
        return "redirect:";
    }




}
