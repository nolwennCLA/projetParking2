package fr.eni.projetParking.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;

public interface VehiculeDAO extends CrudRepository<Vehicule, Integer> {

	Vehicule findVehiculeByImmat(String immat);

	@Query("SELECT t FROM Ticket t WHERE t.parking.idParking = :idParking AND t.prixTicket IS NULL ")
	List<Ticket> findVehiculeInParking(@Param("idParking") Integer idParking);

}
