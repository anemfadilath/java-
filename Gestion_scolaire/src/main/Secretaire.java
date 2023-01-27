package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Date;
import util.Heure;

public class Secretaire extends Administration {
	private String mot_pass="secret";//mot de passe predefini que le secretaire utilise pou se connecter
	private List<Filieres> liste_Filiere =new ArrayList<>();
    private List<Etudiant> liste_Etudiant=new ArrayList<>();
    private List<Professeur> liste_professeur=new ArrayList<>();
    private List<Matiere>liste_matiere=new ArrayList<>();
   private List<Prof_Responsable> liste_prof_responsable=new ArrayList<>();
	private List<Reunion> liste_reunion=new ArrayList<>();
    private static Filieres f;
    private static Etudiant et;
    private static Professeur pr;
    private static Prof_Responsable prof_r;
    private static Matiere m;
    private Salle sal=new Salle();// en supossant qu'on ne peut reservé qu'une et une seul salle pour un cours ou une reuniuon
	private static Reunion r;
	public String getMot_pass() {
		return mot_pass;
	}
	

	public List<Filieres> getListe_Filiere() {
		return liste_Filiere;
	}


	public void setListe_Filiere(List<Filieres> liste_Filiere) {
		this.liste_Filiere = liste_Filiere;
	}


	public List<Etudiant> getListe_Etudiant() {
		return liste_Etudiant;
	}


	public void setListe_Etudiant(List<Etudiant> liste_Etudiant) {
		this.liste_Etudiant = liste_Etudiant;
	}


	public List<Professeur> getListe_professeur() {
		return liste_professeur;
	}


	public void setListe_professeur(List<Professeur> liste_professeur) {
		this.liste_professeur = liste_professeur;
	}


	public List<Matiere> getListe_matiere() {
		return liste_matiere;
	}


	public void setListe_matiere(List<Matiere> liste_matiere) {
		this.liste_matiere = liste_matiere;
	}
	

	public Secretaire() {
		// TODO Auto-generated constructor stub
	}

	public Secretaire(String nom, String prenom, int mois, int jour, int anne,long num_telephone) {
		super(nom, prenom, mois, jour, anne, num_telephone);
		
	}
	////---------------------------------TRAITEMENT ETUDIANT------------------------------------///
	///recherche etudiant
	public Etudiant  chercher_etudiant(int matricul) {
		boolean trouver=true;
		for(int i=0;i<liste_Etudiant.size();i++) {
			Etudiant e=liste_Etudiant.get(i);
			if(e.getMatricule()==matricul) {
				
				et=e;
			}
		}
		return et;
	}
	
	///
	public void afficher_etudiant_filiere(Filieres fil) {
		Filieres fi=verifier_filiere(fil);
		if(fi!=null) {
		
		for(int i=0;i<fi.getListe_etudiant().size();i++) {
			if(fi.getListe_etudiant().isEmpty()) System.out.print("il n'y a pas encore d'etudiant pour cette filiere \n");
			else fi.getListe_etudiant().get(i).afficher();
		}
			
		}
		
	}
	public void afficher_etudiant_etablissement() {
		for (int i = 0; i < liste_Etudiant.size(); i++) {
			if(liste_Etudiant.isEmpty()) System.out.print("il n'y a pas d'etudiant");
			else  liste_Etudiant.get(i).afficher();
			
		
		       }
	}
	
