import java.io.IOException;

public class SignIn extends Page{

    public SignIn() {
        entete("Sign in");
        out( "**** Pour quitter, appuyer 99 ****\n");
        out("Vous êtes un");
        addTabNomOptions("Résident");
        addTabNomOptions("Consommateur");
        out(afficherOptions ());
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new Resident();
                break;
            case 2:
                tabNomOptions.clear();
                new Consommateur();
                break;
            case 99:
                System.exit(0);
                effacer();
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
