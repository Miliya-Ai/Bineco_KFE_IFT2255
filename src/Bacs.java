import java.io.IOException;

public class Bacs extends Page{

    public Bacs(){
        entete("Mes bacs");

        addTabNomOptions("Enregistrer un bac");
        addTabNomOptions("Supprimer un bac");
        out(afficherOptions());

        filtrer();

    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 1:
                tabNomOptions.clear();
                new EnregistrerBac();
                break;
            case 2:
                tabNomOptions.clear();
                new SupprimerBac();
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
