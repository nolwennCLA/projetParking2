package fr.eni.projetParking.bll;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;
import fr.eni.projetParking.dal.ParkingDAO;
import fr.eni.projetParking.dal.TicketDAO;

@Service
public class ParkingManagerImpl implements ParkingManager {
	
	@Autowired
	ParkingDAO daoParking;
	
	@Autowired
	TicketManager managerTicket;
	
	@Autowired
	VehiculeManager managerVehicule;
	
	
	@PostConstruct
	@Transactional
	public void init() {
		// je cree des données pour ma BDD
		
		Parking p1 = new Parking("rue du port", 15, 8.5f);
		Parking p2 = new Parking("rue du grand large", 30, 5f);
		Parking p3 = new Parking("rue des albatros", 2 , 6.5f);
		
		Vehicule v1= new Vehicule("Peugeot", "208", "123PE29");
		Vehicule v2= new Vehicule("Renault", "Clio", "123RE29");
		Vehicule v3= new Vehicule("Citroen", "Picasso", "123CI29");
		
		this.addParking(p1);
		this.addParking(p2);
		this.addParking(p3);
		
		managerVehicule.addVehicule(v1);
		managerVehicule.addVehicule(v2);
		managerVehicule.addVehicule(v3);
		
		try {
			this.addVehiculeInParking(v1, p3);
			this.addVehiculeInParking(v1, p2);
			this.addVehiculeInParking(v1, p1);
		} catch (ParkingExceptionBLL e) {
			e.getMessage();
		}
		
		managerTicket.clotureTicket(managerTicket.getById(1), LocalDateTime.of(2021, 4, 30, 22, 30, 32));
		managerTicket.clotureTicket(managerTicket.getById(2), LocalDateTime.of(2021, 4, 30, 17, 30, 32));
		managerTicket.clotureTicket(managerTicket.getById(3), LocalDateTime.of(2021, 4, 30, 12, 30, 32));
		
	}

	@Override
	@Transactional
	public void addParking(Parking parking) {
		daoParking.save(parking);

	}

	@Override
	@Transactional
	public void updateParking(Parking parking) {
		daoParking.save(parking);
	}

	@Override
	@Transactional
	public void deleteParking(Parking parking) {
		daoParking.delete(parking);

	}

	@Override
	public Parking getById(Integer idParking) {
		return daoParking.findById(idParking).orElse(null);
	}

	@Override
	public List<Parking> getAll() {
		return (List<Parking>) daoParking.findAll();
	}

	@Override
	public Float getChiffreAffaire(Parking parking) {
		List<Ticket>listTicket= parking.getListTicket();
		Float ca = 0f;
		for (Ticket t : listTicket) {
			if (t.getPrixTicket()!=null) {
				ca+=t.getPrixTicket();
			}
			
		}
		return ca;
	}

	@Override
	@Transactional
	public void addVehiculeInParking(Vehicule vehicule, Parking parking) throws ParkingExceptionBLL {
		
		
//		if (parking.getListVehicules()==null) { // pour la 1ere voiture qui entre dans le parking
//			Ticket ticket = new Ticket();
//			ticket.setParking(parking);
//			ticket.setVehicule(vehicule);
//			managerTicket.createTicket(ticket);
//			parking.getListVehicules().add(vehicule);
//			parking.getListTicket().add(ticket);
//			daoParking.save(parking);
//		}else {
//			Integer nbplacesOccupees= parking.getListVehicules().size();
//			// s'il reste de la place 
//			if (nbplacesOccupees<parking.getNbPlace()) {
//				Ticket ticket = new Ticket();
//				ticket.setParking(parking);
//				ticket.setVehicule(vehicule);
//				managerTicket.createTicket(ticket);
//				parking.getListVehicules().add(vehicule);
//				parking.getListTicket().add(ticket);
//				daoParking.save(parking);
//			} else {
//				throw new ParkingExceptionBLL("Il n'y a plus de places dans ce parking");
//			}
//		}
		
		// si c'est la première voiture de ce parking
		if (parking.getListTicket().isEmpty()) {
			Ticket ticket = new Ticket();
			ticket.setParking(parking);
			ticket.setVehicule(vehicule);
			managerTicket.createTicket(ticket);
			parking.getListTicket().add(ticket);
			daoParking.save(parking);
		}else {
		List<Ticket>listTicket= parking.getListTicket();
		Integer nbplacesOccupees=null;
		// je verifie qu'il reste de la place dans le parking
		if (parking.getNbPlace()<=0) {
			
		}
		// pour chaque ticket de ce parking, compte les voitures présentes en verifiant si le prix du ticket a été généré ou non
		for (Ticket t : listTicket) {
			if (t.getPrixTicket()==0f) {
				nbplacesOccupees =+ 1; 
			}
		}
		Integer nbPlacesRestantes = parking.getNbPlace()- nbplacesOccupees;
		
		// s'il reste des places, je cree le ticket avec le parking et le vehicule) et je l'affecte au parking 
		if (nbPlacesRestantes > 0) {
			Ticket ticket = new Ticket();
			ticket.setParking(parking);
			ticket.setVehicule(vehicule);
			managerTicket.createTicket(ticket);
			parking.getListTicket().add(ticket);
			daoParking.save(parking);
		}else {
			throw new ParkingExceptionBLL("Il n'y a plus de places dans ce parking");
		}
		}
	}

}
