import java.io.*;
import java.util.Scanner;

public class LogIn extends Page{


    public boolean verified = false;
   public LogIn() throws IOException {


       entete("Log in");
       out( "**** Pour quitter, appuyer 99 ****\n");
       out("Vous êtes un");
       addTabNomOptions("Résident");
       addTabNomOptions("Consommateur");
       out(afficherOptions ());



       filtrer();


       /*File fichier = new File("password.txt");
       out("Veuillez entrer votre nom d'utilsateur : ");
       Scanner myObj = new Scanner(System.in);
       String utilisateur = myObj.nextLine();

       out("Veuillez entrer votre mot de passe :");
       Scanner obj2 = new Scanner(System.in);
       String mdp = obj2.nextLine();

       verifyLogin(utilisateur, mdp);*/

       //Pourquoi save dans le login? On veut save dans le Sign In
       //Pour login on va juste verifier si 1 : utilisateur existe,
       // 2: si oui, ecq le mot de passe match.
       //save(utilisateurEtPasse);
   };

    /*public void save(String content)throws IOException{
        FileWriter fw = new FileWriter("src/password.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };*/


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                out("Entre les info resident");
                verified = true;
                new Menu();
                break;
            case 2:
                tabNomOptions.clear();
                out("Entre les info consommateur");
                verified = true;
                new Menu();
                break;
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }

    private static Scanner x;

    //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
    public void verifyLogin(String user, String pass){

        boolean verified = false;
        String tempUser = "";
        String tempPass = "";

        try {

            x = new Scanner(new File("passResident.txt"));
            x.useDelimiter("\n|,");

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
        }
    }


    public void out(String message) {
        System.out.println(message);
    }

}


