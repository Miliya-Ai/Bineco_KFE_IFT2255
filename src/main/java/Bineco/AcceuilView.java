package Bineco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class AcceuilView extends View {
	public boolean isResident;
	public boolean isPasswordEligible;

	public AcceuilView() { //constructeur;
		entete("Page d'accueil");
		out( "**** Pour quitter, appuyer 99 ****");
		out("Bonjour");
		addTabNomOptions("Log in");
		addTabNomOptions("Sign In");
		out(afficherOptions ());
		filtrer();

	}

	public void displayInscription() throws IOException {
		entete("Sign in");
		out( "**** Pour quitter, appuyer 99 ****\n");
		out("Vous êtes un");
		addTabNomOptions("Résident");
		addTabNomOptions("Consommateur");
		out(afficherOptions ());
		typeUtilisateur();

		if (controller.isResident()){
			entete("Resident");
			out( "**** Pour quitter, appuyer 99 ****\n");

			addTabNomOptions("Enregistrer");
			out(afficherOptions ());
			credentials(controller.isResident());


			saveInfo(scannerInput("Nom et prenom : "),0);
			saveInfo(scannerInput("Courriel : "),1);
			saveInfo(scannerInput("Adresse : "),2);
			saveInfo(scannerInput("Telephone : "),3);
			//saveInfo(scannerInput("Numero du premier bac a enregistrer : "), 4);
			checkBac();
			newLine();
			out("\n Appuyer sur 1 pour enregistrer");
			filtrer();
		}

	}

	public void credentials (Boolean isResident) throws IOException {
		out("Veuillez choisir un nom d'utilisateur :");
		Scanner myUser = new Scanner(System.in);
		String userAccount = myUser.nextLine();

		Controller.tempInfo[0] = userAccount;
		passwordEligible(userAccount, isResident);

	}

	public void passwordEligible(String userAccount,boolean isResident) throws IOException {
		// Regex trouver sur https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letters-and-numbers
		out("Choisissez un mot de passe (que des lettres et des chiffres) :");
		Scanner myPass = new Scanner(System.in);
		String password = myPass.nextLine();
		isPasswordEligible =  password.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*");

		if (isPasswordEligible){
			userAccount += " " + password;
			save(userAccount, isResident);

            /*BufferedWriter writer = new BufferedWriter(new FileWriter("src/informations.txt", true));
            writer.write(password + ",");
            writer.close();*/
			Controller.tempInfo[1] = password;
		} else {
			passwordEligible(userAccount, isResident);
		}
	}

	public void typeUtilisateur () {
		Scanner scanner = new Scanner(System.in);
		String stringNumeroOption = scanner.nextLine();

		int intNumeroOption = 0;

		try {
			scanner.close();
			intNumeroOption = Integer.parseInt(stringNumeroOption);
			tabNomOptions.clear();
			if (intNumeroOption == 1){
				controller.setResident(true);
				scanner.close();

			} else if (intNumeroOption == 2){
				controller.setResident(false);
				scanner.close();

			} else {
				out("Svp, entrer un numero valide");
				typeUtilisateur();
			}

		} catch (Exception e) {
			out("Svp, entrer un chiffre");
			typeUtilisateur();

		}

	}

	public void displayConnection() {

	}



	@Override
	public void changerPage(int intNumeroOption) throws IOException {
		switch (intNumeroOption) {
			case 1:
				tabNomOptions.clear();
				displayConnection();
				break;
			case 2:
				tabNomOptions.clear();
				displayInscription();
				break;
			case 99:
				exit();
			default:
				out("Svp, entrer un chiffre valide");
				//filtrer();
		}

	}

}