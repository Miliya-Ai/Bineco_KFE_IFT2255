import java.io.IOException;

public class Activites extends Page{


    public Activites(){
        entete("Activitees auxquelles je participe");
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Activitees auxquelles je participe :");
        out("exemple : composte et recycalge.");
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
