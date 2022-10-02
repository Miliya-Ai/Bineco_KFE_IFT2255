public class Menu extends Page{
    public Menu() {
        entete("Menu");
        addTabNomOptions("Enregistrer un bac");
        addTabNomOptions("Trouver un consommateur");
        addTabNomOptions("Faire le suivi de mes bacs");
        addTabNomOptions("Voir les activité que je maintiens");
        addTabNomOptions("Signaler un problème à la ville");
        out(afficherOptions ());
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                new SuiviBacs();
            case 4:
                break;
            case 5:
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
