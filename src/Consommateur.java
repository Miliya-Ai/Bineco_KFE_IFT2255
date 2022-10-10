import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Consommateur extends Page{

    public Consommateur() throws IOException {
        entete("Consommateur");

        out( "**** Pour quitter, appuyer 99 ****\n");

        addTabNomOptions("Revenir a la page d'acceuil");
        out(afficherOptions());

        out("\nVeuillez choisir un nom d'utilisateur : ");
        out("Choisissez un mot de passe (que des lettres ou des chiffres) : ");
        out("Nom : ");
        out("Courriel : ");
        out("Adresse : ");
        out("Telephone : ");
        out("Type de dechets traités : ");
        out("Capacité de traitement : ");
        out("Activité d'exploitation : ");

        filtrer();

        /*out("Veuillez choisir un nom d'utilisateur");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();
        out("Choisissez un mot de passe (que des lettres ou des chiffres)");
        Scanner myPass = new Scanner(System.in);
        String password = myPass.nextLine();
        userAccount += ","+password;
        save(userAccount);*/
    }


    public void save(String content)throws IOException {
        FileWriter fw = new FileWriter("src/passConsommateur.txt",true);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.append("\n"+ content  );
        writer.flush();
        writer.close();

    };

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


}
