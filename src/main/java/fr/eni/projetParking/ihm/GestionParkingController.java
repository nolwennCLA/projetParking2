package fr.eni.projetParking.ihm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.projetParking.bll.ParkingManager;
import fr.eni.projetParking.bll.TicketManager;
import fr.eni.projetParking.bll.VehiculeManager;
import fr.eni.projetParking.bo.Parking;
import fr.eni.projetParking.bo.Ticket;
import fr.eni.projetParking.bo.Vehicule;

@Controller
public class GestionParkingController {

	
	@Autowired
	VehiculeManager managerVehicule;
	
	@Autowired
	ParkingManager managerParking;
	
	@Autowired
	TicketManager managerTicket;
	
	// page d'accueil qui permet de saisir l'immat à l'arrivée du vehicule
	@GetMapping("/vehicule/saisieImmat")
	public String entreImmat(Vehicule vehicule) {
		return "saisieImmat";
	}
	
	// verification de l'existance de l'immat
	@PostMapping("/vehicule/verifImmat")
	public String verifImmat(@Valid Vehicule vehicule, Model model) {
		List<Vehicule>listVehicule = managerVehicule.findAll();
		System.out.println(listVehicule);
		for (Vehicule v : listVehicule) {
			System.out.println(v);
			if (vehicule.getImmat().equals(v.getImmat())) {
				
				Vehicule voit = managerVehicule.findVehiculeByImmat(vehicule.getImmat());
				Integer id= voit.getIdVehicule();
				return "redirect:/vehicule/choixParking/"+id; // pour passer l'id récuperé dans cette mathode à la redirection
			} 
		}
		return "creerVehicule";
	}
	
	//creation du vehicule
	@PostMapping("/vehicule/addVehicule")
	public String addVehicule(@Valid Vehicule vehicule, BindingResult result, Model model ) {
		if (result.hasErrors()) {
			return "creerVehicule";
		}
		managerVehicule.addVehicule(vehicule);
		Integer id= vehicule.getIdVehicule();
		return "redirect:/vehicule/choixParking"+id;	
	}
	
	@GetMapping("/vehicule/choixParking/{id}")
	public String detailVehicule(@PathVariable("id")Integer id, Model model) {
		Vehicule v = managerVehicule.findById(id);
		model.addAttribute("vehicule",v);
		
		List<Parking>listParking = managerParking.getAll();
		model.addAttribute("listParking", listParking);
		
		return "choixParking";
	}
	
	@GetMapping("/parking/creation")
	public String saisieParking(Parking parking) {
		return "addParking";
	}
	
	@PostMapping("/parking/add")
	public String addParking(@Valid Parking parking, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addParking";
		}
		managerParking.addParking(parking);
		return "redirect:/vehicule/saisieImmat";
	}
	
	@GetMapping("/ticket/creation/{idVehicule}/{idParking}")
	public String creerTicket(@PathVariable("idVehicule")Integer idVehicule, @PathVariable("idParking")Integer idParking) {
		Parking p = managerParking.getById(idParking);
		Vehicule v = managerVehicule.findById(idParking);
		Ticket ticket = new Ticket(p, v);
		managerTicket.createTicket(ticket);
		return "redirect:/vehicule/saisieImmat";
		
	}
	
	
	
	
}
