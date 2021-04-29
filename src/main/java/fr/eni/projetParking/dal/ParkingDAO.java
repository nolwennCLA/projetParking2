package fr.eni.projetParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.projetParking.bo.Parking;

public interface ParkingDAO extends CrudRepository<Parking, Integer> {

}
