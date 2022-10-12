import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class LogInResident extends Page{

    private static Scanner x;

    public LogInResident(){
        entete("Log in");
        out( "**** Pour quitter, appuyer 99 ****\n");
        addTabNomOptions("Enter");
        out(afficherOptions ());
        scannerInput();
        filtrer();
    }

    public void scannerInput(){
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }
    //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
    public void verifyLogin(String user, String pass){

        boolean verified = false;
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
        }
    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                //out("Entre les info resident");
                new Menu();
                //verified = true;
                //new Menu();
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


