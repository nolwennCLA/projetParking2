package fr.eni.projetParking.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.projetParking.bll.VehiculeManager;
import fr.eni.projetParking.bo.Vehicule;

@RestController
public class VehiculeRest {
	
	@Autowired
	private VehiculeManager managerVehicule;
	
	@GetMapping("/WS/vehicule/{idParking}")
	public List<Vehicule> vehiculeParParking(@PathVariable Integer idParking){
		return managerVehicule.findVehiculeInParking( idParking);
	}

}
