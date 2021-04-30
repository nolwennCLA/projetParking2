package fr.eni.projetParking.ws;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.projetParking.bll.ParkingManager;
import fr.eni.projetParking.bll.TicketManager;
import fr.eni.projetParking.bll.VehiculeManager;
import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;

@RestController
public class TicketRest {

	 @Autowired
	 TicketManager ticketManager; 
	 
	 @Autowired
	 ParkingManager parkingManager; 
	 
	 @Autowired
	 VehiculeManager vehiculeManager; 
	 
	 private Parking p1 = new Parking("Quimper", 30, 5.5f);
	 private Parking p2 = new Parking("Combrit", 30, 4.6f);
	 
	 private Vehicule v1 = new Vehicule("Citroën", "Picasso", "AA-123-AA");
	 private Vehicule v2 = new Vehicule("Renault", "Clio", "BB-123-BB");
	 
	 private Ticket t1 = new Ticket(p1, v1);
	 private Ticket t2 = new Ticket(p2, v2);
	 
	 @PostConstruct
	 @Transactional
	 private void init() throws IOException {
		 Properties properties = new Properties();
		 properties.load(getClass().getResourceAsStream("/application.properties"));
		 if ("create".equals(properties.getProperty("spring.jpa.hibernate.ddl-auto"))) {
			 
			 //Création de parking
			 parkingManager.addParking(p1);
			 parkingManager.addParking(p2);
			 
			 //Création de véhicule
			 vehiculeManager.addVehicule(v1);
			 vehiculeManager.addVehicule(v2);
			 
			 //Création de ticket
			 ticketManager.createTicket(t1);
			 ticketManager.createTicket(t2);
			 
			}
	 }
	 
	 //liste des tickets
	 @GetMapping("WS/listeTickets/{immat}")
	 public List<Ticket> listTickets(@PathVariable String immat){
		 return ticketManager.getListTicketByVehicule(immat);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
