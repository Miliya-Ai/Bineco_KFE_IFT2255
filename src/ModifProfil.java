import java.io.IOException;
import java.util.Scanner;

public class ModifProfil extends Page{

    public ModifProfil(){

        entete("Modification du profil");

        addTabNomOptions("Modifier le mot de passe");
        addTabNomOptions("Modifier courriel");
        addTabNomOptions("Modifier numero de telephone");
        out(afficherOptions());
        filtrer();

    }

    public void scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();

    }
    public void changerMdp(){

        scannerInput("Ancien mot de passe : ");
        scannerInput("Nouveau mot de passe :");
        scannerInput("Confirmer nouveau mot de passe : ");
    }

    public void changerCourriel(){
        out("Ancien courriel : ");
        out("Nouveau courriel :");
        out("Confirmer courriel : ");
    }

    public void changerTel(){
        out("Ancien telephone : ");
        out("Nouveau telephone :");
        out("Confirmer telephone : ");
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
            case 99:
                effacer();
                System.exit(0);
                break;
            case 1:
                tabNomOptions.clear();
                changerMdp();
                out("changement confirmé");
                new Menu();
                break;
            case 2:
                tabNomOptions.clear();
                changerCourriel();
                out("changement confirmé");
                new Menu();
                break;
            case 3:
                tabNomOptions.clear();
                changerTel();
                out("changement confirmé");
                new Menu();
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }



}
