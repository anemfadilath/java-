package test;

import java.util.Scanner;

import main.Etudiant;
import main.Filieres;
import main.Matiere;
import main.Menu;
import main.Prof_Responsable;
import main.Professeur;
import main.Reunion;
import main.Salle;
import main.Secretaire;

public class Test {
	private void printHeader(){
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                             BIENVENU                                 |");
        System.out.println("|                          SUR NOTRE MENU                              |");
        System.out.println("+----------------------------------------------------------------------+");
    }

	public static void main(String[] args) {
		Menu menu=new Menu();
		menu.mainMenu();
}
}
	

	

