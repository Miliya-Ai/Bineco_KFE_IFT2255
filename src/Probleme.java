import java.io.IOException;

public class Probleme extends Page{


    public Probleme(){
        entete("Signaler un probleme");
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");
        out("Prenom, nom : ");
        out("Adresse : ");
        out("Courriel : ");
        out("Type de probleme : ");
        out("Commentaire : ");
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
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

}
