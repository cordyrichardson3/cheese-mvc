package com.richardson.cheesemvc.controllers;

import com.richardson.cheesemvc.data.CheeseData;
import com.richardson.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {
    /*
    route definitions:
    add: cheese/add
    remove: cheese/remove
    index: ""
     */

    HashMap<String, String> cheeses = new HashMap<>();
    ArrayList<Cheese> cheeseList = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

/*    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheesename,
                                       @RequestParam String cheesedescription) {
        CheeseData.add(new Cheese(cheesename, cheesedescription));
        return "redirect:";

    }
*/

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String removeCheese(Model model){
        model.addAttribute("title", "Remove A Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int cheesename){
        CheeseData.remove(cheesename);
        return "redirect:";
    }




}
