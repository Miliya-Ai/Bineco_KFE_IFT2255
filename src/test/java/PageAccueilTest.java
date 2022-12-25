import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PageAccueilTest {

    @Test

    void TestchangerPage() throws IOException {
        var accueil =new PageAccueil();
        // Test pour Log In
        accueil.changerPage(1);
        assertTrue(accueil.tabNomOptions.isEmpty());

        // Test pour Sign In
        accueil.changerPage(2);
        assertTrue(accueil.tabNomOptions.isEmpty());

        // Tester si le programme quitte
//        accueil.changerPage(99);
//
//        assertTrue(accueil.exited);

        // Tester des mauvaises entrées
        accueil.changerPage(3);
        assertFalse(accueil.tabNomOptions.isEmpty());


    }
}