public class Activites extends Page{


    public Activites(){
        entete("Activitees auxquelles je participe");


        out("Activitees auxquelles je participe :");
        out("   - 1.........");
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 0:
                new Menu();
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }

}
