import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    /**
     * Verifier que getInfoRes cherche les donnees dans le bon champ du fichier csv "informations.txt" et
     * enregistre ses donnees dans la bonne variable.
     * @author Kim
     */
    @Test
    void getInfoRes() throws IOException {
        UserController test = new UserController();
        String[] testNumeroBac = new String[3];
        testNumeroBac[0] = "r00";
        test.getInfoRes("tyff");
        assertEquals(test.name,"Kim");
        assertEquals(test.courriel,"kim@gmail.com");
        assertEquals(test.adresse,"4321 UdeM");
        assertEquals(test.telephone,"5141234321");
        assertEquals(test.numeroBac[0],testNumeroBac[0]);
    }
    /**
     * Verifier que getInfoCons cherche les donnees dans le bon champ du fichier csv "informationsCons.txt" et
     * enregistre ses donnees dans la bonne variable.
     * @author Kim
     */
    @Test
    void getInfoCons() throws IOException {
        UserController test = new UserController();
        String[] testNumeroBac = new String[3];
        testNumeroBac[0] = "r00";
        test.getInfoCons("c00");
        assertEquals(test.name,"SCOURY");
        assertEquals(test.courriel,"scoury@gmail.com");
        assertEquals(test.adresse,"3225 rue wally");
        assertEquals(test.telephone,"5143333331");
        assertEquals(test.typeDechet,"recyclage:2000 composte:1000");
    }


}