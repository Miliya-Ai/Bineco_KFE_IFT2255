import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * S'occupe du besoin fonctionnel "trouver un consommateur"
 */
public class FindConsommateur extends Page{

    /**
     * Contrusteur de FindConmmateur: Imprime les options valident
     */
    public FindConsommateur(){
        entete("Consommateurs");

        addTabNomOptions("Liste des consommateurs");
        addTabNomOptions("Trouver un consommateur");
        out(afficherOptions());
        filtrer();
    }


    /**
     * @param intNumeroOption Le resident choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Liste des consommateur</li>
     *                        <li>Trouver un consommateur</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                if (liveUser.res){
                    new Menu();
                } else {
                    new MenuConsommateur();
                }
                break;
            case 1:
                tabNomOptions.clear();
                listConsommateur();
                break;
            case 2:
                tabNomOptions.clear();
                getConsommateur();
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
     * Imprime sur la console la liste de consommateurs enregistre dans Bineco selon leur code identifiant et
     * le nom de la compagnie.
     */
    public void listConsommateur(){
        String[][] lots = Controller.municipInfo.lesCons;
        String[][] formattedCons = new String[10][8];

        for(int k = 0; k < lots.length; k++){
            System.out.println("Code : "+lots[k][0]+"  Nom : "+lots[k][1]);
        }

        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    /**
     * Imprime sur la console les lots dont une compagnie recherchee s'en occupe.
     * Si la compagnie n'existe pas, lui avertir par un message.
     */
    public void getConsommateur(){

        String code = scannerInput("Code du consommateur cherché :");
        String[] consExist = Controller.municipInfo.listeCons;
        String[][] lots = Controller.municipInfo.lesCons;
        String[][] formattedLots = new String[10][8];

        for (int k = 0; k < lots.length; k++){
            if (lots[k][0].equals(code)){
                String affichage = "";
                String nom = lots[k][1];
                for (int m = 2; m < lots[k].length; m++){
                    affichage += lots[k][m]+" , ";
                }
                out("Code : "+code+"  Nom : "+nom+"  Details : "+affichage);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }


        out("Code consommateur inexistant");
        new FindConsommateur();

    }
    //TODO: verifie si c'est utilise pour une activite
    /**
     * Le resident note un consommateur donnee
     * @param code identifiant d'une compagnie
     */
    public void noter(String code){
        String noter = scannerInput("Voulez vous notez ce consommateur? (y pour oui, n pour non");
        if (noter.equals("n")){
            return;
        } else {
            int note = Integer.parseInt(scannerInput("Note a donner (0-5) :"));
            if (Controller.municipInfo.feedbackCons.get(code) == null){
                int[] temp = new int[1];
                temp[0] = note;
            } else {
                int newLen = Controller.municipInfo.feedbackCons.get(code).length+1;
                int[] newTab = new int[newLen];
                for(int i = 0; i < newLen-1; i++){
                    newTab[i] = Controller.municipInfo.feedbackCons.get(code)[i];
                }
                newTab[newLen-1] = note;
            }
            out("Note envoyee");
        }
    }

}
