public class EnregistrerBac extends Page{

    public EnregistrerBac(){
        entete("Enregistrer un bac");

        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");

        out("Type de bac : ");
        out("Numero du bac : ");
        out("Nom : ");

        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
