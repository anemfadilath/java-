package main;
//class mère de class professeur ,proffesseur responsable,Secretaire,  et class fille de personne

public abstract class Administration extends Personne {
	private Salle sal=new Salle();// en supossant qu'on ne peut reservé qu'une et une seul salle pour un cours ou une reuniuon
	private static Reunion r;
	public Administration() {
		// TODO Auto-generated constructor stub
	}

	public Administration(String nom, String prenom, int mois, int jour, int anne,long num_telephone) {
		super(nom, prenom, mois, jour, anne, num_telephone);
		// TODO Auto-generated constructor stub
	}
	
	public void afficher_salle_dispo() {
		System.out.print("voici les salles disponible");
		for(int i=0;i<sal.s.length;i++) {
			if(sal.s[i].getDispo().equals("disponible")) {
				System.out.print("\n"+i+"\n");
			}
			
		}
	}
	
	public boolean disponibilite_salle(int num) {
		boolean disponible=true;
		for(int i=0;i<sal.s.length;i++) {
			
			if(i==num) {
				String b=sal.s[num].getDispo();
			if(b.equals("occuper")){
				disponible=false;
				//afficher_salle_dispo();
				//System.out.print("le salle choisit n'est pas disponible");
				
			}
			else {
				sal.s[num].setDispo("occuper");
			}
			
			}
			
		}
		return disponible;
	}
	
	public boolean reserver_salle(int num) {
		boolean salle_dispo=disponibilite_salle(num);
		boolean reserv_reussit=true;
		if(salle_dispo==true)  System.out.print("reservation reussit");	
		else {
			System.out.print("cette salle est occuper\n");
			afficher_salle_dispo();//appel de la methodes afficher_salle_dispo de la class mère
			
			reserv_reussit=false;
		}
		return reserv_reussit;	        
	}

}
