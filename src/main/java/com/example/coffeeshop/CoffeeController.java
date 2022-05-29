package com.example.coffeeshop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }
    @GetMapping
    List<Coffee> getCoffees() {
        return coffeeService.getAllCoffees();
    }
    @GetMapping("/{id}")
    ResponseEntity<Optional<Coffee>> getCoffeeById(@PathVariable Long id) {
        Optional<Coffee> c = coffeeService.getCoffeeById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    public ResponseEntity<Coffee> postNewCoffee(@RequestBody Coffee c) {
        Coffee newCoffee = coffeeService.addNewCoffees(c);
        return new ResponseEntity<>(newCoffee, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity<Optional<Coffee>> putCoffee(
            @PathVariable Long id,
            @RequestBody Coffee c) {
        Optional<Coffee> result = coffeeService.editCoffeeById(id, c);
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteCoffeeById(@PathVariable Long id) {
        if (coffeeService.removeCoffee(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }
}
