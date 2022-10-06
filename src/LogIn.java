import java.io.*;
import java.util.Scanner;

public class LogIn {

   public LogIn() throws IOException {
       File fichier = new File("password.txt");
       out("Veuillez entrer votre nom d'utilsateur : ");
       out("Veuillez entrer votre mot de passe :");
       Scanner myObj = new Scanner(System.in);
       String utilisateurEtPasse = myObj.nextLine();

       //Pourquoi save dans le login? On veut save dans le Sign In
       //Pour login on va juste verifier si 1 : utilisateur existe,
       // 2: si oui, ecq le mot de passe match.
       save(utilisateurEtPasse);
   };

    public void save(String content)throws IOException{
        FileWriter fw = new FileWriter("src/password.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };

    //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
    public void checkCrendentials(String userMdp){

    }


    public void out(String message) {
        System.out.println(message);
    }

}


