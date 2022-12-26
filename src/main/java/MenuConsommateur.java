import java.io.IOException;
import java.util.Scanner;

/**
 * Menu du consommateur
 */
public class MenuConsommateur extends Page{
    /**
     * Constructeur de MenuConsommateur: Imprime les options valident
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public MenuConsommateur() throws IOException {

        entete("Menu du consommateur");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Trouver un ou plusieurs consommateurs");
        addTabNomOptions("Faire un suivi ecologique");
        addTabNomOptions("Mon profil");
        addTabNomOptions("Notifier");
        out(afficherOptions ());
        filtrer();
    }

    /**
     * Le consommateur veut notifier tous les residents d'un besoin en déchets spécifiques
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void notifier() throws IOException {
        String msg = scannerInput("Message à transmettre");
        Controller.municipInfo.message.add(msg);
        out("Message transmis");
        new MenuConsommateur();
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
     * @param intNumeroOption Le consommateur choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Trouver un ou plusieurs consommateurs</li>
     *                        <li>Faire un suivi Ecologique</li>
     *                        <li>Mon profil</li>
     *                        <li>Notifier</li>
     *                        <li>Mon profil</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new FindConsommateur();
                break;
            case 2:
                tabNomOptions.clear();
                new Suivi();
                break;
            case 3:
                tabNomOptions.clear();
                new ModifProfil();
                break;
            case 4:
                tabNomOptions.clear();
                notifier();
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