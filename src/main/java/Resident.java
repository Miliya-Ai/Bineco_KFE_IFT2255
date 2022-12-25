import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Insciption d'un resident
 */
public class Resident extends Client{

    /**
     * Constructeur de Resident : Imprime les champs que le resident doit remplir et sauvegarde l'information.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public Resident() throws IOException{
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
    //TODO: check ce qui arrive lorsqu'on met un nom legal non valide, pourquoi on va a tel?
    /**
     * Demande un nom legal qui doit commencer par une lettre majuscule.
     * @return le nom legal valide
     */
    public String getName(){
        String input = scannerInput("Nom (doit debuter par une lettre masjuscule) :  ");

        if(!Character.isUpperCase(input.charAt(0))){
            out("Input invalide (premiere lettre pas majuscule)");
            getName();
        }
        return input;
    }

    /**
     * Demande un numero de telephone de 10 chiffres de format: 5145145145
     * @return le numero de telephone valide
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
     * Une fois l'information enregistrer, le resident revient a la page d'accueil ou il pourra se connecter pour
     * aller a son menu correspondant.
     * @param intNumeroOption Le resident choisit d'enregistrer l'information en appuyant sur 1.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
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
    //TODO: qu'arrive-t-il lorsque le numero du bac a deja ete enregistre par un autre utilisateur?
    /**
     * Verifie le numero du bac du resident. Si le numero n'existe pas, lui avertir par
     * un message.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
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
