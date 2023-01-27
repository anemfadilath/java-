package util;

public class Date {


		
		private int jour;
		private int mois;
		private int annee;
		
		public Date() {

	}
	 public Date(int j,int m,int a){ 
		 if (j>0&&j<=31) {
		 this.setJour(j);
		 }
		 if (m>0&&m<=12) {
		 this.setMois(m);
		 }
		 if(a>1700) {
		 this.setAnnee(a);
		 }
		 
		 
		 
	 }
	public void setAnnee(int a) {
		this.annee=a;
		
	}
	public void setMois(int m) {
		this.mois=m;
		
	}
	public void setJour(int j) {
		this.jour=j;
		
	}
	public void afficher()
	{
		System.out.println(this.jour+":"+this.mois+":"+":"+this.annee);

	}
	public String getDate() {
		return this.annee+ ":"+ this.mois+":"+this.annee;
		
	}

}



