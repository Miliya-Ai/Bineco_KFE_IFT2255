import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MunicipInfoTest {
    /**
     * @author Miliya Ai
     * @throws IOException
     */

    @Test
    void toInt() throws IOException {
       MunicipInfo test = new MunicipInfo();
       String[][] testNumero = {{"1"},{"1"}};
       test.toInt(testNumero);
       int[][] attendu = {{1},{1}};
       assertEquals(test.toInt(testNumero)[0][0],attendu[0][0]);

    }
    /**
     * S'assurer que le fichier cherche la bonne information
     * @author Flory
     * @throws IOException
     */
    @Test
    void toArrL() throws IOException {
        UserController testController = new UserController();
        ArrayList test = new ArrayList();
        test.add("test1 test helloo");
        assertEquals(testController.toArrL("src/test/java/toArrLTest.txt").get(0), test.get(0));
    }

    /**
     * Verifie que les informations d'une liste se transforme bien en un array de String.
     * @author Flory
     * @throws IOException La methode utilise des methodes qui lisent des fichiers.
     *                     Si le fichier n'est pas present, une exception se produit.
     */
    @Test
    void getFromCsv() throws IOException {
        MunicipInfo test = new MunicipInfo();
        String[] data = new String[1];
        data [0] = "nom";
        String [][] formatedTest = new String[][]{data};
        assertArrayEquals(test.getFromCsv("src/test/java/getFromCSVTest.txt"), formatedTest);
    }
}
