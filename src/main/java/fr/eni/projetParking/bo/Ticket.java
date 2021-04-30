package fr.eni.projetParking.bo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTicket;
	
	private LocalDateTime heureArrivee = LocalDateTime.now();
	private LocalDateTime heureDepart;
	private Float prixTicket;
	
	@ManyToOne
	@JsonManagedReference
	private Parking parking;
	
	@ManyToOne
	private Vehicule vehicule;
	
	public Ticket(Parking parking, Vehicule vehicule) {
		super();
		this.parking = parking;
		this.vehicule = vehicule;
	}
	
	

	
	

}
