import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static org.testng.Assert.assertTrue;

/**
 * Created by shedi on 06.12.2015.
 */
public class SortTest {
    final static Logger logger = Logger.getLogger(SortTest.class);
    ArrayList<Integer> listA = new ArrayList<Integer>();
    ArrayList<Integer> listB = new ArrayList<Integer>();

    @BeforeTest
    private void generateArrays() {
        ArrayList<Integer> listC = new ArrayList<Integer>();
        /** initialization object class Main*/
        Main mainObject = new Main();
        logger.info("Test generate 10 random number and set in listA");
        Random rand = new Random();
        /** Test generate 10 random number and set in listA*/
        for(int i=0; i<10; i++) {
            listA.add(rand.nextInt(100));
        }
        logger.info("Test generate 10 random number and set in listB");
        /** Test generate 10 random number and set in listB*/
        for(int i=0; i<10; i++) {
            listB.add(rand.nextInt(100));
        }
    }

    @Test
    public void writeAndReadTest() {
        ArrayList<Integer> testList = new ArrayList<Integer>();
        Main mainObject = new Main();
        testList = mainObject.getCombineAndSortList(listA,listB);
        logger.info("Test is verify elements of the list (ascending)");
        /** Test is verify elements of the list (ascending)*/
        for (int i = 0; i < testList.size() - 1; i++) {
            assertTrue(testList.get(i) <= testList.get(i + 1));
        }
    }
}
