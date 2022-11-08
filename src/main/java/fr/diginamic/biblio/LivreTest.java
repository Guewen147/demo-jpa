package fr.diginamic.biblio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LivreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("bibliotheque");
		EntityManager em2 = emf2.createEntityManager();
	
		EntityTransaction transaction = em2.getTransaction();
		
		transaction.begin();
		
		Livre livre=em2.find(Livre.class,1);
		if(livre !=null) {
			System.out.println(livre);
			
		}
		for(Emprunt emp: livre.getEmprunts()) {
			System.out.println(emp);
		}	
	}

}
