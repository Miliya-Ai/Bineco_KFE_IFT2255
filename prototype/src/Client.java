import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class  Client extends Page {
    public boolean isPasswordEligible;

    public void scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();

    }

    public void save(String content, Boolean isResident)throws IOException {
        String path;
        if (isResident){
            path = "src/passResident.txt";
        }else {
            path = "src/passConsommateur.txt";}

        FileWriter fw = new FileWriter(path,true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append(content +"\n"  );
        writer.flush();
        writer.close();

    }

    public void credentials (Boolean isResident) throws IOException {
        out("Veuillez choisir un nom d'utilisateur :");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();
        passwordEligible(userAccount, isResident);

    }

    public void passwordEligible(String userAccount,boolean isResident) throws IOException {
        // Regex trouver sur https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letters-and-numbers
        out("Choisissez un mot de passe (que des lettres et des chiffres) :");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        isPasswordEligible =  password.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*");

        if (isPasswordEligible){
            userAccount += " " + password;
            save(userAccount, isResident);
        } else {
            passwordEligible(userAccount, isResident);
        }
    }

}