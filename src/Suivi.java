import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Suivi extends Page {
    public Suivi() {
        entete("Suivi ecologique");
        out( "**** Pour retourner au menu, appuyer 0 ****");
        out( "**** Pour quitter, appuyer 99 ****\n");
        //addTabNomOptions("Afficher les métriques écologiques");
        addTabNomOptions("Etat traitement dechets municipaux");
        addTabNomOptions("Metriques ecologiques");
        out(afficherOptions ());
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
                etatTraitement();
                break;
            case 2:
                tabNomOptions.clear();
                new MetriquesEco();
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

    public void listLot(){
        for(Map.Entry<String, String[]> set:
                Controller.municipInfo.lots.entrySet()){

            out("Numero : "+set.getKey()+",   type : "+set.getValue()[0]+",  date ramassé : "+set.getValue()[1]
                +"  date livraison : "+set.getValue()[2]+"  statut : "+set.getValue()[3]);
        }
        out("--Appuyez sur 0 pour revenir au menu--");
        filtrer();
    }

    public void getLot(){
        String numero = scannerInput("Numero du lot recherché : ");
        String[] lotsExist = Controller.municipInfo.listeLots;

        for (int i = 0; i < lotsExist.length; i ++){
            if (lotsExist[i].equals(numero)){
                String[] info = Controller.municipInfo.lots.get(numero);
                String affichage = "";
                for (int j = 0; j < info.length; j++){
                    affichage += info[j]+", ";
                }
                out("numero, type, date ramassé, date livraison, statut, quantitee total, quantite traite, taux rejet");
                out(numero+", "+affichage);
                out("--Appuyez sur 0 pour revenir au menu--");
                filtrer();
                return;
            }
        }
        out("Numero de lot inexistant");
        new Suivi();
    }


}
