package fr.eni.projetParking;

import org.springframework.stereotype.Component;

@Component // le component sera appellé dès le lancement de l'appli, cela va donc changer son contenu, ici les données à mettre en base
public class InitBDD {
	
	
//	@Autowired
//	ContactManager managerContact;
//	
//	@Autowired
//	CommentaireManager managerCommentaire;
//	
//	
//	@PostConstruct // cette methode s'execute après le constructeur, pour pouvoir avoir acces au manager, car l'autowired sera actif seulement après le constructeur
//	private void init() throws IOException, ContactManagerException {
//		
//		// je cree des données pour la BDD et tester mes WS
//			Pays france = new Pays("France","Paris");
//			Pays argentine = new Pays("Argentine","Buenos Aires");
//			
//			Ville ileTudy= new Ville("29980", "Ile Tudy", france);
//			Ville buenosAires = new Ville("123456", "Buenos Aires", argentine);
//			
//			Contact c1 = new Contact("Croc", "Odile", "0298878787", "rue des marais", "croc@croc.fr");
//			Contact c2 = new Contact("Croc", "Amandine", "0298878787", "rue des marais", "croc@croc.fr");
//			Contact c3 = new Contact("Brel", "Jacques", "0298878787", "rue des marquises", "brel@brel.fr");
//			
//			c1.setVille(ileTudy);
//			c2.setVille(ileTudy);
//			c3.setVille(buenosAires);
//			
//			managerContact.addContact(c1);
//			managerContact.addContact(c2);
//			managerContact.addContact(c3);
//			
//			// j'ajoute des commentaires
//			Commentaire com1= new Commentaire("C'est beau la vie");
//			Commentaire com2= new Commentaire("C'est la fete à la grenouille");
//			managerCommentaire.addCommentaire(com1, c1);
//			managerCommentaire.addCommentaire(com2, c1);
//			
			
//	}
	

}