	////suprimer etudiant d'une filiere
	public void suprimer_etudiant(Filieres fil,int matricul) {
		for(int i=0;i<liste_Filiere.size();i++) {
			Filieres a=liste_Filiere.get(i);
			if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
	     	Etudiant etudiant=chercher_etudiant(matricul);
	     	if (etudiant!=null) {
	     		a.getListe_etudiant().remove(etudiant);
	     		liste_Etudiant.remove(etudiant);//suppression totel de l'etudiant de la base de donne
	     		System.out.print("suppression reussit :) \n");
	     	}
	     	else System.out.print("suppression echouer :( verifier le matricul \n");
		  
		        
	}
			else System.out.print("cette filiere n'existe pas \n")	;
		}
	}
	
	
	//methode pour ajouter un etudiant dans une filiere en indicant le nom de la filiaire parametre etudiant et filiere
	public void ajouter_etudiant(Filieres fil,Etudiant e) {
		
		for (int i = 0; i < liste_Filiere.size(); i++) {
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  Etudiant etudiant=chercher_etudiant(e.getMatricule());
				     if(etudiant==null) {
				    	 if(e!=null) {
				     a.getListe_etudiant().add(e);
				  liste_Etudiant.add(e);
				  System.out.print("l'etudiant à eté ajouter :) \n");
				     }
				    	 else System.out.print("information etudiant incomplet \n");
				     }
				  else System.out.print("il existe dejà un etudiant evec cet matricul\n");
				  
			  }
			  else System.out.print("cette filiere n'existe pas \n");
		}
		       
	}
	
	//payement scolarité
	public boolean payement_scolarité(Filieres fil,int matricul) {
		boolean reussit=true;
		for (int i = 0; i < liste_Filiere.size(); i++) {
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  for(int j=0;j<a.getListe_etudiant().size();j++) {
					  Etudiant e=a.getListe_etudiant().get(j);
					  if(e.getMatricule()==matricul) {
						  int indice_etudiant=j;
						  Scanner entier=new Scanner(System.in);
							System.out.print("entrez la somme remis");
							float somme=entier.nextFloat();
							if(e.getScolarite()<=30000) {
								float reste=e.getScolarite()-somme;
								System.out.print(reste);
								e.setScolarite(reste);
								a.getListe_etudiant().set(indice_etudiant, e);
								liste_Etudiant.set(indice_etudiant, e);//en supposant que l'etudiant se trouve dans le mm indice dans 
							                                    //la liste filiere que la liste ecole
								System.out.print("payement reussit :) \n");					 
								}
							else if (e.getScolarite()==0) System.out.print("cet etudian a deja regle toute sa scolarité \n");
				  }
					  else System.out.print("etudiant nom trouver :( verifier le matricul \n");
			  }
		
	}
			  else System.out.print("filiere non trouver :( \n");
		}
		return reussit;
	}
	
	//modifier inforamtion etudiant(seul le matricul et le numero de telephone peuvent etre modifier)
	
	public void modifier_info_eudiant(Filieres fil,int matricul) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  for(int j=0;j<a.getListe_etudiant().size();j++) {
					  Etudiant e=a.getListe_etudiant().get(j);
					  if(e.getMatricule()==matricul) {
						  int indice_etudiant=j;
						  Scanner chaine=new Scanner(System.in);
						  Scanner entier =new Scanner(System.in);
							System.out.print("entrez l'informatin a modifier matricul/numero telephone \n");
							String info=chaine.nextLine();
							if(info.equals("matricul")) {
								System.out.print("entrez le nouveau matricul \t");
								int new_matricul=entier.nextInt();
								Etudiant etud=chercher_etudiant(new_matricul);
								if(etud==null) {
									e.setMatricule(new_matricul);
								a.getListe_etudiant().set(indice_etudiant, e);
								liste_Etudiant.set(indice_etudiant, e);//en supposant que l'etudiant se trouve dans le mm indice dans 
							                                    //la liste filiere que la liste ecole
								System.out.print("modifiction reussit :) \n");					 
								}
								else if(etud!=null) System.out.print("dejà un etudiant avec cet matricul");
							}
							else if (info.equals("numero telephone")) {
								Scanner nb=new Scanner(System.in);
								long telephone=nb.nextLong();
								e.setNum_telephone(telephone);
								a.getListe_etudiant().set(indice_etudiant, e);
								liste_Etudiant.set(indice_etudiant, e);//en supposant que l'etudiant se trouve dans le mm indice dans 
								                               //la liste filiere que la liste ecole
								
							}
							else System.out.print("vous pouvez selement le numero de telephone et le matricul");
				  }
					  else System.out.print("etudiant nom trouver :( verifier le matricul \n");
			  }
		
	        }
			  //else System.out.print("cette filiere n'existe pas");
		}
		
	}
	
	
	///-------------------------------FINTRAITEMENT ETUDIANT-----------------------------------------///
	
	///-----------------------------TRAITEMENT PROFESSEUR--------------------------------------------///
	///chercher un prof
	public Professeur chercher_prof(int id) {
		for(int i=0;i<liste_professeur.size();i++) {
			Professeur p=liste_professeur.get(i);
			if(p.getId_prof()==id) {
				pr=p;
			}
		}
		return pr;
	}
	
	//ajouter un prof a une filiere et en meme temps ajouter une filiere a prof
	public void ajouter_prof_filiere(Filieres fil,Professeur f) {
		for(int i=0;i<liste_Filiere.size();i++) {
			Filieres a=liste_Filiere.get(i);
			Professeur p=chercher_prof(f.getId_prof());
			a.getListe_prof();
			if((fil.getNom().equals(a.getNom()))&&(fil.getNiveau()==a.getNiveau())) {
				if(f!=null) { a.getListe_prof().add(f);
				f.getListe_filiere().add(fil);
				}
				else System.out.print("information incompet");
				if(p==null) liste_professeur.add(f);
				
			}
			else System.out.print("cette filiere n'existe pas");
				
			}
				
			
		}
		
		

	///afficher les prof d'une filiere
	public void afficher_prof_filiere(Filieres fil) {
		Filieres fi=verifier_filiere(fil);
		if(fi!=null) {
			for(int i=0;i<fi.getListe_prof().size();i++) {
				fi.getListe_prof().get(i).afficher();
				
			}
		}
	}
	
	// supprimer un  prof d'une filiere
	public void supprimer_prof_filiere(Filieres fil,int id) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			  Filieres a=liste_Filiere.get(i);
			  a.getListe_prof();
			  Professeur professeur=chercher_prof(id);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  if(professeur!=null) {
					  a.getListe_prof().remove(professeur);
					  System.out.print("suppression reussit :)\n");
				  }
				  else System.out.print("suppression echouer :( \n");
	             }
}
		
	}
	
	public void ajouter_prof_ds_etablissement(Professeur p) {
		Professeur professeur=chercher_prof(p.getId_prof())	;
		if(p!=null) {
		if(professeur==null) liste_professeur.add(p);
	}
	}
	
	public void ajouter_matiere_prof(int id,Matiere m) {
		Professeur prof=chercher_prof(id);
		if(prof!=null) {
			prof.getListe_matiere().add(m);
			
		}
	}

	//----------------------------------------FIN TRAITEMENT PROF---------------------------------------//

	//----------------------------------------------TRAITEMENT MATIERE---------------------------------//
	//ajouter une matiere a une filiere
	public void ajouter_matiere_filiere(Filieres fil,Matiere m) {
		for(int i=0;i<liste_Filiere.size();i++) {
			Filieres a=liste_Filiere.get(i);
			
			a.getListe_matiere();
			if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				Matiere matiere =chercher_matiere(m.getNom());
		         if(matiere==null)
		         {
		        a.getListe_matiere().add(m);	
				liste_matiere.add(m);
				System.out.print("ajout reussit :) \n");
			}
		         else System.out.print("jout echuer :( cette matiere est dejà enregistre pour cette filiere \n");
			}
				
			else System.out.print("cette filiere n'existe pas");
		}
		
		
	}
		
		
	public Matiere chercher_matiere(String nom) {
		for(int i=0;i<liste_matiere.size();i++) {
			Matiere a=liste_matiere.get(i);
			if(a.getNom().trim().equals(nom.trim())) {
				m=a;
			
			}
		}
	return m;	
	}
	
	
	
