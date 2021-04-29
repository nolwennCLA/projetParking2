package fr.eni.projetParking;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.projetParking.bll.ParkingManager;
import fr.eni.projetParking.bll.TicketManager;
import fr.eni.projetParking.bll.VehiculeManager;
import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;

@SpringBootTest
class TestsTicketBLL {
	
	@Autowired
	TicketManager ticketManager;
	
	@Autowired
	ParkingManager parkingManager; 
	
	@Autowired
	VehiculeManager vehiculeManager; 
	
	private Vehicule v1 = new Vehicule("Citroën", "Picasso", "AA-123-AA");
	private Parking p1 = new Parking("Quimper", 50, 5.5f);
	private Ticket t1 = new Ticket(p1, v1);

	private Vehicule v2 = new Vehicule("Renault", "Clio", "BB-123-BB");
	private Parking p2 = new Parking("Combrit", 30, 4.6f);
	private Ticket t2 = new Ticket(p1, v1);
	

	@Test
	void contextLoads() {
		System.out.println(ticketManager.clotureTicket(t1, LocalDateTime.of(2021, 4, 29, 17, 30, 32)));

	}

}
