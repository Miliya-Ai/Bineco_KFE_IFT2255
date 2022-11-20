package Bineco;

public class Utilisateur {

	private String nomUtilisateur;
	private String hashPassword;
	private String nom;
	private String email;
	private String tel;
	private Address address;
	private boolean valide = false;

	/**
	 * 
	 * @param nomUtilisateur
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * 
	 * @param hashPassword
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public String getHashPassword() {
		return this.hashPassword;
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	/**
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Address getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public void isValide() {
		// TODO - implement Utilisateur.isValide
		throw new UnsupportedOperationException();
	}

}