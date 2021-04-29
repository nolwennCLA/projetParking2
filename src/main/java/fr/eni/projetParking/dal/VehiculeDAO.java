package fr.eni.projetParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.projetParking.bo.Vehicule;

public interface VehiculeDAO extends CrudRepository<Vehicule, Integer> {

	void findVehiculeByImmat(String immat);

}
