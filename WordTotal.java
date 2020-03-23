package sample;
/**
 * Class WorldTotal is a program designed to count all of the iterations of all dictionary words counted in the four data
 * sets observed within this project. The class loads in all Dictionary attack word list generated from the Finder class and
 * iterates through each data set to count the words that are above the count of 2 characters.
 * @Authors Tony Tipton
 * @since 2/23/2020
 */
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class WorldTotal is a counting program that iterates through the four data sets of Hotmail, RockYou, MySpace, and PHPBB
 * and counts the total amount of common words found in the data sets. It then uses selection sort to sort the words found from
 * least to greatest and outputs the words to a file. Selection sort algorithm can be found at https://www.geeksforgeeks.org/selection-sort/
 */
public class WordTotal {

    public static void main(String[] args) {
        String wordSample = "";
        List<CounterObj> LengthWordList = new ArrayList<CounterObj>();
        File rockyouWords = new File("RockYouDictonaryWordListCount.txt");
        File mySpaceWords = new File("MySpaceDictonaryWordCount.txt");
        File HotmailWords = new File("HotmailDictonaryWordCount.txt");
        File PHPBBwords = new File("PHPBBDictonaryWordCount.txt");

        try {
            BufferedReader fileToRead = new BufferedReader(new FileReader(PHPBBwords));
            try {
                while ((wordSample = fileToRead.readLine()) != null) {
                    String[] lengthofWord = wordSample.split("\t");
                    if (Integer.parseInt(lengthofWord[1]) > 0)
                    {
                        CounterObj temp = new CounterObj();
                        temp.word = lengthofWord[0];
                        temp.counter = Integer.parseInt(lengthofWord[1]);
                        LengthWordList.add(temp);
                    }

                }


                fileToRead = new BufferedReader(new FileReader(mySpaceWords));
                boolean found = false;
                int countertemp = 0;
                while ((wordSample = fileToRead.readLine()) != null) {
                    String[] lengthofWord = wordSample.split("\t");
                    for (int i = 0; i < LengthWordList.size(); i++)
                    {
                        if(LengthWordList.get(i).word.equals(lengthofWord[0]))
                        {
                            LengthWordList.get(i).counter = LengthWordList.get(i).counter + Integer.parseInt(lengthofWord[1]);
                            found = true;
                        }
                    }
                    if (!found && Integer.parseInt(lengthofWord[1]) > 0)
                    {
                        CounterObj temp = new CounterObj();
                        temp.word = lengthofWord[0];
                        temp.counter = Integer.parseInt(lengthofWord[1]);
                        LengthWordList.add(temp);
                    }
                    found = false;
                    countertemp++;

                }


                fileToRead = new BufferedReader(new FileReader(HotmailWords));
                found = false;
                while ((wordSample = fileToRead.readLine()) != null) {
                    String[] lengthofWord = wordSample.split("\t");
                    for (int i = 0; i < LengthWordList.size(); i++)
                    {
                        if(LengthWordList.get(i).word.equals(lengthofWord[0]))
                        {
                            LengthWordList.get(i).counter = LengthWordList.get(i).counter + Integer.parseInt(lengthofWord[1]);
                            found = true;
                        }
                    }
                    if (!found && Integer.parseInt(lengthofWord[1]) > 0)
                    {
                        CounterObj temp = new CounterObj();
                        temp.word = lengthofWord[0];
                        temp.counter = Integer.parseInt(lengthofWord[1]);
                        LengthWordList.add(temp);
                    }
                    found = false;
                    countertemp++;
                }

                fileToRead = new BufferedReader(new FileReader(rockyouWords));
                found = false;
                while ((wordSample = fileToRead.readLine()) != null) {
                    String[] lengthofWord = wordSample.split("\t");
                    for (int i = 0; i < LengthWordList.size(); i++)
                    {
                        if(LengthWordList.get(i).word.equals(lengthofWord[0]))
                        {
                            LengthWordList.get(i).counter = LengthWordList.get(i).counter + Integer.parseInt(lengthofWord[1]);
                            found = true;
                        }
                    }
                    if (!found && Integer.parseInt(lengthofWord[1]) > 0)
                    {
                        CounterObj temp = new CounterObj();
                        temp.word = lengthofWord[0];
                        temp.counter = Integer.parseInt(lengthofWord[1]);
                        LengthWordList.add(temp);
                    }
                    found = false;
                    countertemp++;
                }
            }
            catch (IOException e)
            {

            }
        }
        catch (FileNotFoundException n)
        {

        }

        int n = LengthWordList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (LengthWordList.get(j).counter < LengthWordList.get(min_idx).counter)
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            CounterObj temp = LengthWordList.get(min_idx);
            LengthWordList.set(min_idx,LengthWordList.get(i));
            LengthWordList.set(i,temp);



        }
        for(int i = 0; i < LengthWordList.size(); ++i)
        {
            try {

                // Open given file in append mode.
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("TotalDataSetsDictionaryWordCount.txt", true));
                out.write(LengthWordList.get(i).word + "\t" + LengthWordList.get(i).counter + "\n");
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception occurred" + e);
            }
        }

    }
}
