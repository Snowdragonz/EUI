package sample;

/**
 * <h1> Encryption GUI</h1>
 * @Author Tony Tipton
 * @since 3/23/2020
 *
 * The EncryptionGUI program implements an application graphical user interface that has several components for users to generate, analyze, and translate
 * passwords, phrases, and hash functions for their needs. There are several sections to the GUI that can be shorted down to 1. Password Generation Section
 * 2. Encryption Translation Section, 3. Password Hacking Section, 4. Phrase to Password Tool Section. The Password Generation Section features a process
 * that allows a user to generate a password with letters, symbols, and digits that can be randomized or customized. The Encryption Translation Section
 * features options to produce a one way hashed of a generated password to observe the functionality of one way hash algorithms. The Password Hacking Section
 * features two primary password hacking methods. Brute force checks every possible combination of characters on the standard English keyboard up until
 * a password length of 10 characters. Dictionary attack utilizes a dictionary located in the source folder of the program that checks password against words
 * found in a dictionary. The Phrase to Password Tool Section features a tool that when inputted a phrase, will generate a memorable Leet speak password for the user.
 *
 */
// Import libraries for use
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
import javafx.geometry.Pos;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.text.*;

/**
 * Class EncryptionGUI primarily declares and implements all of the JavaFx components for the graphical user interface and all private,public,protected
 * variables and methods needed to implement the functionality of the GUI. The class features the message() method which allows for the displaying of
 * messages to the user when appropriate.
 *
 */
public class EncryptionGUI extends Application {

    // Global variables for class use
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

    /**
     * This method is the driver method in starting the execution of the Java program and allows for the conversion to the JavaFX application startup.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    /**
     * the start() method is the start of the graphical user interface which allows the instantiation of the JavaFX application
     * @param primaryStage This is the Stage argument needed to start the application graphical user interface.
     * @return void This returns nothing
     */
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
        Label passwordTimeToBrakeEstimate = new Label("Estimated Time To Break: " + PWBrakeTimeEstimate + " seconds");
        Label passwordStrengthLabel = new Label("Password Strength:   ");
        Label tryToBreakPW = new Label("Current Password:   ");
        Label foundPW = new Label("Found Password:   ");

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
                PWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(password);
                passwordTimeToBrakeEstimate.setText("Estimated Time To Brake: " + PWBrakeTimeEstimate);
                //passwordStrengthImage.setImage(PasswordStrength.determinePasswordStrengthImage(password));
                tryToBreakPW.setText("Current Password: " + password);
            }
            catch(NumberFormatException i)
            {
                EncryptionGUI.message("Please Enter a Numeric Value for Password");
            }
        });

        // Hash Function Section
        ToggleGroup hashGroup = new ToggleGroup();
        Text encryptionSectionText = new Text ("One Way Hash Selection");
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
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
            }
            else if(encryption2.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getMD5(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
            }
            else if(encryption3.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA1(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
            }
            else if(encryption4.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA256(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
            }
            else if(encryption5.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA384(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
            }
            else if(encryption6.isSelected() && password.compareTo("") != 0)
            {
                hashedPassword = hashGenerator.getSHA512(password);
                currentPasswordHash.setText("Password Encrypted:  " + hashedPassword);
                hashPWBrakeTimeEstimate = PasswordStrength.determinePasswordStrength(hashedPassword);
                hashedPasswordTimeToBrakeEstimate.setText("Estimated Time To Break: " + hashPWBrakeTimeEstimate);
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
        pwBreakSectionRow.getChildren().addAll(pwBreakSectionColumn1);// pwBreakSectionColumn2);
        pwBreakSectionRow.setSpacing(20);
        pwBreakSectionColumn1.setSpacing(5);
        pwBreakSectionColumn2.setSpacing(5);
        Button tryToBreak = new Button("Break");

        tryToBreak.setOnAction(e -> {
            if(pwBreak1.isSelected() && password.compareTo("") != 0)
            {
                hackPassword.bruteForce(password);
                foundPW.setText("Found Password: " + hackPassword.bruteForce(password));
            }
            if(pwBreak3.isSelected() && password.compareTo("") != 0) {
                foundPW.setText("Found Password: " + hackPassword.dictionaryAttack(password));
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
                message("Please enter a longer phrase");
            }
        });



        Label passwordSize = new Label("Password Size:  ");
        desiredSize = new TextField();
        HBox passwordBox = new HBox();
        passwordBox.getChildren().addAll(passwordSize,desiredSize);

        VBox defaultLayout = new VBox(10);
        defaultLayout.setPadding(new Insets(10,10,10,10));
        defaultLayout.getChildren().addAll(
                passwordGenerationCharactersText, passwordTypesRow, passwordBox,
                generatePassword,currentPasswordLabel,passwordTimeToBrakeEstimate,
                encryptionSectionText, encryptionSectionRow, generateHash, currentPasswordHash, hashedPasswordTimeToBrakeEstimate
                ,pwBreakSectionText,pwBreakSectionRow,
                tryToBreak,tryToBreakPW,foundPW,P2PSectionText,P2PSectionColumn);

        Scene newScene = new Scene(defaultLayout,500,800);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    /**
     * The message() method creates a small graphical user interface window for the purpose of displaying a message to the user.
     * @param message This parameter is a string that is used to display what message the system needs to present to the user.
     * @return void This method returns nothing
     */
    public static void message(String message)
    {
        Stage messageStage = new Stage();
        messageStage.setTitle("Error");
        VBox MessageGrid = new VBox(10);
        MessageGrid.setAlignment(Pos.CENTER);
        Button Ok = new Button();
        Label messageToDisplay = new Label();
        messageToDisplay.setFont(new Font("Segoe UI",12));
        messageToDisplay.setText(message);
        messageToDisplay.setTextAlignment(TextAlignment.JUSTIFY);

        Ok.setText("Ok");
        Ok.setOnAction(e -> messageStage.close());
        MessageGrid.getChildren().addAll(messageToDisplay, Ok);
        Scene messageScene = new Scene(MessageGrid,350,200);
        messageStage.initModality(Modality.APPLICATION_MODAL);
        messageStage.setScene(messageScene);
        messageStage.showAndWait();
    }


}