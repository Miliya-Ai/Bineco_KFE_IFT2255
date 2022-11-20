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
    public HashMap<String, String[]> lots = new HashMap<>();

    public int[] recyclage12mois = {50000,40000,45000,55000,35000,47000,43000,55000,32000,59000,46000,41000};
    public int[] composte12mois = {20000,10000,15000,35000,15000,27000,23000,35000,12000,39000,26000,21000};
    public int[] ordures12mois = {60000,50000,55000,65000,45000,57000,53000,65000,42000,69000,56000,51000};
    public ArrayList<String> problemes = new ArrayList<>();



    public MunicipInfo(){
        setConsommateurs();
        setBacs();
        setFeedbackCons();
        setLots();
    }

    public void setConsommateurs(){

        consommateurs.put("c00", new String[]{"company1", "recyclage:2000", "composte:1000"});
        consommateurs.put("c01", new String[]{"company2","recyclage:2000", "composte:500"});
        consommateurs.put("c02", new String[]{"company3","recyclage:1000", "composte:1500"});
        consommateurs.put("c03", new String[]{"company4","recyclage:2000", "composte:1000", "dechets:2000"});
        consommateurs.put("c04", new String[]{"company5","recyclage:1500", "composte:500"});
        consommateurs.put("c05", new String[]{"company6","recyclage:750", "composte:1000", "dechets:5000"});
        consommateurs.put("c06", new String[]{"company7","recyclage:2500"});
        consommateurs.put("c07", new String[]{"company8","recyclage:2000", "composte:1000", "dechets:1500"});
        consommateurs.put("c08", new String[]{"company9","composte:1750"});
        consommateurs.put("c09", new String[]{"company10","recyclage:1000", "composte:1000", "dechets:1000"});

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

    public void setLots(){
        lots.put("l00", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel", "1000", "750", "0.25"});
        lots.put("l01", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l02", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l03", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l04", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l05", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l06", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l07", new String[]{"composte","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l08", new String[]{"ordures","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
        lots.put("l09", new String[]{"recyclage","YYYY-MM-DD","YYYY-MM-DD","statut_actuel","1000", "750", "0.25"});
    }

}
