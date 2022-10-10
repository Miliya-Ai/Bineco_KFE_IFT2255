import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PageAccueil extends Page {

    public PageAccueil() { //constructeur;
        entete("Page d'accueil");
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
                new LogIn();
            case 2:
                new SignIn();
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }

    }
}
