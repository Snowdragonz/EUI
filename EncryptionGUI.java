package sample;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.*;

public class EncryptionGUI extends Application {

    private String password = "";
    private String hashedPassword = "";
    private String PWBrakeTimeEstimate = "0";
    private String hashPWBrakeTimeEstimate = "0";
    private String passwordType;
    private TextField desiredSize;
    private TextField phraseInput;
    private ImageView passwordStrengthImage;
    private static String stringSize;
    private static String plaintextPhrase;
    private static String parsedPhrase;
    private static int size;
    private CheckBox userDefined;
    private CheckBox lowerCase;
    private CheckBox upperCase;
    private CheckBox numbers;
    private CheckBox specialCharacters;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Application Window Section
        primaryStage.setTitle("Encryption GUI");

        // Generate a Password Section
        Text passwordGenerationCharactersText = new Text ("Password Character Selection");
        passwordGenerationCharactersText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        Label passwordGenerationCharacters = new Label();
        HBox passwordTypesRow = new HBox();
        VBox passwordTypesColumn1 = new VBox();
        VBox passwordTypesColumn2 = new VBox();
        lowerCase = new CheckBox("Lower Case");
        upperCase = new CheckBox("Upper Case");
        numbers = new CheckBox("Numbers");
        specialCharacters = new CheckBox("Special Char");
        userDefined = new CheckBox("Custom Password");
        passwordTypesColumn1.getChildren().addAll(lowerCase,upperCase,userDefined);
        passwordTypesColumn2.getChildren().addAll(numbers,specialCharacters);
        passwordTypesRow.getChildren().addAll(passwordTypesColumn1, passwordTypesColumn2);
        passwordTypesRow.setSpacing(20);
        passwordTypesColumn1.setSpacing(5);
        passwordTypesColumn2.setSpacing(5);
        Button generatePassword = new Button("Generate Password");
        Label currentPasswordLabel = new Label ("Current Password:  " + password);
        Label passwordTimeToBrakeEstimate = new Label("Estimated Time To Break: " + PWBrakeTimeEstimate);
        Label passwordStrengthLabel = new Label("Password Strength:   ");

        // Generate Password Process
        generatePassword.setOnAction(e -> {
            try {
                stringSize = desiredSize.getText();
                if(userDefined.isSelected() && !lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected()) {
                    password = passwordGenerator.generateUserDefinedPassword();
                }
                else {
                    size = Integer.parseInt(stringSize);

                    if (!userDefined.isSelected() && lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerLettersOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateUpperLettersOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && !upperCase.isSelected() && numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateNumbersOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateSpecialCharactersOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerAndUpperLettersOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && !upperCase.isSelected() && numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerLettersAndNumbersOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerandSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && upperCase.isSelected() && numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateUpperLettersAndNumbersOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && upperCase.isSelected() && !numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateUpperLettersAndSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && !upperCase.isSelected() && numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateNumbersAndSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && upperCase.isSelected() && numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerAndUpperLettersAndNumbersOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && upperCase.isSelected() && !numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerAndUpperLettersAndSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && !upperCase.isSelected() && numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerAndNumbersAndSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && !lowerCase.isSelected() && upperCase.isSelected() && numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateUpperLettersAndNumbersAndSpecialOnlyPassword(size);
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && upperCase.isSelected() && numbers.isSelected() && specialCharacters.isSelected())
                        password = passwordGenerator.generateLowerAndUpperLettersAndNumbersAndSpecialOnlyPassword(size);
                    else
                        EncryptionGUI.message("Please select another combination of password characters");
                }
                currentPasswordLabel.setText("Current Password:  " + password);
                passwordTimeToBrakeEstimate.setText("Estimated Time To Brake: " + PWBrakeTimeEstimate + " seconds");
                passwordStrengthImage.setImage(PasswordStrength.determinePasswordStrengthImage(password));
            }
            catch(NumberFormatException i)
            {
                EncryptionGUI.message("Please Enter a Numeric Value for Password");
            }
        });

