package sample;

/**
 * Class Finder is a class that is used to count the total number of words found in a data breach set based on a given
 * dictionary. This class first loads in a dictionary to be used for counting and creates an array of size of the dictionary
 * with a custom object provided in the CounterObj class. Then the class loads in a data breach set of passwords and counts
 * the number of lines a password appears in the data breach set.
 * @Author Tony Tipton
 * @since 3/23/2020
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Finder declares and initializes the File buffers and array lists needed to store words and begin counting of duplicate words
 * in the data breach set given. The class uses selection sort to sort out from least to greatest of the number of words that appeared.
 * Code for selection sort can be found at https://www.geeksforgeeks.org/selection-sort/
 */
public class Finder {
    public static void main(String[] args)
    {
        int countItr = 0;
        CounterObj[] counterArray = new CounterObj[9999];
        List<CounterObj> phraseWordList = new ArrayList<CounterObj>();
        File fileToRead = new File("10-million-password-list-top-10000.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            String wordInFile = "";

            for(int i = 0; i < 9999; ++i)
            {
                counterArray[i] = new CounterObj();
            }

            for(int i = 0; i < 9999; i++)
            {
                try
                {
                        wordInFile = reader.readLine();
                        wordInFile = wordInFile.toLowerCase();

                    if(wordInFile.length() > 2)
                    {
                        //System.out.println(wordInFile);
                        counterArray[i].word = wordInFile.toString();
                        counterArray[i].counter = 0;
                    }
                    else
                    {
                        counterArray[i].word = "ignoreThisPositionToTheMax";
                        counterArray[i].counter = 0;
                    }
                       }
                    catch(IOException e)
                    {
                        System.out.println("didnt read file");
                    }

            }

        }
        catch (FileNotFoundException e)
        {

        }

//        String wordtotest = "Hello";
//        wordtotest = wordtotest.toLowerCase();
//        System.out.println(wordtotest);

        File fileToCount = new File("hotmailCorrect.txt");

        try {
            BufferedReader readerCount = new BufferedReader(new FileReader(fileToCount));
            String wordToCount = "";

            try
            {
                while ((wordToCount = readerCount.readLine()) != null)
                {
                    System.out.println(wordToCount);

                    for(int i = 0; i < 9999; i++)
                    {
                        wordToCount = wordToCount.toLowerCase();
                        if(wordToCount.contains(counterArray[i].word))
                        {
                            counterArray[i].counter++;
                        }
                    }
                    countItr++;
                    System.out.println(countItr);
                }
            }
            catch (IOException n)
            {

            }

        }
        catch (FileNotFoundException e)
        {

        }


        int n = counterArray.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (counterArray[j].counter < counterArray[min_idx].counter)
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            CounterObj temp = counterArray[min_idx];
            counterArray[min_idx] = counterArray[i];
            counterArray[i] = temp;
        }


        for(int i = 0; i < 9999; ++i)
        {
            try {

                // Open given file in append mode.
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("HotmailDictonaryCommonPasswordCount.txt", true));
                out.write(counterArray[i].word + "\t" + counterArray[i].counter + "\n");
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception occurred" + e);
            }
            //System.out.print(counterArray[i].word + "\t" + counterArray[i].counter + "\n");
        }
}
}
