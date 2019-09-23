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
import java.lang.String;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.*;

public class EncryptionGUI extends Application {

    private Label currentPasswordLabel;
    private String password = "";
    private String passwordType;
    private TextField desiredSize;
    private ImageView passwordStrengthImage;
    private static String stringSize;
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
        currentPasswordLabel = new Label ("Current Password:  " + password);
        Label passwordStrengthLabel = new Label("Password Strength:   ");

        // Hash Function Section
        Text encryptionSectionText = new Text ("Encryption Type Selection");
        encryptionSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        HBox encryptionSectionRow = new HBox();
        VBox encryptionSectionColumn1 = new VBox();
        VBox encryptionSectionColumn2 = new VBox();
        CheckBox encryption1 = new CheckBox("encryption1");
        CheckBox encryption2 = new CheckBox("encryption2");
        CheckBox encryption3 = new CheckBox("encryption3");
        CheckBox encryption4 = new CheckBox("encryption4");
        CheckBox encryption5 = new CheckBox("encryption5");
        CheckBox encryption6 = new CheckBox("encryption6");
        encryptionSectionColumn1.getChildren().addAll(encryption1, encryption2, encryption3);
        encryptionSectionColumn2.getChildren().addAll(encryption4, encryption5, encryption6);
        encryptionSectionRow.getChildren().addAll(encryptionSectionColumn1, encryptionSectionColumn2);
        encryptionSectionRow.setSpacing(20);
        encryptionSectionColumn1.setSpacing(5);
        encryptionSectionColumn2.setSpacing(5);
        Button generateHash = new Button("Generate Encrption");
        String passwordHashed = "test test";
        Label currentPasswordHash = new Label("Password Encrypted:  " + passwordHashed);
        Label passwordHashedStrengthLabel = new Label("Encrypted Password Strength:   ");

        // Password Braking Section
        Text pwBreakSectionText = new Text ("Select a Password Breaking Method");
        pwBreakSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        HBox pwBreakSectionRow = new HBox();
        VBox pwBreakSectionColumn1 = new VBox();
        VBox pwBreakSectionColumn2 = new VBox();
        CheckBox pwBreak1 = new CheckBox("Option 1");
        CheckBox pwBreak2 = new CheckBox("Option 2");
        pwBreakSectionColumn1.getChildren().addAll(pwBreak1);
        pwBreakSectionColumn2.getChildren().addAll(pwBreak2);
        pwBreakSectionRow.getChildren().addAll(pwBreakSectionColumn1, pwBreakSectionColumn2);
        pwBreakSectionRow.setSpacing(20);
        pwBreakSectionColumn1.setSpacing(5);
        pwBreakSectionColumn2.setSpacing(5);
        Button tryToBreak = new Button("Break");
        Label tryToBreakPW = new Label("Current Password:   ");
        Label tryToBreakHash = new Label("Hashed Password:   ");

        // Phrase to Password Section
        Text P2PSectionText = new Text ("Phrase to Password Tool");
        P2PSectionText.setFont(Font.font("Segoe UI",FontWeight.EXTRA_BOLD, 14));
        Label P2PPhrase = new Label("Phrase:   ");
        Label P2PPassword = new Label("Created Password:   ");
        Button generate = new Button("Generate");
        VBox P2PSectionColumn = new VBox();
        P2PSectionColumn.getChildren().addAll(P2PPhrase, P2PPassword,generate);
        P2PSectionColumn.setSpacing(10);
        // Generate Password Process
        generatePassword.setOnAction(e -> {
            try {
                stringSize = desiredSize.getText();
                size = Integer.parseInt(stringSize);

                    if(userDefined.isSelected() && !lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected())
                        password = passwordGenerator.generateUserDefinedPassword();
                    else if (!userDefined.isSelected() && lowerCase.isSelected() && !upperCase.isSelected() && !numbers.isSelected() && !specialCharacters.isSelected())
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

                    currentPasswordLabel.setText("Current Password:  " + password);
                    passwordStrengthImage.setImage(PasswordStrength.determinePasswordStrengthImage(password));
                }
            catch(NumberFormatException i)
            {
                EncryptionGUI.message("Please Enter a Numeric Value for Password");
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
                generatePassword,currentPasswordLabel, passwordStrengthBox,
                encryptionSectionText, encryptionSectionRow, generateHash, currentPasswordHash,
                passwordHashedStrengthBox,pwBreakSectionText,pwBreakSectionRow,
                tryToBreak,tryToBreakPW,tryToBreakHash,P2PSectionText,P2PSectionColumn);

        Scene newScene = new Scene(defaultLayout,400,700);
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
