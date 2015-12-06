/** It's class check correct write to txt file
 * <b>PATH_C</b> и <b>INT_CONSTANT</b>.
 * @autor Buglak Pavel
 * @version 1.0
 */
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.ArrayList;

public class WriteToFileTest {
    final static Logger logger = Logger.getLogger(WriteToFileTest.class);
    /** Path to the file*/
    final String PATH_C = "./src/main/resources/C.txt";
    /** Test number (use for check)*/
    final Integer INT_CONSTANT = 99;

    @Test
    public void writeAndReadTest() {
        ArrayList<Integer> testList = new ArrayList<Integer> ();
        ArrayList<Integer> resultList = new ArrayList<Integer> ();
        testList.add(INT_CONSTANT);
        Main main = new Main();
        main.writeToFile(PATH_C,testList);
        logger.info("Test check conformity numbers (file and list).");
        /** Test check conformity numbers (file and list).*/
        assertEquals(main.getListNumber(PATH_C,resultList).get(0), INT_CONSTANT);
    }
}
