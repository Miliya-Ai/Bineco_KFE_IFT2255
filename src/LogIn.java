import java.io.*;
import java.util.Scanner;

public class LogIn extends Page{


    public boolean verified = false;
    public LogIn() throws IOException {


       entete("Log in");
       out( "**** Pour quitter, appuyer 99 ****\n");
       //out("Vous êtes un");
       //addTabNomOptions("Résident");
       //addTabNomOptions("Consommateur");
       //out(afficherOptions ());

        addTabNomOptions("Enter");
        out(afficherOptions ());
        scannerInput();


       filtrer();


   };

    public void scannerInput() throws FileNotFoundException {
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }

    public void verifyLogin(String user, String pass) throws FileNotFoundException {

        try{
            FileInputStream fstream = new FileInputStream("src/passResident.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(" ");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.setUser(user);
                    Controller.liveUser.setMdp(pass);
                    new Menu();
                    return;
                }/*else{
                    tabNomOptions.clear();
                    new LogInResident();
                }*/
            }
            in.close();

            FileInputStream fstream2 = new FileInputStream("src/passConsommateur.txt");
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine2 = br2.readLine()) != null)   {
                String[] tokens = strLine2.split(" ");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.setUser(user);
                    Controller.liveUser.setMdp(pass);
                    new MenuConsommateur();
                    return;
                }/*else{
                    tabNomOptions.clear();
                    new LogInResident();
                }*/
            }
            in2.close();
            tabNomOptions.clear();
            out("Erreur d'informations de connexion");
            new LogIn();

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                //out("Entre les info resident");
                new LogInResident();
                //verified = true;
                //new Menu();
                break;
            case 2:
                tabNomOptions.clear();
                //out("Entre les info consommateur");
                new LogInConsommateur();
                //verified = true;
                //new Menu();
                break;
            case 99:
                effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }



    public void out(String message) {
        System.out.println(message);
    }

}


