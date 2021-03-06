package fr.eni.projetParking.bll;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Vehicule findVehiculeByImmat(String immat) {
		return daoVehicule.findVehiculeByImmat(immat);
		
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

	@Override
	public List<Vehicule> findAll() {
		return (List<Vehicule>) daoVehicule.findAll();
	}

	@Override
	public Vehicule findById(Integer id) {
		return daoVehicule.findById(id).orElse(null);
	}


}
