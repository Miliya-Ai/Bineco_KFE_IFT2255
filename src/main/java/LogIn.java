import javax.naming.ldap.Control;
import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class LogIn extends Page{


    public boolean verified = false;

    /**
     * Constructeur de LogIn: Imprime les options valident et verifie si l'utilisateur existe ans BINECO.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public LogIn() throws IOException {
       entete("Log in");
       out( "**** Pour quitter, appuyer 99 ****\n");

       addTabNomOptions("Page d'accueil");
       out(afficherOptions ());
       scannerInput();
       filtrer();
   }

    /**
     * Demande le nom d'utilisateur et le mot de passe du client pour verifie s'il est eligibleé
     * @throws FileNotFoundException La methode utilise des methodes qui lisent des fichiers.
     *                               Si le fichier n'est pas present, une exception se produit.
     * @see #verifyLogin(String, String)
     */
    public void scannerInput() throws FileNotFoundException {
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }
    /**
     * Par son nom d'utilisateur et mot, aller chercher dans le fichier contenant nom d'utilisateur et mot de passe
     * des residents et le fichier des consommateurs. Si le client existe dans la base de donnee Bineco, alors afficher
     * le menu correspondant. Sinon, l'utilisateur revient a la page d'accueil.
     *
     * @param user nom d'utilisateur a verifier
     * @param pass mot de passse a verifier
     * @throws FileNotFoundException La methode utilise des methodes qui lisent des fichiers.
     *                               Si le fichier n'est pas present, une exception se produit.
     */

    public void verifyLogin(String user, String pass) throws FileNotFoundException {

        try{
            FileInputStream fstream = new FileInputStream("src/main/java/passResident.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(",");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.getInfoRes(user);
                    new Menu();
                    return;
                }
            }
            in.close();

            FileInputStream fstream2 = new FileInputStream("src/main/java/passConsommateur.txt");
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine2 = br2.readLine()) != null)   {
                String[] tokens = strLine2.split(",");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.getInfoCons(user);

                    String[] lesCons = Controller.municipInfo.listeCons;
                    String[] temp = new String[lesCons.length+1];
                    for (int i = 0; i < temp.length-1; i++){
                        temp[i] = lesCons[i];
                    }
                    temp[temp.length-1] = Controller.tempInfoCons[0];
                    Controller.municipInfo.listeCons = temp;
                    Controller.municipInfo.consommateurs.put(Controller.tempInfoCons[0],
                            new String[]{Controller.tempInfoCons[1],Controller.tempInfoCons[5]
                            +":"+Controller.tempInfoCons[6]});
                    new MenuConsommateur();
                    return;
                }
            }
            in2.close();
            tabNomOptions.clear();
            out("Erreur d'informations de connexion");
            //new LogIn();

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }
    /**
     * Une fois que le client a finit d'entrer ses informations, il peut choisir de se faire valider.
     * @param intNumeroOption Le resident choisit de valider son nom d'utilisateur et mot de passe
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new PageAccueil();
                break;
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }
}


