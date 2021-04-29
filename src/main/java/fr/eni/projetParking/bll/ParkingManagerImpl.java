package fr.eni.projetParking.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;
import fr.eni.projetParking.dal.ParkingDAO;

@Service
public class ParkingManagerImpl implements ParkingManager {
	
	@Autowired
	ParkingDAO daoParking;

	@Override
	public void addParking(Parking parking) {
		daoParking.save(parking);

	}

	@Override
	public void updateParking(Parking parking) {
		daoParking.save(parking);
	}

	@Override
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
		Float ca = null;
		for (Ticket t : listTicket) {
			ca+=t.getPrixTicket();
		}
		return ca;
	}

	@Override
	public void addVehiculeInParking(Vehicule vehicule, Parking parking) throws ParkingExceptionBLL {
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
		
		// s'il reste des places, je cree le ticket et je l'affecte au parking 
		if (nbPlacesRestantes > 0) {
			Ticket ticket = new Ticket();
			parking.getListTicket().add(ticket);
			daoParking.save(parking);
		}else {
			throw new ParkingExceptionBLL("Il n'y a plus de places dans ce parking");
		}
		
		
	}

}
