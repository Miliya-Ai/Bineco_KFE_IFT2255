import java.io.IOException;

/**
 * Menu du resident
 */
public class Menu extends Page{
    //TODO: les notifications contiennent PAS celles de sensibilisation
    /**
     * Constructeur de Menu: Imprime les options valident, l'etat de ses bacs et les notifications
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public Menu() throws IOException {
        entete("Menu");
        //Controller.liveUser.getInfoRes(Controller.liveUser.user);
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Mes bacs");
        addTabNomOptions("Trouver un ou plusieurs consommateurs");
        addTabNomOptions("Faire un suivi ecologique");
        //addTabNomOptions("Voir les activité que je maintiens");
        addTabNomOptions("Signaler un probleme à la ville");
        addTabNomOptions("Mon profil");
        out(afficherOptions ());

        String temp = "Bacs enregistrés :  ";

        for (int i = 0; i < 3; i++){
            String bac = Controller.liveUser.numeroBac[i];
            if(bac != null){

                temp += Controller.liveUser.numeroBac[i] + " Capacité : " + Controller.capteurs.capteursList.get(bac)[0]
                        +",   ";

            }
        }
        out("\n"+temp);
        out("\n" + "Notification : ");
        out(Controller.municipInfo.message.get(0));

        filtrer();
    }
    /**
     * @param intNumeroOption Le resident choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Mes bacs</li>
     *                        <li>Trouver un ou plusieurs consommateurs</li>
     *                        <li>Faire un suivi ecologique</li>
     *                        <li>Signaler un probleme a la ville</li>
     *                        <li>Mon profil</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
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
                new Probleme();
                break;
            case 5:
                tabNomOptions.clear();
                new ModifProfil();
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
