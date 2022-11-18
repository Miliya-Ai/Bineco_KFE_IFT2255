import java.io.IOException;
import java.util.Scanner;

public class ModifProfil extends Page{

    public ModifProfil(){

        entete("Profil");

        addTabNomOptions("Modifier le mot de passe");
        addTabNomOptions("Modifier courriel");
        addTabNomOptions("Modifier numero de telephone");
        addTabNomOptions("Voir mes infos");
        out(afficherOptions());
        filtrer();

    }

    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;

    }
    public void changerMdp(){

        out("Votre mot de passe actuel : " +Controller.liveUser.mdp);

        String newMdp = scannerInput("Nouveau mot de passe : ");
        String confirmation = scannerInput("Confirmer nouveau mot de passe : ");

        if(confirmation.equals(newMdp)){
            Controller.liveUser.mdp = newMdp;
            out("Changement effectué");
        } else {
            out("Les deux inputs ne correspondent pas");
        }
    }

    public void changerCourriel(){
        out("Votre courriel actuel : " +Controller.liveUser.courriel);

        String newMail = scannerInput("Nouveau courriel : ");
        String confirmation = scannerInput("Confirmer nouveau courriel : ");

        if(confirmation.equals(newMail)){
            Controller.liveUser.courriel = newMail;
            out("Changement effectué");
        } else {
            out("Les deux inputs ne correspondent pas");
        }
    }

    public void changerTel(){
        out("Votre telephone actuel  : " +Controller.liveUser.telephone);

        String newTel = scannerInput("Nouveau telephone : ");
        String confirmation = scannerInput("Confirmer telephone : ");

        if(confirmation.equals(newTel)){
            Controller.liveUser.telephone = newTel;
            out("Changement effectué");
        } else {
            out("Les deux inputs ne correspondent pas");
        }
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 99:
                effacer();
                System.exit(0);
                break;
            case 1:
                tabNomOptions.clear();
                changerMdp();
                //out("changement confirmé");
                new ModifProfil();
                break;
            case 2:
                tabNomOptions.clear();
                changerCourriel();
                //out("changement confirmé");
                new ModifProfil();
                break;
            case 3:
                tabNomOptions.clear();
                changerTel();
                //out("changement confirmé");
                new ModifProfil();
                break;
            case 4:
                tabNomOptions.clear();
                Controller.liveUser.afficherInfo();
                out("Appuyez sur 0 pour retourner au Menu");
                filtrer();
                break;
            default:
                out("Svp, entrer un chiffre valide");
                filtrer();
        }
    }



}
