import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MunicipInfo {


    public String[] numerosBac = {"r00", "r01","r02","d00","d01","d02","co00","co01","co02"};
    public String[] listeCons = {"c00","c01","c02","c03","c04","c05","c06","c07","c08","c09"};
    public String[] listeConsDispo = {"c10","c11","c12","c13","c14","c15","c16","c17","c18","c19"};
    public String[] listeLots = {"l00","l01","l02","l03","l04","l05","l06","l07","l08","l09"};
    public HashMap<String, String[]> consommateurs = new HashMap<>();
    public HashMap<String, String[]> bacs = new HashMap<>();
    public HashMap<String, int[]> feedbackCons = new HashMap<>();
    //public HashMap<String, String[]> lots = new HashMap<>();
    public String[] lesLots;
    public String[] lesCons;

    public String[] yearDataStr = getFromCsv("src/main/java/data12mois.txt");
    public int[][] dataYear = toInt(yearDataStr);
    public int[] recyclage12mois = dataYear[0];
    public int[] composte12mois = dataYear[1];
    public int[] ordures12mois = dataYear[2];
    public ArrayList<String> problemes = new ArrayList<>();

    public ArrayList<String> message = new ArrayList<>();


    public MunicipInfo() throws IOException {
        setConsommateurs();
        setBacs();
        setFeedbackCons();
        setLots();
        setMessage();
    }

    public int[][] toInt(String[] str){
        int[][] inInt =new int[str.length][12];
        for (int i = 0; i < str.length; i++){
            String[] temp = (str[i].split(","));
            for (int j = 0; j < temp.length; j++){
                inInt[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return inInt;
    }
    public void setMessage(){
        message.add("Laver vos bacs! - 20 novembre 2022");

    }

    public void setConsommateurs() throws IOException {

        /*consommateurs.put("c00", new String[]{"company1", "recyclage:2000", "composte:1000",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c01", new String[]{"company2","recyclage:2000", "composte:500",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c02", new String[]{"company3","recyclage:1000", "composte:1500",
                                                 "courriel", "adresse", "telephone"});
        consommateurs.put("c03", new String[]{"company4","recyclage:2000", "composte:1000", "dechets:2000",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c04", new String[]{"company5","recyclage:1500", "composte:500",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c05", new String[]{"company6","recyclage:750", "composte:1000", "dechets:5000",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c06", new String[]{"company7","recyclage:2500",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c07", new String[]{"company8","recyclage:2000", "composte:1000", "dechets:1500",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c08", new String[]{"company9","composte:1750",
                                                "courriel", "adresse", "telephone"});
        consommateurs.put("c09", new String[]{"company10","recyclage:1000", "composte:1000", "dechets:1000",
                                                "courriel", "adresse", "telephone"});*/

        lesCons = getFromCsv("src/main/java/dataCons.txt");

    }

    public void setBacs(){
        bacs.put("r00", new String[]{"adresse1", "UNE_DATE"});
        bacs.put("r01", new String[]{"adresse2", "UNE_DATE"});
        bacs.put("r02", new String[]{"adresse3", "UNE_DATE"});
        bacs.put("d00", new String[]{"adresse4", "UNE_DATE"});
        bacs.put("d01", new String[]{"adresse5", "UNE_DATE"});
        bacs.put("d02", new String[]{"adresse6", "UNE_DATE"});
        bacs.put("co00", new String[]{"adress7", "UNE_DATE"});
        bacs.put("co01", new String[]{"adresse8", "UNE_DATE"});
        bacs.put("co02", new String[]{"adresse9", "UNE_DATE"});
    }

    public void setFeedbackCons(){
        feedbackCons.put("c00", null);
        feedbackCons.put("c01", null);
        feedbackCons.put("c02", null);
        feedbackCons.put("c03", null);
        feedbackCons.put("c04", null);
        feedbackCons.put("c05", null);
        feedbackCons.put("c06", null);
        feedbackCons.put("c07", null);
        feedbackCons.put("c08", null);
        feedbackCons.put("c09", null);
    }

    public void setLots() throws IOException {
       /* lots.put("l00", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel", "1000", "750", "0.25"});
        lots.put("l01", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l02", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l03", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l04", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l05", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l06", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l07", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l08", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l09", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});*/
        lesLots = getFromCsv("src/main/java/dataLots.txt");

    }

    public String[] getFromCsv(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        String[] data = lines.toArray(new String[lines.size()]);
        br.close();
        /*for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }*/
        return data;
    }

}
