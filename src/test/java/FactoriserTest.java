import factorisation.Factoriser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FactoriserTest {

    @Test
    void regularFactoriserTestSimpleNumber() {
        assertEquals("2*5", Factoriser.regularFactoriser(10) );
    }

    @Test
    void regularFactoriserTestIllegalNumber() {
        assertNull(Factoriser.regularFactoriser(-1));
    }

    @Test
    void regularFactoriserTestZero() {
        assertNull(Factoriser.regularFactoriser(0));
    }


    @Test
    void regularFactoriserTestLarge() {
        assertEquals("2*2*2*2*5*5*5*5*5", Factoriser.regularFactoriser(50000) );
    }

    @Test
    void sieveFactoriser() {
        assertEquals("2*5", Factoriser.sieveFactoriser(10) );
    }

}
