package factorisation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultsWriter {

  private BufferedWriter bufferedWriter;
  private FileWriter fileWriter;
  private final DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
  private final String fileName;

  public ResultsWriter(String fileName) {
    this.fileName = fileName;
  }

  public BufferedWriter getBufferedWriter() {
    return bufferedWriter;
  }

  public void resultFileCreation() {
    try {
      File file = new File(fileName);
      if (!file.exists()) {
        file.createNewFile();
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        fileWriter.write("");
        bufferedWriter.close();
        fileWriter.close();
      }
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }

  public void newLine() {
    try {
      bufferedWriter.newLine();
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }


  public void resultsStart(int firstNumber, int lastNumber, int increaseAmount) {

    try {
      fileWriter = new FileWriter(fileName, true);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(dateFormat.format(System.currentTimeMillis()) +
          " Skaičiavimo pradžia. Naudojami skaičiai: " +
          firstNumber + ", " + lastNumber + ", " + increaseAmount);
      bufferedWriter.newLine();
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }

  public void printFactorisationResult(long startTime, int number, String result) {
    try {
      bufferedWriter.write(dateFormat.format(startTime) + " " + number + "=" +
          result);
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }

  public void resultsEnd() {
    try {
      bufferedWriter.write(dateFormat.format(System.currentTimeMillis()) + " Skaičiavimo pabaiga");
      bufferedWriter.newLine();
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }

  public void closeResultsWriter() {
    try {
      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException ex) {
      Logger.getAnonymousLogger().log(Level.SEVERE,ex.toString());
    }
  }

}
