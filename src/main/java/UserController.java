import java.io.*;
import java.util.ArrayList;

/**
 *
 */
public class UserController extends Controller{

    public String user, mdp, name, adresse, telephone, courriel;
    public String typeDechet, capacite, activite, code;
    public String[] numeroBac = new String[3];
    public boolean res;


    public UserController(){}

    /**
     * @param usr le nom d'utilisateur
     */
    public void setUser(String usr){
        this.user = usr;
    }

    /**
     * @param pass le mot de passe
     */
    public void setMdp(String pass){
        this.mdp = pass;
    }

    /**
     * Cherche toutes les informations d'un resident et les emmagasinent dans leurs variables correspondant.
     *
     * @param usr le nom d'utilisateur d'un resident
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                    Si le fichier n'est pas present, une exception se produit.
     */
    public void getInfoRes(String usr) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/java/informations.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(",");
            if(tokens[0].equals(usr)){
                setUser(tokens[0]);
                setMdp(tokens[1]);
                this.name = tokens[2];
                this.courriel = tokens[3];
                this.adresse = tokens[4];
                this.telephone = tokens[5];
                for (int i = 6; i < tokens.length; i++){
                    this.numeroBac[i-6] = tokens[i];
                }
                this.res = true;
                return;
            }

        }
    }

    /**
     * Cherche toutes les informations d'un consommateur et les emmagasinent dans leurs variables correspondant.
     *
     * @param usr le nom d'utilisateur d'un consommateur
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                    Si le fichier n'est pas present, une exception se produit.
     */
    public void getInfoCons(String usr) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/java/informationsCons.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(",");
            if (tokens[0].equals(usr)){
                setUser(tokens[0]);
                setMdp(tokens[1]);
                this.name = tokens[2];
                this.courriel = tokens[4];
                this.adresse = tokens[5];
                this.telephone = tokens[6];
                this.typeDechet = tokens[3];
                this.capacite = tokens[3];
                //this.activite = tokens[8];
                this.res = false;
            }

        }
    }

    /**
     * Imprime les informations du client qui avait ete affecte lors de {@link #getInfoCons(String usr)} ou
     * {@link #getInfoRes(String usr)}.
     */
    public void afficherInfo(){

        if (res){
            System.out.println("Nom :  "+this.name);
            System.out.println("Courriel :  "+this.courriel);
            System.out.println("Adresse :  "+this.adresse);
            System.out.println("Telephone :  "+this.telephone);
            System.out.println("Bac1 :  "+this.numeroBac[0]);
            System.out.println("Bac2 :  "+this.numeroBac[1]);
            System.out.println("Bac3 :  "+this.numeroBac[2]);
        } if(res == false) {
            //System.out.println(this.code);
            System.out.println("Nom :  "+this.name);
            System.out.println("Courriel :  "+this.courriel);
            System.out.println("Adresse :  "+this.adresse);
            System.out.println("Telephone :  "+this.telephone);
            System.out.println("Type et capacité :  "+this.typeDechet);
            //System.out.println("Nom :  "+this.capacite);
        }

    }
    /**
     * Utiliser lorsque l'utilisateur souhaite modifier son profil. Il faut aller chercher l'information existante.
     * @param path le fichier a extraire l'information
     * @return information de l'utilisateur sour la forme d'un ArrayList
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     * @see ModifProfil
     */
    public ArrayList toArrL(String path) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader(path));

        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        String[] data = lines.toArray(new String[lines.size()]);
        br.close();

        return lines;
    }


    /**
     * Modifie le fichier correspondant en remplacant l'ancienne information par la nouvelle.
     * @param list toutes les informations du client
     * @param info ancienne information qu'on veut modifier
     * @param newOne nouvelle information qui remplacera l'ancienne
     * @param path le fichier qui contient les informations du client qui sera modifie
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    public void changeInfo(ArrayList list, String info, String newOne, String path) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(path));
        String strInfo = "";
        String line;
        int idx = 0;
        while ((line = reader.readLine()) != null) {
            // Check if the current line contains the search term
            if (line.contains(info) && (line.contains(this.user)||line.contains(this.name))) {
                // The line has been found, take the appropriate action
                strInfo = line;
                break;
            }
            idx += 1;
        }
        String newStr = strInfo.replaceAll(info, newOne);
        list.set(idx, newStr);

        PrintWriter wr = new PrintWriter(path);
        for(Object l : list){
            wr.println(l);
        }
        wr.close();
    }

}
