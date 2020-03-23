package sample;

// Imported libraries
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

/**
 * The PhraseGenerator class implements a helper class to aid in the Phrase to Password Tool Section in the EncryptionGUI class.
 * The class features the conversion method generatePhrase() which is used to generate a Leetspeak password for the user through the use of
 * a phrase which is parsed into letters and mapped to Leetspeak symbols randomly.
 * @Author Tony Tipton
 * @since 3/23/2020
 */

public class PhraseGenerator {

    private static String phrasedPassword;

    /**
     * The generatePhrase() method features the conversion of a string list into a single string, Leetspeak password for the user. The
     * conversion is primarily done through a switch case that houses the Leetspeak symbols, which when given the first character of a phrase,
     * converts and creates a string based on the Leetspeak symbols.
     * @param List This parameter houses the phrase parsed by spaces for later conversion.
     * @return This method returns a String
     */
    public static String generatePhrase(List<String> List) {

        // Local variables
        char firstCharacter;
        String word;
        String translatedWord = "";
        ArrayList<String> phraseLetterList = new ArrayList<String>();
        ArrayList<String> translatedList = new ArrayList<String>();
        StringBuilder generatedPhrase = new StringBuilder();
        boolean goodPassword = false;

        // While loop to generate Leet speak password with given phrase
        while (!goodPassword)
        {
            for (int i = 0; i < List.size(); i++) {
                word = List.get(i).toLowerCase();
                firstCharacter = word.charAt(0);

                // Switch case for providing phrase conversion
                switch (firstCharacter) {
                    case 'a': {
                        phraseLetterList.add("A");
                        phraseLetterList.add("a");
                        phraseLetterList.add("/-\\");
                        phraseLetterList.add("@");
                        phraseLetterList.add("^");
                        phraseLetterList.add("/\\");
                        break;
                    }
                    case 'b': {
                        phraseLetterList.add("B");
                        phraseLetterList.add("b");
                        phraseLetterList.add("|3");
                        phraseLetterList.add("13");
                        phraseLetterList.add("/3");
                        phraseLetterList.add("8");
                        break;
                    }
                    case 'c': {
                        phraseLetterList.add("C");
                        phraseLetterList.add("c");
                        phraseLetterList.add("(");
                        phraseLetterList.add("{");
                        phraseLetterList.add("[");
                        phraseLetterList.add("<");
                        break;
                    }
                    case 'd': {
                        phraseLetterList.add("D");
                        phraseLetterList.add("d");
                        phraseLetterList.add("|)");
                        phraseLetterList.add("|>");
                        phraseLetterList.add("[)");
                        phraseLetterList.add("1)");
                        break;
                    }
                    case 'e': {
                        phraseLetterList.add("E");
                        phraseLetterList.add("e");
                        phraseLetterList.add("3");
                        phraseLetterList.add("[-");
                        break;
                    }
                    case 'f': {
                        phraseLetterList.add("F");
                        phraseLetterList.add("f");
                        phraseLetterList.add("|=");
                        phraseLetterList.add("/=");
                        break;
                    }
                    case 'g': {
                        phraseLetterList.add("G");
                        phraseLetterList.add("g");
                        phraseLetterList.add("6");
                        phraseLetterList.add("9");
                        phraseLetterList.add("gee");
                        break;
                    }
                    case 'h': {
                        phraseLetterList.add("H");
                        phraseLetterList.add("h");
                        phraseLetterList.add("|-|");
                        phraseLetterList.add("#");
                        phraseLetterList.add("}{");
                        phraseLetterList.add("]-[");
                        break;
                    }
                    case 'i': {
                        phraseLetterList.add("I");
                        phraseLetterList.add("i");
                        phraseLetterList.add("!");
                        phraseLetterList.add("1");
                        phraseLetterList.add("|");
                        break;
                    }
                    case 'j': {
                        phraseLetterList.add("J");
                        phraseLetterList.add("j");
                        phraseLetterList.add("_|");
                        phraseLetterList.add("]");
                        phraseLetterList.add("_/");
                        break;
                    }
                    case 'k': {
                        phraseLetterList.add("K");
                        phraseLetterList.add("k");
                        phraseLetterList.add("|<");
                        phraseLetterList.add("|(");
                        break;
                    }
                    case 'l': {
                        phraseLetterList.add("L");
                        phraseLetterList.add("l");
                        phraseLetterList.add("|_");
                        phraseLetterList.add("|");
                        phraseLetterList.add("1_");
                        break;
                    }
                    case 'm': {
                        phraseLetterList.add("M");
                        phraseLetterList.add("m");
                        phraseLetterList.add("^^");
                        phraseLetterList.add("1V1");
                        phraseLetterList.add("/\\//\\");
                        phraseLetterList.add("|\\/|");
                        break;
                    }
                    case 'n': {
                        phraseLetterList.add("N");
                        phraseLetterList.add("n");
                        phraseLetterList.add("|\\|");
                        phraseLetterList.add("1V");
                        phraseLetterList.add("/\\/");
                        phraseLetterList.add("|V");
                        break;
                    }
                    case 'o': {
                        phraseLetterList.add("O");
                        phraseLetterList.add("o");
                        phraseLetterList.add("0");
                        phraseLetterList.add("()");
                        break;
                    }
                    case 'p': {
                        phraseLetterList.add("P");
                        phraseLetterList.add("p");
                        phraseLetterList.add("|*");
                        phraseLetterList.add("|'");
                        break;
                    }
                    case 'q': {
                        phraseLetterList.add("Q");
                        phraseLetterList.add("q");
                        phraseLetterList.add("9");
                        phraseLetterList.add("&");
                        break;
                    }
                    case 'r': {
                        phraseLetterList.add("R");
                        phraseLetterList.add("r");
                        phraseLetterList.add("|^");
                        phraseLetterList.add("I2");
                        phraseLetterList.add("|2");

                        break;
                    }
                    case 's': {
                        phraseLetterList.add("S");
                        phraseLetterList.add("s");
                        phraseLetterList.add("$");
                        phraseLetterList.add("5");
                        break;
                    }
                    case 't': {
                        phraseLetterList.add("T");
                        phraseLetterList.add("t");
                        phraseLetterList.add("+");
                        phraseLetterList.add("-|-");
                        phraseLetterList.add("']['");
                        break;
                    }
                    case 'u': {
                        phraseLetterList.add("U");
                        phraseLetterList.add("u");
                        phraseLetterList.add("|_|");
                        phraseLetterList.add("L|");
                        phraseLetterList.add("(_)");
                        break;
                    }
                    case 'v': {
                        phraseLetterList.add("V");
                        phraseLetterList.add("v");
                        phraseLetterList.add("\\/");
                        phraseLetterList.add("|/");
                        break;
                    }
                    case 'w': {
                        phraseLetterList.add("W");
                        phraseLetterList.add("w");
                        phraseLetterList.add("\\/\\/");
                        phraseLetterList.add("\\^/");
                        phraseLetterList.add("VV");
                        break;
                    }
                    case 'x': {
                        phraseLetterList.add("X");
                        phraseLetterList.add("x");
                        phraseLetterList.add("><");
                        phraseLetterList.add("}{");
                        break;
                    }
                    case 'y': {
                        phraseLetterList.add("Y");
                        phraseLetterList.add("y");
                        //phraseLetterList.add("");
                        //phraseLetterList.add("");
                        break;
                    }
                    case 'z': {
                        phraseLetterList.add("Z");
                        phraseLetterList.add("z");
                        phraseLetterList.add("2");
                        phraseLetterList.add("7_");
                        break;
                    }
                    default: {
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        break;
                    }
                }

                double doubleIndex = (phraseLetterList.size() * Math.random());
                int intIndex = (int) floor(doubleIndex);
                generatedPhrase.append(phraseLetterList.get(intIndex));
                phraseLetterList.clear();
            }

            phrasedPassword = generatedPhrase.toString();

            // Phrased password verification for all characters
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasNumber = false;
            boolean hasSpecial = false;

            for(int i = 0; i < phrasedPassword.length(); i++)
            {

                if("abcdefghijklmnopkrstuvwxyz".contains(Character.toString(phrasedPassword.charAt(i))))
                {
                    hasLower = true;
                }
                else if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(Character.toString(phrasedPassword.charAt(i))))
                {
                    hasUpper = true;

                }
                else if("0123456789".contains(Character.toString(phrasedPassword.charAt(i))))
                {
                    hasNumber= true;
                }
                else if(" ,!”#$%&’()*+,-./:;<=>?@[\\]^_`{|}~".contains(Character.toString(phrasedPassword.charAt(i))))
                {
                    hasSpecial = true;
                }

            }

            // Check for character verification on letters, symbols, and numbers
            if((hasLower && hasNumber && hasSpecial && hasUpper))
            {
                goodPassword = true;
            }
            else
            {
                generatedPhrase = new StringBuilder();
                phraseLetterList.clear();
            }
    }
        return phrasedPassword;
    }
}