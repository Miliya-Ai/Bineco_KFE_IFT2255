import java.io.IOException;

public class Controller {

    //public UserController liveUser = new UserController();
    public static UserController liveUser;
    public static MunicipInfo municipInfo;
    public static Capteurs capteurs;

    public static String[] tempInfo;

    public static String[] tempInfoCons;

    public Controller(){

        //new PageAccueil();

    }

    public void setLiveAccount() throws IOException {
        tempInfo = new String[5];
        tempInfoCons = new String[7];
        liveUser = new UserController();
        municipInfo = new MunicipInfo();
        capteurs = new Capteurs();
    }

    public void start(){
        new PageAccueil();
    }

}
