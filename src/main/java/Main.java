import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //**********************EXECUTER MAIN POUR COMMENCER L'APPLICATION **********************
    public static void main(String[] args) throws IOException {

        Controller init = new Controller();
        init.setLiveAccount();
        init.start();

    }
}

