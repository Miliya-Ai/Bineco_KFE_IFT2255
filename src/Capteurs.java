import java.io.File;
import java.util.HashMap;

public class Capteurs {


    public HashMap<String, String[]> capteursList = new HashMap<>();

    public Capteurs(){
        setCapteurs();
    }

    public void setCapteurs(){

        capteursList.put("r00", new String[] {"0,70", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("co00", new String[] {"0,55", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("d00", new String[] {"0,82"});

        capteursList.put("r01", new String[] {"0,33", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("co01", new String[] {"0,75", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("d01", new String[] {"0,50"});

        capteursList.put("r02", new String[] {"0,25", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("co02", new String[] {"0,80", "categorie1 : 0,50;categorie2 : 0,25;categorie3 : 0,25"});
        capteursList.put("d02", new String[] {"0,65"});

    }

    public void getRempli(){

    }




}
