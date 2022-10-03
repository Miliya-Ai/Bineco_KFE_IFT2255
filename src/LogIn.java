import java.io.*;
import java.util.Scanner;

public class LogIn {

   public LogIn() throws IOException {
       File fichier = new File("password.txt");
       out("veuillez entrer votre nom d'utilsateur");
       out("veuillez entrer votre mot de passe");
       Scanner myObj = new Scanner(System.in);
       String utilisateurEtPasse = myObj.nextLine();
       save(utilisateurEtPasse);
   };

    public void save(String content)throws IOException{
        FileWriter fw = new FileWriter("src/password.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };


    public void out(String message) {
        System.out.println(message);
    }

}


