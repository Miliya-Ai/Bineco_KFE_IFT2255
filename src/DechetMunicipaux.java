public class DechetMunicipaux extends Page{


    public DechetMunicipaux(){
        entete("Etat de traitement des dechets municipaux");


        out("Dechets municipaux--------------");
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
