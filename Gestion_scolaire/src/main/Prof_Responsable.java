package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.Date;
import util.Heure;

public class Prof_Responsable extends Administration {
	private String mot_pass="prof_responsable";//en supossant que tout les prof responsable ont le meme mot de pass
	private Salle sal=new Salle();// en supossant qu'on ne peut reservé qu'une et une seul salle pour un cours ou une reuniuon
	private static Reunion r;
	private int id;
	private List<Reunion> liste_reunion;

	public Prof_Responsable() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prof_Responsable(String nom, String prenom, int mois, int jour, int anne,long num_telephone,int id) {
		super(nom, prenom, mois, jour, anne, num_telephone);
		this.mot_pass="profresponsable";
		this.id=id;
		liste_reunion=new ArrayList<>();
		
				
				}
	public void afficher_prof_responsable() {
		super.afficher();
		System.out.print("id:\t"+id);
	}
	//methode pour verifier si une runion existe djà en passant id en paramettre
	
	public boolean verifier_reunion(int id) {
		boolean existe=true;
		for (int i = 0; i < liste_reunion.size(); i++) {
			
			Reunion a=liste_reunion.get(i);
			if(a.getId_reunion()==id) {
				existe=false;
				
			          }
			
		}
		return existe;
		
	    }
	
	
	 //mehode pour planifier une reunion
	
	public boolean planifier_reunion(Reunion r) {
		boolean creation_reussit=true;
		
		if(r!=null) {
			//verifier si la reunion a créer exite dejà(apple methode planifier reunion)
			boolean  b=verifier_reunion(r.getId_reunion());
			//si la renion exite b n'est pas null si non il est null
			if(b==true) {
				boolean verif_sall=super.disponibilite_salle(r.getNum_salle());
				if(verif_sall==true) {
				liste_reunion.add(r);
				}
				else  {
					System.out.print("cette salle n'est pas disponible \n");
				 super.afficher_salle_dispo();
					creation_reussit=false;
				   
				}
		}
			else {
				System.out.print("cette reunion existe dejà");
				creation_reussit=false;
			}
			
			}
		return creation_reussit;
		     
		
	}
	
	
	public void afficher_reunion() {
		try {
		
		for (int i = 0; i < liste_reunion.size(); i++) {
			
			  liste_reunion.get(i).afficher_r();
			
		}
		}catch(NullPointerException e) {
		 System.out.print("il n'existe aucune reunion");
		}
		if(liste_reunion.isEmpty()) System.out.print("vous n'avez pas encore de reunion");
	}
	
	public void supprimer_reunion(int id) {
		for (int i = 0; i < liste_reunion.size(); i++) {
			Reunion a=liste_reunion.get(i);
			
			if (a.getId_reunion()==id) {
				this.liste_reunion.remove(a);
			
			}
			else System.out.print("cette reunion n'existe pas");
			
		
		}
	
	}
	//methode modifier une reunion 
	
public void modifier_info_reunion(int id) {
	//Reunion c=verifier_reunion(id);
	
	for (int i = 0; i < liste_reunion.size(); i++) {
		
		Reunion c=liste_reunion.get(i);
		if(c.getId_reunion()==id) {
			
			Scanner chaine=new Scanner(System.in);
			Scanner entier=new Scanner(System.in);
			
			System.out.print("entrez l'information à modifier");
			
			String modif=chaine.nextLine();
			//System.out.print(modif);
			
			//si il veut modifier le nom de la reunion
			
			if (modif.equals("nom")) {
				
				System.out.print("entrez le nouveau non");
				
				String new_name=chaine.nextLine();
				
				c.setNom(new_name);
				
			}
			
			//si il veut modifier l'heure de la reunion
			
			else if(modif.equals("heure")) {
				
				
				System.out.print("entrez l'heur de la reunion comme heure,minute");//entrez l'heur avant minute
				
				int heure=entier.nextInt();
				
				int minute=entier.nextInt();
				
				Heure h=new Heure(heure,minute);
				c.setHeure(h);
			}
			
			//si il veut modifier la date de la reunion
			
			else if(modif.equals("date")) {
				
				
				System.out.print("entrez date de la reunion comme jour,mois ,année");//entrez les information dans l'ordre
				int jour=entier.nextInt();
				
				int mois=entier.nextInt();
				
				int annee=entier.nextInt();
				
				Date d=new Date(jour,mois,annee);
				c.setDate_reunion(d);
				}
			//si il veut modifier identifiant de la reunion(n'est pas modifiable)
			else if(modif.equals("id")) {
				
				System.out.print("vous pouvez pas modifier l'identifiant");
				
			}
			else System.out.print("la reunion ne contient pas cette information");			
		}
		//si la reunion n'existe pas(id pas dans le liste)
		else{
			
			System.out.print("cette reunion n'existe pas");
			
		}
		
	}
	
	
} 
public boolean se_connecter(String pass) {
	boolean reussit=false;
	if(mot_pass.equals(pass)) reussit=true;
	return reussit;
}

}



