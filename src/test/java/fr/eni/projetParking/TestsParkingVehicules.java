package fr.eni.projetParking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.projetParking.bll.ParkingManager;
import fr.eni.projetParking.bll.VehiculeManager;
import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Vehicule;

@SpringBootTest
class TestsParkingVehicules {
	
	@Autowired
	ParkingManager managerParking;
	
	@Autowired
	VehiculeManager managerVehicule;

	@Test
	void contextLoads() {
		
		// je cree des données pour ma BDD
		
				Parking p1 = new Parking("rue du port", 15, 8.5f);
				Parking p2 = new Parking("rue du grand large", 30, 5f);
				Parking p3 = new Parking("rue des albatros", 2 , 6.5f);
				
				Vehicule v1= new Vehicule("Peugeot", "208", "123PE29");
				Vehicule v2= new Vehicule("Renault", "Clio", "123RE29");
				Vehicule v3= new Vehicule("Citroen", "Picasso", "123CI29");
				
				managerParking.addParking(p1);
				managerParking.addParking(p2);
				managerParking.addParking(p3);
				
				managerVehicule.addVehicule(v1);
				managerVehicule.addVehicule(v2);
				managerVehicule.addVehicule(v3);
				
			
		
		
		
	}

}
