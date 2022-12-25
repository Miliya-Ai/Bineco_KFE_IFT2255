import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Suivi extends Page {
    public Suivi() {
        entete("Suivi ecologique");
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");
        addTabNomOptions("Etat traitement dechets municipaux");
        addTabNomOptions("Metriques ecologiques municipales");
        //addTabNomOptions("Metriques residentielles");
        out(afficherOptions ());
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
                etatTraitement();
                break;
            case 2:
                tabNomOptions.clear();
                choixTemps();
                break;
            case 3:
                tabNomOptions.clear();
                historiqueBac();
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
    public void etatTraitement(){
        String choix = (scannerInput("1- Liste des lots \n2- Trouver un lot"));
        if (choix.equals("1")){
            listLot();
        }
        if (choix.equals("2")){
            getLot();
        } else {
            out("input invalide");
            new Suivi();
        }

    }

    /**
     *
     */
    public void listLot(){
        /*for(Map.Entry<String, String[]> set:
                Controller.municipInfo.lots.entrySet()){

            out("Numero : "+set.getKey()+",   type : "+set.getValue()[0]+",  date ramassé : "+set.getValue()[1]
                +"  date livraison : "+set.getValue()[2]+"  statut : "+set.getValue()[3]);
        }*/
        String[][] lots = Controller.municipInfo.lesLots;
        String[][] formattedLots = new String[10][8];
        /*for(int i = 0; i < lots.length; i++){
            String[] info = lots[i].split(",");
            for(int j = 0; j < info.length; j++){
                formattedLots[i][j] = info[j];
            }
        }*/
        for(int k = 0; k < lots[0].length; k++){
            System.out.println("Code : "+lots[k][0]+"  type : "+lots[k][1]
                    +"  Date ramassé : "+lots[k][2]
                    +"  Date livré : "+lots[k][3]+"  Statut : "+lots[k][4]);
        }


        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    /**
     *
     */
    public void getLot(){
        String numero = scannerInput("Numero du lot recherché : ");
        String[] lotsExist = Controller.municipInfo.listeLots;
        String[][] lots = Controller.municipInfo.lesLots;
        String[][] formattedLots = new String[10][8];

        for (int k = 0; k < lots.length; k++){
            if (lots[k][0].equals(numero)){
                String affichage = "";
                for (int m = 0; m < lots[k].length; m++){
                    affichage += lots[k][m]+" , ";
                }
                out("numero, type, date ramassé, date livraison, statut, quantitee total, quantite traite, taux rejet");
                out(affichage);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }

        out("Numero inexistant");
        new Suivi();
    }

    /**
     *
     */
    public void choixTemps(){
        out("Sur quel interval de temps voulez vous voir les metriques municipales? : ");
        String choix = scannerInput("1- 1 mois\n2- 3 mois\n3- 6 mois\n4- 12 mois");

        switch (choix){
            case "1":
                metriques(1);
            case "2":
                metriques(3);
            case "3":
                metriques(6);
            case "4":
                metriques(12);
            default:
                out("Choix inexistant");
                choixTemps();
        }
    }

    /**
     * @param temps
     */
    public void metriques(int temps){

        int[] rec = Controller.municipInfo.recyclage12mois;
        int[] comp = Controller.municipInfo.composte12mois;
        int[] ord = Controller.municipInfo.ordures12mois;

        out("---VOLUME TOTAL ET MOYEN SUR LES "+temps+" DERNIERS MOIS---\n");
        out("RECYCLAGE : "+avgSum(temps, rec));
        out("COMPOSTE : "+avgSum(temps, comp));
        out("ORDURES : "+avgSum(temps, ord));

        out("\n---PROPORTIONS DES ACTIVITÉES DANS LES "+temps+" DERNIERS MOIS---\n");
        out(propotions(temps, rec, comp, ord));
        out("\n--Appuyez sur 0 pour revenir au menu--");
        filtrer();

    }

    /**
     * @param temps
     * @param type
     * @return
     */
    public String avgSum(int temps, int[] type){
        int sum = 0;
        for (int i = 0; i < temps; i++){
            sum += type[i];
        }
        double average = sum/temps;
        return "Moyenne : "+average+"   Quantitée totale : "+sum;
    }

    /**
     * @param temps
     * @param r
     * @param c
     * @param o
     * @return
     */
    public String propotions(int temps, int[] r, int[] c, int[] o){
        int sumR = 0;
        for (int i = 0; i < temps; i++){
            sumR += r[i];
        }
        int sumC = 0;
        for (int i = 0; i < temps; i++){
            sumC += c[i];
        }
        int sumO = 0;
        for (int i = 0; i < temps; i++){
            sumO += o[i];
        }
        int sum = sumC + sumO + sumR;
        float propR = (float)sumR/(float)sum;
        float propC = (float)sumC/(float)sum;
        float propO = (float)sumO/(float)sum;

        String affichage = "Recyclage : "+propR+",  "+"Composte : "+propC+",  Ordures : "+propO+
                            "\n---"+propO*100+"% de tout n'est ni recyclé, ni composté.";
        return affichage;
    }


    /**
     *
     */
    public void historiqueBac(){

    }


}
