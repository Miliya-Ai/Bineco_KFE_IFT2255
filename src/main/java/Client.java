import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

abstract class  Client extends Page {
    public boolean isPasswordEligible;

    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;
    }

    public void save(String content, Boolean isResident)throws IOException {
        String path;
        if (isResident){
            path = "src/main/java/passResident.txt";
        }else {
            path = "src/main/java/passConsommateur.txt";}

        /*FileWriter fw = new FileWriter(path,true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append(content +"\n"  );
        writer.flush();
        writer.close();*/

        FileWriter fw = new FileWriter(path, true);
        fw.write(content+"\n");
        fw.close();
    }

    public void credentials (Boolean isResident) throws IOException {
        out("Veuillez choisir un nom d'utilisateur :");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();

        /*BufferedWriter writer = new BufferedWriter(new FileWriter("src/informations.txt", true));
        writer.write(userAccount + ",");
        writer.close();*/
        Controller.tempInfo[0] = userAccount;
        passwordEligible(userAccount, isResident);

    }

    public void passwordEligible(String userAccount,boolean isResident) throws IOException {
        // Regex trouver sur https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letters-and-numbers
        out("Choisissez un mot de passe (que des lettres et des chiffres) :");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        isPasswordEligible =  password.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*");

        if (isPasswordEligible){
            userAccount += "," + password;
            save(userAccount, isResident);

            /*BufferedWriter writer = new BufferedWriter(new FileWriter("src/informations.txt", true));
            writer.write(password + ",");
            writer.close();*/
            Controller.tempInfo[1] = password;
        } else {
            passwordEligible(userAccount, isResident);
        }
    }

    public void saveInfo(String info, int index) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/informations.txt", true));
        fw.write(info + ",");
        fw.close();

        Controller.tempInfo[index] = info;

    }

    public void saveInfoCons(String info, int index){
        Controller.tempInfoCons[index] = info;
    }

    public void newLine() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/informations.txt", true));
        writer.write("\n");
        writer.close();
    }

}