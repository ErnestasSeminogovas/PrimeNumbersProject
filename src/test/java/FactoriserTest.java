import factorisation.Factoriser;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoriserTest {

    @Test
    public void regularFactoriserTestSimpleNumber() {
        assertEquals("2*5", Factoriser.regularFactoriser(10) );
    }

    @Test
    public void regularFactoriserTestIllegalNumber() {
        assertEquals(null, Factoriser.regularFactoriser(-1) );
    }

    @Test
    public void regularFactoriserTestZero() {
        assertEquals(null, Factoriser.regularFactoriser(0) );
    }


    @Test
    public void regularFactoriserTestLarge() {
        assertEquals("2*2*2*2*5*5*5*5*5", Factoriser.regularFactoriser(50000) );
    }

    @Test
    public void sieveFactoriser() {
        assertEquals("2*5", Factoriser.sieveFactoriser(10) );
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void sieveFactoriserExceptionTest()  {
        Factoriser.sieveFactoriser(-1);
    }


    @Test
    public void getFactorisation() {
    }

    @Test
    public void sieve() {

    }
}