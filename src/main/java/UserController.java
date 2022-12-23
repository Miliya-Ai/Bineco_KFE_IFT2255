import java.io.*;

public class UserController extends Controller{



    public String user, mdp, name, adresse, telephone, courriel;
    public String typeDechet, capacite, activite, code;
    public String[] numeroBac = new String[3];
    public boolean res;

    String info;



    public UserController(){


    }

    public void setUser(String usr){
        this.user = usr;
    }

    public void setMdp(String pass){
        this.mdp = pass;
    }

    public String getInfoString() throws IOException {
        String str = null;
        FileInputStream fstream = new FileInputStream("src/informations.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        /*while ((br.readLine()) != null)   {
            str = br.readLine();
        }*/
        str = br.readLine();

        return str;
    }


    public void getInfoRes() throws IOException {
        FileInputStream fstream = new FileInputStream("src/java/main/informations.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(",");
            this.name = tokens[2];
            this.courriel = tokens[3];
            this.adresse = tokens[4];
            this.telephone = tokens[5];
            this.numeroBac[0] = tokens[6];
            return;
        }
    }

    public void getInfoCons() throws IOException {
        FileInputStream fstream = new FileInputStream("src/informations.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(",");
            this.name = tokens[2];
            this.courriel = tokens[3];
            this.adresse = tokens[4];
            this.telephone = tokens[5];
            this.typeDechet = tokens[6];
            this.capacite = tokens[7];
            this.activite = tokens[8];
        }
    }

    public void afficherInfo(){

        if (res){
            System.out.println(this.name);
            System.out.println(this.courriel);
            System.out.println(this.adresse);
            System.out.println(this.telephone);
            System.out.println(this.numeroBac[0]);
            System.out.println(this.numeroBac[1]);
            System.out.println(this.numeroBac[2]);
        } if(res == false) {
            System.out.println(this.code);
            System.out.println(this.name);
            System.out.println(this.courriel);
            System.out.println(this.adresse);
            System.out.println(this.telephone);
            System.out.println(this.typeDechet);
            System.out.println(this.capacite);
        }

    }

}
