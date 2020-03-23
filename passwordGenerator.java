package sample;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.lang.Math;
import java.util.Scanner;

import static java.lang.Math.floor;

/**
 * Class PasswordGenerator is a help class for EncryptionGUI that aids in generating a password based on user prefrences
 * in the Password Generation Section of the GUI. The class features all cases of user input of symbols, digits, and letters
 * and creates a randomized password or a user customized password based on what is inputted.
 * @Authors Tony Tipton
 * @since 3/23/2020
 */
public class passwordGenerator
{
    static Scanner input = new Scanner(System.in);
    private static String userPassword;
    private static boolean isInteger = false;
    private static int size;

    /**
     * This method generates a user defined password
     * @return String This returns the user defined password
     */
    public static String generateUserDefinedPassword()
    {
        String generatedPassword = getUserDefinedPassword();
        return generatedPassword;
    }
    /**
     * This method creates a randomized password based on numbers.
     * @param size This parameter dictates the size of the password to be created
     * @return String This returns the password generated
     */
    public static String generateNumbersOnlyPassword(int size)
    {

        String characterBank = "0123456789";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on special characters.
     * @param size This parameter dictates the size of the password to be created
     * @return String This returns the password generated
     */
    public static String generateSpecialCharactersOnlyPassword(int size)
    {
        String characterBank = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper and lower case letters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerLettersOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper case letters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */

    public static String generateUpperLettersOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }

    /**
     * This method creates a randomized password based on upper and lower case letters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerAndUpperLettersOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                             + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on lower case letters and number characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerLettersAndNumbersOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }

    /**
     * This method creates a randomized password based on upper case letters and numbers characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */

    public static String generateUpperLettersAndNumbersOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper and lower case letters, numbers characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerAndUpperLettersAndNumbersOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on lower case letters and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerandSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper and lower case letters and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateUpperLettersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on numbers and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "0123456789"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper and lower case letters, and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerAndUpperLettersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on lower case letters, numbers, and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "0123456789"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    /**
     * This method creates a randomized password based on upper case letters, numbers, and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateUpperLettersAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }

    /**
     * This method creates a randomized password based on upper and lower case letters, numbers, and special characters.
     * @param size This parameter dictates the size of the password to be created.
     * @return String This returns the password generated.
     */
    public static String generateLowerAndUpperLettersAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }

   public static String getUserDefinedPassword()
    {
        Stage sizeStage = new Stage();
        sizeStage.setTitle("User Defined Password");
        VBox MessageGrid = new VBox(10);
        MessageGrid.setAlignment(Pos.CENTER);
        Label messageToDisplay = new Label();
        TextField userDefinedPassword = new TextField();
        Button submit = new Button();
        messageToDisplay.setFont(new Font("Times New Roman", 14));
        messageToDisplay.setText("Please enter a password");

        submit.setText("Submit");
        submit.setOnAction(e -> {
        userPassword = userDefinedPassword.getText();
        sizeStage.close();
        });

        MessageGrid.getChildren().addAll(messageToDisplay,userDefinedPassword, submit);
        Scene messageScene = new Scene(MessageGrid,350,200);
        sizeStage.initModality(Modality.APPLICATION_MODAL);
        sizeStage.setScene(messageScene);
        sizeStage.showAndWait();
        return userPassword;
    }

}
