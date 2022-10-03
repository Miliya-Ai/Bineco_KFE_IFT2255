import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LogIn {

   public LogIn() {
       File fichier = new File("password.txt");
       fichier.createNewFile();
       out("veuillez entrer votre nom d'utilsateur");
       out("veuillez entrer votre mot de passe");
   };

    Scanner myObj = new Scanner(System.in);

    public String save(){
        FileOutputStream fileOutputStream = new FileOutputStream(myObj);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
    };
    public void out(String message) {
        System.out.println(message);
    }

}


