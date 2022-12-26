import java.io.File;
import java.util.HashMap;

/**
 * Donnees (hardcodees) qui vont etre manipulees par {@link Bacs}
 */
public class Capteurs {


    public HashMap<String, String[]> capteursList = new HashMap<>();
    public String[][] historique = new String[][]{{"0,24;categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25",
                                                    "0,44;categorie1 : 0,47;categorie2 : 0,28;categorie3 : 0,25",
                                                    "0,68;categorie1 : 0,40;categorie2 : 0,30;categorie3 : 0,30"},

                                                    {"0,12;categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25",
                                                    "0,32;categorie1 : 0,27;categorie2 : 0,38;categorie3 : 0,35",
                                                    "0,40;categorie1 : 0,30;categorie2 : 0,40;categorie3 : 0,30"},

                                                    {"0,33;categorie1 : 0,60;categorie2 : 0,15;categorie3 : 0,25",
                                                    "0,51;categorie1 : 0,27;categorie2 : 0,35;categorie3 : 0,38",
                                                    "0,60;categorie1 : 0,35;categorie2 : 0,35;categorie3 : 0,30"}};

    /**
     * Instancie les donnees (hardcodees) des capteurs
     */
    public Capteurs(){
        setCapteurs();
    }

    /**
     * Pour chaque bac, mettre son numero, sa capacite et sa composition dans la "base de donnee" du capteur.
     */
    public void setCapteurs(){

        capteursList.put("r00", new String[] {"0,70", "plastique : 0,50;verres: 0,25;metaux : 0,25"});
        capteursList.put("co00", new String[] {"0,55", "residus de jardin : 0,50;residus de table : 0,25;litiere d'animaux : 0,25"});
        capteursList.put("d00", new String[] {"0,82"});

        capteursList.put("r01", new String[] {"0,33", "papiers : 0,50;cartons : 0,25;metaux : 0,25"});
        capteursList.put("co01", new String[] {"0,75", "pelures : 0,50;produits laitiers: 0,25;feuilles mortes: 0,25"});
        capteursList.put("d01", new String[] {"0,50"});

        capteursList.put("r02", new String[] {"0,25", "plastique : 0,50;cartons : 0,25;papiers: 0,25"});
        capteursList.put("co02", new String[] {"0,80", "litiere d'animaux : 0,50;pelures : 0,25;feuilles mortes : 0,25"});
        capteursList.put("d02", new String[] {"0,65"});

    }







}
