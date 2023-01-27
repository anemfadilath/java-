package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import main.Secretaire;
//certaine methode sont en private car ils peuvent seulement etre appeler via la methode mainMenu
public class Menu {
	private static Secretaire s=new Secretaire();
	private static  Professeur prof2=new Professeur();
	private Filieres donner_info_filiere() {
		Scanner var=new Scanner(System.in);
		System.out.print("indiquez la filire(nom et niveau)");
    	String nom_f=var.nextLine();
    	int niveau=var.nextInt();
    	//creation de la filiere
    	Filieres filiere=new Filieres(nom_f,niveau);
		return filiere;
		
	}
	private Reunion creation_reunion() {
		Scanner var=new Scanner(System.in);
		System.out.print("donner le nom de la reunion \n");
    	String nom_reunion=var.nextLine();
    	 System.out.print("donner l'id de la reunion \n");
    	 int id=var.nextInt();
    	 System.out.print("le date de la reunion (j:mois:année) \n");
    	 int jour=var.nextInt();
    	 int mois=var.nextInt();
    	 int anne=var.nextInt();
    	 System.out.print("indiquez la salle de la reunion");
    	 int salle=var.nextInt();
    	 System.out.print("indiquez l'heure de deroulement(heur minute)");
    	 int heur=var.nextInt();
    	 int min=var.nextInt();
    	 Reunion reunion=new Reunion(nom_reunion,id,heur,min,jour,mois,anne,salle);
		return reunion;
		
	}
	private int indiquez_reunion() {
		Scanner var=new Scanner(System.in);
		System.out.print("indiquez l'identifiant de la reunion");
   	 int id_reunion=var.nextInt();
	return id_reunion;
	}
	private int indiquez_salle() {
		Scanner var=new Scanner(System.in);
		System.out.print("indiquez l'id de la salle \n");
   	 int id_salle=var.nextInt();
	return id_salle;
	}
	
