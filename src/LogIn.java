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


