
public class CV {
	private String nom;
	private String prenom;
	private String formation;
	private int experienceTravail;
	private String[] competences;
	private String attentesCours;
	
	
	public void afficher(){
		System.out.println("Informations de\n"
				+"Nom : "+this.nom+"\n"
				+"Prénom : "+this.prenom+"\n"
				+"Formation : "+this.formation +"\n"
				+"Experience de travail : "+this.experienceTravail+"\n"
				+"Compétences :");
		
		for (int i = 0; i < competences.length; i++) {
			System.out.println(" "+this.competences[i] +" , ");
		}
		
		System.out.println("\nAttentes du cours : "+this.attentesCours);
				
	}
}

