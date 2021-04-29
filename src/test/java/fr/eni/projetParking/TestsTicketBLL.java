package fr.eni.projetParking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.projetParking.bll.TicketManager;

@SpringBootTest
class TestsTicketBLL {
	
	@Autowired
	TicketManager ticketManager;
	
	private Float secondes = 856236f;
	private int heures = Math.round(secondes/3600);
	private Float heures2 = secondes/3600;

	

	@Test
	void contextLoads() {
		System.out.println(heures);
		System.out.println(heures2);
	}

}
