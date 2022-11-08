package fr.diginamic.biblio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "livre")
public class Livre {

	@Id
	private Integer id;
	
	@Column(name = "Titre")
	private String titre;
	
	@Column(name = "Auteur")
	private String auteur;
	
	@ManyToMany
	@JoinTable(name = "COMPO",
				uniqueConstraints = @UniqueConstraint (columnNames = { "ID_EMP", "ID_LIV" }),
				joinColumns = @JoinColumn(name= "ID_EMP" , referencedColumnName ="ID"),
				inverseJoinColumns = @JoinColumn(name= "ID_LIV", referencedColumnName = "ID"))
	private  List<Emprunt> emprunts = new ArrayList<Emprunt>();

	public Livre() {
		
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Livre n°" + id + " ayant le titre suivant : \r " + titre + " écrit par : " + auteur;
	}

	
	
	
}
