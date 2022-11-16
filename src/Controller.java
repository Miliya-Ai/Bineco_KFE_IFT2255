public class Controller {

    //public UserController liveUser = new UserController();
    public static UserController liveUser;

    public Controller(){

        //new PageAccueil();

    }

    public void setLiveAccount(){
        liveUser = new UserController();
    }

    public void start(){
        new PageAccueil();
    }

}
