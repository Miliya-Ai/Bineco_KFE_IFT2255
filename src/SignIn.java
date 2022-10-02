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
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 1:
                break;
            case 2:
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
