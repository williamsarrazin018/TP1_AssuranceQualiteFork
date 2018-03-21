package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.Facture;
import Main.Plat;

public class Tests {

	//Agustin
	@Test
	public void verifierClientTest() {
		Facture.tabClients[0] = "allo5 aulo";
		String client = "allo5 aulo";
		
		boolean clientCorrect = false;
		
		
		for (int i = 0; i < Facture.tabClients.length; i++) {
			if (client == Facture.tabClients[i]){
				clientCorrect = true;
			}
		}
		if(clientCorrect){
			System.out.println("Nom existant");
			String[]nom = client.split(" ");
			if (nom.length > 1){
				System.out.println("Probleme avec espace");
			}
		} else {
			System.out.println("Nom inexistant");
		}
	}
	
	//Agustin
		@Test
			public void verifierPlatTest() {
				Plat plat = new Plat(12,"platTest22");
				String nomTest= "platTest22";
				plat.setNom(nomTest);
				Plat plat1 = new Plat(12,"platTEst");
				Plat plat2 = new Plat(12,"platTest22");
				
				plat2.setNom("platTest22");
			
				Facture.tabPlats[0] = plat1;
				Facture.tabPlats[1] = plat2;
				boolean nomPlat = false;
				Plat test = new Plat(12,"platTest 22");
				
				for (int i = 0; i < 2 ; i++) {

					if ( plat.getNom() == Facture.tabPlats[i].getNom() ){
						nomPlat = true;	
						test.setNom("platTest22");
						
					}
					
					if(nomPlat == true){
						String[]tabPlat = plat.getNom().split(" ");
						if (tabPlat.length > 2){
							System.out.println("Probleme avec espace");//pour test
							nomPlat = false;
						}
						
					}
					
				}
				
				assertEquals(Facture.tabPlats[1].getNom(), test.getNom());
			
			
			}
	
	
	

	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFactureAvecTotalDe0() {
		
		String fichierTest = ".\\testFacture0.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Céline 15.75$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFactureFicSansErreur() {
		
		String fichierTest = ".\\testFactureSansErreur.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Céline 15.75$";
		tabLignesExpected[1] = "Steeve 5.0$";
		tabLignesExpected[2] = "William 13.0$";
		

		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFacturesErreurPlat() {
		
		String fichierTest = ".\\testErreurPlat.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Erreur plat introuvé : Céline Repas_Pouletxxxxx 1";
		tabLignesExpected[2] = "Céline 5.0$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFactureAvecErreurFormatNom() {
		
		String fichierTest = ".\\testErreurFormat.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Erreur de format : Céline t Frites 2";
		tabLignesExpected[1] = "Erreur de format : Céline t Repas_Poulet 1";
		tabLignesExpected[2] = "Roger 10.5$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFactureQteInvalide() {
		
		String fichierTest = ".\\testErreurQte.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Erreur quantité invalide : Steeve Frites -1";
		tabLignesExpected[1] = "Céline 20.75$";
		tabLignesExpected[2] = "Steeve 2.5$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
}
