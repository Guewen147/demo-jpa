package fr.diginamic.regions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "client")
public class Habitant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "PRENOM")
	private String prenom;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToMany
	@JoinTable(name = "LIEN_VILLES_HABITANT",
				uniqueConstraints = @UniqueConstraint (columnNames = { "ID_VILLE", "ID_HABITANT" }),
				joinColumns = @JoinColumn(name= "ID_VILLE" , referencedColumnName ="ID"),
				inverseJoinColumns = @JoinColumn(name= "ID_HABITANT", referencedColumnName = "ID"))
	private List<Ville> ville2 = new ArrayList<Ville>();

	
	public Habitant() {
		
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


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the ville2
	 */
	public List<Ville> getVille2() {
		return ville2;
	}


	/**
	 * @param ville2 the ville2 to set
	 */
	public void setVille2(List<Ville> ville2) {
		this.ville2 = ville2;
	}


	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	


	
	
}
