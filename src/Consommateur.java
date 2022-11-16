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
        saveInfo(scannerInput("Nom : "));
        saveInfo(scannerInput("Courriel : "));
        saveInfo(scannerInput("Adresse : "));
        saveInfo(scannerInput("Telephone : "));
        saveInfo(scannerInput("Type de dechets traités : "));
        saveInfo(scannerInput("Capacité de traitement : "));
        saveInfo(scannerInput("Activité d'exploitation : "));
        newLine();
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
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }


}
