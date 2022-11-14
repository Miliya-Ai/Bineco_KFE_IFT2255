import java.io.IOException;

public class Menu extends Page{
    public Menu() {
        entete("Menu");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Mes bacs");
        addTabNomOptions("Trouver un consommateur");
        addTabNomOptions("Suivi ecologique");
        addTabNomOptions("Voir les activité que je maintiens");
        //addTabNomOptions("Etat de traitement des dechets municipaux");
        addTabNomOptions("Signaler un problème à la ville");
        out(afficherOptions ());

        //out("\nPour revenir au Menu appuyer 0");
        //out("Pour quitter appuyer 99");
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new Bacs();
                break;
            case 2:
                tabNomOptions.clear();
                new FindConsommateur();
                break;
            case 3:
                tabNomOptions.clear();
                new Suivi();
                break;
            case 4:
                tabNomOptions.clear();
                new Activites();
                break;

            case 5:
                tabNomOptions.clear();
                new Probleme();
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
