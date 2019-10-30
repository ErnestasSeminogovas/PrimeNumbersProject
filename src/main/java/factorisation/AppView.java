package factorisation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class AppView {

    private AppController controller;
    private Stage applicationWindow;

    private Label firstNumberLabel;
    private Label lastNumberLabel;
    private Label increaseAmountLabel;
    private Label factorisationStatusLabel;
    private TextField firstNumberInput;
    private TextField lastNumberInput;
    private TextField increaseAmountInput;
    private ProgressBar factorisationProgress;
    private Button startFactorisation;
    private Button endFactorisation;
    private ComboBox algorithmBox;
    private Label algoritmhSelectionLabel;

    public void setController(AppController control) {
        this.controller = control;
    }

    public void setupUI(Stage primaryStage) {
        applicationWindow = primaryStage;

        applicationWindow.setTitle("ElisPro Assignment");
        applicationWindow.setOnCloseRequest(e -> closeWindow());

        firstNumberLabel = new Label("Nuo kurio skaičiaus skaičiuoti:");
        lastNumberLabel = new Label("Iki kurio skaičiaus skaičiuoti:");
        increaseAmountLabel = new Label("Kiek didinti skaičių:");
        algoritmhSelectionLabel = new Label("Algoritmo pasirinkimas:");
        factorisationStatusLabel = new Label("");
        firstNumberInput = new TextField();
        lastNumberInput = new TextField();
        increaseAmountInput = new TextField();
        factorisationProgress = new ProgressBar();
        factorisationProgress.setMinWidth(300);
        startFactorisation = new Button("Pradėti");
        startFactorisation.setOnAction(e -> controller.startThread());
        endFactorisation = new Button("Baigti");
        endFactorisation.setOnAction(e -> controller.stopThread());

        ObservableList<String> algorithms = FXCollections.observableArrayList("Regular", "Sieve");
        algorithmBox = new ComboBox(algorithms);
        algorithmBox.setValue("Regular");


        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 250);
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(algoritmhSelectionLabel,0,0);
        GridPane.setConstraints(algorithmBox, 1, 0);
        GridPane.setConstraints(firstNumberLabel, 0, 1);
        GridPane.setConstraints(lastNumberLabel, 0, 2);
        GridPane.setConstraints(increaseAmountLabel, 0, 3);
        GridPane.setConstraints(firstNumberInput, 1, 1);
        GridPane.setConstraints(lastNumberInput, 1, 2);
        GridPane.setConstraints(increaseAmountInput, 1, 3);
        GridPane.setConstraints(startFactorisation, 1, 4);
        GridPane.setConstraints(endFactorisation, 1, 5);
        GridPane.setConstraints(factorisationStatusLabel, 1, 6);
        GridPane.setConstraints(factorisationProgress, 1, 7);

        grid.getChildren().addAll(firstNumberInput, firstNumberLabel, lastNumberInput, lastNumberLabel,
                increaseAmountInput, startFactorisation, endFactorisation, increaseAmountLabel,
                factorisationStatusLabel, factorisationProgress, algorithmBox, algoritmhSelectionLabel);

        Scene scene = new Scene(grid);
        applicationWindow.setScene(scene);

        applicationWindow.show();

    }

    public void closeWindow() {
        controller.stopThread();
        applicationWindow.close();
    }

    public void alertCreation(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public TextField getFirstNumberInput() { return firstNumberInput; }

    public TextField getLastNumberInput() { return lastNumberInput; }

    public TextField getIncreaseAmountInput() { return increaseAmountInput; }

    public Label getStatusLabel() {
        return factorisationStatusLabel;
    }

    public ProgressBar getProgressBar() {
        return factorisationProgress;
    }

    public ComboBox getAlgorithmBox() { return algorithmBox; }

}
