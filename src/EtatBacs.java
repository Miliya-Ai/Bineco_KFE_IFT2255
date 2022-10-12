import java.io.IOException;

public class EtatBacs extends Page{


    public EtatBacs(){
        entete("Etat de mes bacs");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Recyclage : capacite : x%, composition : ...");
        out("Composte : capacite : x%");
        out("Ordures : capacite : x%");
        out("Historique : ");
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
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




