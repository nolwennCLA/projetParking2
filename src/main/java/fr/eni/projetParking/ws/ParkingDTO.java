package fr.eni.projetParking.ws;

import fr.eni.projetParking.bo.Parking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingDTO {
	
	private Parking parking;
	private Integer chiffreAffaire;
	
	public ParkingDTO(Parking parking, Integer chiffreAffaire) {
		super();
		this.parking = parking;
		this.chiffreAffaire = chiffreAffaire;
	}
	
	

}
