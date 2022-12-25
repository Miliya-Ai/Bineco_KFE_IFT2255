import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La premier affichee lors de l'execution de JAR Bineco.
 */
public class PageAccueil extends Page {

    /**
     * Constructeur de PageAccueil: Imprime les options valident
     */
    public PageAccueil() {
        entete("Page d'accueil");
        out( "**** Pour quitter, appuyer 99 ****");
        out("Bonjour");
        addTabNomOptions("Log in");
        addTabNomOptions("Sign In");
        out(afficherOptions ());
        filtrer();

    }

    /**
     * @param intNumeroOption Le resident choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Log In</li>
     *                        <li>Sign In</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new LogIn();
                break;
            case 2:
                tabNomOptions.clear();
                new SignIn();
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
