public class FindConsommateur extends Page{

    public FindConsommateur(){
        entete("Trouver un consommateur");


        out("Choix du type de consommateur (composte, recyclage, etc...");
        out("Filtre de recherche (exemple : rayon km)");
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }

}
