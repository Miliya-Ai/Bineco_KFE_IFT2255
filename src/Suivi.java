public class Suivi extends Page {
    public Suivi() {
        entete("Suivi ecologique");
        addTabNomOptions("Afficher l'état de mes bacs");
        //addTabNomOptions("Afficher les métriques écologiques");
        addTabNomOptions("Etat traitement dechets municipaux");
        addTabNomOptions("Metriques ecologiques");
        out(afficherOptions ());
        filtrer();
    }


    @Override
    public void changerPage(int intNumeroOption) {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;

            case 1:
                tabNomOptions.clear();
                new EtatBacs();
                break;
            case 2:
                tabNomOptions.clear();
                new DechetMunicipaux();
                break;
            case 3:
                tabNomOptions.clear();
                new MetriquesEco();
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
