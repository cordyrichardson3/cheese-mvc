package com.richardson.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cheese")
public class CheeseController {
    /*
    route definitions:
    add: cheese/add
    remove: cheese/remove
    index: ""
     */

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }


}
