import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultsWriterTest {

    private ResultsWriter writer;

    @Before
    public void setUp() throws Exception {
        ResultsWriter writer = new ResultsWriter("asd.txt" );
    }

    @Test
    public void resultFileCreation() {
        writer.resultFileCreation();
    }

    @Test
    public void resultsStart() {
        writer.resultsStart(10,20,40);
    }

    @Test
    public void factorisationResult() {
        writer.factorisationResult(10,10,"a");
    }

    @Test
    public void newLine() {
        writer.newLine();
    }

    @Test
    public void resultsEnd() {
        writer.resultsEnd();
    }

    @Test
    public void closeResultsWriter() {
        writer.closeResultsWriter();
    }

    @After
    public void tearDown() throws Exception {
        writer=null;
    }
}