        // Hash Function Section
        ToggleGroup hashGroup = new ToggleGroup();
        Text encryptionSectionText = new Text ("Encryption Type Selection");
        encryptionSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        HBox encryptionSectionRow = new HBox();
        VBox encryptionSectionColumn1 = new VBox();
        VBox encryptionSectionColumn2 = new VBox();
        RadioButton encryption1 = new RadioButton("MD2");
        RadioButton encryption2 = new RadioButton("MD5");
        RadioButton encryption3 = new RadioButton("SHA-1");
        RadioButton encryption4 = new RadioButton("SHA-256");
        RadioButton encryption5 = new RadioButton("SHA-384");
        RadioButton encryption6 = new RadioButton("SHA-512");
        encryption1.setToggleGroup(hashGroup);
        encryption2.setToggleGroup(hashGroup);
        encryption3.setToggleGroup(hashGroup);
        encryption4.setToggleGroup(hashGroup);
        encryption5.setToggleGroup(hashGroup);
        encryption6.setToggleGroup(hashGroup);
        encryptionSectionColumn1.getChildren().addAll(encryption1, encryption2, encryption3);
        encryptionSectionColumn2.getChildren().addAll(encryption4, encryption5, encryption6);
        encryptionSectionRow.getChildren().addAll(encryptionSectionColumn1, encryptionSectionColumn2);
        encryptionSectionRow.setSpacing(20);
        encryptionSectionColumn1.setSpacing(5);
        encryptionSectionColumn2.setSpacing(5);
        Button generateHash = new Button("Generate Encryption");
        Label currentPasswordHash = new Label("Password Encrypted:  ");
        Label hashedPasswordTimeToBrakeEstimate = new Label("Estimated Time To Break: " + hashPWBrakeTimeEstimate + " seconds");
        Label passwordHashedStrengthLabel = new Label("Encrypted Password Strength:   ");
        generateHash.setOnAction(e -> {

            if(encryption1.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getMD2(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
            if(encryption2.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getMD5(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
            if(encryption3.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA1(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
            if(encryption4.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA256(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
            if(encryption5.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA384(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
            if(encryption6.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA512(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
            }
        });


        // Password Breaking Section
        ToggleGroup brakePW = new ToggleGroup();
        Text pwBreakSectionText = new Text ("Select a Password Breaking Method");
        pwBreakSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        HBox pwBreakSectionRow = new HBox();
        VBox pwBreakSectionColumn1 = new VBox();
        VBox pwBreakSectionColumn2 = new VBox();
        RadioButton pwBreak1 = new RadioButton("Bruteforce");
        RadioButton pwBreak2 = new RadioButton("Bruteforce Analysis");
        RadioButton pwBreak3 = new RadioButton("Dictonary Attack");
        pwBreak1.setToggleGroup(brakePW);
        pwBreak2.setToggleGroup(brakePW);
        pwBreak3.setToggleGroup(brakePW);
        pwBreakSectionColumn1.getChildren().addAll(pwBreak1, pwBreak3);
        pwBreakSectionColumn2.getChildren().addAll(pwBreak2);
        pwBreakSectionRow.getChildren().addAll(pwBreakSectionColumn1, pwBreakSectionColumn2);
        pwBreakSectionRow.setSpacing(20);
        pwBreakSectionColumn1.setSpacing(5);
        pwBreakSectionColumn2.setSpacing(5);
        Button tryToBreak = new Button("Break");
        Label tryToBreakPW = new Label("Current Password:   ");
        Label tryToBreakHash = new Label("Hashed Password:   ");
        tryToBreak.setOnAction(e -> {
            if(pwBreak1.isSelected() && password.compareTo("") != 0)
            {
                hackPassword.bruteForce(password);
            }
            if(pwBreak2.isSelected() && password.compareTo("") != 0) {
                try {
                    hackPassword.CalcuateTimeToBrake(password);
                } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            if(pwBreak3.isSelected() && password.compareTo("") != 0) {
                try {
                    System.out.println("Password Found : " + hackPassword.dictionaryAttack(password));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        // Phrase to Password Section
        Text P2PSectionText = new Text ("Phrase to Password Tool");
        P2PSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        Label P2PPhrase = new Label("Enter an 8 word Phrase:   ");
        TextField phraseInput = new TextField();
        Label P2PPassword = new Label("Created Password:   ");
        Button generatePhrase = new Button("Generate");
        VBox P2PSectionColumn = new VBox();
        HBox inputPhraseRow = new HBox();
        inputPhraseRow.getChildren().addAll(P2PPhrase, phraseInput);
        P2PSectionColumn.getChildren().addAll(inputPhraseRow, P2PPassword,generatePhrase);
        P2PSectionColumn.setSpacing(10);
        generatePhrase.setOnAction(e -> {

        plaintextPhrase = phraseInput.getText();
        String seperator[] = plaintextPhrase.split(" ");
        List<String> phraseWordList = new ArrayList<String>();
        phraseWordList = Arrays.asList(seperator);
        if (phraseWordList.size() > 7)
        {
            parsedPhrase = PhraseGenerator.generatePhrase(phraseWordList);
            P2PPassword.setText("Created Password:   " + parsedPhrase);
        }
        else
        {
            P2PPassword.setText("Created Password:   Please Enter a phrase that has 8 or more words");
        }
        });



        Label passwordSize = new Label("Password Size:  ");
        desiredSize = new TextField();
        HBox passwordBox = new HBox();
        passwordBox.getChildren().addAll(passwordSize,desiredSize);

        passwordStrengthImage = new ImageView();
        Image passwordStrengthBar = new Image(EncryptionGUI.class.getResourceAsStream("White.png"));
        passwordStrengthImage.setImage(passwordStrengthBar);
        HBox passwordStrengthBox = new HBox();
        passwordStrengthBox.getChildren().addAll(passwordStrengthLabel,passwordStrengthImage);

        ImageView passwordHashedStrengthImage = new ImageView();
        Image currentPasswordHashedStrengthImage = new Image(EncryptionGUI.class.getResourceAsStream("White.png"));
        passwordHashedStrengthImage.setImage(currentPasswordHashedStrengthImage);
        HBox passwordHashedStrengthBox = new HBox();
        passwordHashedStrengthBox.getChildren().addAll(passwordHashedStrengthLabel, passwordHashedStrengthImage);
        VBox defaultLayout = new VBox(10);
        defaultLayout.setPadding(new Insets(10,10,10,10));
        defaultLayout.getChildren().addAll(
                passwordGenerationCharactersText, passwordTypesRow, passwordBox,
                generatePassword,currentPasswordLabel,passwordTimeToBrakeEstimate, passwordStrengthBox,
                encryptionSectionText, encryptionSectionRow, generateHash, currentPasswordHash, hashedPasswordTimeToBrakeEstimate,
                passwordHashedStrengthBox,pwBreakSectionText,pwBreakSectionRow,
                tryToBreak,tryToBreakPW,tryToBreakHash,P2PSectionText,P2PSectionColumn);

        Scene newScene = new Scene(defaultLayout,400,800);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public static void message(String message)
    {
        Stage messageStage = new Stage();
        messageStage.setTitle("Error");
        VBox MessageGrid = new VBox();
        Button Ok = new Button();
        Label messageToDisplay = new Label();
        messageToDisplay.setFont(new Font("Segoe UI",12));
        messageToDisplay.setText(message);
        messageToDisplay.setTranslateX(85);
        messageToDisplay.setTranslateY(75);

        Ok.setText("Ok");
        Ok.setOnAction(e -> messageStage.close());
        Ok.setTranslateX(150);
        Ok.setTranslateY(90);
        MessageGrid.getChildren().addAll(messageToDisplay, Ok);
        Scene messageScene = new Scene(MessageGrid,350,200);
        messageStage.initModality(Modality.APPLICATION_MODAL);
        messageStage.setScene(messageScene);
        messageStage.showAndWait();
    }


}