	private void Editer_filiere(Secretaire secretaire) {
		int choice=1;
		Scanner entier=new Scanner(System.in);
		Scanner chaine=new Scanner(System.in);
		try {
		while(choice!=0){
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("1:ajouter un prof à une filiere \n");
		System.out.print("2:Supprimer un prof d'une filiere \n");
		System.out.print("3:modifier le prof responsable \n");
		System.out.print("4:Ajouter une matiere\n");
		System.out.print("5:Supprimer une matiere \t");
		System.out.print("\t\t\t7:afficher les etudiant d'une filiere \n");
		System.out.print("\t\t\t8:affficher les prof d'une filiere \n");
		System.out.print("\t\t\t9:afficher tout les matiere d'une filiere \n");
		System.out.print("\t\t\t10:Renir au menu precednet\n");
		System.out.print("0:pour quitter \n");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("Entrez votre choix \n");
		choice=entier.nextInt();
		switch(choice) {
		    case 1:
		    {   
		    	Filieres filiere=donner_info_filiere();
		    	System.out.print("indiquer les information du prof que vous voulez ajouter \n");
		    	System.out.print("nom/prenon");
		    	String nom=chaine.nextLine();
		    	String prenom=chaine.nextLine();
		    	System.out.print("indiquer le date de naissance j/mois/anne");//entrez le jour puis le mois puis l'annee
		    	int jour=entier.nextInt();
		    	int mois=entier.nextInt();
		    	int anne=entier.nextInt();
		    	System.out.print("indiquez le numero de telephone(ne pas commencer par 0)");
		    	Long telephone=entier.nextLong();
		    	System.out.print("indiquez l'identifiant");
		    	int id=entier.nextInt();
		    	Professeur prof=new Professeur(nom,prenom,jour,mois,anne,telephone,id);
		    	
		    	secretaire.ajouter_prof_filiere(filiere,prof);
		    }break;
		    case 2:{
		    	Filieres filiere=donner_info_filiere();
		    	System.out.print("entrez l'id du prof");
		    	int id=entier.nextInt();
		    	secretaire.supprimer_prof_filiere(filiere, id);
		    	
		    }break;
		    case 3:{
		    	Filieres filiere=donner_info_filiere();
		    	
		    	secretaire.modifier_prof_responsable_filiere(filiere);
		    }break;
		    case 4:{
		    	Filieres filiere=donner_info_filiere();
		    	System.out.print("indiquez le nom de la matiere");
		    	String nom_matiere=chaine.nextLine();
		    	Matiere matiere=new Matiere(nom_matiere);
		    	secretaire.ajouter_matiere_filiere(filiere, matiere);
		    	
		    }break;
		    case 5:{
		    	Filieres filiere=donner_info_filiere();
		    	System.out.print("indiquez le nom de la matiere");
		    	String nom_matiere=chaine.nextLine();
		    	secretaire.suprimer_matiere(filiere, nom_matiere);
		    	
		    }break;
		    case 7:{
		    	Filieres filiere=donner_info_filiere();
		    	secretaire.afficher_etudiant_filiere(filiere);
		    }break;
		    case 8:{
		    	Filieres filiere=donner_info_filiere();
		    	secretaire.afficher_prof_filiere(filiere);
		    }break;
		    case 9:{
		    	Filieres filiere=donner_info_filiere();
		    	secretaire.afficher_matiere_filiere(filiere);
		    }break;
		    case 10:menu_Secretaire(secretaire);break;
		    case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		      }break;
		}
	}
		}catch(InputMismatchException e) {
			System.out.print("eurreur vous devez entrez un entier \n");
		}
		
	}
	private Etudiant donner_info_etudiant() {
		Scanner var=new Scanner(System.in);
		System.out.print("indiquer les information de l'etudiant que vous voulez ajouter \n");
    	System.out.print("nom/prenon");
    	String nom=var.nextLine();
    	String prenom=var.nextLine();
    	System.out.print("indiquer le date de naissance j/mois/anne");//entrez le jour puis le mois puis l'annee
    	int jour=var.nextInt();
    	int mois=var.nextInt();
    	int anne=var.nextInt();
    	System.out.print("indiquez le numero de telephone(ne pas commencer par 0)");
    	Long telephone=var.nextLong();
    	System.out.print("indiquez le matricul");
    	int id=var.nextInt();
    	Etudiant etudiant=new Etudiant(nom,prenom,jour,mois,anne,telephone,id);
		return etudiant;
		
	}
	private void editer_etudiant(Secretaire secretaire) {
		int choice=1;
		Scanner var=new Scanner(System.in);
		try {
		while(choice!=0) {
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("1:modifier information d'un etudiant\n");
		System.out.print("2:supprimer etudiant \n");
		System.out.print("3:enregistrer payement etudiant \n");
		System.out.print("5:revenir menu principal \n");
		System.out.print("0:Quitter \n");
		System.out.print("Entrez votre choix \n");
		System.out.println("+----------------------------------------------------------------------------+");
		choice=var.nextInt();
		switch(choice) {
		     
		      case 1:{
		    	  Filieres filiere=donner_info_filiere();
		    	  System.out.print("entrez le matricul  de l'etudiant");
		    	  int id=var.nextInt();
		    	  secretaire.modifier_info_eudiant(filiere,id);
		    	  
		    	  
		          }break;
		      case 2:{
		    	  Filieres filiere=donner_info_filiere();
		    	  System.out.print("entrez le matricul de l'etudiant");
		    	  int id=var.nextInt();
		    	  secretaire.suprimer_etudiant(filiere, id);
		    	  
		    	  
		      }break;
		      case 3:{
		    	  Filieres filiere=donner_info_filiere();
		    	  System.out.print("entrez le matricul  de l'etudiant");
		    	  int id=var.nextInt();
		    	  secretaire.payement_scolarité(filiere, id);
		    	  
		      }break;
		      case 5:menu_Secretaire(secretaire);break;
		      case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		      }break;
		      
		}
		
	}
	}catch(InputMismatchException e) {
		System.out.print("eurreur vous devez entrez un entier \n");
	}

	}
	 private void editer_prof(Secretaire secretaire) {
		 int choice=1;
			Scanner var=new Scanner(System.in);
			try {
			while(choice!=0) {
		 System.out.println("+----------------------------------------------------------------------------+");
		 System.out.print("1:ajouter une matiere à un prof \n");
		 System.out.print("2:revenir au menu principal \n");
		 System.out.print("0:Quitter");
		 System.out.print("Entrez votre choix \n");
		 System.out.println("+----------------------------------------------------------------------------+");
		choice=var.nextInt();
		 switch(choice) {
		      case 1:{
		      
		    	  System.out.print("indiquez le nom de la matiere");
			      String nom_matiere=var.next();
			      Matiere matiere=new Matiere(nom_matiere);
			      System.out.print("entrez l'id du prof");
			      int id=var.nextInt();
			      secretaire.ajouter_matiere_prof(id, matiere);
		      }break;
		      case 2:menu_Secretaire(secretaire);break;
		      case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		     
		      }break;
		 }
		 
			
			}
			}catch(InputMismatchException e) {
				System.out.print("eurreur vous devez entrez un entier \n");
			}
		 
	 }
	private void menu_Secretaire(Secretaire secretaire) {
		int choice=1;
		Scanner var=new Scanner(System.in);
		try {
		while(choice !=0) {
	   System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("1:editer un etudiant \n");
		System.out.print("2:editer une filiere \n");
		System.out.print("3:editer un prof \n");
		System.out.print("4:ajouter une filiere \n");
		System.out.print("5:Ajouter un etudiant \n");
		System.out.print("6:ajouter un prof à l'etablissement \n");
		System.out.print("7:planifier une reunion de l'aministration \n");
		System.out.print("8:modifier une reunion \t");
		System.out.print(" \t \t\t9:rendre disponible une salle\n");
		System.out.print(" \t \t \t10:reservé une salle \n");
		System.out.print(" \t \t \t11: afficher les salle disponible \n");
		System.out.print(" \t \t \t12:afficher les reunion planifier \n");
		System.out.print(" \t \t \t13:afficher tout les etudiant \n");
		System.out.print(" \t \t \t14:afficher toute les filieres \n");
		System.out.print("\t\t\t15:ajouter un prof respossable\n");
		System.out.print("\t\t\t16:Supprimer une filiere \n");
		System.out.print(" \t \t \t17:Revenir au menu principal\n");
		System.out.print("\t \t \t0:Quitter \n");
		System.out.print("Entrez votre choix \n");
	   System.out.println("+----------------------------------------------------------------------------+");
		choice=var.nextInt();
		switch (choice) {
		     case 1:editer_etudiant(secretaire);break;
		     case 2:Editer_filiere(secretaire);break;
		     case 3:editer_prof(secretaire);break;
		     case 4:{
		    	 Filieres filiere_new=donner_info_filiere();
		    	 secretaire.ajouter_filiere(filiere_new);
		     }break;
		     case 5:{
		    	 Etudiant etudiant=donner_info_etudiant();
		    	  //System.out.print("indiquez les information de la nouvelle filiere de l'etudiant");
		    	  Filieres filiere=donner_info_filiere();
		    	  secretaire.ajouter_etudiant(filiere, etudiant);
		    	  
		     }break;
		     case 6:{
		    	 //Filieres filiere=donner_info_filiere();
			    	System.out.print("indiquer les information du prof que vous voulez ajouter \n");
			    	System.out.print("nom \t");
			    	String nom=var.next();
			    	System.out.print("prenom \t");
			    	String prenom=var.next();
			    	System.out.print("indiquer le date de naissance j/mois/anne");//entrez le jour puis le mois puis l'annee
			    	int jour=var.nextInt();
			    	int mois=var.nextInt();
			    	int anne=var.nextInt();
			    	System.out.print("indiquez le numero de telephone(ne pas commencer par 0)");
			    	Long telephone=var.nextLong();
			    	System.out.print("indiquez l'identifiant");
			    	int id=var.nextInt();
			    	Professeur prof=new Professeur(nom,prenom,jour,mois,anne,telephone,id);
			    	secretaire.ajouter_prof_ds_etablissement(prof);
		     }break;
		     case 7:{
		    	 Reunion reunion=creation_reunion();
		    	 secretaire.planifier_reunion(reunion);
		     }break;
		     case 8:{
		    	 int id_reunion=indiquez_reunion();
		    	 secretaire.modifier_info_reunion(id_reunion);
		     }break;
		     case 9:{
		    	 int id_salle=indiquez_salle();
		    	 secretaire.rendre_disponible_sall(id_salle);
		     }break;
		     case 10:{
		    	 int id_salle=indiquez_salle();
		    	 secretaire.reserver_salle(id_salle);
		     }break;
		     case 11:secretaire.afficher_salle_dispo();break;
		     case 12:secretaire.afficher_reunion();break;
		     case 13:secretaire.afficher_etudiant_etablissement();break;
		     case 14:secretaire.afficher_filieres_ecole();break;
		     case 15:{
		    	 
				  System.out.print("entrez le nom du prof \t");
				  String nom=var.nextLine();
				  System.out.print("\n");
				  System.out.print("entrez le prenom \t");
				  String prenom=var.nextLine();
				  System.out.print("entrez la date de naissance comme:jour mois année");
				  int jour=var.nextInt();
				  int mois=var.nextInt();
				  int annee=var.nextInt();
				  System.out.print("le numero de telephone");
				  long numero=var.nextLong();
				  System.out.print("indiquez l'identifiant");
			    	int id=var.nextInt();
				  Prof_Responsable prof =new Prof_Responsable(nom,prenom,jour,mois,annee,numero,id);
				  secretaire.ajouter_prof_responsable(prof);
		     }break;
		     case 16:{
			    	Filieres filiere=donner_info_filiere();
			    	secretaire.supprimer_filiere(filiere);
			    	
			    }break;
		     case 17:mainMenu();break;
		     case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		      }break;
		     
		}
		
	}
		}catch(InputMismatchException e) {
			System.out.print("eurreur vous devez entrez un entier \n");
		}
	}
	private void menu_Prof(Professeur prof) {
		int choice=1;
		Scanner var=new Scanner(System.in);
		try {
		while(choice!=0) {
	    System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("1:afficher liste de filieres enseigner \n");
		System.out.print("2:afficher liste de matiere enseigner \n");
		System.out.print("3:reserver  une salle pour un cours \n \t\t\t");
		System.out.print("\t\t4:afficher les salle disponible\n");
		System.out.print("\t\t5:revenir au menu precedent \n");
		System.out.print("\t\t0:Quitter \n");
		System.out.print("Entrez votre choix \n");
		System.out.println("+----------------------------------------------------------------------------+");
		choice=var.nextInt();
		switch(choice) {
		      case 1:prof.afficher_filiere_enseigner();break;
		      case 2:prof.afficher_matiere_enseigner();break;
		      case 3:{
		    	  
			    	 int id_salle=indiquez_salle();
		    	  prof.reserver_salle(id_salle);
		      }break;
		      case 4:prof.afficher_salle_dispo();break;
		      case 5:mainMenu();break;
		}
		
		
		}
		}catch(InputMismatchException e) {
			System.out.print("eurreur vous devez entrez un entier \n");
		}
	}
	private void menu_prof_responssable(Prof_Responsable prof_r) {
		int choice=1;
		Scanner var=new Scanner(System.in);
		try {
		while(choice!=0) {
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("1:planifier une reunion \n");
		System.out.print("2:modifier une reunion \n");
		System.out.print("3:supprimer une reunion \n");
		System.out.print("4:afficher liste des renion \n \t\t\t");
		System.out.print("\t\t5:resrver une salle \n");
		System.out.print("\t\t6:afficher les salle disponible\n");
		System.out.print("\t\t7:revenir au menu principal \n");
		System.out.print("0:Quitter \n");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.print("Entrez votre choix \n");
		choice=var.nextInt();
		switch(choice) {
		      case 1:{
		    	  Reunion reunion=creation_reunion();
			      prof_r.planifier_reunion(reunion);
		      }break;
		      case 2:{
		    	  int id_reunion=indiquez_reunion();
			    	 prof_r.modifier_info_reunion(id_reunion);
		      }break;
		      case 3:{
		    	  int id_reunion=indiquez_reunion();
		    	  prof_r.supprimer_reunion(id_reunion);
		      }break;
		      case 4:prof_r.afficher_reunion();break;
		      case 5:{
		    	  int id_salle=indiquez_salle();
		    	  prof_r.reserver_salle(id_salle);
		      }break;
		      case 6:prof_r.afficher_salle_dispo();break;
		      case 7:mainMenu();break;
		      case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		      }break;
		      
		}
		
		}
		}catch(InputMismatchException e) {
			System.out.print("eurreur vous devez entrez un entier \n");
		}
		
	}
	
    public void mainMenu(){
    	int choice=1;
		Scanner var=new Scanner(System.in);
		try  {
		while(choice!=0) {
        System.out.println("+----------------------------------------------------------------------------+");
        System.out.println("|                     1. SECRETAIRE                                   |");
        System.out.println("|                     2. PROFESSEUR                                          |");
        System.out.println("|                     3. PROFESSEUR RESPONSABLE                             |");
        System.out.println("|                     0. SORTIR                                              |");
        System.out.println("+----------------------------------------------------------------------------+");
        System.out.print("Entrez votre choix \n");
		choice=var.nextInt();
		switch(choice) {
		      case 1:{
		    	  System.out.print("entrez votre mot de pass");
		    	  String pass=var.next();
		    	  
		  		boolean connection=s.se_connecter(pass);
		  		if(connection==true) {
		  			menu_Secretaire(s);
		  		}
		  		
		      }break;
		      case 2:{
		    	  /*
		    	   * 
		    	   ici pour que le professeur puisse se connecter sin idnetifier est chercher dans la liste
		    	   des professeur de l'etablissement qui se trouve dans le classe secretaire
		    	   */
		    	  System.out.print("entrez votre mot de pass");
		    	  String pass=var.next();
		    	 
		    	 boolean connecter= prof2.se_connecter(pass);
		    	 System.out.print("entrez votre identifiant");
		    	 int id=var.nextInt();
		    	 prof2=s.chercher_prof(id);
		    	 if((prof2!=null)&&(connecter==true)) {
		    		 prof2.afficher();
		    		 System.out.print("\n\n");
		    		 menu_Prof(prof2);
		    	 }
		    	 else System.out.print("mot de pass ou id incorrecte\n");
		    	  
		      }break;
		      case 3:{
		    	  /*
		    	   * 
		    	   ici pour que le professeur responsable puisse se connecter sin idnetifier est chercher dans la liste
		    	   des professeur de l'etablissement qui se trouve dans le classe secretaire
		    	   */
		    	  System.out.print("entrez votre mot de pass");
		    	  String pass=var.next();
		    	  Prof_Responsable prof=new Prof_Responsable();
		    	 boolean connecter= prof.se_connecter(pass);
		    	 System.out.print("entrez votre identifiant");
		    	 int id=var.nextInt();
		    	 prof=s.chercher_prof_responsable(id);
		    	 
		    	 if((prof!=null)&&(connecter==true)) {
		    		 prof.afficher();
		    		 menu_prof_responssable(prof);
		    	 }
		    	 else System.out.print("mot de pass ou id incorrecte\n");
		    	 
		      }break;
		      case 0:{
		    	  System.out.print("AUREVOIRE \n");
		    	  System.exit(0);
		    	  
		      }break;
		    	  
		}
        
    }
    }catch(InputMismatchException e) {
		System.out.print("eurreur vous devez entrez un entier \n");
	}
    }
    
}

