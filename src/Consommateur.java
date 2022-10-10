import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Consommateur extends Page{

    public Consommateur() throws IOException {
        entete("Consommateur");

        out("Veuillez choisir un nom d'utilisateur");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();
        out("Choisissez un mot de passe (que des lettres ou des chiffres)");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        userAccount += ","+password;
        save(userAccount);
    }


    public void save(String content)throws IOException {
        FileWriter fw = new FileWriter("src/passConsommateur.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };


}
