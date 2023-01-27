package main;

public class Etudiant extends Personne {
	private int matricule;
	private  float scolarite;
	//private Filieres filiere;//en supossant qu'un etudiant peut etre inscrit dans une seul ficliaire
	

	public Etudiant() {
		
	}

	public int getMatricule() {
		return matricule;
	}


	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	
	

	public float getScolarite() {
		return scolarite;
	}

	public void setScolarite(float scolarite) {
		this.scolarite = scolarite;
	}

	public Etudiant(String nom, String prenom, int mois, int jour, int anne,long num_telephone ,int matricule) {
		super(nom, prenom, mois, jour, anne, num_telephone);
		this.matricule=matricule;
		this.scolarite=30000;
		
	}
public void afficher() {
	super.afficher();
	System.out.print("matricul:\t"+matricule+"reste scolarité à payer"+scolarite+"\n\n");
}
}
