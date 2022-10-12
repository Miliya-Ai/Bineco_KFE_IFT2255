import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PageAccueil extends Page {

    public PageAccueil() { //constructeur;
        entete("Page d'accueil");
        out( "**** Pour quitter, appuyer 99 ****");
        out("Bonjour");
        addTabNomOptions("Log in");
        addTabNomOptions("Sign In");
        out(afficherOptions ());
        filtrer();

    }

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
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }

    }
}
