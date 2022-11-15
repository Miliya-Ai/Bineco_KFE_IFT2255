import java.io.*;
import java.util.Scanner;



public class LogInResident extends Page{

    private static Scanner x;

    public LogInResident() throws FileNotFoundException {
        entete("Log in");
        out( "**** Pour quitter, appuyer 99 ****\n");
        addTabNomOptions("Enter");
        out(afficherOptions ());
        scannerInput();
        //filtrer();
    }

    public void scannerInput() throws FileNotFoundException {
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }
    //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
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
                    new Menu();
                    return;
                }/*else{
                    tabNomOptions.clear();
                    new LogInResident();
                }*/


            }
            in.close();


        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }




    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
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

}


