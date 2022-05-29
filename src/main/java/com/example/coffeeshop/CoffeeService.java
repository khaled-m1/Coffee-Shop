package com.example.coffeeshop;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
  private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }
    Optional<Coffee> getCoffeeById(Long id) {
        return coffeeRepository.findById(id);
    }
    Coffee addNewCoffees(Coffee c) {
        return coffeeRepository.save(c);
    }
    Optional<Coffee> editCoffeeById(Long id, Coffee c) {
        if (coffeeRepository.existsById(id)) {
            Coffee chosenCoffee = coffeeRepository.getById(id);
            chosenCoffee.setName(c.name);
            chosenCoffee.setPrice(c.price);
            return Optional.of(coffeeRepository.save(chosenCoffee));
        }
        return Optional.empty();
    }
    boolean removeCoffee(Long id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
