import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    /**
     * @author Kim
     * Verifier que getInfoRes cherche les donnees dans le bon champ du fichier csv "informations.txt" et
     * enregistre ses donnees dans la bonne variable.
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
}