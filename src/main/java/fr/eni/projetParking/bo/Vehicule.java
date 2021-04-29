package fr.eni.projetParking.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehicule;
	
	private String marque;
	private String modele;
	private String immat;
	
	public Vehicule(String marque, String modele, String immat) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.immat = immat;
	}
	

	
}
