package fr.eni.projetParking.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetParking.bo.Vehicule;
import fr.eni.projetParking.dal.VehiculeDAO;

@Service
public class VehiculeManagerImpl implements VehiculeManager {

	@Autowired
	VehiculeDAO daoVehicule;
	
	@Override
	public void addVehicule(Vehicule vehicule) {
		daoVehicule.save(vehicule);
	}

	@Override
	public void findVehiculeByImmat(String immat) {
		daoVehicule.findVehiculeByImmat(immat);
		
	}

}
