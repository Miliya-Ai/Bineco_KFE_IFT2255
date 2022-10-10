public class Menu extends Page{
    public Menu() {
        entete("Menu");
        addTabNomOptions("Enregistrer un bac");
        addTabNomOptions("Trouver un consommateur");
        addTabNomOptions("Faire le suivi de mes bacs");
        addTabNomOptions("Voir les activité que je maintiens");
        addTabNomOptions("Etat de traitement des dechets municipaux");
        addTabNomOptions("Signaler un problème à la ville");
        out(afficherOptions ());
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 1:
                new EnregistrerBac();
                break;
            case 2:
                new FindConsommateur();
                break;
            case 3:
                new SuiviBacs();
                break;
            case 4:
                new Activites();
                break;
            case 5:
                new DechetMunicipaux();
                break;
            case 6:
                new Probleme();
                break;
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }
}
