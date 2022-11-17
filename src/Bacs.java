import java.io.*;
import java.util.Scanner;

public class Bacs extends Page{

    public Bacs(){
        entete("Mes bacs");

        addTabNomOptions("Enregistrer un bac");
        addTabNomOptions("Supprimer un bac");
        out(afficherOptions());

        filtrer();

    }

    @Override
    public void changerPage(int intNumeroOption) throws IOException {
        switch (intNumeroOption) {
            case 0:
                tabNomOptions.clear();
                new Menu();
                break;
            case 1:
                tabNomOptions.clear();
                enregistrerBac();
                break;
            case 2:
                tabNomOptions.clear();
                supprimerBac();
                break;
            case 99:
                effacer();
                System.exit(0);

                break;
            default:
                //out("Svp, entrer un chiffre valide");
                //filtrer();
        }
    }

    public String scannerInput(String message){
        out(message);
        Scanner temp = new Scanner(System.in);
        String wut = temp.nextLine();
        return wut;

    }


    // --------------------------A FAIRE------------------------------
    public void enregistrerBac() throws IOException {
        String num = scannerInput("Numero du bac a enregistrer : ");
        for(int i = 0; i < 3; i++){
            if(num == Controller.liveUser.numeroBac[i]){
                out("Bac deja enregistré! ");
                tabNomOptions.clear();
                new Bacs();
                break;
            }
            if(Controller.liveUser.numeroBac[i] == null){
                Controller.liveUser.numeroBac[i] = num;

                addToFile(num +",");
                //Controller.liveUser.getInfoRes();
                out("Bac enregistré");
                tabNomOptions.clear();
                new Menu();
                return;
            }
        }

    }


    //-----------------------------A TESTER----------------------------
    public void supprimerBac() throws IOException {
        /*String num = scannerInput("Numero du bac a supprimer : ");
        String[] temp = new String[3];

        for(int i = 0; i < 3; i++){

            if(Controller.liveUser.numeroBac[i] == num){
                Controller.liveUser.numeroBac[i] = null;

                int k =0;
                for (int j = 0; j < 3; j++){
                    if(Controller.liveUser.numeroBac[j] != null){
                        temp[k] = Controller.liveUser.numeroBac[j];
                        k++;
                    }
                }
                Controller.liveUser.numeroBac = temp;
                out("Bac supprimé");
                new Menu();
                return;
            }
        }
        out("Numero de bac inexistant dans vos bacs!");
        new Menu();*/
        String[] temp = new String[3];
        out("Voici vos bacs : ");
        int k = 1;
        for( int i = 0; i < 3; i++){
            if(Controller.liveUser.numeroBac[i] != null){
                temp[k-1] = Controller.liveUser.numeroBac[i];
                out(k +"-  " +Controller.liveUser.numeroBac[i]);
            }
        }

        String num = scannerInput("Quel bac voulez nous supprimer? (numero correspondant) : ");
        int numInt = Integer.parseInt(num);
        if(numInt <= 3 && temp[numInt-1] != null){
            temp[numInt -1] = null;

            int m = 0;
            for(int j = 0; j < 3; j++){
                if(temp[j] != null){
                    Controller.liveUser.numeroBac[m] = temp[j];
                    m++;
                }
            }
            out("Suppression réussie");
            tabNomOptions.clear();
            new Menu();
            return;
        }
        out("Erreur dans la suppression");
        tabNomOptions.clear();
        new Menu();



    }


    public void addToFile(String str) throws IOException {
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("src/informations.txt", true));

            // Writing on output stream
            out.write(str);
            // Closing the connection
            out.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }

    }

}
