import java.util.HashMap;

public class MunicipInfo {


    public String[] numerosBac = {"r00", "r01","r02","d00","d01","d02","co00","co01","co02"};
    public HashMap<String, String[]> consommateurs = new HashMap<>();

    public HashMap<String, String[]> bacs = new HashMap<>();

    public HashMap<String, int[]> feedbackCons = new HashMap<>();



    public MunicipInfo(){
        setConsommateurs();
        setBacs();
        setFeedbackCons();
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

}
