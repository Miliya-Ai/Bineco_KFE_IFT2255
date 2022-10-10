public class EtatBacs extends Page{


    public EtatBacs(){
        entete("Etat de mes bacs");

        out("Recyclage : capacite : x%, composition : ...");
        out("Composte : capacite : x%");
        out("Ordures : capacite : x%");
        out("Historique : ");
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
                //filtrer();
        }
    }


}




