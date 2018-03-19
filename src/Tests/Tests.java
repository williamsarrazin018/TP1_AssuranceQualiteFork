package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.Facture;

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
			String
			boolean nomPlat =true;
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
		tabLignesExpected[1] = "Céline 15.75$";
		
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
		tabLignesExpected[1] = "Céline 15.75$";
		tabLignesExpected[2] = "Steeve 5.0$";
		tabLignesExpected[3] = "William 13.0$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
	//William
	@SuppressWarnings("deprecation")
	@Test
	public void testLignesFactureAvecErreurFormatNom() {
		
		String fichierTest = ".\\testErreurNom.txt";
		
		Facture facture = new Facture();
		
		facture.gererCommandes(fichierTest);
		
		facture.lignesFacture();
		
		String[] tabLignesExpected = new String[20];
		tabLignesExpected[0] = "Erreur de format : Céline t Frites 2";
		tabLignesExpected[1] = "Erreur de format : Céline t Repas_Poulet 1";
		tabLignesExpected[2] = "Roger 10.5$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
}
