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
                this.numeroBac[0] = tokens[6];
                this.res = true;
                return;
            }

        }
    }

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
