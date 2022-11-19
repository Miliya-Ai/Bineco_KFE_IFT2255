import java.util.HashMap;

public class MunicipInfo {


    public String[] bacs = {"b00", "b01","b02","d00","d01","d02","co00","co01","co02"};
    public HashMap<String, String[]> consommateurs = new HashMap<>();



    public MunicipInfo(){
        setConsommateurs();
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

}
