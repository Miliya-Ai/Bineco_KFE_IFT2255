import java.io.IOException;

/**
 * Dependamment si le client est un resident ou consommateur, il accedera a la page d'inscription correspondant
 */
public class SignIn extends Page{

    /**
     * Constructeur de SignIn: Imprime les options valides
     */
    public SignIn() {
        entete("Sign in");
        out( "**** Pour quitter, appuyer 99 ****\n");
        out("Vous êtes un");
        addTabNomOptions("Résident");
        addTabNomOptions("Consommateur");
        out(afficherOptions ());
        filtrer();
    }
    //TODO: mettre des noms plus descriptifs?
    /**
     * @param intNumeroOption Le client choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Resident</li>
     *                        <li>Consommateur</li>
     *                        </ol>
     * @throws IOException
     */
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

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
