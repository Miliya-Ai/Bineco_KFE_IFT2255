import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConsommateurTest {

    @Test
    void TestgetName() throws IOException {
        Consommateur consommateur = new Consommateur(false);


        // Test valid name
        String validName = "ValidName";
        assertEquals(consommateur.getName(),validName);
    }


}