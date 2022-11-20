package Bineco;

import java.util.ArrayList;

public class Consommateur extends Utilisateur {

	private Dechet dechetsTraite;
	private int capaciteTraitement;
	private ArrayList<String> activiteExploitation;

	/**
	 * 
	 * @param dechetsTraite
	 */
	public void setTypeDechetsTraite(Dechet dechetsTraite) {
		// TODO - implement Consommateur.setTypeDechetsTraite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activiteExploitation
	 */
	public void setActivitExploitation(String activiteExploitation) {
		// TODO - implement Consommateur.setActivitExploitation
		throw new UnsupportedOperationException();
	}

	public Dechet getDechetsTraite() {
		return this.dechetsTraite;
	}

	public ArrayList<String> getActiviteExploitation() {
		return this.activiteExploitation;
	}

	/**
	 * 
	 * @param index
	 */
	public String getNoteActiviteExploitation(int index) {
		// TODO - implement Consommateur.getNoteActiviteExploitation
		throw new UnsupportedOperationException();
	}

}