package fr.eni.projetParking.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.projetParking.bo.Ticket;

public interface TicketDAO extends CrudRepository<Ticket, Integer>{

	@Query("select t from Ticket t where t.vehicule.immat = :immat")
	List<Ticket> getListTicketByVehicule(@Param("immat") String immat);
	
	

}
