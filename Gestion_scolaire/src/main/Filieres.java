package main;
import java.util.ArrayList;
import java.util.List;

public class Filieres {
	private String nom;
	private int niveau;
	private List<Matiere> liste_matiere;//liste des matire enseigneé dans la filiere
	private List<Etudiant> liste_etudiant;//liste des etudiant de le filiere
	private List<Professeur>liste_prof;//liste des prof d'une filiere(en suposant qu'une filire comporte plusieurs prof)
	private Prof_Responsable prof;//en supossant que chaque filiere à un prof responsable
	public Filieres(String nom, int niveau,Prof_Responsable prof) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.prof=prof;
		this.liste_matiere=new ArrayList<>();                            
		this.liste_etudiant=new ArrayList<>();
		this.liste_prof=new ArrayList<>();
	}
	
	public Filieres(String nom, int niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.liste_matiere =new ArrayList<>();
		this.liste_etudiant = new ArrayList<>();
		this.liste_prof =new ArrayList<>();
	}

	public Filieres() {
		
	}
	
	
	public Prof_Responsable getProf() {
		return prof;
	}
	public void setProf(Prof_Responsable prof) {
		this.prof = prof;
	}
	public List<Matiere> getListe_matiere() {
		return liste_matiere;
	}
	public List<Etudiant> getListe_etudiant() {
		return liste_etudiant;
	}
	public List<Professeur> getListe_prof() {
		return liste_prof;
	}
	
	public void setListe_matiere(List<Matiere> liste_matiere) {
		this.liste_matiere = liste_matiere;
	}
	public void setListe_etudiant(List<Etudiant> liste_etudiant) {
		this.liste_etudiant = liste_etudiant;
	}
	public void setListe_prof(List<Professeur> liste_prof) {
		this.liste_prof = liste_prof;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	
	//methode afficher information d'une filiere
	public void afficherFiliere() {
		
		    System.out.print("nom:\t"+nom+"\t\tniveau \t"+niveau);
		    System.out.print("prof responssable:\t\t\t\n");
		    try {
		    prof.afficher_prof_responsable();
		    }catch(NullPointerException e) {
		    	System.out.print("pas encore definie\n\n");
		    }
		    
		      }
	

}
