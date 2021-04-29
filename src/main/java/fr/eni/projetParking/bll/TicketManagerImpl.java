package fr.eni.projetParking.bll;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.dal.TicketDAO;

@Service
public class TicketManagerImpl implements TicketManager {

	@Autowired
	TicketDAO ticketDao; 
	
	
	@Override
	@Transactional
	public void createTicket(Ticket ticket) {
		ticket.setHeureArrivee(LocalDateTime.now());
		ticketDao.save(ticket);
	}

	@Override
	@Transactional
	public void removeTicket(Ticket ticket) {
		ticketDao.delete(ticket);
	}

	@Override
	@Transactional
	public void updateTicket(Ticket ticket) {
		ticketDao.save(ticket);
	}

	/**
	 * Retourne un ticket par son id ou null
	 */
	@Override
	public Ticket getById(Integer id) {
		return ticketDao.findById(id).orElse(null);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return (List<Ticket>) ticketDao.findAll();
	}

	@Override
	@Transactional
	public Float clotureTicket(Ticket ticket, LocalDateTime heureDepart) {
		//insertion de l'heure de départ dans le ticket
		ticket.setHeureDepart(heureDepart);
		//calcul du nombre d'heure restées dans le parking
		Duration dur = Duration.between(ticket.getHeureArrivee(), ticket.getHeureDepart());
		Float secondes = (float) dur.getSeconds();
		//conversion des secondes en heures
		Float heures = secondes/3600;
		//Toute heure commencée est comptée en totalité
		
		//calcul du prix du ticket 
		Float prixTicket = heures * ticket.getParking().getTarifHoraire();
		return prixTicket;
	}

}
