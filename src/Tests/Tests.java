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
		boolean clientEspaceCorrect = true;
		
		for (int i = 0; i < Facture.tabClients.length; i++) {
			if (client == Facture.tabClients[i]){
				clientCorrect = true;
			}
		}
		if(clientCorrect){
			System.out.println("Nom existant");
			String[]nom = client.split(" ");
			if (nom[1] != null){
				System.out.println("Probleme avec espace");
			}
		} else {
			System.out.println("Nom inexistant");
		}
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
		tabLignesExpected[1] = "C�line 15.75$";
		
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
		tabLignesExpected[1] = "C�line 15.75$";
		tabLignesExpected[2] = "Steeve 5.0$";
		tabLignesExpected[3] = "William 13.0$";
		
		assertEquals(tabLignesExpected, facture.getLignesFactures());
		
		
	}
	
}
