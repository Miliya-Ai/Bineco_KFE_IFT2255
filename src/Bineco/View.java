package Bineco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private ArrayList<View> history;
	private int viewIndex;
	public Controller controller = new Controller();
	protected ArrayList<String> tabNomOptions = new ArrayList<String>() ;


	public void display() {

	}

	/**
	 * 
	 * @param option
	 */
	public void navigate(String option) {
		switch (option) {
			case "AccueilView":
				tabNomOptions.clear();
				new AcceuilView();
				break;
			case "ProfilView":
				tabNomOptions.clear();
				new ProfilView();
				break;
			case "BacView":
				tabNomOptions.clear();
				new BacView();
				break;
			case "MetriqueView":
				tabNomOptions.clear();
				new MetriqueView();
				break;
			case "MenuResidentView":
				tabNomOptions.clear();
				new MenuResidentView();
				break;
			case "MenuConsommateurView":
				tabNomOptions.clear();
				new MenuConsommateurView();
				break;
		}

	}

	public void exit() {
		System.exit(0);
	}

	/**
	 * 
	 * @param view
	 */
	public void addView2History(View view) {
		// TODO - implement View.addView2History
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param viewIndex
	 */
	public void setViewIndex(int viewIndex) {
		this.viewIndex = viewIndex;
	}

	/*
	/**
	 *
	 * @param msg

	public void printMsg(String msg) {
		System.out.println(msg);
	}
	 */

	public void entete (String nomPage){
		/*
		out("\n"
				+ "################ " + nomPage + " ##################" +"  Session de : "+Controller.liveUser.user
				+ "\n");
		 */

		out("\n"
				+ "################ " + nomPage + " ##################"
				+ "\n");
	}

	public void out (String message){
		System.out.println(message);
	}

	public String afficherOptions () {
		String optionDonnee = "";
		int lenghtTabNomOptions = tabNomOptions.size() ;
		int indexTab = 0;
		for (int i = 1; i <= lenghtTabNomOptions; i++){
			optionDonnee += "[" + i + "]: " + tabNomOptions.get(indexTab) + "\n";
			indexTab += 1;
		}
		return optionDonnee;
	}

	public void addTabNomOptions(String option) {
		this.tabNomOptions.add(option);
	}

	public void filtrer () {
		Scanner scanner = new Scanner(System.in);
		String stringNumeroOption = scanner.nextLine();

		int intNumeroOption = 0;

		try {
			intNumeroOption = Integer.parseInt(stringNumeroOption);
			changerPage(intNumeroOption);
			scanner.close();

		} catch (Exception e) {
			out("Svp, entrer un chiffre");
			filtrer();

		}

	}
	public void changerPage(int intNumeroOption) throws IOException {

	}

}