package com.pablo.mvc.burgertracker.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pablo.mvc.burgertracker.models.Burger;
import com.pablo.mvc.burgertracker.repositories.BurgerRepository;
import java.util.Optional;

@Service
public class BurgerService {
    @Autowired
    private BurgerRepository burgerRepository;
//    private final BurgerRepository burgerRepository;
//    public BurgerService(BurgerRepository burgerRepository) {
//        this.burgerRepository = burgerRepository;
//    }

    // returns all the burgers
        public List<Burger> allBurgers() {
            return burgerRepository.findAll();
        }
    // creates a burger
        public Burger createBurger(Burger b) {
            return burgerRepository.save(b);
        }
    // retrieves a burger
        public Burger findBurger(Long id) {
            Optional<Burger> optionalBurger = burgerRepository.findById(id);
            if(optionalBurger.isPresent()) {
                return optionalBurger.get();
            } else {
                return null;
            }
        }
    // this method will update the burger
        public Burger updateBurger(Burger updateBurger) {
            return burgerRepository.save(updateBurger);
        }
    public void deleteBurger(Long id) {
        Optional<Burger> deleteBurgerAction = burgerRepository.findById(id);
        if (deleteBurgerAction.isPresent()) {
            burgerRepository.deleteById(id);
        }
        else {
            System.out.println("Error, can't delete burger");
        }
    }
}
