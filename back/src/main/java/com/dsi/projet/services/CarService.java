package com.dsi.projet.services;

import com.dsi.projet.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {


    public List<Car> findAll();

    public Optional<Car> findById(String id) ;

    public Car save(Car car) ;

    public void deleteById(String id) ;
}