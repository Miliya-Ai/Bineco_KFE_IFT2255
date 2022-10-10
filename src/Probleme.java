public class Probleme extends Page{


    public Probleme(){
        entete("Signaler un probleme");


        out("Vers le formualire ->  .............");
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
