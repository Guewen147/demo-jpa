package fr.diginamic.regions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name ="Ville")
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * @return the habitant
	 */
	public List<Habitant> getHabitant() {
		return habitant;
	}

	/**
	 * @param habitant the habitant to set
	 */
	public void setHabitant(List<Habitant> habitant) {
		this.habitant = habitant;
	}

	@Column(name ="NAME")
	private String nom;
	
	@Column(name ="CODE_POSTAL")
	private Integer codePostal;
	
	@Column(name ="DATE_RECENSEMENT")
	@Temporal(TemporalType.DATE)
	private Date dateRecensement;
	
	@Column(name ="CATEGORIE")
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="REG_ID")
	private Region region;
	
	
	@ManyToMany
	@JoinTable(name = "LIEN_VILLES_HABITANT",
				uniqueConstraints = @UniqueConstraint (columnNames = { "ID_VILLE", "ID_HABITANT" }),
				joinColumns = @JoinColumn(name= "ID_VILLE" , referencedColumnName ="ID"),
				inverseJoinColumns = @JoinColumn(name= "ID_HABITANT", referencedColumnName = "ID"))
	private List<Habitant> habitant = new ArrayList<Habitant>();
	

	public Ville() {
	    super();
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
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the dateRecensement
	 */
	public Date getDateRecensement() {
		return dateRecensement;
	}

	/**
	 * @param dateRecensement the dateRecensement to set
	 */
	public void setDateRecensement(Date dateRecensement) {
		this.dateRecensement = dateRecensement;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Ville n°" + id + " Appeler aussi : " + nom + " ayant un Code Postal equvalent à : " + codePostal + " /r à au pour la derniere fois une date de recensement le :"
				+ dateRecensement + " et est consideré comme une Ville de Categorie : " + categorie;
	}
	
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
}
