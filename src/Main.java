
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static final String fichier = ".\\commande.txt";
	
	public static void main(String[] args) {

		//Partie 1
		
		CV cv1 = new CV("Sarrazin", "William", "Collégiale", 1, "Programmation", "Apprendre de nouvelles choses");
		
		CV cv2 = new CV("Torres", "Agustin", "Collégiale", 2, "Prog", "Apprendre");
		
		System.out.println("Bienvenue chez Barette!\nFactures:");
		
		//cv1.afficher();
		
		//cv2.afficher();
		
		//Partie 2

		BufferedReader bReader = null;
		FileReader fReader = null;

		try {

			//Tableaux pour stocker les informations
			String tabClients[] = new String[20];
			Plat tabPlats[] = new Plat[20];
			Commande tabCommandes[] = new Commande[20];
			
			boolean clients = false;
			boolean plats = false;
			boolean commandes = false;
			
			int cptClient = 0;
			int cptPlat = 0;
			int cptCommande = 0;
			
			//Lire le contenu du fichier et le mettre dans les tableaux
			fReader = new FileReader(fichier);
			bReader = new BufferedReader(fReader);

			String ligneCourrante;

			while ((ligneCourrante = bReader.readLine()) != null) {
				if (ligneCourrante.contains("Clients")) {
					
					clients = true;
					
				} else if (ligneCourrante.contains("Plats")){
					
					clients = false;
					plats = true;
					
				} else if (ligneCourrante.contains("Commandes")) {
					
					plats = false;
					commandes = true;
					
				}
				
				if (clients) {
					
					tabClients[cptClient] = ligneCourrante;
					
					cptClient++;
					
				}
				
				
				if (plats && !ligneCourrante.contains("Plats")) {
					
					String[] plat = ligneCourrante.split(" ");				
					Plat platTmp = new Plat(Double.parseDouble(plat[1]), plat[0]);
					tabPlats[cptPlat] = platTmp;
					cptPlat++;
				}
				
				if (commandes && !ligneCourrante.contains("Commandes") && !ligneCourrante.contains("Fin")) {
					
					try {
						
						String[] commande =  ligneCourrante.split(" ");
						Commande commandeTmp = new Commande(commande[0], commande[1], Integer.parseInt(commande[2]));
						tabCommandes[cptCommande] = commandeTmp;
						cptCommande++;
						
					} catch (Exception formatInvalide) {
						
						System.out.println("Le fichier ne respecte pas le format demandé!");
						
					}
					
				}
				
				
			}
			
				//Faire les factures
				for (int i = 1; i < cptClient; i++) {
				
				double prix = 0;
				
				for (int j = 0; j < cptCommande; j++) {
					
					if (tabClients[i].equals(tabCommandes[j].getNomClient())) {
						
						boolean trouve = false;
						
						for (int k = 0; k <= cptPlat && !trouve; k++) {
							
							if (tabPlats[k].getNom().equals(tabCommandes[j].getNomPlat())) {
								
								prix += tabPlats[k].getPrix() * tabCommandes[j].getQte();
								trouve = true;
								
							} else {
								
								prix += 0;
								
							}
						}
						
					} 
					
				}
				
				System.out.println(tabClients[i] + " " + prix + "$");
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bReader != null)
					
					bReader.close();
				

				if (bReader != null)
					
					bReader.close();
				

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
		
		
}


