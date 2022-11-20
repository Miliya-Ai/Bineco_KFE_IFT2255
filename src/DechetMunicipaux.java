import java.io.IOException;

public class DechetMunicipaux extends Page{


    public DechetMunicipaux(){
        entete("Etat de traitement des dechets municipaux");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Recuperation : ");
        out("Livraison : ");
        out("Usage : ");
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                if (liveUser.res){
                    new Menu();
                } else {
                    new MenuConsommateur();
                }
                break;
            case 99:
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
