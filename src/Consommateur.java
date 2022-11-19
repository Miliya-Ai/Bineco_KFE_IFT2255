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
        saveInfo(scannerInput("Nom : "),0);
        saveInfo(scannerInput("Courriel : "),1);
        saveInfo(scannerInput("Adresse : "),2);
        saveInfo(scannerInput("Telephone : "),3);
        saveInfo(scannerInput("Type de dechets traités : "),4);
        saveInfo(scannerInput("Capacité de traitement : "),5);
        saveInfo(scannerInput("Activité d'exploitation : "),6);
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
