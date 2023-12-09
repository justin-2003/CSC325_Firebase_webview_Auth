package com.example.csc325_firebase_webview_auth;

import com.example.csc325_firebase_webview_auth.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class SignUp {
    @FXML
    TextField signUpPassword,signUpEmail,signUpName,signUpPhone;

    @FXML
    Label label;
    public void onLoginButtonClick(ActionEvent e) throws IOException, ExecutionException, InterruptedException {

        if (signUpEmail.getText().equals("") || signUpName.getText().equals("") || signUpPassword.getText().equals("")) {
            label.setText("You are missing fields! Try again!");
        }

        else {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(signUpEmail.getText())
                    .setEmailVerified(false)
                    .setPassword(signUpPassword.getText())
                    .setDisplayName(signUpName.getText())
                    .setDisabled(false);

            UserRecord userRecord;
            try {
                userRecord = App.fauth.createUser(request);
                User.getUser().setName(signUpName.getText());
                System.out.println("Successfully created new user: " + userRecord.getUid());
                App.setRoot("AccessFBView.fxml");
            } catch (FirebaseAuthException ex) {
                label.setText("Unable to make a new account! Try Again!");
                System.out.println(ex);
            }
        }
    }
}
