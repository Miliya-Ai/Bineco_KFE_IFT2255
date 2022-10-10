import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Resident extends Page{

    public Resident()throws IOException{
        entete("Resident");

        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Revenir a la page d'acceuil");
        out(afficherOptions());
        out("\nChoisir nom utilisateur : ");
        out("Choisir mot de passe : ");
        out("Nom et prenom : ");
        out("Courriel : ");
        out("Adresse : ");
        out("Telephone : ");
        out("Numero du premier bac a enregistrer : ");



        //Creation des credentials pour LogIn
        /*out("Veuillez choisir un nom d'utilisateur");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();
        out("Choisissez un mot de passe (que des lettres ou des chiffres)");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        userAccount += ","+password;
        save(userAccount);*/

        //Information du consommateur
        filtrer();


    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                new PageAccueil();
                break;
            case 99:
                System.exit(0);
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }




    public void save(String content)throws IOException {
        FileWriter fw = new FileWriter("src/passResident.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };
}
