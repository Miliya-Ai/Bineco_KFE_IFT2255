import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BacsTest {
    @Test
    void supprimerBac() throws IOException {
        Controller testCon = new Controller();
        Bacs test = new Bacs();
        String[] testNumeroBac = new String[3];
        testNumeroBac[0] = "r00";
        test.supprimerBac();
    }
}
