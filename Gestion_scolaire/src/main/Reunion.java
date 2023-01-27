package main;

import java.util.Random;

import util.Date;
import util.Heure;

public class Reunion {
	//Random number=new Random();
	private String nom;
	private Heure heure;
	private Date date_reunion;
	private int id_reunion;
	private int num_salle;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Heure getHeure() {
		return heure;
	}
	
	public void setHeure(Heure heure) {
		this.heure = heure;
	}
	
	public Date getDate_reunion() {
		return date_reunion;
	}
	
	public void setDate_reunion(Date date_reunion) {
		this.date_reunion = date_reunion;
	}
	public int getNum_salle() {
		return num_salle;
	}
	
	public void setNum_salle(int num_salle) {
		this.num_salle = num_salle;
	}
	

public int getId_reunion() {
	
		return id_reunion;
	}

	public void setId_reunion(int id_reunion) {
		this.id_reunion = id_reunion;
	}
	
public Reunion(String nom,int id,int heur,int min,int j ,int m,int a,int s) {
	
	this.nom=nom;
	this.id_reunion=id;
	this.heure=new Heure(heur,min);
	this.date_reunion=new Date(j,m,a);
	this.num_salle=s;
}

public Reunion(String nom, Heure heure, Date date_reunion, int id_reunion, int num_salle) {
	super();
	this.nom = nom;
	this.heure = heure;
	this.date_reunion = date_reunion;
	this.id_reunion = id_reunion;
	this.num_salle = num_salle;
}

public void afficher_r() {
	
	System.out.print("nom:\t"+nom+"\tid reunion:\t"+id_reunion+"\tsalle:\t"+num_salle);
	
	System.out.print("\tdate:\t");
	
	date_reunion.afficher();
	
	System.out.print("\theure:\t");
	
	heure.afficher_heur();
	
}
}
