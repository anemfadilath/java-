package main;

import java.util.ArrayList;
import java.util.List;

public class Professeur extends Administration {
	private List<Matiere>liste_matiere;
	private List<Filieres>liste_filiere;
	private int id_prof;
	private String mot_pass="professeur";
	
	//private  Prof_Responsable p=new Prof_Responsable();
	
	
	public Professeur() {
		
	}

	public int getId_prof() {
		return id_prof;
	}

	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	

	public List<Matiere> getListe_matiere() {
		return liste_matiere;
	}
	

	public List<Filieres> getListe_filiere() {
		return liste_filiere;
	}

	public void setListe_filiere(List<Filieres> liste_filiere) {
		this.liste_filiere = liste_filiere;
	}

	public void setListe_matiere(List<Matiere> liste_matiere) {
		this.liste_matiere = liste_matiere;
	}

	public Professeur(String nom, String prenom, int mois, int jour, int anne,long num_telephone,int id) {
		super(nom, prenom, mois, jour, anne, num_telephone);
		liste_matiere=new ArrayList<>();
		liste_filiere=new ArrayList<>();
		this.id_prof=id;
		
	}
	
	public void afficher_matiere_enseigner() {
		//IllegalStateException e;
		try {
		
		for (int i = 0; i < liste_matiere.size(); i++) {
			
			  liste_matiere.get(i).afficher_matire_info();
		}
		}catch(NullPointerException e) {
		
		 System.out.print("il n'esxiste pas de matiere pour ce prof ");
			
		}
	}
	public void afficher_filiere_enseigner() {
		try {
			for(int i=0;i<liste_filiere.size();i++) {
				liste_filiere.get(i).afficherFiliere();
			}
		}catch(NullPointerException e) {
			System.out.print("il n'existe pas de filiere pour cet prof");
		}
	}
		
	
	public boolean se_connecter(String pass) {
		boolean reussit=false;
		if(mot_pass.equals(pass)) {
			reussit=true;
		}
		return reussit;
	}
	
}
