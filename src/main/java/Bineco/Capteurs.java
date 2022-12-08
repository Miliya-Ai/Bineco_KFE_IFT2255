package Bineco;

import java.util.HashMap;

public class Capteurs {

	public HashMap<String, String[]> capteursList = new HashMap<>();

	public Capteurs(){
		setCapteurs();
	}

	public void setCapteurs(){

		capteursList.put("r00", new String[] {"0,70", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("co00", new String[] {"0,55", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("d00", new String[] {"0,82"});

		capteursList.put("r01", new String[] {"0,33", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("co01", new String[] {"0,75", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("d01", new String[] {"0,50"});

		capteursList.put("r02", new String[] {"0,25", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("co02", new String[] {"0,80", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
		capteursList.put("d02", new String[] {"0,65"});

	}


	/**
	 * 
	 * @param bac
	 */
	public int getUpdateCapaciteActuelle(Bac bac) {
	return 3; 
	}

	/**
	 * 
	 * @param bac
	 */
	public String getUpdateCompositionActuelle(Bac bac) {
	return "Capteur";
	}

	public String[][] historique = new String[][]{{"0,24;categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25",
			"0,44;categorie1 : 0,47;categorie2 : 0,28;categorie3 : 0,25",
			"0,68;categorie1 : 0,40;categorie2 : 0,30;categorie3 : 0,30"},

			{"0,12;categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25",
					"0,32;categorie1 : 0,27;categorie2 : 0,38;categorie3 : 0,35",
					"0,40;categorie1 : 0,30;categorie2 : 0,40;categorie3 : 0,30"},

			{"0,33;categorie1 : 0,60;categorie2 : 0,15;categorie3 : 0,25",
					"0,51;categorie1 : 0,27;categorie2 : 0,35;categorie3 : 0,38",
					"0,60;categorie1 : 0,35;categorie2 : 0,35;categorie3 : 0,30"}};




}