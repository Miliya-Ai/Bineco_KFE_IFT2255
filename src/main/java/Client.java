import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * S'occupe de l'inscription des clients
 */
abstract class  Client extends Page {
    public boolean isPasswordEligible;

    /**
     * @param message texte que le resident entre dans la console
     * @return le string lu
     */
    public String scannerInput(String message){
        out(message);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

    /**
     * Enregistrer le nom d'utilisateur et le mot de passe du client lors de l'inscription.
     *
     * @param content nom d'utilisateur et le mot de passe
     * @param isResident si c'est un resident, enregistrer ses informations dans le fichier correspondant
     * @throws IOException si le fichier n'est pas present, une exception se produit
     */
    public void save(String content, Boolean isResident)throws IOException {
        String path;
        String path2;
        if (isResident){
            path = "src/main/java/passResident.txt"; //contient seulement le nom d'utilisateur et mot de passe des residents
            path2 = "src/main/java/informations.txt"; //contient toutes les informations des residents
        }else {
            path = "src/main/java/passConsommateur.txt"; //contient seulement le nom d'utilisateur et mot de passe des consommateurs
            path2 = "src/main/java/informationsCons.txt"; //contient toutes les informations des consommateurs
        }

        FileWriter fw = new FileWriter(path, true);
        fw.write(content+"\n");
        fw.close();

        FileWriter fw2 = new FileWriter(path2, true);
        fw2.write(content+",");
        fw2.close();

    }

    /**
     * Demande au client de choisir son nom d'utilisateur et un mot de passe lors de l'inscription.
     * <p>
     *     Comme les donnees des clients sont emmagasinees dans des fichiers de format csv, le nom d'utilisateur
     *     ne doit pas contenir de virgule.
     *
     *     La methode ne permet pas de nom d'utilisateur duplique.Si le nom d'utilisateur existe deja,
     *     le client doit en choisir un autre.
     * </p>
     * @param isResident si c'est un resident, enregistrer ses donnees dans le bon fichier
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     * @see #passwordEligible(String, boolean)
     */
    public void credentials (Boolean isResident) throws IOException {
        out("Veuillez choisir un nom d'utilisateur (pas de virgule!):");
        Scanner myUser = new Scanner(System.in);
        String userAccount = myUser.nextLine();

        for(int i = 0; i < Controller.municipInfo.activeUsers.size(); i++){
            String it = Controller.municipInfo.activeUsers.get(i);
            it = it.replaceAll("[\\r\\n]", "");
            if(userAccount.equals(it)){
                out("Nom d'utilisateur deja utilisé!");
                credentials(isResident);
                return;
            }
        }


        Controller.municipInfo.addUser(userAccount);
        Controller.tempInfo[0] = userAccount;
        //le nom d'utilisateur est elligible, demander maintenant de choisir un mot de passe
        passwordEligible(userAccount, isResident);

    }

    /**
     * Une fois le nom d'utilisateur choisi, choisir un mot de passe.
     *<p>
     *     Le mot de passe doit contenir seulement des lettres (majuscules ou minuscules) et des chiffres. Il sera
     *     enregistre dans un fichier de format csv: il ne pourra pas contenir de virgules.
     *</p>
     *
     *
     * @param userAccount nom d'utilisateur
     * @param isResident si c'est un resident, sauvegarder l'information dans le fichier correspondant
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void passwordEligible(String userAccount,boolean isResident) throws IOException {
        // Regex trouver sur
        // https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letters-and-numbers
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
            save(userAccount, isResident); //enregistre l'information
            Controller.tempInfo[1] = password;
        } else {
            passwordEligible(userAccount, isResident);
        }
    }

    /**
     * Enregistre les informations propres aux residents.
     * <p>Informations et leur index correspondant dans tempInfo dans {@link Controller}:
     *      <ol>
     *          <li>Nom d'utilisateur</li>
     *          <li>Mot de passe</li>
     *          <li>Courriel</li>
     *          <li>Addresse</li>
     *          <li>Telephone</li>
     *      </ol>
     * </p>
     * @param info information du resident
     * @param index index correspondant a l'information a enregistrer dans tempInfo
     *
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void saveInfo(String info, int index) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/informations.txt", true));
        fw.write(info + ",");
        fw.close();

        Controller.tempInfo[index] = info;

    }

    /**
     * Enregistre les infomations propres aux consommateurs.
     *
     * <p>Informations et leur index correspondant dans tempInfo dans {@link Controller}:
     *      <ol>
     *          <li>Nom d'utilisateur</li>
     *          <li>Mot de passe</li>
     *          <li>Type de dechets traites</li>
     *          <li>Courriel</li>
     *          <li>Addresse</li>
     *          <li>Telephone</li>
     *      </ol>
     *
     * </p>
     * @param info information du consommateur
     * @param index index correspondant a l'information a enregistrer dans tempInfo
     * @return information a enregistre
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public String saveInfoCons(String info, int index) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/informationsCons.txt", true));
        fw.write(info + ",");
        fw.close();
        Controller.tempInfoCons[index] = info;
        return info;
    }

    /**
     * Ajoute un "new line" pour que les nouvelles informations futurs ne soit pas toutes sur la meme ligne.
     * @param path le fichier qui avait ete modifie
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void newLine(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write("\n");
        writer.close();
    }

}