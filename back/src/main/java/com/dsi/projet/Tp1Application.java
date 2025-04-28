package com.dsi.projet;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsi.projet.controllers.CarController;
import com.dsi.projet.controllers.ConductorController;
import com.dsi.projet.controllers.TrajetController;
import com.dsi.projet.entities.Car;
import com.dsi.projet.entities.Conductor;
import com.dsi.projet.entities.Trajet;


@Transactional
@SpringBootApplication
public class Tp1Application implements CommandLineRunner {
	@Autowired
	private CarController carController;

	@Autowired
	private ConductorController conductorController;

	@Autowired
	private TrajetController trajetController;


	
	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Car c = new Car("aze","bmw",LocalDate.of(2004,4,1),6);
		carController.createCar(c);
		Conductor cd = new Conductor("azert","azert","azert@gmail.com",999999,4,c);
		conductorController.createConductor(cd);
		Trajet t = new Trajet("azert","azert","azert",LocalDate.of(2025, 10, 10),4);
		trajetController.createTrajet(t);
		conductorController.addTrajetToConductor(cd.getId(),t.getId());
	}



}
