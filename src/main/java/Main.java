import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shedi on 05.12.2015.
 */
public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        final String PATH_A="./src/main/resources/A.txt";
        final String PATH_B="./src/main/resources/B.txt";
        final String PATH_C="./src/main/resources/C.txt";

        Main mainObject = new Main();
        ArrayList<Integer> listA = new ArrayList<Integer> ();
        ArrayList<Integer> listB = new ArrayList<Integer> ();

        logger.info("Program get content file A and write to listA");
        listA = mainObject.getListNumber(PATH_A,listA);

        logger.info("Program get content file B and write to listB");
        listB = mainObject.getListNumber(PATH_B,listB);

        logger.info("Program save results in file C");
        mainObject.writeToFile(PATH_C,mainObject.getCombineAndSortList(listA,listB));
    }

    /** method checkString
     * @return method check sting. If string is number return true else false.
     */
    public static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
        }

    /** method getCombineAndSortList
     * @return method connect two list in one and sort
     */
    public ArrayList<Integer> getCombineAndSortList(ArrayList<Integer> listA,ArrayList<Integer> listB)
    {
        ArrayList<Integer> listC = new ArrayList<Integer> ();
        logger.info("Program is join lists");
        listC.addAll(listA);
        listC.addAll(listB);
        logger.info("Program is sort list");
        Collections.sort(listC);
        return listC;
    }

    /** method getListNumber
     * @return method get list from txt file
     */
    public ArrayList<Integer> getListNumber(String path,ArrayList<Integer> list)
    {
        logger.info("Program get data with file and write in list");
        Scanner in = null;
        try {
            in = new Scanner(new File(path));
            while(in.hasNext()) {
                String str = in.nextLine();
                /** if string is number then add in the list else show message "File is content string" */
                if(checkString(str)) {
                    list.add(Integer.valueOf(str));
                }
                else
                    logger.info("File is content string");
            }

        in.close();
        } catch (FileNotFoundException e) {
            logger.info("File is not found or file content string");
        }
        return list;
    }

    /** method writeToFile
     * @return method write data from list in the text file
     */
    public void writeToFile(String path,ArrayList<Integer> list)
    {
        logger.info("Program write data with list in file");
        final String SEPARATOR="line.separator";
        List<String> newList = new ArrayList<String>(list.size());
        for (Integer myInt : list) {
            newList.add(String.valueOf(myInt));
        }

        Writer writer = null;
        try {
            writer = new FileWriter(path);
            for (String line : newList) {
                writer.write(line);
                writer.write(System.getProperty(SEPARATOR));
            }
            writer.flush();
        } catch (Exception e) {

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
