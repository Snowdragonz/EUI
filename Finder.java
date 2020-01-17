package sample;
import org.w3c.dom.css.Counter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    public static void main(String[] args)
    {
        CounterObj[] counterArray = new CounterObj[100];
        List<CounterObj> phraseWordList = new ArrayList<CounterObj>();
        File fileToRead = new File("C:\\Users\\Snowd\\IdeaProjects\\Barrett Thesis\\Top100.txt\\");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            String wordInFile = "";

            for(int i = 0; i < 100; ++i)
            {
                counterArray[i] = new CounterObj();
            }

            for(int i = 0; i < 100;i++)
            {
                try
                {
                        wordInFile = reader.readLine();
                        counterArray[i].word = wordInFile.toString();
                        counterArray[i].counter = 0;
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
//
//        for(int i = 100; i < 100 ; i++)
//        {
//            System.out.println(counterArray[i].word);
//        }

        File fileToCount = new File("C:\\Users\\Snowd\\IdeaProjects\\Barrett Thesis\\rockyou.txt\\");

        try {
            BufferedReader readerCount = new BufferedReader(new FileReader(fileToCount));
            String wordToCount = "";

            try
            {
                while ((wordToCount = readerCount.readLine()) != null)
                {
                    //System.out.println(wordToCount);

                    for(int i = 0; i < 100; i++)
                    {
                        if(wordToCount.contains(counterArray[i].word))
                        {
                            counterArray[i].counter++;
                        }
                    }
                }
            }
            catch (IOException n)
            {

            }

        }
        catch (FileNotFoundException e)
        {

        }


        // https://www.geeksforgeeks.org/selection-sort/
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


        for(int i = 0; i < 100; ++i)
        {
            System.out.print(counterArray[i].word + "\t" + counterArray[i].counter + "\n");
        }
}
}
