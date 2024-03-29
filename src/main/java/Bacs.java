import java.io.*;
import java.util.Scanner;

/**
 * Manipulation de bacs: enregistrer, supprimer ou voir son etat
 */
public class Bacs extends Page{

    /**
     * Constructeur de Bacs: Imprime les options valident
     *
     * @see #changerPage(int) 
     */
    public Bacs(){
        entete("Mes bacs");
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Enregistrer un bac");
        addTabNomOptions("Supprimer un bac");
        addTabNomOptions("Etat de mes bacs");
        addTabNomOptions("Trouver un bac");
        addTabNomOptions("Voir l'historique de mes bacs");
        out(afficherOptions());

        filtrer();
    }

    /**
     * @param intNumeroOption Le resident choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Enregistrer un bac</li>
     *                        <li>Supprimer un bac</li>
     *                        <li>Etat de mes bacs</li>
     *                        <li>Trouver un bac</li>
     *                        <li>Voir l'historique de mes bacs</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     *
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 1:
                tabNomOptions.clear();
                enregistrerBac();
                break;
            case 2:
                tabNomOptions.clear();
                supprimerBac();
                break;
            case 3:
                tabNomOptions.clear();
                etatBacs();
                break;
            case 4:
                tabNomOptions.clear();
                getBac();
                break;
            case 5:
                tabNomOptions.clear();
                historiqueBac();
                break;
            case 99:
                System.exit(0);

                break;
            default:
                filtrer();
        }
    }

    /**
     * @param message texte que le resident entre dans la console
     * @return le string lu
     */
    public String scannerInput(String message){
        out(message);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }


    /**
     * Verifie le bac a enregistrer.
     * <p>
     * Si le bac a enregistrer se trouve deja parmi la liste de bacs du resident, lui avertir par un message.
     * Si le bac a enregistrer ne se trouve pas dans la base de donnee de Bineco, lui avertir par un message.
     * Sinon, le nouveau bac sera associe au compte du resident. Il en a le droit a maximum 3.
     * Apres, la page de Bacs s'affiche une autre fois.
     * </p>
     *
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void enregistrerBac() throws IOException {
        String num = scannerInput("Numero du bac a enregistrer : ");
        for (int k = 0; k < Controller.municipInfo.numerosBac.length; k++){
            if(Controller.municipInfo.numerosBac[k].equals(num)){

                for(int i = 0; i < 3; i++){
                    if(num == Controller.liveUser.numeroBac[i]){
                        out("Bac deja enregistré! ");
                        tabNomOptions.clear();
                        new Bacs();
                        return;

                    }
                    if(Controller.liveUser.numeroBac[i] == null){
                        Controller.municipInfo.newBac(Controller.municipInfo.toArrL(), num);
                        out("Bac enregistré");
                        for(int m = 0; m < 3; m++){
                            Controller.liveUser.numeroBac[m] = null;
                        }
                        Controller.liveUser.getInfoRes(Controller.liveUser.user);
                        tabNomOptions.clear();
                        new Bacs();
                        return;
                    }
                }

            }
        }
        out("Bac inexistant!");
        new Bacs();
        return;

    }

    /**
     * Le bac en question ne sera plus associe au compte du resident.
     * <p>
     *     Affiche les bacs associes a son compte afin que le resident puisse choisir lequel supprimer.
     *     Si le numero de bac a supprimer n'est pas valide, lui avertir par un message. Apres, la page de Bacs
     *     s'affiche de nouveau.
     * </p>
     *
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void supprimerBac() throws IOException {

        String[] temp = new String[3];
        out("Voici vos bacs : ");
        int k = 1;
        for( int i = 0; i < 3; i++){
            if(Controller.liveUser.numeroBac[i] != null){
                temp[k-1] = Controller.liveUser.numeroBac[i];
                out(k +"-  " +Controller.liveUser.numeroBac[i]);
                k++;
            }
        }
        String num = scannerInput("Quel bac voulez nous supprimer? (numero correspondant) : ");
        int numInt = Integer.parseInt(num);

        for (int j = 1; j <= k; j++){
            if(numInt == j){
                String numero = Controller.liveUser.numeroBac[numInt-1];
                Controller.municipInfo.deleteBac(Controller.municipInfo.toArrL(), numero);
                out("Bac supprimé!");
                for(int m = 0; m < 3; m++){
                    Controller.liveUser.numeroBac[m] = null;
                }
                Controller.liveUser.getInfoRes(Controller.liveUser.user);
                new Bacs();
                return;
            }
        }

        out("Erreur dans la suppression");
        tabNomOptions.clear();
        new Bacs();
    }


    /**
     * Affiche l'etat de tous les bacs associes au resident.
     * <p>
     * Les etats d'un bac :
     * <ol>
     *     <li>Capacite</li>
     *     <li>Composition</li>
     * </ol>
     *
     */
    public void etatBacs(){

        for(int i = 0; i < 3; i++){
            String bac = Controller.liveUser.numeroBac[i];
            if (bac != null){
                String[] capComp = Controller.capteurs.capteursList.get(bac);
                if(capComp.length != 1){
                    String[] composition = Controller.capteurs.capteursList.get(bac)[1].split(";");
                    String afficher2 = Controller.capteurs.capteursList.get(bac)[0];
                    String afficherComp = "";
                    for (int j = 0; j < composition.length; j++){
                        afficherComp += composition[j] +"     ";
                    }
                    out(bac +"-->    Capacité : "+afficher2  + "     Composition : "+afficherComp);
                } else {
                    String cap = Controller.capteurs.capteursList.get(bac)[0];
                    out(bac +"-->    Capacité : "+cap);
                }
            }
        }
        filtrer();
    }

    /**
     * Affiche les informations associees au bac que le resident veut connaitre.
     * <p>
     *     Les informations  exhibees :
     *     <ol>
     *         <li>Code</li>
     *         <li>Adresse</li>
     *         <li>Date d'emision</li>
     *     </ol>
     *     Si le numero de bac n'est pas associe a son compte, lui afficher le messager. La page Bacs se reaffiche.
     *
     */
    public void getBac(){

        String numero = scannerInput("Numero du bac :");
        String[] listBac = Controller.municipInfo.numerosBac;

        String[][] bacs = Controller.municipInfo.lesBacs;
        for (int k = 0; k < bacs.length; k++){
            if (bacs[k][0].equals(numero)){

                out("Code : "+numero+"  Adresse : "+bacs[k][1]+"  Date d'emission : "+bacs[k][2]);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }
        out("Numero de bac non-existant");
        new Bacs();

    }

    /**
     * Affiche les donnees de tous les bacs du resident dans les 3 derniers jours.
     *
     * <p>
     *     Les données:
     *     <ol>
     *         <li>Capacite</li>
     *         <li>Composition</li>
     *     </ol>
     *
     */
    public void historiqueBac(){
        int idx = 0;
        for (int i = 0; i < 3; i++){
            String bac = Controller.liveUser.numeroBac[i];
            if(bac != null){
                String[] someBac = Controller.capteurs.historique[idx];
                out("\nHistorique du bac "+bac+" dans les 3 derniers jours : ");
                for (int j = 0; j < someBac.length; j++){
                    String[] split = someBac[j].split(";");
                    String capacite = split[0];
                    String cap = split[1]+"   "+split[2]+"   "+split[3];
                    out("Capacité : "+capacite+"  Composition (categorie, proportion) : "+cap);
                }
                idx++;
            }
        }
        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }



}
