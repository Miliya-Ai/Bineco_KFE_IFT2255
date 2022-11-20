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
        //saveInfoCons(scannerInput("Code : "), 0);
        checkCode();
        saveInfoCons(scannerInput("Nom : "),1);
        saveInfoCons(scannerInput("Courriel : "),2);
        saveInfoCons(scannerInput("Adresse : "),3);
        saveInfoCons(scannerInput("Telephone : "),4);
        saveInfoCons(scannerInput("Type de dechets traités : "),5);
        saveInfoCons(scannerInput("Capacité de traitement : "),6);

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

    public void checkCode() throws IOException {
        String code = scannerInput("Code :");
        for (int i = 0; i < Controller.municipInfo.listeConsDispo.length; i ++){
            String listBac = Controller.municipInfo.listeConsDispo[i];
            if(listBac.equals(code)){
                saveInfoCons(code, 0);
                return;
            }
        }
        out("Code inexistant ou deja enregistré");
        checkCode();
    }


}
