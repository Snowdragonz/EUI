package sample;
/**
 * Class World Printer is a program that is used to print out specific words of a specific length to aid in finding out
 * the most counted or most iterated password from the data sets analyzed.
 * @Author Tony Tipton
 * @Since 3/23/2020
 */

import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class WordPrinter {

    String wordSample = "";

    /**
     * This method is the program driver that loads in the file to be analyzed and can be parsed
     * for words of a specific length
     * @param args This is the driver parameter
     */
    public static void main(String[] args) {
        String wordSample = "";
        ArrayList<String> LengthWordList = new ArrayList<String>();
        File file = new File("TotalDataSetsDictionaryCommonPasswordCount.txt");
        try {
            BufferedReader fileToRead = new BufferedReader(new FileReader(file));
            try {
                while ((wordSample = fileToRead.readLine()) != null) {
                    String[] lengthofWord = wordSample.split("\t");
                    if (lengthofWord[0].length() == 15) // length variable
                    {
                        System.out.print(lengthofWord[0] + "\t" + lengthofWord[1] + "\n");
                    }
                }
            }
            catch (IOException e)
            {

            }
        }
        catch (FileNotFoundException n)
        {

        }




    }
}
