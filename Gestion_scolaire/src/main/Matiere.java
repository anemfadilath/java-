package main;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private String nom;
	private Professeur prof;//le proffeseur qui enseigne la matire (en suposant qu'une matire est enseigne par un seul prof)
	private List<Filieres> liste_filiere;//liste des filiere dans la quel la matire est enseigné
	public Matiere(String nom,String n,String prenom,int j,int m,int a,long tel,int id) {
		super();
		this.nom = nom;
		this.prof = new Professeur(n,prenom,j,m,a,tel,id);
		this.liste_filiere=new ArrayList<>();
	}
	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	public Matiere(String nom) {
		super();
		this.nom = nom;
	}


	//afficher les info sur une matire
	
	public void afficher_matire_info() {
		
		System.out.print("nom \t"+nom+"\n\n");
		//System.out.print("information profeseur");
		//prof.afficher();
	}
	//ajouter une filiere a une matire
	    public void ajouter_filiere(Filieres f) {
		    if(f!=null)  this.liste_filiere.add(f);
	     }
	    
	    //afficher les filiere dans la quel une matire est enseigner
	    
	public void afficher_filiere_matiere() {
		
		for (int i = 0; i < liste_filiere.size(); i++) {
			
			  liste_filiere.get(i).afficherFiliere();
			
		}
		
	}

}
