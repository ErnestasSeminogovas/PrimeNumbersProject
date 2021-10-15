import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import factorisation.FactorisationTask;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.junit.jupiter.api.Test;

class FactorisationTaskTest {

    @Test
    void testComplexConstructorFirstNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt");
        assertEquals(10, task.getFirstNumber());
    }

    @Test
    void testComplexConstructorLastNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt");
        assertEquals(20, task.getLastNumber());
    }

    @Test
    void testComplexConstructorIncreaseAmountNumber() {
        FactorisationTask task = new FactorisationTask(10,20,30, "asd.txt", "algorithm.txt");
        assertNotEquals(41411, task.getIncreaseAmount());
    }

    @Test
    void testThreadRunnerRegular() {
        FactorisationTask factorisationThread = new FactorisationTask(
                10,
                20,
                1,
                "asd.txt",
                "Regular"
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

      factorisationThread.call();
    }

    @Test
    void testThreadRunnerSieve() {
        FactorisationTask factorisationThread = new FactorisationTask(
                10,
                20,
                1,
                "asd.txt",
                "Sieve"
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

        factorisationThread.call();
    }

    @Test
    void testThreadRunnerBigNumbers() {
        FactorisationTask factorisationThread = new FactorisationTask(
                100000,
                200000,
                10000,
                "asd.txt",
                "Regular"
        );
        ProgressBar a = new ProgressBar();
        a.progressProperty().bind(factorisationThread.progressProperty());
        Label b = new Label();
        b.textProperty().bind(factorisationThread.messageProperty());

        factorisationThread.call();
    }
}
