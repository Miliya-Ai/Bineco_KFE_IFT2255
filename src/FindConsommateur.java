import java.io.IOException;

public class FindConsommateur extends Page{

    public FindConsommateur(){
        entete("Trouver un consommateur");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Choix du type de consommateur (composte, recyclage, etc...");
        out("Filtre de recherche (exemple : rayon km)");
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 99:
                System.exit(0);
                effacer();
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

}
