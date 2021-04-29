package fr.eni.projetParking.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTicket;
	
	private LocalDate heureArrivee;
	private LocalDate heureDepart;
	private Float prixTicket;
	
	@ManyToOne
	private Parking parking;
	@ManyToOne
	private Vehicule vehicule;
	
	public Ticket(LocalDate heureArrivee, Parking parking, Vehicule vehicule) {
		super();
		this.heureArrivee = heureArrivee;
		this.parking = parking;
		this.vehicule = vehicule;
	}
	
	

}
