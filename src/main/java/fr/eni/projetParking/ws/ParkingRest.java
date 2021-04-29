package fr.eni.projetParking.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.projetParking.bll.ParkingManager;

@RestController
public class ParkingRest {
	
	@Autowired
	private ParkingManager managerParking;
	
//	@GetMapping("/WS/parkings")
//	public List<Parking>

}
