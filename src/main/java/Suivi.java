import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * S'occupe du besoin fonctionnel "Suivi ecologique"
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
     * @param intNumeroOption Le resident choisit la page vers laquelle se diriger.
     *                        Les nombres representent les pages.
     *                        <ol>
     *                        <li>Etat traitement dechets municipaux</li>
     *                        <li>Metriques ecologiques municipales</li>
     *                        </ol>
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
     * @param message texte que le resident entre dans la console
     * @return le string lu
     */
    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;
    }

    /**
     * Les options chosits dependeront si l'utilisateur connait quel numero de lot a chercher.
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
     *  Imprime tous les lots ainsi que leur information tel que leur identifiant, leur type, leur date de ramassage,
     *  leur date de livraison et leur statut.
     */
    public void listLot(){

        String[][] lots = Controller.municipInfo.lesLots;
        String[][] formattedLots = new String[10][8];

        for(int k = 0; k < lots[0].length; k++){
            System.out.println("Code : "+lots[k][0]+"  type : "+lots[k][1]
                    +"  Date ramassé : "+lots[k][2]
                    +"  Date livré : "+lots[k][3]+"  Statut : "+lots[k][4]);
        }


        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    /**
     * Imprime leur identifiant, leur type, leur date de ramassage, leur date de livraison et leur statut du lot que
     * le resident voudrait connaitre.
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
     * L'utilisateur choisit un interval de temps lorsqu'il connaitre les metriques ecologiques municipales.
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
     * Calcule les metriques selon l'intervalle de temps choisi.
     * <ol>
     *     <li>le volume total et la moyenne</li>
     *     <li>les proportions des activites</li>
     * </ol>
     *
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
     * @param temps intervalle de temps
     * @param type recyclage, compostage ou dechet
     * @return le string du calcul
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
     * @param temps intevalle de temps
     * @param r recyclage
     * @param c compostage
     * @param o dechet
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


}
