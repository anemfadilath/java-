package main;

public class Salle {
	private  String dispo;
	
	
	public Salle(String dispo) {
		this.dispo=dispo;
		
	}
	//private Salle sa=new Salle("disponible");
	public static Salle s[]= new Salle[10];
	
	public  Salle(){
		
		for(int i=0;i<10;i++) {
			Salle.s[i]=new Salle("disponible");
		}
		
	}
	
	public String getDispo() {
		return dispo;
	}
	public void setDispo(String disp) {
		dispo = disp;
		
	}
	public static Salle[] getS() {
		return s;
	}
	public void afficher() {
		System.out.print(""+dispo);
	}
	 public void afficher_salle() {
		for(int i=0;i<10;i++) {
			System.out.print("salle:"+i+"\n");s[i].afficher();System.out.print("\n \t");
		}
	}

	

}
