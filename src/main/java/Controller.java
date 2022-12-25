import java.io.IOException;

/**
 * Utiliser pour manipuler tous les informations dans le passe et le present. Point de depart et coeur de BINECO.
 */
public class Controller {

    //public UserController liveUser = new UserController();
    public static UserController liveUser;
    public static MunicipInfo municipInfo;
    public static Capteurs capteurs;
    public static String[] tempInfo;
    public static String[] tempInfoCons;

    /**
     * Constructeur de Controller
     */
    public Controller(){
        //new PageAccueil();
    }

    /**
     * Instancie les variables utilent au fonctionnement de BINECO.
     * <ol>
     *     <li>tempInfo contient les informations d'un resident lors de l'inscription</li>
     *     <li>tempInfoCons contient les informations d'un consommateur lors de l'inscription</li>
     *     <li>liveUser instancie {@link UserController}</li>
     *     <li>municipInfo instancie {@link MunicipInfo}</li>
     *     <li>capteur instancie {@link Capteurs}</li>
     * </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                    Si le fichier n'est pas present, une exception se produit.
     */
    public void setLiveAccount() throws IOException {
        tempInfo = new String[5];
        tempInfoCons = new String[7];
        liveUser = new UserController();
        municipInfo = new MunicipInfo();
        capteurs = new Capteurs();
    }

    /**
     * La premiere page qui apparait lors de l'excution du JAR de BINECO est la {@link PageAccueil}
     */
    public void start(){
        new PageAccueil();
    }

}
