package com.pablo.mvc.burgertracker.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pablo.mvc.burgertracker.models.Burger;

@Repository // connection to database

public interface BurgerRepository extends CrudRepository<Burger, Long> {
    // this method retrieves all the burgers from the database
        @Override
        List<Burger> findAll();




//    // this method finds burgers with descriptions containing the search string
//        List<Burger> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//        Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//        Long deleteByTitleStartingWith(String search);

}

