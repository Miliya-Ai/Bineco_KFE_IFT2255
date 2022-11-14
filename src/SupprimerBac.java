import java.io.IOException;

public class SupprimerBac extends Page{

    public SupprimerBac(){

        entete("Suppression d'un bac");

        out("Numero du bac a supprimer : ");
        filtrer();
    }



    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
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
