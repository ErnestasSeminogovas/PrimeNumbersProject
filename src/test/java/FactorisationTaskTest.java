import factorisation.FactorisationTask;
import factorisation.Factoriser;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FactorisationTaskTest {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void testComplexConstructorFirstNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt",
                new Factoriser());
        assertEquals(10, task.getFirstNumber());
    }

    @Test
    public void testComplexConstructorLastNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt",
                new Factoriser());
        assertEquals(20, task.getLastNumber());
    }

    @Test
    public void testComplexConstructorIncreaseAmountNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt",
                new Factoriser());
        assertNotEquals(41411, task.getIncreaseAmount());
    }

    @Test
    public void testThreadRunnerRegular() throws Exception {
        FactorisationTask factorisationThread = new FactorisationTask(
                10,
                20,
                1,
                "asd.txt",
                "Regular",
                new Factoriser()
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

      factorisationThread.call();
    }

    @Test
    public void testThreadRunnerSieve() throws Exception {
        FactorisationTask factorisationThread = new FactorisationTask(
                10,
                20,
                1,
                "asd.txt",
                "Sieve",
                new Factoriser()
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

        factorisationThread.call();
    }

    @Test
    public void testThreadRunnerBigNumbers() throws Exception {
        FactorisationTask factorisationThread = new FactorisationTask(
                100000,
                200000,
                10000,
                "asd.txt",
                "Regular",
                new Factoriser()
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

        factorisationThread.call();
    }

    @Test(expected = InterruptedException.class)
    public void testThreadInterruptedException() throws Exception {
        FactorisationTask factorisationThread = new FactorisationTask(
            100000,
            200000,
            10000,
            "asd.txt",
            "Regular",
            new Factoriser()
        );

        when(factorisationThread.call()).thenThrow(InterruptedException.class);

        factorisationThread.call();

    }
}