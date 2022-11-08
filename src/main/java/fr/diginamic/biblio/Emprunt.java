package fr.diginamic.biblio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "EMPRUNT")
public class Emprunt {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "DELAI")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	
	@ManyToMany(mappedBy="emprunts")
	private List<Livre> livres = new ArrayList<Livre>();


	/**
	 * 
	 */
	public Emprunt() {
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
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}


	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}


	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	/**
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}


	/**
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	/**
	 * @return the idClient
	 */
	public Client getIdClient() {
		return client;
	}


	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Client client) {
		this.client = client;
	}


	/**
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}


	/**
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}


	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", idClient=" + client + ", livres=" + livres + "]";
	}
	
	
}
