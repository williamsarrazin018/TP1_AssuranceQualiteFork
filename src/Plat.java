
public class Plat {
	private int prix;
	private String nom;
	
	public Plat(int prix, String nom){
		
		this.nom = nom;
		
		this.prix = prix;
		
	}
	
	public void setNom(String nom){
		
		this.nom = nom;
		
	}
	
	public void setPrix(int prix){
		
		this.prix = prix;
		
	}
	
	public String getNom(){
		
		return this.nom;
		
	}
	
	public int getPrix(int prix){
		
		return this.prix;
		
	}
	
}
