import javax.naming.ldap.Control;
import java.io.*;
import java.util.Scanner;

public class LogIn extends Page{


    public boolean verified = false;
    public LogIn() throws IOException {


       entete("Log in");
       out( "**** Pour quitter, appuyer 99 ****\n");
       //out("Vous êtes un");
       //addTabNomOptions("Résident");
       //addTabNomOptions("Consommateur");
       //out(afficherOptions ());

        addTabNomOptions("Enter");
        out(afficherOptions ());
        scannerInput();


       filtrer();


   };

    public void scannerInput() throws FileNotFoundException {
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }

    public void verifyLogin(String user, String pass) throws FileNotFoundException {

        try{
            FileInputStream fstream = new FileInputStream("src/main/java/passResident.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(",");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.setUser(user);
                    Controller.liveUser.setMdp(pass);
                    Controller.liveUser.name = Controller.tempInfo[0];
                    Controller.liveUser.courriel = Controller.tempInfo[1];
                    Controller.liveUser.adresse = Controller.tempInfo[2];
                    Controller.liveUser.telephone = Controller.tempInfo[3];
                    Controller.liveUser.numeroBac[0] = Controller.tempInfo[4];
                    Controller.liveUser.res = true;
                    new Menu();
                    return;
                }
            }
            in.close();

            FileInputStream fstream2 = new FileInputStream("src/main/java/passConsommateur.txt");
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine2 = br2.readLine()) != null)   {
                String[] tokens = strLine2.split(",");
                if (tokens[0].equals( user) && tokens[1].equals(pass)){
                    tabNomOptions.clear();
                    Controller.liveUser.setUser(user);
                    Controller.liveUser.setMdp(pass);
                    Controller.liveUser.code = Controller.tempInfoCons[0];
                    Controller.liveUser.name = Controller.tempInfoCons[1];
                    Controller.liveUser.courriel = Controller.tempInfoCons[2];
                    Controller.liveUser.adresse = Controller.tempInfoCons[3];
                    Controller.liveUser.telephone = Controller.tempInfoCons[4];
                    Controller.liveUser.typeDechet = Controller.tempInfoCons[5];
                    Controller.liveUser.capacite = Controller.tempInfoCons[6];
                    Controller.liveUser.res = false;

                    String[] lesCons = Controller.municipInfo.listeCons;
                    String[] temp = new String[lesCons.length+1];
                    for (int i = 0; i < temp.length-1; i++){
                        temp[i] = lesCons[i];
                    }
                    temp[temp.length-1] = Controller.tempInfoCons[0];
                    Controller.municipInfo.listeCons = temp;
                    Controller.municipInfo.consommateurs.put(Controller.tempInfoCons[0],
                            new String[]{Controller.tempInfoCons[1],Controller.tempInfoCons[5]
                            +":"+Controller.tempInfoCons[6]});
                    new MenuConsommateur();
                    return;
                }
            }
            in2.close();
            tabNomOptions.clear();
            out("Erreur d'informations de connexion");
            new LogIn();

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 1:
                tabNomOptions.clear();
                //out("Entre les info resident");
                //new LogInResident();
                //verified = true;
                //new Menu();
                break;
            case 2:
                tabNomOptions.clear();
                //out("Entre les info consommateur");
                //new LogInConsommateur();
                //verified = true;
                //new Menu();
                break;
            case 99:
                //effacer();
                System.exit(0);

                break;
            default:
                out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }



    public void out(String message) {
        System.out.println(message);
    }

}


