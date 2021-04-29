package fr.eni.projetParking.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Parking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParking;
	
	private String adresse;
	private Integer nbPlace;
	private Float tarifHoraire;
	
	@OneToMany (mappedBy = "parking")
	private List<Ticket>listTicket;
	
	public Parking(String adresse, Integer nbPlace, Float tarifHoraire) {
		super();
		this.adresse = adresse;
		this.nbPlace = nbPlace;
		this.tarifHoraire = tarifHoraire;
	}
	
	
	

}
