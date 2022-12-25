import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class MunicipInfo {


    public String[] numerosBac = {"r00", "r01","r02","d00","d01","d02","co00","co01","co02"};
    public String[] listeCons = {"c00","c01","c02","c03","c04","c05","c06","c07","c08","c09"};
    public String[] listeConsDispo = {"c10","c11","c12","c13","c14","c15","c16","c17","c18","c19"};
    public String[] listeLots = {"l00","l01","l02","l03","l04","l05","l06","l07","l08","l09"};
    public HashMap<String, String[]> consommateurs = new HashMap<>();
    //public HashMap<String, String[]> bacs = new HashMap<>();
    public String[][] lesBacs;
    public HashMap<String, int[]> feedbackCons = new HashMap<>();
    //public HashMap<String, String[]> lots = new HashMap<>();
    public String[][] lesLots;
    public String[][] lesCons;

    //public String[][] utilisateurs = getFromCsv("src/main/java/informations.txt");
    public String[][] yearDataStr = getFromCsv("src/main/java/data12mois.txt");
    public int[][] dataYear = toInt(yearDataStr);
    public int[] recyclage12mois = dataYear[0];
    public int[] composte12mois = dataYear[1];
    public int[] ordures12mois = dataYear[2];

    public ArrayList<String> problemes = new ArrayList<>();

    public ArrayList<String> message = new ArrayList<>();

    public ArrayList<String > activeUsers;


    /**
     * @throws IOException
     */
    public MunicipInfo() throws IOException {
        setConsommateurs();
        setBacs();
        setFeedbackCons();
        setLots();
        setMessage();
        activeUsers = getExUser();
    }

    /**
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<String> getExUser() throws FileNotFoundException {
        String path = "src/main/java/existingUser.txt";
        ArrayList<String> result = new ArrayList<>();
        try (FileReader f = new FileReader(path)) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    result.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    /**
     * @param str
     * @return
     */
    public int[][] toInt(String[][] str){
        int[][] inInt =new int[str.length][12];
        for (int i = 0; i < str.length; i++){
            //String[] temp = (str[i].split(","));
            for (int j = 0; j < str[i].length; j++){
                inInt[i][j] = Integer.parseInt(str[i][j]);
            }
        }
        return inInt;
    }

    /**
     *
     */
    public void setMessage(){
        message.add("Laver vos bacs! - 20 novembre 2022");

    }

    /**
     * @throws IOException
     */
    public void setConsommateurs() throws IOException {
        lesCons = getFromCsv("src/main/java/dataCons.txt");
    }

    /**
     * @throws IOException
     */
    public void setBacs() throws IOException {
        lesBacs = getFromCsv("src/main/java/bacsEmis.txt");
    }

    /**
     *
     */
    public void setFeedbackCons(){
        feedbackCons.put("c00", null);
        feedbackCons.put("c01", null);
        feedbackCons.put("c02", null);
        feedbackCons.put("c03", null);
        feedbackCons.put("c04", null);
        feedbackCons.put("c05", null);
        feedbackCons.put("c06", null);
        feedbackCons.put("c07", null);
        feedbackCons.put("c08", null);
        feedbackCons.put("c09", null);
    }

    /**
     * @throws IOException
     */
    public void setLots() throws IOException {
        lesLots = getFromCsv("src/main/java/dataLots.txt");
    }

    /**
     * @param path
     * @return
     * @throws IOException
     */
    public String[][] getFromCsv(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        String[] data = lines.toArray(new String[lines.size()]);
        br.close();

        String[][] formatted = new String[data.length][];
        for (int i = 0; i < data.length;  i++){
            formatted[i] = data[i].split(",");
        }
        return formatted;
    }

    /**
     * @param str
     * @throws IOException
     */
    public void addCons(String str) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/dataCons.txt", true));
        fw.write(str + ",");
        fw.close();
    }

    /**
     * @param str
     * @throws IOException
     */
    public void addUser(String str) throws IOException {
        FileWriter fw = (new FileWriter("src/main/java/existingUser.txt", true));
        fw.write("\n"+str);
        fw.close();
    }

    /**
     * @return
     * @throws IOException
     */
    public ArrayList toArrL() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/informations.txt"));

        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        //String[] data = lines.toArray(new String[lines.size()]);
        br.close();

        return lines;
    }

    /**
     * @param list
     * @param bac
     * @throws IOException
     */
    public void newBac(ArrayList list, String bac) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/informations.txt"));
        String strInfo = "";
        String line;
        int idx = 0;
        while ((line = reader.readLine()) != null) {
            // Check if the current line contains the search term
            if (line.contains(Controller.liveUser.user)) {
                // The line has been found, take the appropriate action
                strInfo = line;
                break;
            }
            idx += 1;
        }
        strInfo+=bac+",";
        list.set(idx, strInfo);
        PrintWriter wr = new PrintWriter("src/main/java/informations.txt");
        for(Object l : list){
            wr.println(l);
        }
        wr.close();

    }

    /**
     * @param list
     * @param bac
     * @throws IOException
     */
    public void deleteBac(ArrayList list, String bac) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/informations.txt"));
        String strInfo = "";
        String line;
        int idx = 0;
        while ((line = reader.readLine()) != null) {
            // Check if the current line contains the search term
            if (line.contains(Controller.liveUser.user)) {
                // The line has been found, take the appropriate action
                strInfo = line;
                break;
            }
            idx += 1;
        }
        String newStr = strInfo.replaceAll(","+bac, "");
        list.set(idx, newStr);
        PrintWriter wr = new PrintWriter("src/main/java/informations.txt");
        for(Object l : list){
            wr.println(l);
        }
        wr.close();
    }

}
