package fr.eni.projetParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.projetParking.bo.Ticket;

public interface TicketDAO extends CrudRepository<Ticket, Integer>{

}
