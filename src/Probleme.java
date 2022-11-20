import java.io.IOException;
import java.util.Scanner;

public class Probleme extends Page{


    public Probleme(){
        entete("Signaler un probleme");
        addTabNomOptions("Remplacement d'un bac");
        addTabNomOptions("Demande d'un nouveau bac");
        out(afficherOptions());
        filtrer();
    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
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
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;
    }

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

    public void remplacerBac(){
        String nom = Controller.liveUser.name;
        String adresse = Controller.liveUser.adresse;
        String courriel = Controller.liveUser.courriel;

        String output = nom+", "+adresse+", "+courriel+", "+"demande de remplacemen de bac";
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
