import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SignInTest {

    @Test
    public void testChangerPage() throws IOException {
        SignIn signIn = new SignIn();

        // Test changing to Resident page
        signIn.changerPage(1);
        assertTrue(signIn.tabNomOptions.isEmpty());

        // Test changing to Consommateur page
        signIn.changerPage(2);
        assertTrue(signIn.tabNomOptions.isEmpty());

        // Test exiting the program
        signIn.changerPage(99);
        // We can't directly test if the program exited, so we can add a flag variable to check if it did
       // assertTrue(signIn.exited);

        // Test entering an invalid option
        signIn.changerPage(3);
        assertFalse(signIn.tabNomOptions.isEmpty());
    }
}