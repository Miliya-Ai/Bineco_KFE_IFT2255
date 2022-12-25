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

    String info;


    /**
     *
     */
    public UserController(){


    }

    /**
     * @param usr
     */
    public void setUser(String usr){
        this.user = usr;
    }

    /**
     * @param pass
     */
    public void setMdp(String pass){
        this.mdp = pass;
    }

    /**
     * @return
     * @throws IOException
     */
    public String getInfoString() throws IOException {
        String str = null;
        FileInputStream fstream = new FileInputStream("src/informations.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        str = br.readLine();

        return str;
    }


    /**
     * @param usr
     * @throws IOException
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
     * @param usr
     * @throws IOException
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
     *
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
     * @param path
     * @return
     * @throws IOException
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
     * @param list
     * @param info
     * @param newOne
     * @param path
     * @throws IOException
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
