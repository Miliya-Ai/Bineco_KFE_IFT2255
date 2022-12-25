import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Init l'environnement de Bineco.
 * La classe principale de JAR Bineco.
 */
public class Main {
    /**
     *
     * @param args aucun parametre ne devrait etre passe a l'entree
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                    Si le fichier n'est pas present, une exception se produit.
     */

    //**********************EXECUTER MAIN POUR COMMENCER L'APPLICATION **********************
    public static void main(String[] args) throws IOException {

        Controller init = new Controller();
        init.setLiveAccount();
        init.start();

    }
}

