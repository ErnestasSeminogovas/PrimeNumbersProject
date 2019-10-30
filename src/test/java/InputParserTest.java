import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import javax.xml.soap.Text;

import static org.junit.Assert.*;

public class InputParserTest{

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    TextField fieldA;
    TextField fieldB;
    TextField fieldC;
    TextField fieldD;

    @Before
    public void setUp() throws Exception {
        fieldA = new TextField();
        fieldB = new TextField();
        fieldC = new TextField();
        fieldD = new TextField();

        fieldA.setText("-10");
        fieldB.setText("qwnfpqwnfiqwnf");
        fieldC.setText("null");
        fieldD.setText("10");
    }
    @Test
    public void parseInputA() {
        assertEquals(-1,InputParser.parseInput(fieldA));
    }

    @Test(expected = NumberFormatException.class)
    public void parseInputB() {
        InputParser.parseInput(fieldB);
    }

    @Test(expected = NumberFormatException.class)
    public void parseInputC() {
        InputParser.parseInput(fieldC);
    }

    @Test
    public void parseInputD() {
        assertEquals(10, InputParser.parseInput(fieldD));
    }

    @After
    public void tearDown() throws Exception {
        fieldA = null;
        fieldB = null;
        fieldC = null;
        fieldD = null;
    }
}