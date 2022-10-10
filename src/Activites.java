public class Activites extends Page{


    public Activites(){
        entete("Activitees auxquelles je participe");


        out("Activitees auxquelles je participe :");
        out("exemple : composte et recycalge.");
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }

}
