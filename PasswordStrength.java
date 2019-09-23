package sample;

import javafx.scene.image.Image;

public class PasswordStrength {

    public static Image determinePasswordStrengthImage(String password)
    {
        int passwordLength;
        boolean hasLowerChar = false;
        boolean hasUpperChar = false;
        boolean hasNumbers = false;
        boolean hasSpecialCharacters = false;
        Image passwordStrengthBar = new Image(passwordGenerator.class.getResourceAsStream("White.png"));
        return passwordStrengthBar;
    }
}
