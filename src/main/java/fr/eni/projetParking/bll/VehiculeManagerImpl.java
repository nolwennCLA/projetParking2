package fr.eni.projetParking.bll;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;
import fr.eni.projetParking.dal.VehiculeDAO;

@Service
public class VehiculeManagerImpl implements VehiculeManager {

	@Autowired
	VehiculeDAO daoVehicule;
	
	@Override
	@Transactional
	public void addVehicule(Vehicule vehicule) {
		daoVehicule.save(vehicule);
	}

	@Override
	public void findVehiculeByImmat(String immat) {
		daoVehicule.findVehiculeByImmat(immat);
		
	}

	@Override
	public  List<Vehicule> findVehiculeInParking(Integer idParking) {
		List<Vehicule>lstVehicule = new ArrayList<Vehicule>();
		List<Ticket>lst = daoVehicule.findVehiculeInParking(idParking);
		for (Ticket t : lst) {
			lstVehicule.add(t.getVehicule());
		}
		return lstVehicule;
		
	}

}
