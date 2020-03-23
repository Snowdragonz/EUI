package sample;

import java.io.*;
import java.io.FileNotFoundException;

/**
 * Class hackPassword declares and implements two primary password attacking processes, Brute Force Attack and Dictionary Attack
 * the Brute Force attack method iterates through every possible combination of a string up to a total of 10 characters in a string
 * the Dictionary attack method iterates through a given dictionary.txt file to match the password to a possible word found in the dictionary file.
 * @Author Tony Tipton
 * @since 3/23/2020
 */
public class hackPassword {

    public static char[] charArray, endBruteForceArray;
    public static int intArray[];
    public static char bit, bit0, bit1, bit2, bit3, bit4;
    public static int ascii, ascii0, ascii1, ascii2, ascii3, ascii4, charArrayLegnth;
    public static String startBruteForce, endBruteForceString, newKey, currentKey;
    public static long startTime, endTime;
    public static int counter = 1;

    /**
     * The bruteForce method does a Brute Force attack on the characters found on the English Keyboard by iterating through
     * a combination of 10 characters starting at ASCII value 32 and iterates through to the ASCII range until ASCII value 126.
     * It iterates through this range bit by bit addition and generating a new password to check against the password created by
     * the user. Useage of this method has been replaced through the sue of GPU computation through a program called Hashcat.
     * @param password This parameter has the password generated by the user to be used in brute forcing the password.
     * @return String This method returns a string that is the found matching password.
     */
    public static String bruteForce(String password) {
        startTime = System.currentTimeMillis();
        charArrayLegnth = password.length();
        charArray = new char[charArrayLegnth];
        intArray = new int[charArrayLegnth];
        endBruteForceArray = new char[charArrayLegnth];

        for (int i = 0; i < charArrayLegnth; i++)
        {
            charArray[i] = ' ';
        }
        currentKey = new String(endBruteForceArray);

        for (int i = 0; i < charArrayLegnth; i++)
        {
            endBruteForceArray[i] = '~';
        }
        endBruteForceString = new String(endBruteForceArray);

        // While loop for iterating through every combination up to 10 characters
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
                                if (intArray[5] == 126) {
                                     intArray[5] = 32;
                                     if (intArray[6] == 126) {
                                         intArray[6] = 32;
                                        if (intArray[7] == 126) {
                                            intArray[7] = 32;
                                           if (intArray[8] == 126) {
                                               intArray[8] = 32;
                                              if (intArray[9] == 126) {
                                              intArray[9] = 32;}
                                          else {intArray[9]++;}}
                                       else {intArray[8]++;}}
                                    else {intArray[7]++;}}
                                 else {intArray[6]++;}}
                              else {intArray[5]++;}}
                            else { intArray[4]++;}}
                        else {intArray[3]++;}}
                    else {intArray[2]++;}}
                else {intArray[1]++;}}
            else { intArray[0]++;}

            for (int i = 0; i < charArrayLegnth; i++) {
                ascii = intArray[i];
                bit = (char) ascii;
                charArray[i] = bit;
            }

            newKey = new String(charArray);
            currentKey = newKey;
        }
        endTime = System.currentTimeMillis();
        return currentKey;

    }

    /**
     * The dictionaryAttack method features comparing a given password with any words within a dictionary given to the program as a text file.
     * The method converts the password and words in the dictionary to lowercase words as the speed to check variability of a password is
     * negligible.
     * @param password This is the password generated by the user.
     * @return String This method returns a string of the found password.
     */
    public static String dictionaryAttack(String password)
    {
        startTime = System.currentTimeMillis();
        String tempPass = password.toLowerCase();
        String passwordFound = "";

        try {
            BufferedReader readerCount = new BufferedReader(new FileReader("dictionary.txt"));
            String wordToCount = "";

            try {
                while ((wordToCount = readerCount.readLine()) != null) {
                    wordToCount = wordToCount.toLowerCase();
                    if (wordToCount.equals(tempPass))
                    {
                        passwordFound = wordToCount;
                        break;
                    }
                }
            } catch (IOException e) {
                EncryptionGUI.message("Dictionary file to look in not found");
            }
        }
        catch(FileNotFoundException e)
        {
            EncryptionGUI.message("Dictionary file to look in not found");
        }

        endTime = System.currentTimeMillis();
        return passwordFound;
    }
}
