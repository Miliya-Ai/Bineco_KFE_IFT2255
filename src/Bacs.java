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

                //addToFile(num +",");
                appendInfo(num);
                //Controller.liveUser.getInfoRes();
                out("Bac enregistré");
                //Controller.liveUser.getInfoRes();
                tabNomOptions.clear();
                new Bacs();
                break;
            }
        }

    }


    //-----------------------------A TESTER----------------------------
    public void supprimerBac() throws IOException {

        String[] temp = new String[3];
        out("Voici vos bacs : ");
        int k = 1;
        for( int i = 0; i < 3; i++){
            if(Controller.liveUser.numeroBac[i] != null){
                temp[k-1] = Controller.liveUser.numeroBac[i];
                out(k +"-  " +Controller.liveUser.numeroBac[i]);
                k++;
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


    public void appendInfo(String input) throws IOException {

        String filePath = "src/informations.txt";
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }

        String fileContents = buffer.toString();
        //System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        String oldLine = Controller.liveUser.getInfoString();

        /*for (int i = 0; i < Controller.liveUser.numeroBac.length; i++){
            oldLine += Controller.liveUser.numeroBac[i];
        }*/
        //oldLine += ",";
        out(oldLine);

        String newLine = oldLine += input;
        out(newLine);
        //Replacing the old line with new line
        fileContents = fileContents.replace(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        //System.out.println("");
        //System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();


    }

}
