import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Resident extends Client{

    /**
     * @throws IOException
     */
    public Resident()throws IOException{
        entete("Resident");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Enregistrer");
        out(afficherOptions ());

        credentials(true);


        saveInfo(getName(),0);
        saveInfo(scannerInput("Courriel : "),1);
        saveInfo(scannerInput("Adresse : "),2);
        saveInfo(getTel(),3);
        //saveInfo(scannerInput("Numero du premier bac a enregistrer : "), 4);
        checkBac();
        newLine("src/main/java/informations.txt");
        out("\n Appuyer sur 1 pour enregistrer");
        filtrer();

    }

    /**
     * @return
     */
    public String getName(){
        String input = scannerInput("Nom (doit debuter par une lettre masjuscule) :  ");

        if(!Character.isUpperCase(input.charAt(0))){
            out("Input invalide (premiere lettre pas majuscule)");
            getTel();
        }
        return input;
    }

    /**
     * @return
     */
    public String getTel(){
        String input = scannerInput("Telephone (doit etre de longueur 10) :  ");
        if(input.length() != 10){
            out("Input invalide (pas 10 de long)");
            getTel();
        }
        return input;
    }


    /**
     * @param intNumeroOption
     * @throws IOException
     */
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

    /**
     * @throws IOException
     */
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
