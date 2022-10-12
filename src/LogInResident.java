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

        /*boolean verified = false;
        String tempUser = "";
        String tempPass = "";

        try {

            x = new Scanner(new File("passResident.txt"));
            x.useDelimiter("\n,");

            while(x.hasNext() && !verified){
                tempUser = x.next();
                tempPass = x.next();

                if (tempUser.trim().equals(user.trim()) && tempPass.trim().equals(pass.trim())){
                    verified = true;

                }
            }
            x.close();
            out("valider!");


        } catch (Exception e) {
            out(tempUser);
            out(tempPass);
            out("Erreur, nom d'utilisateur ou mot de passe non valide");
            scannerInput();
        }*/

        /*boolean verfified = false;
        String tempUser = "";
        String tempPass = "";




        x = new Scanner(new File("passResident.txt"));
        String[] inputs = x.delimiter().split(",");
        tempUser = inputs[0];
        tempPass = inputs[1];
        out(tempPass);
        out(tempUser);

        if (user.equals(tempUser)  && pass.equals(tempPass)  ){
            verfified = true;
            out("MATCH");
        } else {
            out("erreur");
        }*/


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
                }else{
                    tabNomOptions.clear();
                    new LogInResident();
                }
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
                //out("Entre les info resident");
                //new Menu();
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

}


