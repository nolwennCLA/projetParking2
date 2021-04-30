package fr.eni.projetParking.ws;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingDTO {
	
	private String adresseParking;
	private Float chiffreAffaire;
	

	public ParkingDTO(String adresseParking, Float chiffreAffaire) {
		super();
		this.adresseParking = adresseParking;
		this.chiffreAffaire = chiffreAffaire;
	}
	
	

}
