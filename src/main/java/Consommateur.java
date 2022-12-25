import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Inscription d'un consommateur
 */
public class Consommateur extends Client{
    //TODO: check si on enregistre les activites
    /**
     * Constructeur de Consommateur : Imprime les champs que le consommateur doit remplir et sauvegarde l'information.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public Consommateur() throws IOException {
        entete("Consommateur");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Enregistrer");
        out(afficherOptions ());
        String info = "";
        credentials(false);
        //saveInfoCons(scannerInput("Code : "), 0);
        info += checkCode()+",";

        info += saveInfoCons(getName(),1)+",";
        info += saveInfoCons(traitement(), 2)+",";
        info += saveInfoCons(scannerInput("Courriel : "),2)+",";
        info += saveInfoCons(scannerInput("Adresse : "),3)+",";
        info += saveInfoCons(getTel(),4);
        /*info += saveInfoCons(scannerInput("Type de dechets traités : "),5)+",";
        info += saveInfoCons(scannerInput("Capacité de traitement : "),6);*/

        newLine("src/main/java/dataCons.txt");
        newLine("src/main/java/informationsCons.txt");
        Controller.municipInfo.addCons(info);
        Controller.municipInfo.setConsommateurs();
        //newLine();
        out("\n Appuyer sur 1 pour enregistrer");

        filtrer();

    }
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
     * Une fois l'information enregistrer, le consommateur revient a la page d'accueil ou il pourra se connecter pour
     * aller a son menu correspondant.
     * @param intNumeroOption Le consommateur choisit d'enregistrer l'information en appuyant sur 1.
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
                //effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

    /**
     * Demande le type de dechet soit recyclage, compostage ou dechet et sa capacite de traitement.
     *
     * @return le chiffre correspondant au type de dechet traite
     * <ol>
     *     <li>Recyclage</li>
     *     <li>Compostage</li>
     *     <li>Dechets</li>
     * </ol>
     */
    public String traitement(){
        String value = "";
        String type = scannerInput("Type de dechet traité : \n1- Recyclage\n2-Composte\n3-Dechets");
        if(!(type.equals("1")||type.equals("2")||type.equals("3"))){
            out("Input erroné");
            traitement();
        } else {
            switch (type){
                case "1":
                    String qty = scannerInput("Quantité : ");
                    value+= "recyclage:"+qty;
                    break;
                case "2":
                    String qty2 = scannerInput("Quantité : ");
                    value+= "composte:"+qty2;
                    break;
                case "3":
                    String qty3 = scannerInput("Quantité : ");
                    value+= "dechets:"+qty3;
                    break;
            }
        }
        return value;
    }

    /**
     * Verifie le code identifiant du consommateur. Si le code n'existe pas ou a deja ete enregistre, lui avertir par
     * un message.
     * @return le code identifiant du consommateur
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public String checkCode() throws IOException {
        String code = scannerInput("Code :");
        for (int i = 0; i < Controller.municipInfo.listeConsDispo.length; i ++){
            String listBac = Controller.municipInfo.listeConsDispo[i];
            if(listBac.equals(code)){
                //saveInfoCons(code, 0);
                return code;
            }
        }
        out("Code inexistant ou deja enregistré");
        checkCode();
        return code;
    }


}
