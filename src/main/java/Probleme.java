import java.io.IOException;
import java.util.Scanner;

/**
 * S'occupe du besoin fonctionnel "Signaler un probleme"
 */
public class Probleme extends Page{


    /**
     * Constructeur de Menu: Imprime les actions valident
     */
    public Probleme(){
        entete("Signaler un probleme");
        addTabNomOptions("Remplacement d'un bac");
        addTabNomOptions("Demande d'un nouveau bac");
        out(afficherOptions());
        filtrer();
    }
    /**
     * @param intNumeroOption Le resident choisit l'action a entreprendre.
     *                        Les nombres representent les actions valables.
     *                        <ol>
     *                        <li>Remplacement d'un bac</li>
     *                        <li>Demande d'un nouveau bac</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                if (liveUser.res){
                    new Menu();
                } else {
                    new MenuConsommateur();
                }
                break;
            case 1:
                tabNomOptions.clear();
                remplacerBac();
                break;
            case 2:
                tabNomOptions.clear();
                demandeBac();
                break;
            case 99:
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

    /**
     * @param message texte que le resident entre dans la console
     * @return le string lu
     */
    public String scannerInput(String message){
        out(message);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

    /**
     * Faire parvenir a municipInfo le nom du resident, son adresse, son courriel et type de problème qui est de
     * demander un nouveau bac.
     * Avant d'envoyer la requete, le resident doit confirmer que c'est son souhait. Sinon, il peut l'annuler.
     */
    public void demandeBac(){
        String nom = Controller.liveUser.name;
        String adresse = Controller.liveUser.adresse;
        String courriel = Controller.liveUser.courriel;

        String output = nom+", "+adresse+", "+courriel+", "+"demande de nouveau bac";
        out("Votre message : ---> "+output);
        String choix = scannerInput("Appuyez sur 1 pour envoyer\nAppuyez sur 2 pour annuler");
        if (choix.equals("1")){
            Controller.municipInfo.problemes.add(output);
            out("Envoyé");
            out("--Appuyez sur 0 pour revenir au menu--");
            filtrer();

        }
        if (choix.equals("2")){
            out("Annulé");
            out("--Appuyez sur 0 pour revenir au menu--");
            filtrer();
        }
    }
    //TODO: on ne demande pas pour quel type de bac? recyclage, dechet ou compostage?
    /**
     * Faire parvenir a municipInfo le nom du resident, son adresse, son courriel et type de problème qui est de
     * remplacer un bac.
     * Avant d'envoyer la requete, le resident doit confirmer que c'est son souhait. Sinon, il peut l'annuler.
     */
    public void remplacerBac(){
        String nom = Controller.liveUser.name;
        String adresse = Controller.liveUser.adresse;
        String courriel = Controller.liveUser.courriel;

        String output = nom+", "+adresse+", "+courriel+", "+"demande de remplacement de bac";
        out("Votre message : ---> "+output);
        String choix = scannerInput("Appuyez sur 1 pour envoyer\nAppuyez sur 2 pour annuler");
        if (choix.equals("1")){
            Controller.municipInfo.problemes.add(output);
            out("Envoyé");
            out("--Appuyez sur 0 pour revenir au menu--");
            filtrer();

        }
        if (choix.equals("2")){
            out("Annulé");
            out("--Appuyez sur 0 pour revenir au menu--");
            filtrer();
        }
    }

}
