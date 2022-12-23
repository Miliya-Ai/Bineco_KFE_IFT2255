import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FindConsommateur extends Page{

    public FindConsommateur(){
        entete("Consommateurs");

        addTabNomOptions("Liste des consommateurs");
        addTabNomOptions("Trouver un consommateur");
        out(afficherOptions());
        filtrer();
    }


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
                //effacer();
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

    public void listConsommateur(){

        /*for(Map.Entry<String, String[]> set:
            Controller.municipInfo.consommateurs.entrySet()){

            out("Code : "+set.getKey()+",   nom : "+set.getValue()[0]);
        }*/

        String[] lots = Controller.municipInfo.lesCons;
        String[][] formattedCons = new String[10][8];
        for(int i = 0; i < lots.length; i++){
            String[] info = lots[i].split(",");
            for(int j = 0; j < info.length; j++){
                formattedCons[i][j] = info[j];
            }
        }
        for(int k = 0; k < formattedCons[0].length; k++){
            System.out.println("Code : "+formattedCons[k][0]+"  Nom : "+formattedCons[k][1]);
        }

        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    public void getConsommateur(){

        String code = scannerInput("Code du consommateur cherché :");
        String[] consExist = Controller.municipInfo.listeCons;
        /*for (int j = 0; j < consExist.length; j++){
            if (consExist[j].equals(code)){
                String[] info = Controller.municipInfo.consommateurs.get(code);
                String nom = info[0];
                String details = info[1];

                if(info.length > 2){
                    for (int i = 2; i < info.length; i++){
                        details += " , "+info[i];
                    }
                }
                out("Code : "+code+"  Nom : "+nom+"  Info: "+details);
                noter(code);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }*/

        String[] lots = Controller.municipInfo.lesCons;
        String[][] formattedLots = new String[10][8];
        for(int i = 0; i < lots.length; i++){
            String[] info = lots[i].split(",");
            for(int j = 0; j < info.length; j++){
                formattedLots[i][j] = info[j];
            }
        }
        for (int k = 0; k < lots.length; k++){
            if (formattedLots[k][0].equals(code)){
                String affichage = "";
                String nom = formattedLots[k][1];
                for (int m = 2; m < formattedLots[k].length; m++){
                    affichage += formattedLots[k][m]+" , ";
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
