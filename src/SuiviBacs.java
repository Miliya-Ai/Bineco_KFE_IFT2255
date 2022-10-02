public class SuiviBacs extends Menu {
    public SuiviBacs() {
        entete("Faire le suivi de mes bacs");
        addTabNomOptions("Afficher l'état de mes bacs");
        addTabNomOptions("Afficher les métriques écologiques");
        addTabNomOptions("Voir l'état de mes déchets");
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
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}
