package sample;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

public class PhraseGenerator {

    public static String generatePhrase(List<String> List)
    {
        char firstCharacter;
        String word;
        String translatedWord = "";
        ArrayList<String> phraseLetterList = new ArrayList<String>();
        ArrayList<String> translatedList = new ArrayList<String>();
        StringBuilder generatedPhrase = new StringBuilder();

        for(int i = 0; i < List.size(); i++)
        {
            word = List.get(i).toLowerCase();
            firstCharacter = word.charAt(0);
            //System.out.println(firstCharacter);

            switch (firstCharacter)
            {
                case 'a':
                    {
                        phraseLetterList.add("A");
                        phraseLetterList.add("a");
                        phraseLetterList.add("/-\\");
                        phraseLetterList.add("@");
                        break;
                    }
                case 'b':
                    {
                        phraseLetterList.add("B");
                        phraseLetterList.add("b");
                        phraseLetterList.add("|3");
                        phraseLetterList.add("13");
                        break;
                    }
                case 'c':
                    {
                        phraseLetterList.add("C");
                        phraseLetterList.add("c");
                        phraseLetterList.add("(");
                        phraseLetterList.add("{");
                        break;
                    }
                case 'd':
                    {
                        phraseLetterList.add("D");
                        phraseLetterList.add("d");
                        phraseLetterList.add("|)");
                        phraseLetterList.add("|>");
                        break;
                    }
                case 'e':
                    {
                        phraseLetterList.add("E");
                        phraseLetterList.add("e");
                        phraseLetterList.add("3");
                        //phraseLetterList.add("");
                        break;
                    }
                case 'f':
                    {
                        phraseLetterList.add("F");
                        phraseLetterList.add("f");
                        phraseLetterList.add("|=");
                        //phraseLetterList.add("");
                        break;
                    }
                case 'g':
                    {
                        phraseLetterList.add("G");
                        phraseLetterList.add("g");
                        phraseLetterList.add("6");
                        phraseLetterList.add("9");
                        phraseLetterList.add("gee");
                        break;
                    }
                case 'h':
                    {
                        phraseLetterList.add("H");
                        phraseLetterList.add("h");
                        phraseLetterList.add("|-|");
                        phraseLetterList.add("#");
                        break;
                    }
                case 'i':
                    {
                        phraseLetterList.add("I");
                        phraseLetterList.add("i");
                        phraseLetterList.add("!");
                        phraseLetterList.add("1");
                        break;
                    }
                case 'j':
                    {
                        phraseLetterList.add("J");
                        phraseLetterList.add("j");
                        phraseLetterList.add("_|");
                        phraseLetterList.add("]");
                        break;
                    }
                case 'k':
                    {
                        phraseLetterList.add("K");
                        phraseLetterList.add("k");
                        phraseLetterList.add("|<");
                        phraseLetterList.add("|(");
                        break;
                    }
                case 'l':
                    {
                        phraseLetterList.add("L");
                        phraseLetterList.add("l");
                        phraseLetterList.add("|_");
                        phraseLetterList.add("|");
                        break;
                    }
                case 'm':
                    {
                        phraseLetterList.add("M");
                        phraseLetterList.add("m");
                        phraseLetterList.add("^^");
                        phraseLetterList.add("1V1");
                        break;
                    }
                case 'o':
                    {
                        phraseLetterList.add("O");
                        phraseLetterList.add("o");
                        phraseLetterList.add("0");
                        phraseLetterList.add("()");
                        break;
                    }
                case 'p':
                    {
                        phraseLetterList.add("P");
                        phraseLetterList.add("p");
                        phraseLetterList.add("|*");
                        phraseLetterList.add("|'");
                        break;
                    }
                case 'q':
                    {
                        phraseLetterList.add("Q");
                        phraseLetterList.add("q");
                        phraseLetterList.add("9");
                        phraseLetterList.add("&");
                        break;
                    }
                case 'r':
                    {
                        phraseLetterList.add("R");
                        phraseLetterList.add("r");
                        phraseLetterList.add("|^");
                        phraseLetterList.add("I2");
                        break;
                    }
                case 's':
                    {
                        phraseLetterList.add("S");
                        phraseLetterList.add("s");
                        phraseLetterList.add("$");
                        phraseLetterList.add("5");
                        break;
                    }
                case 't':
                    {
                        phraseLetterList.add("T");
                        phraseLetterList.add("t");
                        phraseLetterList.add("+");
                        phraseLetterList.add("-|-");
                        break;
                    }
                case 'u':
                    {
                        phraseLetterList.add("U");
                        phraseLetterList.add("u");
                        phraseLetterList.add("|_|");
                        phraseLetterList.add("L|");
                        break;
                    }
                case 'v':
                    {
                        phraseLetterList.add("V");
                        phraseLetterList.add("v");
                        phraseLetterList.add("\\/");
                        phraseLetterList.add("|/");
                        break;
                    }
                case 'w':
                    {
                        phraseLetterList.add("W");
                        phraseLetterList.add("w");
                        phraseLetterList.add("\\/\\/");
                        phraseLetterList.add("\\^/");
                        break;
                    }
                case 'x':
                    {
                        phraseLetterList.add("X");
                        phraseLetterList.add("x");
                        phraseLetterList.add("><");
                        phraseLetterList.add("}{");
                        break;
                    }
                case 'y':
                    {
                        phraseLetterList.add("Y");
                        phraseLetterList.add("y");
                        //phraseLetterList.add("");
                        //phraseLetterList.add("");
                        break;
                    }
                case 'z':
                    {
                        phraseLetterList.add("Z");
                        phraseLetterList.add("z");
                        phraseLetterList.add("2");
                        phraseLetterList.add("7_");
                        break;
                    }
                default:
                    {
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        phraseLetterList.add("");
                        break;
                    }
            }
            //for (int j = 0; i < phraseLetterList.size(); i++)
            //{
                double doubleIndex = (phraseLetterList.size() * Math.random());
                int intIndex = (int) floor(doubleIndex);
                generatedPhrase.append(phraseLetterList.get(intIndex));
            //}
            phraseLetterList.clear();
        }

        System.out.println(generatedPhrase.toString());
        return generatedPhrase.toString();
    }



}
