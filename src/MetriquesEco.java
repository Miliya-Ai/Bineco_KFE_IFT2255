import java.io.IOException;

public class MetriquesEco extends Page{



    public MetriquesEco(){
        entete("Metriques ecologiques");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Resident ou municipal : ");
        out("   Type : recycalge, composte, ordures : ");
        out("       Intervalle de temps : ");

        out("\n ------AFFICHAGE DES METRIQUES------");
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                if (liveUser.res){
                    new Menu();
                } else {
                    new MenuConsommateur();
                }
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
