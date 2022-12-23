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
        String path2;
        if (isResident){
            path = "src/main/java/passResident.txt";
            path2 = "src/main/java/informations.txt";
        }else {
            path = "src/main/java/passConsommateur.txt";
            path2 = "src/main/java/informationsCons.txt";
        }

        /*FileWriter fw = new FileWriter(path,true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append(content +"\n"  );
        writer.flush();
        writer.close();*/

        FileWriter fw = new FileWriter(path, true);
        fw.write(content+"\n");
        fw.close();

        FileWriter fw2 = new FileWriter(path2, true);
        fw2.write(content+",");
        fw2.close();

    }

    public void credentials (Boolean isResident) throws IOException {
        out("Veuillez choisir un nom d'utilisateur (pas de virgule!):");
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
        out("Choisissez un mot de passe (au moins une lettre et un chiffre, pas de virgule!) :");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        if(password.equals(userAccount)){
            out("Mot de passe ne peut pas etre meme chose que le username.");
            passwordEligible(userAccount, isResident);
        }
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

    public String saveInfoCons(String info, int index) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/informationsCons.txt", true));
        fw.write(info + ",");
        fw.close();
        Controller.tempInfoCons[index] = info;
        return info;
    }

    public void newLine(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write("\n");
        writer.close();
    }

}