package fr.eni.projetParking.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.projetParking.bll.ParkingManager;
import fr.eni.projetParking.bo.Parking;

@RestController
public class ParkingRest {
	
	@Autowired
	private ParkingManager managerParking;
	
	@GetMapping("/WS/parkings")
	public List<ParkingDTO> parkingAvecCA(){
		List<ParkingDTO> lst = new ArrayList<ParkingDTO>();
		List<Parking>lstParking = managerParking.getAll();
		for (Parking p : lstParking) {
			ParkingDTO park = new ParkingDTO(p.getAdresse(),managerParking.getChiffreAffaire(p) );
			lst.add(park);
		}
		
		return lst;
	}
	

}
