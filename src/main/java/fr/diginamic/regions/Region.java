package fr.diginamic.regions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="region")
public class Region {

	@Id
	private Integer id;
	
	@Column(name = "NOM", length = 20, nullable = false)
	private String nom;

	@OneToMany(mappedBy="region")
	private List<Ville> villes = new ArrayList<Ville>() ;

	/**
	 * @return the villes
	 */
	public List<Ville> getVilles() {
		return villes;
	}


	/**
	 * @param villes the villes to set
	 */
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}


	public Region() {
		
	}
	

	@Override
	public String toString() {
		return "Id : " + id + ", Nom : " + nom ;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}
