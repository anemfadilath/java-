package util;

public class Heure {
private int heure;
private int min;
public Heure() {
	
}
public Heure(int heure, int min) {
	super();
	this.heure = heure;
	this.min = min;
}
public void afficher_heur() {
	
	System.out.print(""+heure+"/"+min);
}

}
