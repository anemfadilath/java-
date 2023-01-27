package main;

import util.Date;

public abstract class Personne {
	protected String nom;
	protected String prenom;
	protected Date date_naissance;
	protected long num_telephone;
	protected int age;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public long getNum_telephone() {
		return num_telephone;
	}
	public void setNum_telephone(long num_telephone) {
		this.num_telephone = num_telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Personne() { }
	public Personne(String nom, String prenom,int jour,int mois,int anne,long num_telephone) {
		this.nom=nom;
		this.prenom=prenom;
		date_naissance=new Date(jour,mois,anne);
		this.num_telephone=num_telephone;
		this.age=2021-anne;
		
	}
	public void afficher() {
		
			System.out.print("nom :"+nom +"\t prenom:"+prenom+"\nage:"+age+"numero telephone"+num_telephone);
			System.out.print(" \tdate de naissance :\t");
			try {
			date_naissance.afficher();
			}catch(NullPointerException e) {
				System.out.print("pas encore enregistre");
			}
	      
			
		
	}
	

}
