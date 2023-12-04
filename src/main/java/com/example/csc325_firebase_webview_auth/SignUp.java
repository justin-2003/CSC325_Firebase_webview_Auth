package com.example.csc325_firebase_webview_auth;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUp {
    @FXML
    TextField signUpPassword,signUpEmail,signUpName,signUpPhone;
    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(signUpEmail.getText())
                .setEmailVerified(false)
                .setPassword(signUpPassword.getText())
                .setPhoneNumber("+" + signUpPhone.getText())
                .setDisplayName(signUpName.getText())
                .setDisabled(false);
        try {
            UserRecord userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user:");
            System.out.println("UID: " + userRecord.getUid());
            System.out.println("Email: " + userRecord.getEmail());
            System.out.println("Display Name: " + userRecord.getDisplayName());
            return true;
        } catch (FirebaseAuthException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
            ex.printStackTrace();
            // Log the error or display a user-friendly message
            return false;
        }
    }
}
