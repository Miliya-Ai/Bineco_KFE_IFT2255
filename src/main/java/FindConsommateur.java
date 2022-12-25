import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class FindConsommateur extends Page{

    public FindConsommateur(){
        entete("Consommateurs");

        addTabNomOptions("Liste des consommateurs");
        addTabNomOptions("Trouver un consommateur");
        out(afficherOptions());
        filtrer();
    }


    /**
     * @param intNumeroOption
     * @throws IOException
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
                listConsommateur();
                break;
            case 2:
                tabNomOptions.clear();
                getConsommateur();
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
     * @param message
     * @return
     */
    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;

    }

    /**
     *
     */
    public void listConsommateur(){
        String[][] lots = Controller.municipInfo.lesCons;
        String[][] formattedCons = new String[10][8];

        for(int k = 0; k < lots.length; k++){
            System.out.println("Code : "+lots[k][0]+"  Nom : "+lots[k][1]);
        }

        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    /**
     *
     */
    public void getConsommateur(){

        String code = scannerInput("Code du consommateur cherché :");
        String[] consExist = Controller.municipInfo.listeCons;
        String[][] lots = Controller.municipInfo.lesCons;
        String[][] formattedLots = new String[10][8];

        for (int k = 0; k < lots.length; k++){
            if (lots[k][0].equals(code)){
                String affichage = "";
                String nom = lots[k][1];
                for (int m = 2; m < lots[k].length; m++){
                    affichage += lots[k][m]+" , ";
                }
                out("Code : "+code+"  Nom : "+nom+"  Details : "+affichage);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }


        out("Code consommateur inexistant");
        new FindConsommateur();

    }

    /**
     * @param code
     */
    public void noter(String code){
        String noter = scannerInput("Voulez vous notez ce consommateur? (y pour oui, n pour non");
        if (noter.equals("n")){
            return;
        } else {
            int note = Integer.parseInt(scannerInput("Note a donner (0-5) :"));
            if (Controller.municipInfo.feedbackCons.get(code) == null){
                int[] temp = new int[1];
                temp[0] = note;
            } else {
                int newLen = Controller.municipInfo.feedbackCons.get(code).length+1;
                int[] newTab = new int[newLen];
                for(int i = 0; i < newLen-1; i++){
                    newTab[i] = Controller.municipInfo.feedbackCons.get(code)[i];
                }
                newTab[newLen-1] = note;
            }
            out("Note envoyee");
        }
    }

}
