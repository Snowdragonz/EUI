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
        double passwordlength = password.length();
        ArrayList<Long> possibilties= new ArrayList<Long>();
        double countedPossibilities = 0;
        double totalPossibilties = 0;
        ArrayList<String> counterArray = new ArrayList<String>();
        String longestMatchingWord = "";

        File fileToRead = new File("dictionary.txt");
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
                countedPossibilities = countedPossibilities + 26;
            }
            else if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(Character.toString(password.charAt(i))) && !hasUpper)
            {
                hasUpper = true;
                countedPossibilities = countedPossibilities + 26;
            }
            else if("0123456789".contains(Character.toString(password.charAt(i))) && !hasNumber)
            {
                hasNumber= true;
                countedPossibilities = countedPossibilities + 10;
            }
            else if(" ,!”#$%&’()*+,-./:;<=>?@[\\]^_`{|}~".contains(Character.toString(password.charAt(i))) && !hasSpecial)
            {
                hasSpecial = true;
                countedPossibilities = countedPossibilities + 33;
            }

        }
        double centuries = 0;
        double years = 0;
        double days = 0;
        double hours = 0;
        double minutes = 0;
        double seconds = 0;
        double tempcenturies = 0;
        double tempyears = 0;
        double tempdays = 0;
        double temphours = 0;
        double tempminutes = 0;
        double tempseconds2 = 0;
        double tempseconds = 0;
        double point = 0.00000037;
        double point1 = 3.8;

//        BigDecimal E = new BigDecimal(Math.E);
//        BigInteger fivehundread = new BigInteger("1000");
//        BigInteger zero = new BigInteger("0");
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
        //y =3.7*e(3.8x) rounded to 4 to fit into big decimal

        totalPossibilties = (Math.pow(countedPossibilities, passwordlength));
        tempseconds2 = point*Math.pow(Math.E, totalPossibilties*4);
        tempseconds = tempseconds2;

        if (tempseconds == 0)
        {

        }
        else if (tempseconds > 1)
        {

        }
        else
        {
            tempseconds = 0;
        }


        seconds = tempseconds % 60;
        tempminutes = tempseconds / 60;
        minutes = tempminutes % 60;
        temphours = tempminutes / 60;
        hours = temphours % 24;
        tempdays = temphours / 24;
        days = tempdays % 365;
        tempyears = tempdays / 365;

        if(tempyears > 500)
        {
            return ("Greater than 500" +  " years ");
        }
        //years = tempcenturies.divide(BigInteger.valueOf(100));
        //System.out.println(tempyears.toString() +  " years " + days.toString() + " days " + hours.toString() + " hours " + minutes.toString() + " minutes " + seconds.toString() + " seconds");
        else
            {
            return (tempyears + " years " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
            }
    }
}