import java.io.IOException;

public class MenuConsommateur extends Page{
    public MenuConsommateur() throws IOException {

        /*if(Controller.liveUser.res){
            Controller.liveUser.getInfoRes();
        } else {
            Controller.liveUser.getInfoCons();
        }*/
        entete("Menu du consommateur");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Trouver un consommateur");
        addTabNomOptions("Suivi Ecologique");
        addTabNomOptions("Mon profil");
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
                new FindConsommateur();
                break;
            case 2:
                tabNomOptions.clear();
                new Suivi();
                break;
            case 3:
                tabNomOptions.clear();
                new ModifProfil();
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