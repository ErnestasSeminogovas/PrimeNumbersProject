package factorisation;

public class AppController {

    private final AppView view;
    private FactorisationTask factorisationThread;
    private final String factorisationFileName;

    public AppController(AppView view) {
        this.view = view;
        this.factorisationThread = new FactorisationTask();
        this.factorisationFileName = "rezultatai.txt";
    }

    public void alertCreation(String title, String headerText, String contentText) {
        view.alertCreation(title, headerText, contentText);
    }

    //creates a new thread or cancels if there was already an active one
    public void startThread() {
        try {
            int firstNumberInput = InputParser.parseInput(view.getFirstNumberInput());
            int lastNumberInput = InputParser.parseInput(view.getLastNumberInput());
            int increaseAmountInput = InputParser.parseInput(view.getIncreaseAmountInput());
            String algorithm = view.getAlgorithmBox().getValue().toString();

            stopThread();

            factorisationThread = new FactorisationTask(
                    firstNumberInput,
                    lastNumberInput,
                    increaseAmountInput,
                    factorisationFileName,
                    algorithm
            );

            view.getProgressBar().progressProperty().bind(factorisationThread.progressProperty());
            view.getStatusLabel().textProperty().bind(factorisationThread.messageProperty());

            new Thread(factorisationThread).start();
        }
        catch (NumberFormatException ex) {
            alertCreation("Error","There is an issue with the input numbers",
                    "A non number or a negative number is entered in an input field");
        }



    }

    public void stopThread() {
        if (factorisationThread.isRunning()) {
            factorisationThread.cancel();
        }
    }


}
