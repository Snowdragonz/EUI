package sample;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.lang.Math;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.floor;

public class passwordGenerator
{
    static Scanner input = new Scanner(System.in);
    private static String userPassword;
    private static boolean isInteger = false;
    private static int size;

    public static String generateUserDefinedPassword()
    {
        String generatedPassword = getUserDefinedPassword();
        return generatedPassword;
    }

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

    public static String generateSpecialCharactersOnlyPassword(int size)
    {
        String characterBank = "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';
        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }

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
    public static String generateLowerandSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateUpperLettersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "0123456789"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateLowerAndUpperLettersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateLowerAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "0123456789"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateUpperLettersAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

        StringBuilder generatedPassword = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            double doubleIndex = (characterBank.length() * Math.random());
            int intIndex = (int) floor(doubleIndex);
            generatedPassword.append(characterBank.charAt(intIndex));
        }
        return generatedPassword.toString();
    }
    public static String generateLowerAndUpperLettersAndNumbersAndSpecialOnlyPassword(int size)
    {
        String characterBank = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "`~!@#$%^&*()-_=+[{]};:',<.>/?|" + '\\' + '\"';

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
        VBox MessageGrid = new VBox();
        Label messageToDisplay = new Label();
        TextField userDefinedPassword = new TextField();
        Button submit = new Button();
        messageToDisplay.setFont(new Font("Times New Roman", 14));
        messageToDisplay.setText("Please enter a password");
        messageToDisplay.setTranslateX(85);
        messageToDisplay.setTranslateY(75);

        submit.setText("Submit");
        submit.setOnAction(e -> {
        userPassword = userDefinedPassword.getText();
        sizeStage.close();
        });
        submit.setTranslateX(150);
        submit.setTranslateY(90);
        MessageGrid.getChildren().addAll(messageToDisplay,userDefinedPassword, submit);
        Scene messageScene = new Scene(MessageGrid,350,200);
        sizeStage.initModality(Modality.APPLICATION_MODAL);
        sizeStage.setScene(messageScene);
        sizeStage.showAndWait();
        return userPassword;
    }

}
