package mydomain.myapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "findAllPlayers", query = "SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull(message="Image type must be specified.")
	@Size(min=5)
	private String nom;
	private String prenom;
	private String position;
	@Min(value=5,message="dddddddd")
	private int numero;
	
	@Transient
	boolean editable;

	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int i) {
		this.numero = i;
	}
	
	public Player(String nom, String prenom, String position, int numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.position = position;
		this.numero = numero;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
