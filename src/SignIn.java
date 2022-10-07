import java.io.IOException;

public class SignIn extends Page{

    public SignIn() {
        entete("Sign in");
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
                new Resident();
            case 2:
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
