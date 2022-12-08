package Bineco;

import java.util.*;

public class Resident extends Utilisateur {

	private String prenom;
	private ArrayList<Bac> bacs;

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @param bac
	 */
	public void addBacs(Bac bac) {
		// TODO - implement Resident.addBacs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param valid
	 */
	public void setValid(Boolean valid) {
		// TODO - implement Resident.setValid
		throw new UnsupportedOperationException();
	}

	public String getPrenom() {
		return this.prenom;
	}

	public ArrayList<Bac> getBacs() {
		return this.bacs;
	}

}