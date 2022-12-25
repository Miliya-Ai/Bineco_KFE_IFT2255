import java.io.IOException;
import java.util.Scanner;

/**
 * Permet a l'utilisateur de modifier ses renseignements personnels
 */
public class ModifProfil extends Page{

    /**
     * Constructeur de ModifProfil: Imprime les options valident
     */
    public ModifProfil(){

        entete("Profil");

        addTabNomOptions("Modifier le mot de passe");
        addTabNomOptions("Modifier courriel");
        addTabNomOptions("Modifier numero de telephone");
        addTabNomOptions("Voir mes infos");
        out(afficherOptions());
        filtrer();

    }

    /**
     * @param message texte que le resident entre dans la console
     * @return le string lu
     */
    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String line = temp.nextLine();
        return line;

    }

    /**
     * Le nouveau mot de passe ne doit correspondre au nom d'utilisateur. Lors du changement, il faut confirmer a
     * nouveau le nouveau mot de passe.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
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

    /**
     * Lors du changement, il faut confirmer a nouveau le nouveau courriel.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
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

    /**
     * Le nouveau numero de telephone doit contenir 10 chiffre de format: 5145145143. Lors du changement,
     * il faut confirmer a nouveau le nouveau numero de telephone.
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
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


    /**
     * @param intNumeroOption L'utilisateur choisit l'action a entreprendre.
     *                        Les nombres representent l'action.
     *                        <ol>
     *                        <li>Modifier le mot de passe</li>
     *                        <li>Modifier courriel</li>
     *                        <li>Modifier numero de telephone</li>
     *                        <li>Voir mes infos</li>
     *                        </ol>
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
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
