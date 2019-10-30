import javafx.stage.Stage;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
    }

    @Test
    public void start() throws Exception {
        Main main = new Main();
        main.start(new Stage());
    }
}