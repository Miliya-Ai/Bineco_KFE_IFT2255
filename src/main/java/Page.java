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

    /**
     *
     */
    public Page() {

    }

    /**
     * @param nomPage
     */
    public void entete (String nomPage){
        out("\n"
            + "################ " + nomPage + " ##################" +"  Session de : "+Controller.liveUser.user
            + "\n");
    }

    /**
     * @return
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
     * @param option
     */
    public void addTabNomOptions(String option) {
        this.tabNomOptions.add(option);
    }

    /**
     * @param message
     */
    public void out (String message){
        System.out.println(message);
    }

    /**
     *
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
     * @param intNumeroOption
     * @throws IOException
     */

    public void changerPage(int intNumeroOption) throws IOException {

    }
}
