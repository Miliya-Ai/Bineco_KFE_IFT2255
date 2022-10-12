import java.io.*;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class LogInConsommateur extends Page{

    public void readFichier() {
        try {

            String pathname = "src/passConsommateur.txt";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

            String username;
            String pwd;
            boolean verified = false;

            //Fonction pour regarder si l<utilisateur existe, et si oui, ecq le mot de passe est bon
            public void verifyLogin() {

                Scanner scanner = new Scanner(System.in);

                for (; ; ) {
                    System.out.print("entrer nom d'utilisation ：");
                    username = scanner.next();
                    System.out.print("entrer mot de passe：");
                    pwd = scanner.next();

                    if (username.equals(username) && pwd.equals(pwd)) {

                        for (; ; ) {
                            System.out.println("entrer nouvelle nom d'utilisation：");
                            pwd = scanner.next();
                            System.out.println("entrer nouvelle mot de passe：");
                            String password = scanner.next();
                            if (pwd.equals(password)) {
                                this.pwd = password;
                                System.out.println("entrer avec succès, ton mot de passe ：" + pwd);

                                break;
                            } else {
                                System.out.println("C'est pas correct, reentrer ça：");
                            }
                        }
                        break;
                    } else {
                        System.out.println("les deux pas correct，reentrer ça ：");
                    }
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
                        System.exit(0);
                        break;
                    default:
                        out("Svp, entrer un chiffre valide");
                        filtrer();
                }
            }

    }