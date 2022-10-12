import java.io.*;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class LogInConsommateur extends Page{

        public LogInConsommateur() throws FileNotFoundException {

            entete("Log in");
            out( "**** Pour quitter, appuyer 99 ****\n");
            addTabNomOptions("Enter");
            out(afficherOptions ());
            scannerInput();

        }


    public void scannerInput() throws FileNotFoundException {
        out("Nom d'utilisateur :");
        Scanner nom = new Scanner(System.in);
        String userName = nom.nextLine();

        out("Mot de passe:");
        Scanner mtp = new Scanner(System.in);
        String password = mtp.nextLine();
        verifyLogin(userName, password);

    }

            String username;
            String pwd;
            boolean verified = false;

            //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
            //https://stackoverflow.com/questions/4008905/read-multiline-text-with-values-separated-by-whitespaces
            public void verifyLogin(String user, String pass) {

                try{
                    FileInputStream fstream = new FileInputStream("src/passConsommateur.txt");
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null)   {
                        String[] tokens = strLine.split(" ");
                        if (tokens[0].equals( user) && tokens[1].equals(pass)){
                            tabNomOptions.clear();
                            new MenuConsommateur();
                        }else{
                            tabNomOptions.clear();
                            new LogInConsommateur();
                        }
                    }
                    in.close();
                } catch (Exception e){
                    System.err.println("Error: " + e.getMessage());
                }
            }


            public void changerPage ( int intNumeroOption) throws IOException {
                switch (intNumeroOption) {
                    case 1:
                        tabNomOptions.clear();
                        out("Entre les info resident");
                        verified = true;
                        new Menu();
                        break;
                    case 2:
                        tabNomOptions.clear();
                        out("Entre les info consommateur");
                        new LogInConsommateur();
                        verified = true;
                        new Menu();
                        break;
                    case 99:
                        effacer();
                        System.exit(0);

                        break;
                    default:
                        out("Svp, entrer un chiffre valide");
                        filtrer();
                }
            }

    }