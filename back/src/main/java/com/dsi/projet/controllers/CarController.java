package com.dsi.projet.controllers;

import com.dsi.projet.entities.Car;
import com.dsi.projet.services.CarService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable String id) {
        Optional<Car> car = carService.findById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable String id, @RequestBody Car carDetails) {
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()) {
            Car updatedCar = car.get();
            updatedCar.setMarque(carDetails.getMarque());
            updatedCar.setAnnee(carDetails.getAnnee());
            updatedCar.setNbPlaces(carDetails.getNbPlaces());
            return ResponseEntity.ok(carService.save(updatedCar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}