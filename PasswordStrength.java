package sample;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Class Password Strength is a helper class in determining a time estimate based on observed Brute Force attack and Dictionary
 * Attack performed within the project. The class has method determinPAsswordStrength that determinds the time estimate using Java
 * BigInteger and BigDeciaml to calculate large numbers for the time estimate
 * @Author Tony Tipton
 * @since 2/23/2020
 */
public class PasswordStrength {

    /**
     * This method performs the necessary calculation based on an algorithm gathered from analysing Brute Force and Dictionary attack algorithm
     * and calculates the time estimated to break a password based on the given password.
     * @param password This parameter is the generated password by the user.
     * @return String This method returns the estimated time to figure out the password.
     */
    public static String determinePasswordStrength(String password)
    {
        int passwordlength = password.length();
        ArrayList<Long> possibilties= new ArrayList<Long>();
        BigDecimal countedPossibilities = new BigDecimal("0");
        BigDecimal totalPossibilties = new BigDecimal("0");
        ArrayList<String> counterArray = new ArrayList<String>();
        String longestMatchingWord = "";

        File fileToRead = new File("dictionary.txt\\");
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isNumber = false;
        boolean isSpecial = false;

        for(int i = 0; i < password.length(); i++)
        {

            if("abcdefghijklmnopkrstuvwxyz".contains(Character.toString(password.charAt(i))) && !hasLower)
            {
                hasLower = true;
                countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(26));
            }
            else if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(Character.toString(password.charAt(i))) && !hasUpper)
            {
                hasUpper = true;
                countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(26));
            }
            else if("0123456789".contains(Character.toString(password.charAt(i))) && !hasNumber)
            {
                hasNumber= true;
                countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(10));
            }
            else if(" ,!”#$%&’()*+,-./:;<=>?@[\\]^_`{|}~".contains(Character.toString(password.charAt(i))) && !hasSpecial)
            {
                hasSpecial = true;
                countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(33));
            }

        }
        BigInteger centuries = new BigInteger("0");
        BigInteger years = new BigInteger("0");
        BigInteger days = new BigInteger("0");
        BigInteger hours = new BigInteger("0");
        BigInteger minutes = new BigInteger("0");
        BigInteger seconds = new BigInteger("0");
        BigInteger tempcenturies = new BigInteger("0");
        BigInteger tempyears = new BigInteger("0");
        BigInteger tempdays = new BigInteger("0");
        BigInteger temphours = new BigInteger("0");
        BigInteger tempminutes = new BigInteger("0");
        BigDecimal tempseconds2 = new BigDecimal("0");
        BigInteger tempseconds = new BigInteger("0");
        BigDecimal point2 = new BigDecimal("0.00000000002");
        BigDecimal subtract = new BigDecimal("14692");
        BigInteger fivehundread = new BigInteger("1000");
        BigInteger zero = new BigInteger("0");
        //BigDecimal centuries = new BigDecimal("0");

        ///////////////INSERT Dictionary Attack Here//////////////////////
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            String wordInFile = "";

            while ((wordInFile = reader.readLine()) != null) {
                //System.out.println(wordInFile);
                wordInFile = wordInFile.toLowerCase();
                if (wordInFile.length() > 3) {
                    if (password.contains(wordInFile))
                    {
                        if(longestMatchingWord.length() < wordInFile.length())
                        {
                            longestMatchingWord = wordInFile;
                        }
                    }
                }
            }
            for (int i = 0; i < longestMatchingWord.length(); i++) {
                if ("abcdefghijklmnopkrstuvwxyz".contains(Character.toString(password.charAt(i)))) {
                    //isLower = true;
                    //countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(26));
                    passwordlength--;
                    //System.out.println(passwordlength);
                }
                else if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(Character.toString(password.charAt(i)))) {
                    //isUpper = true;
                    //countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(26));
                    passwordlength--;
                }
                else if ("0123456789".contains(Character.toString(password.charAt(i)))) {
                    //isNumber = true;
                    //countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(10));
                    passwordlength--;
                }
                else if (" ,!”#$%&’()*+,-./:;<=>?@[\\]^_`{|}~".contains(Character.toString(password.charAt(i)))) {
                    //isSpecial = true;
                    //countedPossibilities = countedPossibilities.add(BigDecimal.valueOf(33));
                    passwordlength--;
                }

            }
        }
        catch (FileNotFoundException e)
        {

        }
        catch(IOException e)
        {
            System.out.println("didnt read file");
        }

        // Algorithm is here
        //long seconds = (long) (12.015 * Math.pow(Math.E, 0.000000000000001*totalPossibilties));
        //BigDecimal seconds = new BigDecimal(0.00000000002*totalPossibilties - 14692);

        totalPossibilties = (countedPossibilities.pow(passwordlength));
        tempseconds2 = point2.multiply(totalPossibilties).subtract(subtract);
        tempseconds = tempseconds2.toBigInteger();

        if (tempseconds.compareTo(zero) == 0)
        {

        }
        else if (tempseconds.compareTo(zero) == 1)
        {

        }
        else
        {
            tempseconds = zero;
        }


        seconds = tempseconds.mod(BigInteger.valueOf(60));
        tempminutes = tempseconds.divide(BigInteger.valueOf(60));
        minutes = tempminutes.mod(BigInteger.valueOf(60));
        temphours = tempminutes.divide(BigInteger.valueOf(60));
        hours = temphours.mod(BigInteger.valueOf(24));
        tempdays = temphours.divide(BigInteger.valueOf(24));
        days = tempdays.mod(BigInteger.valueOf(365));
        tempyears = tempdays.divide(BigInteger.valueOf(365));

        if(tempyears.compareTo(fivehundread) == 1)
        {
            return ("Greater than 1000" +  " years ");
        }
        //years = tempcenturies.divide(BigInteger.valueOf(100));
        //System.out.println(tempyears.toString() +  " years " + days.toString() + " days " + hours.toString() + " hours " + minutes.toString() + " minutes " + seconds.toString() + " seconds");
        else
            {
            return (tempyears.toString() + " years " + days.toString() + " days " + hours.toString() + " hours " + minutes.toString() + " minutes " + seconds.toString() + " seconds");
            }
    }
}