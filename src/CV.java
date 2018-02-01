
public class CV {
	private String nom;
	private String prenom;
	private String formation;
	private int experienceTravail;
	private String competences;
	private String attentesCours;
	
	public CV (String nom, String prenom,String formation, int experienceTravail, String competences, String attentesCours ){
		
		nom = this.nom;
		prenom = this.prenom;
		formation = this.formation;
		experienceTravail = this.experienceTravail;
		competences = this.competences;
		attentesCours = this.attentesCours;
				
	}
	
	public void afficher(){
		System.out.println("Informations de\n"
				+"Nom : "+this.nom+"\n"
				+"Prénom : "+this.prenom+"\n"
				+"Formation : "+this.formation +"\n"
				+"Experience de travail : "+this.experienceTravail+"\n"
				+"Compétences :");
		
		System.out.println("\ncompetences : "+this.competences);
		
		System.out.println("\nAttentes du cours : "+this.attentesCours);
				
	}
}

