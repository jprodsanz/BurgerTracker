package com.pablo.mvc.burgertracker.controllers;
import com.pablo.mvc.burgertracker.models.Burger;
import com.pablo.mvc.burgertracker.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BurgerService burgerService;

    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
        // retrieves all burgers from DB
            List <Burger> burgers = burgerService.allBurgers();
        // stores list in model
            model.addAttribute("burgers", burgers);
            return "index.jsp";
    }
    @GetMapping("/burger/new")
    public String newBurger(@ModelAttribute("newBurger") Burger newBurger) {
        return "NewBurger.jsp";
    }

    @PostMapping("/burger/new")
    public String createBurger(@Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result, Model model)
    {
        if(result.hasErrors()){
            List<Burger> burgers = burgerService.allBurgers();
            model.addAttribute("burgers", burgers);
            return "NewBurger.jsp";
        }
        burgerService.createBurger(newBurger);
        return "redirect:/";
    }
}
