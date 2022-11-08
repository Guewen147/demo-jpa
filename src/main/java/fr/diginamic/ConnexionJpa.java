package fr.diginamic;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.biblio.Livre;
import fr.diginamic.regions.Adresse;
import fr.diginamic.regions.Categorie;
import fr.diginamic.regions.Habitant;
import fr.diginamic.regions.Region;
import fr.diginamic.regions.Ville;


public class ConnexionJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");
		EntityManager em = entityManagerFactory.createEntityManager();
	
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		
	
		Region r= em.find(Region.class,1);
		if (r!= null){
			System.out.println(r);
		}
		
		Region r2 = new Region();
		r2.setId(3);
		r2.setNom("Bretagne");
		em.persist(r2);
		
		Region r3 = new Region();
		r3.setId(1);
		r3.setNom("Bouche du rhones");
		em.persist(r3);
		
		Ville v1 = new Ville();
		v1.setNom("Quimper");
		v1.setCodePostal(29300);
		v1.setDateRecensement(new Date());
		v1.setCategorie(Categorie.MOYENNE);
		v1.setRegion(r2);
		em.persist(v1);
		
		
//		Habitant h1 = new Habitant();
//		h1.setNom("ANZO");
//		h1.setPrenom("pasta");
//		em.persist(h1);
		
//		v1.getHabitant().add(h1);
		
		Adresse adresse = new Adresse();
		adresse.setNumero(12);
		adresse.setRue("Italien");
		adresse.setVille("Rome");
		
		Habitant h1 = new Habitant();
		h1.setNom("ANZO");
		h1.setPrenom("pasta");
		h1.setAdresse(adresse);
		em.persist(h1);
		
		
		
		transaction.commit();
		
//		EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("bibliotheque");
//		EntityManager em2 = entityManagerFactory2.createEntityManager();
//		EntityTransaction transaction2 = em2.getTransaction();
//		
//		transaction2.begin();
//		
//		Livre l= em2.find(Livre.class,1);
//		if (l!= null){
//			System.out.println(l);
//		}
//		
//		
//		transaction2.commit();
//		
	}

}
