import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MunicipInfoTest {

    @Test
    void toInt() throws IOException {
       MunicipInfo test = new MunicipInfo();
       String[][] testNumero = {{"1"},{"1"}};
       test.toInt(testNumero);
       int[][] attendu = {{1},{1}};
       assertEquals(test.toInt(testNumero)[0][0],attendu[0][0]);

    }

}