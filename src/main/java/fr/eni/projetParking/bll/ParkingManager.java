package fr.eni.projetParking.bll;

import java.util.List;

import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Vehicule;

public interface ParkingManager {
	
	public void addParking(Parking parking);
	public void updateParking(Parking parking);
	public void deleteParking (Parking parking);
	public Parking getById(Integer idParking);
	public List<Parking> getAll();
	public Float getChiffreAffaire(Parking parking);
	public void addVehiculeInParking(Vehicule vehicule, Parking parking)throws ParkingExceptionBLL;

}
