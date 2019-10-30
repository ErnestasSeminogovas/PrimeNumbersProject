import factorisation.AppController;
import factorisation.AppView;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AppViewTest {

  @Rule
  public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

  private AppView view;

  @Before
  public void setUp() throws Exception {
    view = new AppView();
  }

  @Test
  public void setController() {
    AppController controller = new AppController(view);
    view.setController(controller);
  }

  @Test
  public void setupUI() {
    //view.setupUI(new Stage());
  }

  @Test
  public void closeWindow() {
    view = new AppView();
    view.closeWindow();
  }

  @Test
  public void alertCreation() {
    //view.alertCreation("Great","Job","You did it ");
  }

  @Test
  public void getFirstNumberInput() {
  }

  @Test
  public void getLastNumberInput() {
  }

  @Test
  public void getIncreaseAmountInput() {
  }

  @Test
  public void getStatusLabel() {
  }

  @Test
  public void getProgressBar() {
  }

  @Test
  public void getAlgorithmBox() {
  }

  @After
  public void tearDown() throws Exception {

  }
}