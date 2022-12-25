import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public abstract class Page extends Controller{
    protected ArrayList<String> tabNomOptions = new ArrayList<String>() ;
    public Controller controller = new Controller();

    public Page() {

    }

    /**
     * Utiliser a choque fois qu'une page est creee
     * @param nomPage a imprimer sur la console
     */
    public void entete (String nomPage){
        out("\n"
            + "################ " + nomPage + " ##################" +"  Session de : "+Controller.liveUser.user
            + "\n");
    }

    /**
     * Construit un string d'options a partir de la tabNomOptions.
     * @return un string d'options a afficher sur une page donnee
     */
    public String afficherOptions () {
        String optionDonnee = "";
        int lenghtTabNomOptions = tabNomOptions.size() ;
        int indexTab = 0;
        for (int i = 1; i <= lenghtTabNomOptions; i++){
            optionDonnee += "[" + i + "]: " + tabNomOptions.get(indexTab) + "\n";
            indexTab += 1;
        }
        return optionDonnee;
    }

    /**
     * Ajouter un option dans tabNomOption qui contient tous les options sous forme de ArrayList.
     * @param option une option permise pour une page donnee
     */
    public void addTabNomOptions(String option) {
        this.tabNomOptions.add(option);
    }

    /**
     * Fonctionne comme sout.
     * @param message a imprimer sur la console
     */
    public void out (String message){
        System.out.println(message);
    }

    /**
     * Utiliser pour verifier l'option choisit par l'utilisateur et prendre action correspondant
     * a l'option.
     * @see #changerPage(int intNumeroOption)
     */
    public void filtrer () {
        Scanner myObj = new Scanner(System.in);
        String stringNumeroOption = myObj.nextLine();
        int intNumeroOption = 0;

        try {
            intNumeroOption = Integer.parseInt(stringNumeroOption);
            changerPage(intNumeroOption);
            myObj.close();
        } catch (Exception e) {

            filtrer();

        }

    }


    /**
     * Option 0 pour revenir au menu correspondant a l'utilisateur et option 99, pour quitter.
     * Option 0 n'est pas valide pour la page d'accueil, log in, sign in, menu du resident et menu de consommateur.
     * @param intNumeroOption numero correspondant aux options de la page
     * @throws IOException
     */

    public void changerPage(int intNumeroOption) throws IOException {

    }
}
