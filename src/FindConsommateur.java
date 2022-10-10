public class FindConsommateur extends Page{

    public FindConsommateur(){
        entete("Trouver un consommateur");


        out("Trouver un consommateur... filtre....");
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
