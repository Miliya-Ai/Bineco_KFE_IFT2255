import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Resident extends Client{

    public Resident()throws IOException{
        entete("Resident");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Enregistrer");
        out(afficherOptions ());

        credentials(true);
        scannerInput("Nom et prenom : ");
        scannerInput("Courriel : ");
        scannerInput("Adresse : ");
        scannerInput("Telephone : ");
        scannerInput("Numero du premier bac a enregistrer : ");
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
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }


}
