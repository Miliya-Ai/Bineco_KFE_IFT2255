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


        saveInfo(scannerInput("Nom et prenom : "),0);
        saveInfo(scannerInput("Courriel : "),1);
        saveInfo(scannerInput("Adresse : "),2);
        saveInfo(scannerInput("Telephone : "),3);
        //saveInfo(scannerInput("Numero du premier bac a enregistrer : "), 4);
        checkBac();
        newLine("src/main/java/informations.txt");
        out("\n Appuyer sur 1 pour enregistrer");
        filtrer();

    }

    /*public void saveInfo(String info) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/informations.txt", true));
        writer.write(info + ",");
        writer.close();
    }

    public void newLine() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/informations.txt", true));
        writer.write("\n");
        writer.close();
    }*/

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new PageAccueil();
                break;
            case 99:
                //effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

    public void checkBac() throws IOException {
        String bac = scannerInput("Numero du premier bac a enregistrer :");
        for (int i = 0; i < Controller.municipInfo.numerosBac.length; i ++){
            String listBac = Controller.municipInfo.numerosBac[i];
            if(listBac.equals(bac)){
                saveInfo(bac, 4);
                return;
            }
        }
        out("Numero de bac inexistant");
        checkBac();
    }


}
