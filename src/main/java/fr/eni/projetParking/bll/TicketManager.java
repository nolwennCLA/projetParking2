package fr.eni.projetParking.bll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;

/**
 * CRUD de Ticket
 * @author cdenis2
 *
 */
public interface TicketManager {
	
	/**
	 * Création du ticket
	 * @param ticket
	 */
	public void createTicket(Ticket ticket);
	
	/**
	 * Suppression d'un ticket
	 * @param ticket
	 */
	public void removeTicket(Ticket ticket);
	
	/**
	 * Mise à jour d'un ticket
	 * @param ticket
	 */
	public void updateTicket(Ticket ticket);
	
	/**
	 * Récupère le ticket par son id
	 * @param id
	 * @return
	 */
	public Ticket getById(Integer id);
	
	/**
	 * Récupération de tous les tickets
	 * @return
	 */
	public List<Ticket> getAllTicket();
	
	/**
	 * Clôture d'un ticket : génération de 
	 * - l'heure de départ du parking
	 * - calcul automatique du prix du ticket
	 * @param ticket
	 */
	public Float clotureTicket(Ticket ticket, LocalDateTime heureDepart);

	/**
	 * Web Service : recherche de la liste des tickets d'un véhicule par son immat
	 * @param immat
	 * @return
	 */
	public List<Ticket> getListTicketByVehicule(String immat);

}
