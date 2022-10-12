import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Consommateur extends Client{

    public Consommateur() throws IOException {
        entete("Consommateur");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Enregistrer");
        out(afficherOptions ());

        credentials(false);
        scannerInput("Nom : ");
        scannerInput("Courriel : ");
        scannerInput("Adresse : ");
        scannerInput("Telephone : ");
        scannerInput("Type de dechets traités : ");
        scannerInput("Capacité de traitement : ");
        scannerInput("Activité d'exploitation : ");
        out("\n Appuyer sur 1 pour enregistrer");
        filtrer();

    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new PageAccueil();
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
