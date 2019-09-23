package sample;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.lang.String;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class EncryptionGUI extends Application {

    private Stage defaultWindow;
    private Button generatePassword;
    private Label currentPasswordLabel;
    private Label passwordGenerationCharacters;
    private Label passwordStrengthLabel;
    private Label passwordHashedStrengthLabel;
    private Label currentPasswordHash;
    private String password = "";
    private String passwordHashed = "test test";
    private String passwordType;
    private Label passwordSize;
    private TextField desiredSize;
    private HBox passwordBox;
    private HBox  passwordStrengthBox;
    private HBox passwordHashedStrengthBox;
    private HBox passwordTypesRow;
    private VBox passwordTypesColumn1;
    private VBox passwordTypesColumn2;
    private ImageView passwordStrengthImage;
    private ImageView passwordHashedStrengthImage;
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
        defaultWindow = primaryStage;
        defaultWindow.setTitle("Encryption GUI");
        generatePassword = new Button ("Generate Password");
        currentPasswordLabel = new Label ("Current Password:  " + password);
        passwordStrengthLabel = new Label("Password Strength:   ");
        currentPasswordHash = new Label("Password Hashed:  " + passwordHashed);
        passwordHashedStrengthLabel = new Label("Hashed Password Strength:   ");
        //passwordStengthImage = new Image("yeet.png");
        //currentPassword = new Label (password);

        // CheckBox Section
        passwordGenerationCharacters = new Label("Select Password Characters");
        passwordTypesRow = new HBox();
        passwordTypesColumn1 = new VBox();
        passwordTypesColumn2 = new VBox();
        lowerCase = new CheckBox("Lower Case");
        upperCase = new CheckBox("Upper Case");
        numbers = new CheckBox("Numbers");
        specialCharacters = new CheckBox("Special Char");
        userDefined = new CheckBox("Custom Password");
        passwordTypesColumn1.getChildren().addAll(lowerCase,upperCase,userDefined);
        passwordTypesColumn2.getChildren().addAll(numbers,specialCharacters);
        passwordTypesRow.getChildren().addAll(passwordTypesColumn1,passwordTypesColumn2);
        passwordTypesRow.setSpacing(20);
        passwordTypesColumn1.setSpacing(5);
        passwordTypesColumn2.setSpacing(5);

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
                    passwordStrengthImage.setImage(passwordGenerator.determinePasswordStrength());

                }

            catch(NumberFormatException i)
            {
                EncryptionGUI.message("Please Enter a Numeric Value for Password");
            }
        });
        passwordSize = new Label("Password Size:  ");
        desiredSize = new TextField();
        passwordBox = new HBox();
        //passwordBox.setPadding(new Insets(10,10,10,10));
        passwordBox.getChildren().addAll(passwordSize,desiredSize);

        passwordStrengthImage = new ImageView();
        Image passwordStrengthBar = new Image(EncryptionGUI.class.getResourceAsStream("White.png"));
        passwordStrengthImage.setImage(passwordStrengthBar);
        passwordStrengthBox = new HBox();
        passwordStrengthBox.getChildren().addAll(passwordStrengthLabel,passwordStrengthImage);

        passwordHashedStrengthImage = new ImageView();
        Image currentPasswordHashedStrengthImage = new Image(EncryptionGUI.class.getResourceAsStream("White.png"));
        passwordHashedStrengthImage.setImage(currentPasswordHashedStrengthImage);
        //passwordHashedStrengthLabel.setText("Hashed Password Strength");
        passwordHashedStrengthBox = new HBox();
        passwordHashedStrengthBox.getChildren().addAll(passwordHashedStrengthLabel, passwordHashedStrengthImage);
        VBox defaultLayout = new VBox(10);
        defaultLayout.setPadding(new Insets(10,10,10,10));
        //passwordStrengthLabel.setUnderline(true);
        defaultLayout.getChildren().addAll(passwordGenerationCharacters,passwordTypesRow,passwordBox,generatePassword,currentPasswordLabel,passwordStrengthBox,currentPasswordHash,passwordHashedStrengthBox);
        Scene newScene = new Scene(defaultLayout,400,450);
        defaultWindow.setScene(newScene);
        defaultWindow.show();
    }

    public static void message(String message)
    {
        Stage messageStage = new Stage();
        messageStage.setTitle("Error");
        VBox MessageGrid = new VBox();
        Button Ok = new Button();
        Label messageToDisplay = new Label();
        messageToDisplay.setFont(new Font("Times New Roman", 14));
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
