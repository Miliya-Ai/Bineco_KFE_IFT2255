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
    public void changerMdp() throws IOException {
        String mdp = Controller.liveUser.mdp;
        out("Votre mot de passe actuel : " +mdp);

        String newMdp = scannerInput("Nouveau mot de passe : ");
        if(newMdp.equals(Controller.liveUser.user)){
            out("Mot de passe doit etre different du username");
            changerMdp();
        }
        String confirmation = scannerInput("Confirmer nouveau mot de passe : ");

        if(confirmation.equals(newMdp)){
            //Controller.liveUser.mdp = newMdp;
            if(Controller.liveUser.res){
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informations.txt"), mdp,
                        newMdp, "src/main/java/informations.txt");
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/passResident.txt"), mdp,
                        newMdp, "src/main/java/passResident.txt");
                Controller.liveUser.getInfoRes(Controller.liveUser.user);
            } else {
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informationsCons.txt"), mdp,
                        newMdp, "src/main/java/informationsCons.txt");
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/passConsommateurs.txt"), newMdp,
                        newMdp, "src/main/java/passConsommateurs.txt");
                Controller.liveUser.getInfoCons(Controller.liveUser.user);
            }

            out("Changement effectué");
            new ModifProfil();
        } else {
            out("Les deux inputs ne correspondent pas");
            changerMdp();
        }
    }

    public void changerCourriel() throws IOException {
        String mail = Controller.liveUser.courriel;
        out("Votre courriel actuel : " +mail);

        String newMail = scannerInput("Nouveau courriel : ");
        String confirmation = scannerInput("Confirmer nouveau courriel : ");

        if(confirmation.equals(newMail)){
            if(Controller.liveUser.res){
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informations.txt"), mail,
                        newMail, "src/main/java/informations.txt");
                Controller.liveUser.getInfoRes(Controller.liveUser.user);
            } else {
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informationsCons.txt"), mail,
                        newMail, "src/main/java/informationsCons.txt");
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/dataCons.txt"), mail,
                        newMail, "src/main/java/dataCons.txt");
                Controller.liveUser.getInfoCons(Controller.liveUser.user);
            }
            out("Changement effectué");
            new ModifProfil();
        } else {
            out("Les deux inputs ne correspondent pas");
            new ModifProfil();
        }
    }

    public void changerTel() throws IOException {
        String tel = Controller.liveUser.telephone;
        out("Votre telephone actuel : " +tel);

        String newTel = scannerInput("Telephone (doit etre de longueur 10) :  ");
        if(newTel.length() != 10){
            out("Input invalide (pas 10 de long)");
            changerTel();
        }
        String confirmation = scannerInput("Confirmer nouveau telephone : ");

        if(confirmation.equals(newTel)){
            //Controller.liveUser.courriel = newMail;
            if(Controller.liveUser.res){
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informations.txt"), tel,
                                                newTel, "src/main/java/informations.txt");
                Controller.liveUser.getInfoRes(Controller.liveUser.user);
            } else {
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/informationsCons.txt"), tel,
                                                newTel, "src/main/java/informationsCons.txt");
                Controller.liveUser.changeInfo(Controller.liveUser.toArrL("src/main/java/dataCons.txt"), tel,
                                                newTel, "src/main/java/dataCons.txt");
                Controller.liveUser.getInfoCons(Controller.liveUser.user);
            }

            //Controller.liveUser.getInfoRes(Controller.liveUser.user);
            out("Changement effectué");
            new ModifProfil();
        } else {
            out("Les deux inputs ne correspondent pas");
            new ModifProfil();
        }
    }


    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                if (liveUser.res){
                    new Menu();
                } else {
                    new MenuConsommateur();
                }
                break;

            case 99:
                //effacer();
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