public void suprimer_matiere(Filieres fil,String nom) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			  Filieres a=liste_Filiere.get(i);
			 
			  a.getListe_matiere();
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  Matiere matiere=chercher_matiere(nom);
				  if(matiere!=null) {
					  a.getListe_matiere().remove(matiere);
					  System.out.print("suppression reussit :) \n");
				  }
				  
				  else System.out.print("suppression echouer :( vrifier le nom de la matiere \n");
	               }
		}
}

public void afficher_matiere_filiere(Filieres fil) {
	Filieres fi=verifier_filiere(fil);
	if(fi!=null) {
		for(int i=0;i<fi.getListe_matiere().size();i++) {
			if(fi.getListe_matiere().isEmpty()) System.out.print("il n'y a pas encore de matiere pour cette fliere");
			else fi.getListe_matiere().get(i).afficher_matire_info();
		}
	}
	
}
	
//--------------------------------FIN TRAITEMENT MATIERE-------------------------------------------//
	
	///------------------------------------TRAITEMENT FILIERE-------------------------------------///
	public Filieres verifier_filiere(Filieres fil) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  f=a;
				  
			  }
		
	}
		return f;
	}
	public void ajouter_filiere(Filieres fil) {
		boolean creation_reussit=true;
		if (fil!=null) {
		Filieres b=verifier_filiere(fil);
		if(b==null) liste_Filiere.add(fil);			
		
		else {
			System.out.print("cette filiere existe dejà");
			creation_reussit=false;
		}
		
	}
		
	}
	
	public void afficher_filieres_ecole() {
		for(int i=0;i<liste_Filiere.size();i++) {
			//if(liste_Filiere.isEmpty()) System.out.print("il n'existe aucune filiere");
			this.liste_Filiere.get(i).afficherFiliere();
		}
	}
	public void supprimer_filiere(Filieres fil) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
		if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
		 
			this.liste_Filiere.remove(a);
			System.out.print("suppression reussit :) \n");
		}
		else System.out.print("suppression echouer :( verifier les information entrez \n");
		
	}
		}
	
	public void modifier_prof_responsable_filiere(Filieres fil) {
		for (int i = 0; i < liste_Filiere.size(); i++) {
			
			  Filieres a=liste_Filiere.get(i);
			  //si filiere existe :ajoute l'etudiant a la filiere
			  if((fil.getNom().trim().equals(a.getNom().trim()))&&(fil.getNiveau()==a.getNiveau())) {
				  Scanner chaine=new Scanner(System.in);
				  Scanner entier =new Scanner(System.in);
				  System.out.print("entrez le nom du prof");
				  String nom=chaine.nextLine();
				  System.out.print("entrez le prenom");
				  String prenom=chaine.nextLine();
				  System.out.print("entrez la date de naissance comme:jour mois année");
				  int jour=entier.nextInt();
				  int mois=entier.nextInt();
				  int annee=entier.nextInt();
				  System.out.print("le numero de telephone");
				  long numero=entier.nextLong();
				  System.out.print("indiquez l'identifiant");
			    	int id=entier.nextInt();
				  Prof_Responsable prof =new Prof_Responsable(nom,prenom,jour,mois,annee,numero,id);
				  a.setProf(prof);
				  ajouter_prof_responsable(prof);//rajouter le prof dans la liste du prof responssable si il existe pas.
			  }
		
	}
		
	}
	//-------------------------------------FIN TRAITEMENT FILIERE------------------------------------//
	
	public void rendre_disponible_sall(int num) {
          for(int i=0;i<sal.s.length;i++) {
			
			if(i==num) {
				String b=sal.s[num].getDispo();
			if(b.equals("occuper")) sal.s[num].setDispo("disponible");
				
			
	                  }
	
                    }
	     }
	
	
	
	///----------------------------TRAITEMENT REUNION------------------------------------------------------///
	
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
			if(liste_reunion.isEmpty()) System.out.print("vous n'avez aucune reunion \n");
			else liste_reunion.get(i).afficher_r();
			System.out.print("\n");
			
		}
		}catch(NullPointerException e) {
		 System.out.print("il n'existe aucune reunion \n");
		}
		
	}
	
	public void supprimer_reunion(int id) {
		for (int i = 0; i < liste_reunion.size(); i++) {
			Reunion a=liste_reunion.get(i);
			//if(liste_reunion.isEmpty()) System.out.print("vous n'avez aucune reunion \n");
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
///----------------------------------------------FIN TRAITEMENT REUNION-------------------------------------------
public Prof_Responsable chercher_prof_responsable(int id) {
	for(int i=0;i<liste_prof_responsable.size();i++) {
		Prof_Responsable prof=liste_prof_responsable.get(i);
		if(prof.getId()==id) {
			prof_r=prof;
		}

	}
	return prof_r;
	}
public void ajouter_prof_responsable(Prof_Responsable p) {
	if(p!=null) {
		Prof_Responsable prof=chercher_prof_responsable(p.getId());
		if(prof==null) {
			liste_prof_responsable.add(p);
		}
				}
	}

//Methode connection(pour que le scretaire se connecte)
public boolean se_connecter(String pass) {
	boolean reussit=false;
	if(pass.equals(mot_pass)) reussit=true;
	else System.out.print("mot de pass incorrecte :( \n");
	return reussit;
	
	
}

}





