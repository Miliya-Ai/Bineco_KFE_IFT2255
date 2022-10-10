public class MetriquesEco extends Page{



    public MetriquesEco(){
        entete("Metriques ecologiques");


        out("Metriques--------------");
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
