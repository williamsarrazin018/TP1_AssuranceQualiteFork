package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.Facture;

public class Tests {

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
	
	
	
}
