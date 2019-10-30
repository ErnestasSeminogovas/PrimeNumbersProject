import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import factorisation.AppController;
import factorisation.AppView;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class AppViewTest {

  @Rule
  public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

  private AppView view;

  @Test
  public void setupUIAndCloseOk() {
    view = new AppView();

    AppController appController = Mockito.mock(AppController.class);
    doNothing().when(appController).stopThread();
    view.setController(appController);

    Stage stage = new Stage();
    view.setupUI(stage);
    view.closeWindow();
  }

  @Test
  public void alertCreation() {
    view = new AppView();
    view.alertCreation("asd","sss","sss");
    view.closeAlert();
  }

}