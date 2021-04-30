package fr.eni.projetParking.bll;

import java.util.List;

import fr.eni.projetParking.bo.Vehicule;

public interface VehiculeManager {
	
	public void addVehicule(Vehicule vehicule);
	public void findVehiculeByImmat(String immat);
	public  List<Vehicule> findVehiculeInParking(Integer idParking);

}
