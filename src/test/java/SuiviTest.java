import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuiviTest {
    public Suivi test;
    @BeforeEach
    void initialiserEnv(){
        test = new Suivi(false);
    }

    /**
     * @author Kim
     * Test si le calcul est bon
     */
    @Test
    void avgSum() {

        int[] arrayTest = {0,0,0};
        String attendu = "Moyenne : 0.0   Quantitée totale : 0";
        assertEquals(test.avgSum(1, arrayTest), attendu);
    }

    /**
     * @author Xavier
     * La proportion de quantite recycle, composte ou mis a l'echet doit etre NaN pour une quantite = 0.
     */
    @Test
    void propotions() {
        int[] arrayTest = {0};
        float propR = 0;
        float propC = 0;
        float propO = 0;
        String attendu = "Recyclage : NaN"+",  "+"Composte : NaN"+",  Ordures : NaN"+
                "\n---NaN"+"% de tout n'est ni recyclé, ni composté.";
        assertEquals(test.propotions(1, arrayTest, arrayTest, arrayTest), attendu);
    }
}