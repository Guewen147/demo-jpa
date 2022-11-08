package fr.diginamic.regions;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertionVilleJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("recensement");
		EntityManager em1 = emf1.createEntityManager();

		EntityTransaction transaction1 = em1.getTransaction();
		
		transaction1.begin();
		
		
		Ville v1 = new Ville();
		v1.setNom("Quimper");
		v1.setCodePostal(29300);
		v1.setDateRecensement(new Date());
		v1.setCategorie(Categorie.MOYENNE);
		em1.persist(v1);
		
		Ville v2 = new Ville();
		v2.setNom("Quimperlé");
		v2.setCodePostal(29300);
		v2.setDateRecensement(new Date());
		v2.setCategorie(Categorie.PETITE);
		em1.persist(v2);
		
		
		
		transaction1.commit();
	}

}
