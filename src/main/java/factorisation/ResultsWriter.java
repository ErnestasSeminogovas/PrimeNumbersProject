package factorisation;

import com.sun.media.jfxmedia.logging.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ResultsWriter {

  private BufferedWriter bufferedWriter;
  private FileWriter fileWriter;
  private DateFormat dateFormat;
  private String fileName;

  public ResultsWriter(String fileName) {
    this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
    this.fileName = fileName;
  }

  public void resultFileCreation() {
    try {
      File file = new File(fileName);
      if (!file.exists()) {
        file.createNewFile();
        FileWriter newFileWriter = new FileWriter(file);
        BufferedWriter newBufferedWriter = new BufferedWriter(newFileWriter);
        newFileWriter.write("");
        newBufferedWriter.close();
        newFileWriter.close();
      }
    } catch (IOException ex) {
      Logger.logMsg(Logger.ERROR, ex.toString());
    }
  }


  public void resultsStart(int firstNumber, int lastNumber, int increaseAmount) {

    try {
      fileWriter = new FileWriter(fileName, true);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(dateFormat.format(System.currentTimeMillis()) +
          " Skaičiavimo pradžia. Naudojami skaičiai: " +
          firstNumber + ", " + lastNumber + ", " + increaseAmount);
      newLine();
    } catch (IOException ex) {
    }
  }

  public void factorisationResult(long startTime, int number, String result) {
    try {
      bufferedWriter.write(dateFormat.format(startTime) + " " + number + "=" +
          result);
    } catch (IOException ex) {
      Logger.logMsg(Logger.ERROR, ex.toString());
    }
  }

  public void newLine() {
    try {
      bufferedWriter.newLine();
    } catch (IOException ex) {
      Logger.logMsg(Logger.ERROR, ex.toString());
    }
  }


  public void resultsEnd() {
    try {
      bufferedWriter.write(dateFormat.format(System.currentTimeMillis()) + " Skaičiavimo pabaiga");
      newLine();
    } catch (IOException ex) {
      Logger.logMsg(Logger.ERROR, ex.toString());
    }
  }

  public void closeResultsWriter() {
    try {
      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException ex) {
      Logger.logMsg(Logger.ERROR, ex.toString());
    }
  }

}
