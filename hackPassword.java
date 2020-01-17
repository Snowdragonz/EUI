package sample;

import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class hackPassword {

    public static char[] charArray, endBruteForceArray;
    public static int intArray[];
    public static char bit, bit0, bit1, bit2, bit3, bit4;
    public static int ascii, ascii0, ascii1, ascii2, ascii3, ascii4, charArrayLegnth;
    public static String startBruteForce, endBruteForceString, newKey, currentKey;
    public static long startTime, endTime;
    public static int counter = 1;

    public static String bruteForce(String password) {
        startTime = System.currentTimeMillis();
        charArrayLegnth = password.length();
        charArray = new char[charArrayLegnth];
        intArray = new int[charArrayLegnth];
        endBruteForceArray = new char[charArrayLegnth];

        for (int i = 0; i < charArrayLegnth; i++) {
            charArray[i] = ' ';
        }
        currentKey = new String(endBruteForceArray);

        for (int i = 0; i < charArrayLegnth; i++) {
            endBruteForceArray[i] = '~';
        }
        endBruteForceString = new String(endBruteForceArray);


        while (currentKey != endBruteForceString && (currentKey.compareTo(password) != 0)) {
            for (int i = 0; i < charArrayLegnth; i++) {
                bit = charArray[i];
                ascii = (int) bit;
                intArray[i] = ascii;
            }

            if (intArray[0] == 126) {
                intArray[0] = 32;
                if (intArray[1] == 126) {
                    intArray[1] = 32;
                    if (intArray[2] == 126) {
                        intArray[2] = 32;
                        if (intArray[3] == 126) {
                            intArray[3] = 32;
                            if (intArray[4] == 126) {
                                intArray[4] = 32;
                            }
                          /*
                          if (intArray[5] == 126)
                             {intArray[5] = 32;
                             if (intArray[6] == 126)
                                {intArray[6] = 32;
                                if (intArray[7] == 126)
                                   {intArray[7] = 32;
                                   if (intArray[8] == 126)
                                      {intArray[8] = 32;
                                      if (intArray[9] == 126)
                                         {intArray[9] = 32;}
                                      else {intArray[9]++;}}
                                   else {intArray[8]++;}}
                                else {intArray[7]++;}}
                             else {intArray[6]++;}}
                          else {intArray[5]++;}}
                          */
                            else {
                                intArray[4]++;
                            }
                        } else {
                            intArray[3]++;
                        }
                    } else {
                        intArray[2]++;
                    }
                } else {
                    intArray[1]++;
                }
            } else {
                intArray[0]++;
            }

            for (int i = 0; i < charArrayLegnth; i++) {
                ascii = intArray[i];
                bit = (char) ascii;
                charArray[i] = bit;
            }
            newKey = new String(charArray);
            currentKey = newKey;
            System.out.println(currentKey);
        }
        endTime = System.currentTimeMillis();

        //System.out.println("Time To Brake Password: " + (endTime - startTime) + "ms");
        return "currentKey";

    }

    public static long bruteForceTime(String password) {
        startTime = System.currentTimeMillis();
        charArrayLegnth = password.length();
        charArray = new char[charArrayLegnth];
        intArray = new int[charArrayLegnth];
        endBruteForceArray = new char[charArrayLegnth];

        for (int i = 0; i < charArrayLegnth; i++) {
            charArray[i] = ' ';
        }
        currentKey = new String(endBruteForceArray);

        for (int i = 0; i < charArrayLegnth; i++) {
            endBruteForceArray[i] = '~';
        }
        endBruteForceString = new String(endBruteForceArray);


        while (currentKey != endBruteForceString && (currentKey.compareTo(password) != 0)) {
            System.out.println(currentKey + " " + counter);
            for (int i = 0; i < charArrayLegnth; i++) {
                bit = charArray[i];
                ascii = (int) bit;
                intArray[i] = ascii;
            }

            if (intArray[0] == 126) {
                intArray[0] = 32;
                if (intArray[1] == 126) {
                    intArray[1] = 32;
                    if (intArray[2] == 126) {
                        intArray[2] = 32;
                        if (intArray[3] == 126) {
                            intArray[3] = 32;
                            if (intArray[4] == 126) {
                                intArray[4] = 32;
                            }
                          /*
                          if (intArray[5] == 126)
                             {intArray[5] = 32;
                             if (intArray[6] == 126)
                                {intArray[6] = 32;
                                if (intArray[7] == 126)
                                   {intArray[7] = 32;
                                   if (intArray[8] == 126)
                                      {intArray[8] = 32;
                                      if (intArray[9] == 126)
                                         {intArray[9] = 32;}
                                      else {intArray[9]++;}}
                                   else {intArray[8]++;}}
                                else {intArray[7]++;}}
                             else {intArray[6]++;}}
                          else {intArray[5]++;}}
                          */
                            else {
                                intArray[4]++;
                            }
                        } else {
                            intArray[3]++;
                        }
                    } else {
                        intArray[2]++;
                    }
                } else {
                    intArray[1]++;
                }
            } else {
                intArray[0]++;
            }

            for (int i = 0; i < charArrayLegnth; i++) {
                ascii = intArray[i];
                bit = (char) ascii;
                charArray[i] = bit;
            }
            newKey = new String(charArray);
            currentKey = newKey;
            //System.out.println(currentKey + " " + counter);
            counter++;
        }
        //System.out.println(counter);
        System.out.println(currentKey + " " + counter);
        counter = 1;
        endTime = System.currentTimeMillis();

        //System.out.println("Time To Brake Password: " + (startTime - endTime) + "ms");
        return (endTime - startTime);

    }

    public static void CalcuateTimeToBrake(String password) throws FileNotFoundException, UnsupportedEncodingException
    {
        long time;
        PrintWriter writer = new PrintWriter("Estimate.txt", "UTF-8");
            for (int i = 0; i < 10; i++)
            {
                time = bruteForceTime(password);
                //System.out.println(time);
                writer.println(time);
                //writer.println(time + "ms");
            }
            writer.close();
    }

    public static void EstimateTimeToBrake(String password)
    {
        boolean containsLower, containsUpper, containsNumber, containsSpecChar;
        int EArrayLength = password.length();
        char[] analysisCharArray;
        analysisCharArray = password.toCharArray();

        for (int i = 0; i < EArrayLength; i++)
        {
            for (int j = 0; j < EArrayLength; j++)
            {

            }
        }
    }

    // File can be referenced from https://sinister.ly/Thread-14-Million-Password-List
    public static String dictionaryAttack(String password) throws FileNotFoundException
    {
        startTime = System.currentTimeMillis();
        String passwordFound = "";
        try
        {
            ArrayList<String> searchArray = new ArrayList<String>();
            Scanner scan = new Scanner(new File("14millionpass.txt"));
            while (scan.hasNextLine()) {
                searchArray.add(scan.nextLine());
            }
            scan.close();

            for(int i = 0; i < searchArray.size(); i++)
            {
                if (searchArray.get(i).equals(password))
                {
                    passwordFound = searchArray.get(i);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("File not Found");
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return passwordFound;
    }
}
