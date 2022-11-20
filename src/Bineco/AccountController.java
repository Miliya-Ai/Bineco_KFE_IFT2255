package Bineco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountController extends Controller {

	private boolean passwordValide;

	public String scannerInput(String message){
		out(message);
		Scanner temp = new Scanner(System.in);
		String wut = temp.nextLine();
		temp.close();
		return wut;
	}

	public void save(String content, Boolean isResident)throws IOException {
		String path;
		if (isResident){
			path = "src/Bineco/passResident.txt";
		}else {
			path = "src/Bineco/passConsommateur.txt";}

		FileWriter fw = new FileWriter(path,true);
		BufferedWriter writer = new BufferedWriter(fw);
		writer.append(content +"\n"  );
		writer.flush();
		writer.close();
	}



	public void creerAccount() {
		// TODO - implement Bineco.AccountController.creerAccount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loggedUser
	 */
	public void deleteAccount(Utilisateur loggedUser) {
		// TODO - implement Bineco.AccountController.deleteAccount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loggedUser
	 * @param contenuModifie
	 */
	public void modifierProfil(Utilisateur loggedUser, String contenuModifie) {
		// TODO - implement Bineco.AccountController.modifierProfil
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loggedUser
	 */
	public void passwordValide(Utilisateur loggedUser) {
		// TODO - implement Bineco.AccountController.passwordValide
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Utilisateur
	 */
	public void logOut(int Utilisateur) {
		// TODO - implement Bineco.AccountController.logOut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 */
	public void hashPassword(String password) {
		// TODO - implement Bineco.AccountController.hashPassword
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param passwordValide
	 */
	public void logIn(boolean passwordValide) {
		// TODO - implement Bineco.AccountController.logIn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loggedUser
	 */
	public Activite findActiviteMaintenu(Utilisateur loggedUser) {
		// TODO - implement Bineco.AccountController.findActiviteMaintenu
		throw new UnsupportedOperationException();
	}

	public void out (String message){
		System.out.println(message);
	}



}