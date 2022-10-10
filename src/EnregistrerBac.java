public class EnregistrerBac extends Page{

    public EnregistrerBac(){
        entete("Enregistrer un bac");

        out("Numero du bac : ");
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
