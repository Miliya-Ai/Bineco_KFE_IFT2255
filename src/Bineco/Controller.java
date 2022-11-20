package Bineco;

public class Controller {

	public static Utilisateur loggedUser;
	public static MunicipInfo municipInfo; //fausse donnee
	public static Capteurs capteurs; //fausse donnee
	public static String[] tempInfo; // information du resident
	public static String[] tempInfoCons; // information du consommateur
	public boolean resident;


	public void start(){
		new AcceuilView();
		setLiveAccount();
	}

	//comme a chaque fois qu'on ouvre une session, dn doit creer de nouvelles donnees.
	public void setLiveAccount(){
		tempInfo = new String[5];
		tempInfoCons = new String[7];
		loggedUser = new Utilisateur();
		municipInfo = new MunicipInfo();
		capteurs = new Capteurs();
	}


	/**
	 * 
	 * @param information
	 */
	public void lireConsole(String information) {
		// TODO - implement Controller.lireConsole
		throw new UnsupportedOperationException();
	}

	public String afficherMessageError() {
		// TODO - implement Controller.afficherMessageError
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 *
	 */
	public void setResident(boolean isResident) {
		this.resident = isResident;
	}

	public boolean isResident(){
		return this.resident;
	}

}